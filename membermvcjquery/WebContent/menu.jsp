<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<ul>
		<%String id =(String)session.getAttribute("loginInfo");
			if(id == null){
%>
		<li><a href="/membermvcjquery/user/login/member.jsp">가입</a></li>
		<li><a href="/membermvcjquery/user/login/login.jsp">로그인</a></li>
		<li><a href="productlist">전체상품</a></li>
		<li><a href="viewcart">장바구니</a></li>
		
		<%}else{ //로그인한 경우%> 
		<li><a href="logout">로그아웃</a></li>
		<li><a href="productlist">전체상품</a></li>
		<li><a href="viewcart">장바구니</a></li>
		<li><a href="productlistjson">전체상품JSON</a></li>
		
		<%} %>
	</ul>