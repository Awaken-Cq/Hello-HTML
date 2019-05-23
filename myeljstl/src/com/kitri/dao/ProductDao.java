package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.Product;
import com.kitri.dto.ProductCategory;
import com.kitri.util.*;

public class ProductDao {
	public List<Product> selectAll(){
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		//1) JDBC 드라이버로드
		//2) DB연결
			conn = DBConnection.makeConnection();
			//3) SQL송신
			String selectAllSQL = "SELECT pc.cate_no, pc.cate_name, p.product_no, p.product_name, p.product_price, p.product_detail \n"+
					"FROM product p JOIN product_category pc \n" +
					"ON p.product_cate = pc.cate_no \n"+
					"ORDER BY pc.cate_no, p.product_no";
			pstmt = conn.prepareStatement(selectAllSQL);
			//4) 결과수신
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String product_no = rs.getString("product_no");
				String product_name = rs.getString("product_name");
				int product_price = rs.getInt("product_price");
				String product_detail = rs.getString("product_detail");
				
				String cate_no = rs.getString("cate_no");
				String cate_name = rs.getString("cate_name");
				
				ProductCategory pc = new ProductCategory(cate_no, cate_name);
				Product p = new Product(product_no, product_name, product_price, product_detail, pc);
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//5) 연결닫기
		DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	public Product selectId(String pid) {
		Product p = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String selectIdSQL = "SELECT pc.cate_no, pc.cate_name, p.product_no, p.product_name, p.product_price, p.product_detail\r\n" + 
					"FROM product p JOIN product_category pc\r\n" + 
					"ON p.product_cate = pc.cate_no\r\n" + 
					"where p.product_no = ?";
					
			pstmt = conn.prepareStatement(selectIdSQL);
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ProductCategory pc = new ProductCategory();
				
				pc.setCate_no(rs.getString("cate_no"));
				pc.setCate_name(rs.getString("cate_name"));
			
				p = new Product();
				
				p.setProduct_no(rs.getString("product_no"));
				p.setProduct_name(rs.getString("product_name"));
				p.setProduct_price(rs.getInt("product_price"));
				p.setProduct_detail(rs.getString("product_detail"));
				p.setProductCategory(pc);
				
				
		
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			DBClose.close(conn, pstmt, rs);
		}
		
		return p;
	}
	
	
}
