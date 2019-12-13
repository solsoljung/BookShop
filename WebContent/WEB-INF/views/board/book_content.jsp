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
			<img alt="Bootstrap Image Preview" src="images/book_content_image1.jpg" width="500"/>
		</div>
		<div class="col-md-4">
			<h1>우리가 간신히 희망할 수 있는 것</h1>
			<br>
			<h1>김영민</h1>
			<br>
			<h1>14000원</h1>
			<br>
			<h1>☆☆☆☆☆</h1>
			<br>
			<!-- 드롭다운 시작 -->
			<div class="dropdown">
				 
				<button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
					수량 선택
				</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					 <a class="dropdown-item disabled" href="#">1개</a> 
					 <a class="dropdown-item" href="#">2개</a> 
					 <a class="dropdown-item" href="#">3개</a>
				</div>
			</div>
			<!-- 드롭다운 끝 -->
			<br>
			<a href="#" class="btn btn-lg active btn-link" type="button">장바구니</a> 
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
				<a class="btn" href="#">바로 만나보기 »</a>
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
		<div class="col-md-1">
		</div>
		<div class="col-md-10">
			<h1 align="center">'올 겨울 최고의 웅앵웅!'</h1>
			<h2 align="center">한 겨울에 만나는 따스한 웅앵웅!</h2>
		</div>
		<div class="col-md-1">
		</div>
	</div>
	
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>