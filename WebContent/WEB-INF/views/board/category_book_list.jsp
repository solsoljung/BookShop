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
$(function(){
	$("#btnAddBook").click(function(){
 		location.href = "add_book_form.adm?category_code=${category_code}";
	});
	$(".btnCartDelete").click(function(){
// 		console.log($(this));
		var that = $(this);
		var v = $(this).data("num");
		console.log(v);	
		var url = "book_delete.ajax";
		
		var sData = {
				"book_num" : v
		};
		$.post(url, sData, function(rData){
			if (rData.trim() == "book_delete_success") {
				var result = confirm("정말 삭제하시겠습니까?"); 
				if(result){
					that.parent().parent().remove();
				}
			}
			
		});
	});
});
</script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
${msg}
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
						<th>삭제</th>
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
						<td>
						  <input type="button" class="btnCartDelete" data-num="${vo.book_num}" style="font-weight:bold;font-size:13px;" value="X"/>
						</td>
					</tr>
				</c:forEach>
				</tbody>
				
			</table>
			<br>
			<input type="button" class="btn btn-success" value="상품등록" id="btnAddBook"/>
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