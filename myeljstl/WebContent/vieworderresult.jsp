<%@page import="java.util.Date"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="com.kitri.dto.OrderLine"%>
<%@page import="com.kitri.dto.OrderInfo"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! int x;%>
<style>
.title{
 text-align:center;
}

</style>

<div class="vieworder">
<h4 class="title">주문내역 보기</h4>
<table style="text-align:center;border-collapse:collapse; width:80%; margin: 0 auto;" border="1" >
	<tr>
		<th>주문번호</th>
		<th>주문일자</th>
		<th>상품번호</th>
		<th>상품명</th>
		<th>가격</th>
		<th>주문수량</th>
		
	</tr>
<c:set var="list" value="${requestScope.orderlist}"/>	
<c:forEach var="info" items="${list}">
<c:set var="lines" value="${info.lines}"/>

<c:set var="linessize" value="${fn:length(lines)}"/>

	<tr>
	<td rowspan="${linessize}">${info.order_no}</td>
	<td rowspan="${linessize}">${info.order_date}</td>
	<c:forEach var="line" items="${lines}" varStatus="i">
	<c:set var="p"  value="${line.product}"/>
	<c:if test="${i.index >0}">
	<tr>
	</c:if>
		<td>${p.product_no}</td>
		<td>${p.product_name}</td>
		<td>${p.product_price}</td>
		<td>${line.order_quantity}</td>	
	</c:forEach>
	</tr>	
</c:forEach>

	
	
<%-- 	<% List<OrderInfo> list = (List)request.getAttribute("orderlist");

	for(OrderInfo info : list){
%><tr><%
		int order_no = info.getOrder_no();
		Date order_date = info.getOrder_date();
		List<OrderLine> lines = info.getLines();
%>	<td rowspan="<%=lines.size()%>"><%=order_no%></td>
	<td rowspan="<%=lines.size()%>"><%=order_date%></td>
	
<%		x = 0;
		for(OrderLine line : lines){
			if(x>0){%>
			<tr>
			
			<%}
			Product p = line.getProduct();
			String product_no = p.getProduct_no();
			String product_name = p.getProduct_name();
			int product_price = p.getProduct_price();
			int order_quantity = line.getOrder_quantity();
			x++;
%>		<td><%=product_no%></td>
		<td><%=product_name%></td>
		<td><%=product_price%></td>
		<td><%=order_quantity%></td>			
	</tr>
	<%}
	}%> --%>
</table>
</div>