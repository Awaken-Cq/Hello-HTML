package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.RepBoardDto;
import com.kitri.exception.AddException;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class RepBoardDao {

	public void insert(RepBoardDto repBoardDto) throws AddException {
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
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new AddException("게시글 등록 오류 : " + e.getMessage());

		} finally {
			DBClose.close(con, pstmt);
		}

	}


	public List<RepBoardDto> selectByRows(int startRow, int endRow) {
		List<RepBoardDto> list = new ArrayList<>();
		String selectByRowsSQL = "SELECT *\r\n" + "FROM(SELECT rownum r, repboard.*\r\n" + "FROM repboard\r\n"
				+ "START WITH parent_seq = 0\r\n" + "CONNECT BY PRIOR board_seq = parent_seq\r\n"
				+ "ORDER SIBLINGS BY board_seq DESC)\r\n" + "WHERE r between ? and ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.makeConnection();
			pstmt = con.prepareStatement(selectByRowsSQL);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 검색결과의 한행의 정보를 RepBoard객체에 대입
				RepBoardDto repBoard = new RepBoardDto();

				repBoard.setBoard_seq(rs.getInt("board_seq"));
				repBoard.setParent_seq(rs.getInt("parent_seq"));
				repBoard.setBoard_subject(rs.getString("board_subject"));
				repBoard.setBoard_writer(rs.getString("board_writer"));
				repBoard.setBoard_contents(rs.getString("board_contents"));
				repBoard.setBoard_date(rs.getTimestamp("board_date"));
				repBoard.setBoard_password(rs.getString("board_password"));
				repBoard.setBoard_viewcount(rs.getInt("board_viewcount"));

				list.add(repBoard);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBClose.close(con, pstmt, rs);
		}

		return list;
	}
	
	
	



public static void main(String[] args) {
	RepBoardDao dao = new RepBoardDao();
//		RepBoardDto repBoardDto = new RepBoardDto();
//		repBoardDto.setBoard_contents("ㄴㄱㄷㄹ");
//		repBoardDto.setBoard_password("1234");
//		repBoardDto.setBoard_subject("벌써6개월");
//		repBoardDto.setBoard_writer("니내가누군지아니?");
	// repBoardDto.setParent_seq(1); //답글쓰기용 테스트
	
//	try {
//			dao.insert(repBoardDto);
	
		for(RepBoardDto repBoard : dao.selectByRows(1, 10)){
			System.out.println(repBoard.toString());
			System.out.println("------------------------------");
		}
//	} catch (AddException e) {
//		e.printStackTrace();
//	}
	
}


public int selectTotalCnt() {
	String selectTotalCntSQL = "SELECT count(*) cnt From repboard";
	int totalCnt= -1;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		con = DBConnection.makeConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery(selectTotalCntSQL);
		if(rs.next()) {
			totalCnt = rs.getInt("cnt");
		}
	}catch(Exception e) {
		
	}finally {
		DBClose.close(con, stmt, rs);
	}
	return totalCnt;
}

}
