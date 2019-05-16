<%@page import="com.kitri.util.MoveUrl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.MemberDto, com.kitri.util.MoveUrl"%>
<%@ include file="/template/header.jsp"%>

<script type="text/javascript"">
function deleteMember(){
	if(confirm("탈퇴하시겠습니까?")){
		document.location.href = "<%=root%>/user?act=deletemember";
		
	}
}
</script>
<%
//String name = request.getParameter("name");
MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
if(memberDto != null){
%><Strong><%=memberDto.getName()%>(<%=memberDto.getId()%>)</Strong>님 환영합니다 ^_^<br>
<a href="<%=root%>/user?act=logout">로그아웃</a>
<a href="<%=root%>/user?act=mvmodify">정보수정</a>
<a href="" onclick="javascript:deleteMember();">회원탈퇴</a>
<%
if("now0510".equals(memberDto.getId())){
%>
<a href="<%=root%>/admin?act=memberlist">관리자</a>
<%
}
%>

<%
}else{
	MoveUrl.redirect(request, response, "/user?act=mvlogin");
}
%>



<%@ include file="/template/footer.jsp"%>