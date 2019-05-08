<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
int cnt = 0;
int max;
String cntStr;
String cntTotal;

public void init(){
	cnt = 0;
	max = 8;
	}

%>

<%
cnt++;
cntStr = "";
cntTotal = "";
cntStr = String.valueOf(cnt);
int len = cntStr.length();
int zeroCnt = max-len;
	for(int i = 0; i< zeroCnt;i++) {
		cntTotal += "0";
	}
	cntTotal += cntStr;
%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">당신은<%
for(int i = 0 ; i<cntTotal.length();i++){%><img width="50" src="/basicjsp/img/<%=cntTotal.charAt(i)%>.png"><%
}
%>번째 방문자입니다.
</div>
</body>
</html>