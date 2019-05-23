<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
$(function(){
	var bArr = $("div.addcartresult>button");
	$(bArr[0]).click(function(){
		alert("상품목록클릭");
		//메뉴중 상품목록메뉴찾기
		$("nav>ul>li>a[href=productlist]").trigger("click");
		return false;
	});
	$(bArr[1]).click(function(){
		alert("가자");
		$("nav>ul>li>a[href=viewcart]").trigger("click");
		return false;
	});
});
</script>


<div class="addcartresult" style="position:absolute;top:200px;left:100px;width:250px;border:1px solid;background-color:yellow;">
장바구니에 넣었습니다.
<button>상품목록으로 가기</button>
<button>장바구니로 가기</button>
</div>