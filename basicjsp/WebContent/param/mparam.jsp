<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String name = request.getParameter("name");
int age = Integer.parseInt(request.getParameter("age"));
String[] fruit = request.getParameterValues("fruit");

String color = age == 10? "pink" : "cyan";

%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><%=name %>(<font color="<%=color %>"><%=id%></font>)님 안녕하세요<br>
당신이 좋아하는 과일은 <%
		if(fruit == null)
			out.println("없습니다.");
	else if(fruit.length == 1)
			out.println(fruit[0] + "입니다.");
		else {
			String str = "";
			for(int i = 0; i< fruit.length;i++) {
				str += fruit[i]+", ";
			}
			str = str.substring(0, str.length()-2);
			out.println(str+"입니다.");
		}
%></div>
</body>
</html>