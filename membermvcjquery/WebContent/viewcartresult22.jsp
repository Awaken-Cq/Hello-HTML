<%@page import="java.util.Set"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
    
</script>
<%!
Map<Product, Integer> rcart;

String cate;
String name;
String no;
int price;
int quantity;
int total;
%>

<%
rcart = (Map)request.getAttribute("rcart");

if(rcart == null){
	System.out.println("servlet->jsp 전송이 실패했습니다.");
}else{
/* for(int i = 0;i<rcart.size();i++){
	 //rcart.keySet().toArray();
	for(int j= 0 ; i<rcart.keySet().toArray().length ; i++){
		Product p = (Product)rcart.keySet().toArray()[i];
	} */
	Set<Product> keys =rcart.keySet();
	for( Product p : keys){
		cate = p.getProductCategory().getCate_name();
		name = p.getProduct_name();
		no = p.getProduct_no();
		price = p.getProduct_price();
		quantity = rcart.get(p);
		total = price * quantity;
		%>
		<div style="float:left;">
		<img src="img/<%=no%>.jpg">
		<div>
		상품번호 : <span><%=no%></span><br>
		상품명 : <span><%=name%></span><br>
		종류 : <span><%=cate%></span><br>
		가격 : <span><%=price%></span><br>
		수량 : <span><input type="number" value="<%=quantity%>" min="1" max="99"></span><br>
		총 가격 : <span><%=total%></span>
		</div>
		
		</div>
	<%}%>
	
<%}%>


