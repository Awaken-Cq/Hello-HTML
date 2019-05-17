<%@ page import="com.kitri.dto.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!Product p;%>

<% p = (Product)request.getAttribute("p");
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
<%}%>