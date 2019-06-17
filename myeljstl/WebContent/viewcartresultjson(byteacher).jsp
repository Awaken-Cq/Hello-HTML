<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%-- <%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%> --%>
<%@page import="com.fasterxml.jackson.core.type.TypeReference"%>

<%@page import="java.util.HashMap"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.Map"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  
    
<%

 /*
 ObjectMapper mapper = new ObjectMapper();
 String result = 
 mapper.writeValueAsString(request.getAttribute("rcart"));
 */
%><%-- <%=result%> --%>
<%
Map<Product, Integer> rcart = (Map)request.getAttribute("rcart");
/* for(Product p: rcart.keySet()){
	JSONObject obj = new JSONObject();
	obj
	jsonArr.add(element)
} */
ObjectMapper mapper = new ObjectMapper();

System.out.println("------");
%>
<%
JSONArray jsonArr = new JSONArray(); 
for(Product p: rcart.keySet()){   
	
	/* [
	  {"product":{"prod_no":"001", "prod_name":, "productCategory":{}},
	 "quantity":1}
	 ,{"product":{"prod_no":"002", "prod_name":, "productCategory":{}},
		 "quantity":2}
	 ,{"product":{"prod_no":"003", "prod_name":, "productCategory":{}},
		 "quantity":3}
	
	] */
	//String key = p.toString();
	//String key = mapper.writeValueAsString(p);
   JSONObject jsonObj = new JSONObject();
   JSONObject jsonP = new JSONObject();   
   jsonP.put("prod_no", p.getProd_no());
   jsonP.put("prod_name", p.getProd_name());
   jsonP.put("prod_price",p.getProd_price());
   jsonP.put("prod_detail", p.getProd_detail()==null?"":p.getProd_detail());
   
   jsonObj.put("product", jsonP);
   jsonObj.put("quantity", rcart.get(p));
   jsonArr.add(jsonObj);
}%><%=jsonArr.toJSONString()%>
