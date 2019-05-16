<%@page import="java.io.Console"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String cate;
	String no;
	String name;
	int price;%>

<%
	List<Product> plist = (List<Product>) request.getAttribute("pd");

%>
<%
	if (plist == null || plist.size() == 0) {
%>상품이 없습니다.
<%
	} else {
		for (int i = 0; i < plist.size(); i++) {
			cate = plist.get(i).getProductCategory().getCate_name();
			no = plist.get(i).getProduct_no();
			name = plist.get(i).getProduct_name();
			price = plist.get(i).getProduct_price();
%>

<div>
	<div class="productinfo">
<img  id="<%=no%>" class="pimg" src="img/<%=no%>.jpg" width="100"><br>
category : <%=cate%><br>
no : <%=no%><br>
name : <%=name%><br>
price : <%=price%><br> 
	</div>
</div>
<%
	}
%>

<%
	}
%>

