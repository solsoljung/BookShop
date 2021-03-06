<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <title>책 상세보기</title>
<style>
.titleFont {
  font-weight: bold;
  color: 	#6495ED;
  font-size: 64px;

}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- Latest compiled and minified CSS -->


<script>
$(function(){
	$(".btnCartAjax").click(function(){
// 		console.log($(this));
		var that = $(this);
		var v = $(this).data("num");
		var book_amount = $("#inputAmount").val();
		console.log(v);	
		var url = "cart.ajax";
		
		var sData = {
				"book_num" : v,
				"book_amount" : book_amount
		};
		$.post(url, sData, function(rData){
			if (rData.trim() == "cart_add") {
				var result = confirm('장바구니로 이동하시겠습니까?'); 
				if(result) { 
					location.replace('cart_form.mem'); 
					} else {
						//no 
					}
			}
		});
	});
	$("#btnBuyNow").click(function(){
		var book_amount = $("#inputAmount").val();
		location.href = "buy_pro.mem?checked=${vo.book_num}&arrayParam=" + book_amount;
	});
});

</script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<br>
<br>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-4">
			<img src="upload/${vo.book_image}" width="500"/>
		</div>
		<div class="col-md-4">
			<h1>${vo.book_name}</h1>
			<br>
			<h1>${vo.book_writer}</h1>
			<br>
			<h1>${vo.book_price}원</h1>
			<br>
			<h1>☆☆☆☆☆</h1>
			<br>
			수량:&nbsp;&nbsp;
			<input type="text" id="inputAmount" style="text-align:center;font-size:20px;width:50px;" name="book_amount" value="1"/>&nbsp;개
			<br>
			<br>
			<c:choose>
				 	<c:when test="${not empty mem_id}">
<a id="btnPutCart" class="btn btn-lg active btn-link btnCartAjax" type="button" data-num="${vo.book_num}">장바구니</a>
<a id="btnBuyNow" class="btn btn-lg btn-link" type="button">바로 구매</a>
					</c:when>
					<c:otherwise>
<a href="login.sol" class="btn btn-lg btn-link" type="button">장바구니 담기</a>
<a href="login.sol" class="btn btn-lg btn-link" type="button">바로 구매</a>
					</c:otherwise>
			</c:choose>
		</div>
		<div class="col-md-2">
		</div>
	</div>
	<br>
	<hr>
	<br>
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-4">
			<h1>
				이 작가의 다른 작품
			</h1>
			<h5>
				이 작가의 다른 책도 만나보세요!
			</h5>
			<p>
				<a class="btn" href="best.sol?search_keyword=${vo.book_writer}">바로 만나보기 »</a>
			</p>
		</div>
		<div class="col-md-4">
			<h1>
				이 장르의 비슷한 소설
			</h1>
			<h5>
				이 책이 마음에 드셨다면!
			</h5>
			<p>
				<a class="btn" href="#">다른 책도 보기 »</a>
			</p>
		</div>
		<div class="col-md-2">
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<div class="row">
		<div class="col-md-3">
		</div>
		<div class="col-md-6">
			<h1 align="center" style="font-family:fontawesome-webfont">책소개</h1>
			<br>
			<br>
			<br>
			<!-- 집에서는 이것을 넣으시오  style="font-family:Nanum DongHwaDdoBag" -->
			<h2 align="center">${vo.book_explain}</h2>
		
		<br>
		<br>
		<br>
		<br>
		<br>
		</div>
		<div class="col-md-3">
		</div>
	</div>
	
</div>
	<script src="~/bootstrap-select.min.js"></script>
	<script src="~/defaults-ko-KR.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>