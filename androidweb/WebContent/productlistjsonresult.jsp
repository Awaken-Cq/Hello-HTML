
<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <%
	List<Product> plist = (List) request.getAttribute("pd");
<%
	if (plist == null || plist.size() == 0) {
%>
<%
	} else {
		for (int i = 0; i < plist.size(); i++) {
		for(Product p : plist)
			cate = plist.get(i).getProductCategory().getCate_name();
			no = plist.get(i).getProduct_no();
			name = plist.get(i).getProduct_name();
			price = plist.get(i).getProduct_price();
%> --%>
<c:set var="plist" value="${requestScope.pd}"/>

<c:choose>
	<c:when test="${empty plist}">
	상품이 없습니다.
	</c:when>
	<c:otherwise>
		<c:forEach var="p" items="${plist}" >
		<div>
			<div class="productinfo" style="float:left;text-align:center;">
			<img  id="${p.product_no}" class="pimg" src="img/${p.product_no}.jpg" alt="${p.product_name}"><br>
			category : <span>${p.productCategory.cate_name}</span><br>
			no : <span>${p.product_no}</span><br>
			name : <span>${p.product_name}</span><br>
			price : <span>${p.product_price}</span><br> 
			</div>
		</div>
		</c:forEach>
	
	</c:otherwise>
	</c:choose>

<%-- <div>
	<div class="productinfo" style="float:left;text-align:center;">
<img  id="<%=no%>" class="pimg" src="img/<%=no%>.jpg" alt="<%=name%>"><br>
category : <span><%=cate%></span><br>
no : <span><%=no%></span><br>
name : <span><%=name%></span><br>
price : <span><%=price%></span><br> 
	</div>
</div> --%>
<%-- <%
	}
%>

<%
	}
%> --%>

