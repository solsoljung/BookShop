<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <title>상품 구매</title>
<style>

 #center {
	line-height: 200px;
      }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- Latest compiled and minified CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/3.3.7/paper/bootstrap.min.css" rel="stylesheet"/>
<script>
$(function(){

	$(".btnCartDelete").click(function(){
// 		console.log($(this));
		var that = $(this);
		var v = that.data("num");
		console.log(v);	
		var url = "buyList_delete.ajax";
		
		var sData = {
				"book_num" : v
		};
		$.post(url, sData, function(rData){
			if (rData.trim() == "delete_success") {
				that.parent().parent().remove();
			}
		});
	});
	
	$("#btnBuy").click(function(e){
		e.preventDefault();
		var amount = 0;
		$(".oneAmount").each(function(){
			amount = $(this).text();
		});
		$(".onePrice").each(function(){
			price = $(this).text();
		});
		console.log(amount);
	});
	
});

</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<br>
<br>
<h1 align="center">상품 결제</h1>
<br>
<br>
<br>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			<table class="table" id="cartTable">
				<thead>
					<tr style="font-size:10pt">
						<th colspan="2">상품명</th>
						<th>가격</th>
						<th>수량</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="vo">
					<tr class="targetTr">
						<td colspan="2"><img src="images/${vo.book_image}" width="50"/>
						<span style ="font-size:20pt">${vo.book_name}</span></td>
						<td style="font-size:15pt" class="onePrice">${vo.book_price}</td>
						<td style="font-size:15pt" class="oneAmount">${vo.book_amount}</td>
						<!-- 체크박스 -->
						<td>
						  <input type="button" class="btnCartDelete" data-num="${vo.book_num}" style="font-weight:bold;font-size:13px;" value="X"/>
						</td>
						<!-- 체크박스 끝-->
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-2">
		</div>
	</div>
	<br>
	<hr>
	<br>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-4">
			<h1 align="center">
				총 상품 가격  :  51000원
			</h1> 
		</div>
		<div class="col-md-4">
			<!-- <button type="button" class="btn btn-success btn-lg btn-block"> -->
			<button type="button" class="btn btn-primary btn-lg" id="btnBuy">
				결제하기
			</button>
			<button type="button" class="btn btn-success btn-lg">
				계속 쇼핑하기
			</button>
			<br>
			<br>
			<br>
		</div>
		<div class="col-md-2">
		</div>
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