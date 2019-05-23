<%@page import="java.io.FileInputStream"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page buffer="100kb" %>
<%@page errorPage="err.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
int x= 0;
%>
<% // 1~10000출력
for(int i = 0 ; i<10000;i++){
	++x;
%>
<%=x%>	
<%}%>
<% //a.txt파일을 byte단위로 읽기위한 스트림객체 생성
FileInputStream fis = null;
fis = new FileInputStream("a.txt");

%>




</body>
</html>