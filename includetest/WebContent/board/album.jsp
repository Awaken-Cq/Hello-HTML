<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- include하는 방법 2가지 
<jsp:include page="/templete/header.jsp"></jsp:include> -->
<!-- 실행된 결과화면(html)을 출력 -->
<%@ include file="/templete/header.jsp"%>
<!-- 파일자체(코드)롤 통째로 가져온다. -->
<%=name%>사진이 나와요..!!!
<%@ include file="/templete/footer.jsp"%>