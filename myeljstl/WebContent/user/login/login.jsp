<%@ page import="com.kitri.controller.LoginServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/template/header.jsp"%>

<script type="text/javascript">
	$(function() {
		$("#loginBtn").click(function() {

			$.ajax({
				url : 'login',
				data : $('form').serialize(),
				method : 'post',
				success : function(result) {
					if (result.trim() == '1') {//성공
						location.href = "/myeljstl/semantic.jsp";

					} else {//실패
						alert(result.trim());
					}
				}
			});
			return false;

		});
	
		var $registerBtnObj = $("#moveRegisterBtn");//회원가입버튼객체
		$registerBtnObj.click(function(){
			//내가 메뉴를 직접클릭하지 않아도 강제로 클릭된것처럼 이벤트를 강제로 발생시킬 수 있다 : trigger
			//이벤트를 강제로 발생시키는것은 코드의 재사용성을 높히는 결과
		$("nav>ul>li>a[hrep='user/member.jsp']").trigger("click");
		});
	});
	
</script>
</head>
<body>

	<div class="container" align="center">
		<div class="col-lg-6" align="center">
			<h2>로그인</h2>
			<form id="loginform" method="post" action="">
				<input type="hidden" name="act" value="login">
				<div class="form-group" align="right">
					<label for=""><input type="checkbox" class="form-control"
						name="idsave" value="idsave" placeholder="">아이디저장</label>
				</div>
				<div class="form-group" align="left">
					<label for="">아이디</label> <input type="text" class="form-control"
						id="id" name="id" placeholder="">
				</div>
				<div class="form-group" align="left">
					<label for="">비밀번호</label> <input type="password"
						class="form-control" id="pass" name="pass" placeholder="">
				</div>
			</form>
			<div class="form-group" align="center">
				<button form="loginform" class="btn btn-warning" id="loginBtn">로그인</button>
				<button class="btn btn-primary" id="moveRegisterBtn">회원가입</button>
			</div>
		</div>
	</div>

	<%@ include file="/template/footer.jsp"%>