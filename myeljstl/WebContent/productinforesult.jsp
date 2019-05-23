<%@ page import="com.kitri.dto.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="p" value="${requestScope.p}"/>
<c:choose>
	<c:when test="${empty p}">
	상품 정보를 조회할 수 없습니다.
	</c:when>
	<c:otherwise>
	<div style="float:left;text-align:center">
	<img name="${p.product_no}" src="img/${p.product_no}.jpg" width=500>
	<div>
	
		Category :${p.productCategory.cate_name}<br>
		Product_No :${p.product_no}<br>
		Product_Name :${p.product_name }<br>
		Product_Price :<fmt:formatNumber value="${p.product_price}" type="currency" currencySymbol="￦"/><br>
		<!-- <form action="addcart" method="get"> -->
		<input type="hidden" name="no" value="${p.product_no}">
		Product_Count : <input type="number" name="cnt" value="1" min="1" max="999">
		<button name="bkBtn">장바구니넣기</button>
		<!-- </form> -->
	</div>
</div>
	</c:otherwise>
</c:choose>
<%-- <% p = (Product)request.getAttribute("p");
if(p==null){
%>	상품 정보를 조회할 수 없습니다.
<%}else{
	String no = p.getProduct_no();
%>
<div style="float:left;text-align:center">
	<img name="<%=no%>" src="img/<%=no%>.jpg" width=500>
	<div>
		Category :<%=p.getProductCategory().getCate_name()%><br>
		Product_No :<%=no%><br>
		Product_Name :<%=p.getProduct_name()%><br>
		Product_Price :<%=p.getProduct_price()%><br>
		<!-- <form action="addcart" method="get"> -->
		<input type="hidden" name="no" value="<%=no%>">
		Product_Count : <input type="number" name="cnt" value="1" min="1" max="999">
		<button name="bkBtn">장바구니넣기</button>
		<!-- </form> -->
	</div>
</div>
<%}%> --%>