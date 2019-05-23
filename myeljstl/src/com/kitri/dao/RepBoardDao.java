package com.kitri.dao;

import java.sql.*;

import com.kitri.dto.RepBoardDto;
import com.kitri.exception.AddException;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class RepBoardDao {

	public void insert(RepBoardDto repBoardDto) throws AddException{
		String insertSQL = "insert into repboard( \r\n"
		+ " BOARD_SEQ, PARENT_SEQ, BOARD_SUBJECT, BOARD_WRITER, BOARD_CONTENTS, BOARD_DATE, BOARD_PASSWORD, BOARD_VIEWCOUNT) \r\n"
+ " values(BOARD_SEQ.NEXTVAL, ?, 		?, 				?, 				?, 		systimestamp, 		?,			0)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.makeConnection();
			pstmt = con.prepareStatement(insertSQL);
			
			pstmt.setInt(1, repBoardDto.getParent_seq());
			pstmt.setString(2, repBoardDto.getBoard_subject());
			pstmt.setString(3, repBoardDto.getBoard_writer());
			pstmt.setString(4, repBoardDto.getBoard_contents());
			pstmt.setString(5, repBoardDto.getBoard_password());
			
			int r = pstmt.executeUpdate();
			System.out.println("업데이트된 컬럼 수 : " + r);
			
		} catch (Exception e) {
			try {
				con.rollback();
			}catch (SQLException e1){
			e1.printStackTrace();
			}
			e.printStackTrace();
			throw new AddException("게시글 등록 오류 : " + e.getMessage());
			
		} finally {
				DBClose.close(con, pstmt);
		}
		
	}
	
	public static void main(String[] args) {
		RepBoardDao dao = new RepBoardDao();
		RepBoardDto repBoardDto = new RepBoardDto();
		repBoardDto.setBoard_contents("ㄴㄱㄷㄹ");
		repBoardDto.setBoard_password("1234");
		repBoardDto.setBoard_subject("벌써6개월");
		repBoardDto.setBoard_writer("니내가누군지아니?");
		//repBoardDto.setParent_seq(1); //답글쓰기용 테스트
	
		try {
			dao.insert(repBoardDto);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}
	
	
}
