package com.kitri.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.PageBean;
import com.kitri.dto.RepBoardDto;
import com.kitri.service.RepBoardService;

/**
 * Servlet implementation class RepBoardListServlet
 */
@WebServlet("/boardlist")
public class RepBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       RepBoardService service;
    public RepBoardListServlet() {
    	service = new RepBoardService();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cp = request.getParameter("currentPage");
		
		int currentPage = 1;//보여줄 현재페이지
		if(cp != null) {
			currentPage = Integer.parseInt(cp);
		}
		int cntPerPage = 10; // 페이지별 보여줄 목록수
		int cntPerPageGroup = 3;
		int totalCnt = service.getTotalCnt();
		String url="boardlist";
		PageBean pb = 
				new PageBean(currentPage,
							cntPerPage,
							cntPerPageGroup,
							totalCnt,
							url);
		
		List<RepBoardDto> list = 
				service.findByRows(pb.getStartRow(), pb.getEndRow());
		
		for(RepBoardDto dto : list) {
			System.out.println(dto);
		}
		pb.setList(list);
		
		//request.setAttribute("list", list);
		request.setAttribute("pb", pb);
//		for(RepBoardDto dto : list) {
//		System.out.println(dto);
//		}
		//현재페이지, startRow, endRow
		//1			1			10
		//2			11			20
		//3			21			30
		//5			41			50
//		현재페이지	이전	시작페이지	끝페이지	다음
//		1		x		1		3	o	
//		2		x		1		3	o
//		3		x		1		3	o
//		4		o		4		6	o
//		5		o		4		6	o
//		6		o		4		6	o
//		7		o		7		9	o
//		...
//		10		o		10		10	x
//		11 all x
		
//		int startRow = currentPage * cntPerPage - 9;
		//int startRow = (currentPage-1) * cntPerPage + 1;
		
		//int endRow = currentPage *cntPerPage;
		
		//총페이지 수 계산
		//int totalCnt = service.getTotalCnt();//총게시글 수
//		int totalPage = (totalCnt-1)/cntPerPage+1;
		//int totalPage = (int)Math.ceil((float)totalCnt/cntPerPage);//총페이지수
		
	//	request.setAttribute("totalPage", totalPage);
//		페이지그룹에 보여줄 페이지수
		
		
	
		
		//int startPage = ((currentPage-1)/cntPerPageGroup)*cntPerPageGroup+1;
		//int endPage = startPage + cntPerPageGroup-1;
		//if(endPage>totalPage) {
		//	endPage = totalPage;
		//}
		
		//1)현재 페이지를 3으로 남아서 나머지가 0이면 start는 현재페이지 -2 엔드페이지는 현재페이지 
		//2)현재 페이지를 3으로 남아서 나머지가 1이면 start는 현재페이지 -1 엔드페이지는 현재페이지 +1
		//3)현재 페이지를 3으로 남아서 나머지가 2이면 start는 현재페이지  엔드페이지는 현재페이지 +2
		
//		if(currentPage%cntPerPageGroup == 2) {
//			startPage = currentPage-2;
//			endPage = currentPage;
//
//		}else if(currentPage%cntPerPageGroup == 1) {
//			startPage = currentPage-1;
//			endPage = currentPage+1;
//			
//		}else if(currentPage%cntPerPageGroup == 0) {
//			startPage = currentPage;
//			endPage = currentPage+2;
//		}


		
		
		
		String path = "boardlistresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}


}
