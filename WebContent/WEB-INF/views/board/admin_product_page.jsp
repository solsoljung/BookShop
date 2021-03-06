<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <title>제품 관리</title>
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
	$("#btnAddCategory").click(function(){
		location.href = "category_add_form.adm";
	});
	$(".btnCategoryDelete").click(function(){
		var that = $(this);
		var v = $(this).data("num");
		console.log(v);	
		var url = "category_delete.ajax";
		
		var sData = {
				"category_code" : v
		};
		$.post(url, sData, function(rData){
			if (rData.trim() == "success_category_delete") {
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
<br>
<br>
<br>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
		</div>
		<div class="col-md-6">
			<table class="table" style="font-size:30px;">
				<thead>
					<tr style="font-size:10pt">
						<th>장르 코드</th>
						<th>장르</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td>${vo.category_code}</td>
						<td><a href="category_book_list.adm?category_code=${vo.category_code}&category_code_explain=${vo.category_code_explain}">${vo.category_code_explain}</a></td>
						<td>
						  <input type="button" class="btnCategoryDelete" data-num="${vo.category_code}" style="font-weight:bold;font-size:13px;" value="X"/>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
				<input type="button" class="btn btn-success" value="카테고리 등록" id="btnAddCategory"/>
		</div>
		<div class="col-md-3">
		</div>
	</div>
</div>
</body>
</html>