<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <title>작가 페이지</title>
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
	<!-- 여기부턴 베스트 셀러 반복할 부분 -->
	<div class="row">
	<c:forEach items="${list}" var="bestVo" varStatus="status">
		<div class="col-md-2">
		</div>
		<div class="col-md-1">
			<h1 align="right">${status.count}</h1>
		</div>
		<div class="col-md-2">
		<img src="upload/${bestVo.book_image}" width="300"/>
		</div>
		<div class="col-md-5">
			<h1><a href="content.sol?book_num=${bestVo.book_num}">
				${bestVo.book_name}
				</a>
			</h1>
			<hr>
			<h4>${bestVo.book_writer}</h4>
			<h4>${bestVo.book_price}</h4>
			<h4>★★★★★</h4>
			<hr>
			<a href="#" class="btn btn-lg btn-link" type="button">장바구니 담기</a>
			<a href="#" class="btn btn-lg btn-link" type="button">바로 구매</a>
		</div>
		<div class="col-md-2">
		</div>
		<br>
		<hr>
		<br>
		</c:forEach>
		<hr>
	</div>
	<!-- 베스트셀러 끝! -->
</div>
</body>
</html>