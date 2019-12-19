<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <title>베스트 셀러</title>
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
		<div class="col-md-8">
		<h1 align="center">${category_code_explain}</h1>
		<br>
		<br>
		<table class="table" style="font-size:30px;">
				<thead>
					<tr style="font-size:10pt">
						<th>책 번호</th>
						<th>책 제목</th>
						<th>재고량</th>
						<th>판매량</th>
						<th>가격</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td>${vo.book_num}</td>
						<td><a href="book_info_modify.adm?book_num=${vo.book_num}">${vo.book_name}</a></td>
						<td>${vo.book_stock}</td>
						<td>${vo.book_sold_count}</td>
						<td>${vo.book_price}</td>
					</tr>
				</c:forEach>
				</tbody>
				
			</table>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
		</div>
		<div class="col-md-2">
		</div>
	</div>
</div>
</body>
</html>