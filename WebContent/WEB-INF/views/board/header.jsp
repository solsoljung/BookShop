<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>
<style>
.titleFont {
  font-weight: bold;
  color: 	#ff6933;
  font-size: 100px;

}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- Latest compiled and minified CSS -->

<script>
$(document).ready(function(){
	$("#imgGoMain").click(function(){
		location.href = "main.sol";
	});
	$("#btnMainLogo").click(function(){
		location.href = "main.sol";
	});
	$("#btnLogin").click(function(){
		location.href = "login.sol";
	});
	$("#notLoginMyPage").click(function(){
		location.href = "login.sol";
	});
	$("#notLoginCart").click(function(){
		location.href = "login.sol";
	});
	$("#btnLogout").click(function(){
		location.href = "logout.mem";
	});
	$("#btnCart").click(function(){
		location.href = "cart_form.mem";
	});
	$("#btnRegister").click(function(){
		location.href = "register.sol";
	});
});
</script>
</head>
<body>
<div class="container-fluid">
<div class="row">
		<div class="col-md-4">
			<img src="images/book_main.image.png" width="200" id="imgGoMain">
		</div>
		<div class="col-md-4" align="center">
			<ul class="nav">
				<li class="nav-item">
					<a class="nav-link active" href="best.sol">베스트 셀러</a>
				</li>
				<li class="nav-item">
					<a class="nav-link">국내도서</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">외국도서</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">장르별 보기</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">신간도서</a>
				</li>
			</ul>
			<hr>
			<span class="titleFont" style="font-family:'배달의민족 주아'" id="btnMainLogo">솔 책방</span>
		</div>
		<div class="col-md-4">
			<div class="btn-group" role="group">
				 <c:choose>
				 	<c:when test="${not empty mem_id}">
					<button class="btn btn-secondary" type="button" id="btnLogout">
					로그아웃
				</button> 
				<button class="btn btn-secondary" type="button" id="btnRegister">
					회원가입
				</button> 
				<button class="btn btn-secondary" type="button">
					마이 페이지
				</button> 
				<button class="btn btn-secondary" type="button" id="btnCart">
					장바구니
				</button>
					</c:when>
					<c:otherwise>
				<button class="btn btn-secondary" type="button" id="btnLogin">
					로그인
				</button> 
				<button class="btn btn-secondary" type="button" id="btnRegister">
					회원가입
				</button> 
				<button class="btn btn-secondary" type="button" id="notLoginMyPage">
					마이 페이지
				</button> 
				<button class="btn btn-secondary" type="button" id="notLoginCart">
					장바구니
				</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>
</body>
</html>