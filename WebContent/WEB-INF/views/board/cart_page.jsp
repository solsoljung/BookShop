<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <title>장바구니</title>
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
		var v = $(this).data("num");
		console.log(v);	
		var url = "cart_delete.ajax";
		
		var sData = {
				"book_num" : v
		};
		$.post(url, sData, function(rData){
			if (rData.trim() == "delete_success") {
				console.log(rData.trim());
				that.parent().parent().remove();
			}
		});
	});
	
	$("#btnBuy").click(function(e){
		location.href = "buy_list.mem";
	});
	
	$(".plus").click(function(){
		var num = $(this).prev().val();
		var plusNum = parseInt(num) + 1;
				   
		if(plusNum >= 20) {
			$(this).prev().val(num);
		} else {
			$(this).prev().val(plusNum);          
		}

		var url = "change_book_num.ajax";
		var v = $(this).prev().data("num");
		var sData = {
				"book_num" : v,
				"book_amount" : plusNum
		};
		$.post(url, sData, function(rData){
			console.log(rData);
		});
		  });
	$(".minus").click(function(){
		var num = $(this).next().val();
		var minusNum = parseInt(num) - 1;
				   
		if(minusNum < 0) {
			$(this).next().val(num);
		} else {
			$(this).next().val(minusNum);   
		}
		
		var url = "change_book_num.ajax";
		var v = $(this).next().data("num");
		var sData = {
				"book_num" : v,
				"book_amount" : minusNum
		};
		$.post(url, sData, function(rData){
			console.log(rData);
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
<h1 align="center">장바구니</h1>
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
						<th>상품이미지</th>
						<th>상품명</th>
						<th>가격</th>
						<th>수량</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="cartVo">
					<tr class="targetTr">
						<td><img src="upload/${cartVo.book_image}" width="150"/></td>
						<td><span style ="font-size:20pt">${cartVo.book_name}</span></td>
						<td style="font-size:15pt">${cartVo.book_price}원</td>
						<td>
						<%-- <input type="text" style="text-align:center; width:50px;" name="book_amount" value="${cartVo.book_amount}"/> --%>
						<p class="cartStock">
 						<button type="button" class="minus">-</button>
 							<input type="number" data-num="${cartVo.book_num}" class="numBox" min="1" max="20" value="${cartVo.book_amount}" readonly="readonly"/>
						 <button type="button" class="plus">+</button>
 						</p>
						</td>
						<!-- 삭제 -->
						<td>
						  <input type="button" class="btnCartDelete" data-num="${cartVo.book_num}" style="font-weight:bold;font-size:13px;" value="X"/>
						</td>
						<!-- 삭제 끝-->
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
		<div class="col-md-8" align="center">
			<!-- <button type="button" class="btn btn-success btn-lg btn-block"> -->
			<button type="button" class="btn btn-primary btn-lg" id="btnBuy">
				선택한 상품 주문하기
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
	<script src="/resources/jquery/jquery-3.3.1.min.js"></script>
	<script src="~/bootstrap-select.min.js"></script>
	<script src="~/defaults-ko-KR.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>