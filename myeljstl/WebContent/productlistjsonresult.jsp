<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%List<Product> list = (List)request.getAttribute("productlist");
for(Product product: list){
	%><%=product.getProduct_name()%>
<%}%> --%>
${requestScope.productlist}

