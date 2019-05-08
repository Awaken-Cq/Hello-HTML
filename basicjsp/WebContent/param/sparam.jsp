<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
int age = Integer.parseInt(request.getParameter("age"));
String id = request.getParameter("id");


String color = age == 10? "pink" : "cyan";
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><%=name %><font color="<%=color %>"><%=id%></font>님 안녕하세요</div>


</body>
</html>