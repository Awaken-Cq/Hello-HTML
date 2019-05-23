<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- prefix="c"는 접두어 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl.jsp</title>
</head>
<body>
<%-- <c:set var="num" value="99"/> --%><%-- <% int num = 99;%> --%>
<c:set var="num" value="${param.num}"/><%-- <% int num=Integer.parseInt(request.getparameta("num"))%> --%>
<c:if test="${num%2==0}"> <%-- <%if(num%2==0){} %> --%>
${num}은 짝수입니다.
</c:if>
<hr>
<c:choose>
	<c:when test="${num%2==0}">${num}은 짝수입니다.</c:when>
	<c:otherwise>${num}은 홀수입니다.</c:otherwise>
</c:choose>
<hr>
<c:forEach begin="1" end="10" step="1" var="i"><%-- <%for i=1;i<=10,i++){} %> --%>
${i}<br>
</c:forEach>
<hr>
<c:set var="total" value="0"/>
<c:forEach begin="1" end="10" var="i"><!-- step을 생략하면 default로 1임. -->
	<c:set var="total" value="${total+i}"/><br><!-- c:set은 변수가 없으면 선언 존재하면 재사용(중복선언이 아님) -->
1~${i}합:${total}
</c:forEach>
<br>
<%
List<String> list = new ArrayList<>();
list.add("one");list.add("two");list.add("three");
request.setAttribute("list", list);
%>

<%-- <%for(String e : (String)request.getAttribute("list")){} %> --%>
<c:forEach var="e" items="${requestScope.list}">
${e}<br>
</c:forEach>
<hr>
<c:forEach var="e" items="${requestScope.list}" varStatus="obj">
${obj.index} - ${e} : ${obj.count}회 반복<br>
<!-- index는 list의 몇번째 요소를 사용하고있는지를 나타내고
count는 몇회 반복실행중인지를 나타냄. -->
</c:forEach>


</body>
</html>