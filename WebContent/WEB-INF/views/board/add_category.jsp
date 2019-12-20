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
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
			<form action="category_add_pro.adm">
			<table class="table">
				<tr>
					<td>카테고리 코드</td>
					<td><input type="text" name="category_code"></td>
				</tr>
				<tr>
					<td>카테고리 코드 설명</td>
					<td><input type="text" name="category_code_explain"></td>
				</tr>
			</table>
			<br>
			<br>
			<span style="float:right"><input type="submit" class="btn btn-success" value="추가하기"></span>
			
		</form>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	
		<br>
		<br>
		<br>
		<br>
		<br>
</div>
	<script src="~/bootstrap-select.min.js"></script>
	<script src="~/defaults-ko-KR.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>