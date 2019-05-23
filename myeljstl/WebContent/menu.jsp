<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<ul>
	<c:set var="id" value="${sessionScope.loginInfo}"/>
		<c:choose>
		<c:when test="${empty id}"><%-- 로그인 안한 경우 --%>
			<li><a href="/myeljstl/user/login/member.jsp">가입</a></li>
			<li><a href="/myeljstl/user/login/login.jsp">로그인</a></li>
		</c:when>
		<c:otherwise> <%-- 로그인 한 경우 --%>
			<li><a href="logout">로그아웃</a></li>
		</c:otherwise>
		</c:choose>
			<li><a href="productlist">전체상품</a></li>
			<li><a href="viewcart">장바구니</a></li>
		<c:choose>
		<c:when test="${!empty id}">
			<li><a href="vieworder">주문내역보기</a></li>
		</c:when>
		</c:choose>
		<li><a href="productlistjson">전체상품JSON</a></li>
		<li><a href="write.html">글쓰기</a></li>
		
	</ul>