package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.*;
import com.kitri.exception.AddException;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class OrderDao {

	public void insert(OrderInfo info) throws AddException {
		Connection con = null;
		try {
			con = DBConnection.makeConnection();
//		오토커밋을 피하려면 setAutocCommit() 그리고 commit()
			con.setAutoCommit(false);
			insertInfo(con, info);
			List<OrderLine> lines = info.getLines();
			insertLine(con, lines);
//		commit()
			con.commit();
		} catch (Exception e) {
//			try {
//				con.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
			e.printStackTrace();
			throw new AddException("주문추가 오류 : " + e.getMessage());
		} finally {
			DBClose.close(con);
		}
	}

	public void insertInfo(Connection con, OrderInfo info) throws SQLException {
		PreparedStatement pstmt = null;
		String insertInfoSQL = "insert into order_info(order_no, order_id) \r\n"
				+ "values(seq_order_info_order_no.nextval, ?)";

		try {
			pstmt = con.prepareStatement(insertInfoSQL);
			pstmt.setString(1, info.getCustomer().getId());
			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, null);

		}

	}

	public void insertLine(Connection con, List<OrderLine> lines) throws SQLException {
		PreparedStatement pstmt = null;
		String insertLineSQL = "insert into order_line(order_no, order_product_no, order_quantity) \r\n"
				+ "values(seq_order_info_order_no.currval, ?, ?)";
		try {
			pstmt = con.prepareStatement(insertLineSQL);
			for (OrderLine line : lines) {
				String product_no = line.getProduct().getProduct_no();
				pstmt.setString(1, product_no);
				int product_quantity = line.getOrder_quantity();
				pstmt.setInt(2, product_quantity);
//				pstmt.executeUpdate();
//				일괄처리는 DB처리의 퍼포먼스향상을 꾀하기위한 방법.
				pstmt.addBatch();//일괄처리에 추가
			}
			pstmt.executeBatch();//일괄처리
//		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, null);
		}

	}
	
	public List<OrderInfo> selectById(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderInfo> list = null;
		try {
			con = DBConnection.makeConnection();
			list = new ArrayList<>();
//			StringBuffer selectByIdSQL = new StringBuffer("");
			String selectByIdSQL = "SELECT info.order_no, info.order_date, p.product_no, p.product_name, p.product_price, line.order_quantity\r\n" + 
					"FROM order_info info JOIN order_line line\r\n" + 
					"ON info.order_no = line.order_no\r\n" + 
					"JOIN product p ON p.product_no = line.order_product_no\r\n" + 
					"WHERE order_id = ? \r\n" + 
					"ORDER BY order_no DESC, product_no";
			pstmt = con.prepareStatement(selectByIdSQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			OrderInfo info = null;
			OrderLine line = null;
			List<OrderLine> lines = null;
			int old_order_no = -1;
			while(rs.next()) {
				int order_no = rs.getInt("order_no");
				if(old_order_no != order_no) { // 주문번호가 다를때. info를 새로만듬.
					info = new OrderInfo();
					// add는 참조를 시킨것을 말하기 때문에 참조 후에 add를 해도 참조메모리를 갖고있기 때문에 info를 list.add로 삼은 코드의 위치는 선후를 가리지 않는다.
					//주소값으로 참조값? 추가값?을 넣기때문에 선후의 차이가없다. 
					list.add(info);
					info.setOrder_no(order_no);
					info.setOrder_date(rs.getDate("order_date"));
					lines = new ArrayList<>();
					info.setLines(lines);
					old_order_no = order_no;
				}
				//주문번호가 같을때는 기존 info 사용.
				line = new OrderLine();
				String product_no = rs.getString("product_no"); //상품번호, 명, 가격
				Product p = new Product();
				p.setProduct_no(product_no);
				p.setProduct_name(rs.getString("product_name"));
				p.setProduct_price(rs.getInt("product_price"));
				
				line.setProduct(p);
				line.setOrder_quantity(rs.getInt("order_quantity"));
				
				
				lines.add(line);
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return list;
	}

	
}
