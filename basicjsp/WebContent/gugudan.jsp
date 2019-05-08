<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!
int i;
int j;

	public String ggdProcess() {
		String sp = "";
		sp ="<table border=\"2\" align=\"center\" width=\"800\" height=\"600\">";
		for (j = 0; j < 10; j++) {
			sp += "<tr align=\"center\"> \n";
			for (i = 2; i < 10; i++) {
				if(j == 0 ){
					sp += "<td>" + i + "단</td> \n";
				}else{
			sp += "<td> " + i + " * " + j + " = " + i * j + "</td> \n";
			}
		}
	} 	sp +="</table>";
		return sp;		
	}%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>*** 구구단out.println ***</h3>
		<table border="2" width="800" height="700">
		<%
				for (j = 0; j < 10; j++) {
					out.println("<tr align=\"center\">");
					for (i = 2; i < 10; i++) {
						if (j == 0) {
							out.println("<td>" + i + "단" + "</td>");
						} else {
							out.println("<td>" + i + " * " + j + " = " + (i * j) + "</td>");
						}
					}
					out.println("</tr>");
				}
			%>
		</table>
		<hr>
		<h3>*** 구구단(out & 출력태그???) ***</h3>
		
		<% String sp = ggdProcess(); %>
		<%= sp %>
				
		
		
		
		</table>

		<hr>
		<h3>*** 구구단(출력태그) ***</h3>
		<table border="2" width="800" height="700">
		<%for(j=0;j<10;j++){%>
			<tr align="center">
			<%for(i=2;i<10;i++) {%>
				<%if(j==0){ %>
				<td><%=i%>단</td> 
				<%}else{ %>
				<td><%=i + " * " + j + " = " + (i*j)%></td> 
				<%} %>
			<%} %>
			</tr>
		<%} %>
		</table>
		<hr>
		
	</div>
</body>
</html>