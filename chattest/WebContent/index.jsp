<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(function(){
	var btn = $("button[name=qwer]");
//function login(){
	$(btn).click(function(){
		var info = $("div>input").val();
		//alert("err");
		alert(info);
		
	});
//}

});

</script>
</head>
<body>
<div>
<input type="text">
<button name="qwer" type="button">입장</button>
</div>
</body>
</html>