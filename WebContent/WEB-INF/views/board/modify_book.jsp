<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <title>책 정보 수정</title>
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
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			<form action="book_modify.adm">
			<input type="hidden" name="book_num" value="${vo.book_num}"/>
			<table class="table">
				<tr>
					<td>제목</td>
					<td><input type="text" value="${vo.book_name}" name="book_name" style="text-align:center; width:200px;"></td>
				</tr>
				<tr>
					<td>작가</td>
					<td><input type="text" value="${vo.book_writer}" name="book_writer" style="text-align:center; width:200px;"></td>
				</tr>
				<tr>
					<td>재고량</td>
					<td><input type="text" value="${vo.book_stock}" name="book_stock" style="text-align:center; width:200px;"></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" value="${vo.book_price}" name="book_price" style="text-align:center; width:200px;"></td>
				</tr>
				<tr>
					<td>카테고리</td>
					<td><input type="text" value="${vo.category_code}" name="category_code" style="text-align:center; width:200px;"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="100" rows="10" name="book_explain">${vo.book_explain}</textarea></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" value="${vo.book_image}" name="book_image"></td>
				</tr>
			</table>
			<input type="submit" class="btn btn-success" value="수정완료">
		</form>
		</div>
		<div class="col-md-2">
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