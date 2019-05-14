package com.kitri.dao;

import java.sql.*;
import java.util.List;

import com.kitri.dto.CustomerDto;
import com.kitri.exception.NotFoundException;
import com.kitri.util.*;

public class CustomerDao {


	private static CustomerDao customerDao;
	
	static {
		
		customerDao = new CustomerDao();
		
	}
	
	private CustomerDao() {}
	
	public static CustomerDao getCustomerDao() {
		return customerDao;
	}

	
	
	
	public CustomerDto selectById(String id) throws com.kitri.exception.NotFoundException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 1.jdbc 드라이버 로드 n Connection
		
	
			try {
				conn = DBConnection.makeConnection();
				// Sql 작업
				String selectByIdSql = "select * from customer where id=?";
				pstmt = conn.prepareStatement(selectByIdSql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					CustomerDto c = new CustomerDto();
					c.setId("id");
					c.setPass(rs.getString("pass"));
					c.setName(rs.getString("name"));
					
					return c;
				} else {
					throw new NotFoundException("아이디에 해당하는 고객이 없습니다.");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new NotFoundException(e.getMessage());
			}finally {
				DBClose.close(conn, pstmt, rs);
			}			
	}

	

	public List<CustomerDto> selectByName(String name) {

		return null;
	}

	public List<CustomerDto> selectAll(String name) {

		return null;
	}

	public void insert(CustomerDto c) {

	}

}
