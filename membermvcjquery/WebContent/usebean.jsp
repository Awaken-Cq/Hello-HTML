<%@page import="com.kitri.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usebean.jsp</title>
</head>
<body>
<%-- <%
//1.request의 속성(이름:"c" , 타입:com.kitri.dto.Customer)얻기
CustomerDto c = (CustomerDto)request.getAttribute("c");

//2.1 속성이 null인 경우
// Customer객체생성하여 c참조변수에 대입
// c참조변수를 request의 속성(이름:"c")로 추가.
if(c == null){
	c = new CustomerDto();
	request.setAttribute("c", c);
}

%> --%>
<!-- 클래스는 꼭 패키지명으로 써주기 -->
<jsp:useBean id="c" class="com.kitri.dto.CustomerDto" scope="request"/>

<%-- <%
c.setId("id1");
%> --%>
<jsp:setProperty name="c" property="id" value="id1"/>

<!-- c.setName(request.getParameter("n")); -->
<jsp:setProperty name="c" property="name" param="n"/>

<%-- <%=c.getId() %> --%>
<jsp:getProperty name="c" property="id"/>



</body>
</html>