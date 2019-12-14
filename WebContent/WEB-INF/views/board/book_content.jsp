<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	$("#btnPutCart").click(function(){
		var howmany = $("#dropdownVal").val();
		console.log(howmany);
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
			<img src="images/${vo.book_image}" width="500"/>
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
			<!-- 드롭다운 시작 -->
			<!-- <div class="dropdown">
				 
				<button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
					수량 선택
				</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="dropdownVal">
					 <a class="dropdown-item disabled" href="#">1</a> 
					 <a class="dropdown-item" href="#">2</a> 
					 <a class="dropdown-item" href="#">3</a>
				</div>
			</div> -->
			<div>
			<select class="selectpicker" title="수량선택" data-style="btn-primary" style="width:60px;height:40px;font-size:20px;"> 
						<option>1</option> 
						<option>2</option> 
						<option>3</option> 
						</select>
			</div>
			<!-- 드롭다운 끝 -->
			<br>
			<a href="#" id="btnPutCart" class="btn btn-lg active btn-link" type="button">장바구니</a> 
			<a href="#" class="btn btn-lg btn-link" type="button">바로 구매</a>
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
				<a class="btn" href="same_writer.sol?book_writer=${vo.book_writer}">바로 만나보기 »</a>
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
			<h2 align="center" style="font-family:Nanum DongHwaDdoBag">${vo.book_explain}</h2>
		
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