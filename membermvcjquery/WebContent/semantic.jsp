<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semantic.jsp</title>
<style>
header {<!--
	background-image: url("/img/logo.png");
	background-repeat: no-repeat;
	background-position: right;
	height: 100px;
	-->
}

nav>ul {
	list-style: none;
	padding: 0px;
}

nav>ul>li {
	display: inline-block;
}

footer {
	position: fixed;
	bottom: 0px;
	width: 100%;
	background-color: steelblue;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		//dom트리에서 nav>ul>li>a객체들 찾기
		var aArr = $("nav>ul>li>a");
		$(aArr).click(function() {
			var vurl = $(this).attr("href");
			if (vurl == 'logout') {
				$.ajax({
					url : vurl,
					method : 'get',
					success : function(result) {
						alert(result.trim());
						location.href = "semantic.jsp";
					}
				});
			} else {

				$.ajax({
					//js 객체의 프로퍼티 : 프로퍼티값
					url : vurl, // 요청할 url(vurl)
					method : 'get', // 요청할 method(get)
					//success 프로퍼티는 함수형태로 만들어져야 한다.
					success : function(result) { //응답받았을때 결과 가져올 인자값을 넣어줘야한다.(result)
						$("section").html(result);
						pimgClickEvent();
						
					}
				});
			}
			return false;
		});
	});

	function pimgClickEvent() {
		var pArr = $(".pimg");

		$(pArr).click(function() {
			pinfo = $(this).attr("id");
			
			$.ajax({
				url : 'productinfo',
				method : 'GET',
				data : "pinfo=" + pinfo,
				success : function(result) {
					$("section").html(result);
				basketClickEvent();
				}
			});
		});
	}

function basketClickEvent() {
		var bkBtn = $("button[name=bkBtn]");
		$(bkBtn).click(function(){
		var $no = $("div>div>input[name=no]").val();
		var $cnt = $("div>div>input[name=cnt]").val();
			alert("왔다.");
		$.ajax({
				url:"addcart",
				method:"get",
				data:{ no : $no,
					cnt : $cnt
					},
				success:function(result){
					alert("장바구니에 추가성공");
					$("div.addcartresult").remove();
					//$("section").html(result.trim());
					//기존섹션을 지우는 것이 아니라 버튼만 보이게 할것이기때문에 append
					$("section").append(result.trim());
				}
					
			});
			
			
			}); 
			
		}

</script>
</head>
<body>
	<header align="center">
		<h1>HEADER</h1>
	</header>
	<nav>
		메뉴
		<jsp:include page="menu.jsp" />
	</nav>
	<section>본문</section>
	<footer>성공한 프로그래머®CopyRight™</footer>
</body>
</html>