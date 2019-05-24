package com.kitri.service;

import java.util.List;

import com.kitri.dao.RepBoardDao;
import com.kitri.dto.RepBoardDto;
import com.kitri.exception.AddException;

public class RepBoardService {

	
	private RepBoardDao dao;
	public RepBoardService() {
		dao = new RepBoardDao();
	}
	
	public void write(RepBoardDto repBoardDto) throws AddException {
		dao.insert(repBoardDto);
	}
	
	public void reply(RepBoardDto repBoardDto) throws AddException {
		if(repBoardDto.getParent_seq()==0) {
			throw new AddException("부모글번호가 없는 답글입니다.");
		}
		dao.insert(repBoardDto);
	}
	
	public List<RepBoardDto> findByRows(int startRow, int endRow) {
		return dao.selectByRows(startRow, endRow);
		
	}

	public int getTotalCnt() {
		
		return dao.selectTotalCnt();
	}


}
