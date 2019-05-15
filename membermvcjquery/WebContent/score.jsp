<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	int voter = 0;
	int star = 0;
	int totalStar = 0;
	int avgStar = 0;
%>
<%
star = Integer.parseInt(request.getParameter("score"));
voter++;
totalStar += star;
avgStar = (totalStar/voter);
%>

참여자 수 : <%=voter%><br>
총 별점 : <%=totalStar%><br>
평균 별점 : <%=avgStar%>

