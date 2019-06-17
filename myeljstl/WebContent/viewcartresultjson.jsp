<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="jdk.nashorn.api.scripting.JSObject"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
ObjectMapper mapper = new ObjectMapper();
Map<Product, Integer> map = (Map)request.getAttribute("rcart");    
//1.map을 풀어헤침
for(Map.Entry<Product, Integer> entry : map.entrySet()){
	JSONObject json = new JSONObject();
	JSONObject productJson = new JSONObject(mapper.writeValueAsString(entry.getKey()));
	json.put("product", productJson);
	json.put("quantity", entry.getValue());
	JSONArray jArray = new JSONArray();
	jArray.put(json);

	%><%=jArray %><%
}%>


//2.풀어헤친 map을 json object로 재생성
    
//3.생성된 json을 jsonArray형태로 만들기

	

	



    