<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include.jsp</title>
</head>
<body>
<h3>포함지시자</h3>
<%@include file="loginresult.jsp" %><%//파일의 내용자체를 가져와 코드에 추가함
//변하지않을 내용의 jsp를 넣으려면 포함지시자를 사용하는게 좋다.%>
<hr>
<h3>포함태그</h3>
<jsp:include page="loginresult.jsp"/><%//메소드로 실행을 시켜 결과만 출력함
//동적으로 변하는 내용의 jsp를 넣으려면 포함태그를 사용하는게 좋다.%>
</body>
</html>