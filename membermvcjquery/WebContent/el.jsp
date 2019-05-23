<%@page import="com.kitri.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
작업구분
<hr>
<%=request.getParameter("opt")%>작업을 선택했습니다.<br>
${param.opt}작업을 선택했습니다.
<hr>
<%=Integer.parseInt(request.getParameter("a"))+10%><br>
${param.a+10}
<hr>
<% CustomerDto c = new CustomerDto("id1", "p1", "nl");
request.setAttribute("c",c);%>
고객이름 : <%=((CustomerDto)request.getAttribute("c")).getName()%><br>
고객이름 : ${requestScope.c.name}
</body>
</html>