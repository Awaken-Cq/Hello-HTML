<%@ page import="com.kitri.dto.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!Product p;%>

<% p = (Product)request.getAttribute("p");
if(p==null){
%>	상품 정보를 조회할 수 없습니다.
<%}else{%>
<div>
	<img name="<%=p.getProduct_no()%>" src="img/<%=p.getProduct_no()%>.jpg" width=300>
	<div>
		Category :<%=p.getProductCategory().getCate_name()%>
		Product_No :<%=p.getProduct_no()%><br>
		Product_Name :<%=p.getProduct_name()%><br>
		Product_Price :<%=p.getProduct_price()%><br>
		Product_Count : <input type="number" name="cnt">
		<button type="button" name="bkBtn">장바구니담기</button>
	</div>
</div>
<%}%>