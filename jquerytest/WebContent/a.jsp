<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%//request.setCharacterEncoding("utf-8"); %>
<%String id = request.getParameter("id");
String name = request.getParameter("name");
%>
<%
Thread.sleep(10*1000);
%><%=name%>(<%=id%>)님 환영합니다:)