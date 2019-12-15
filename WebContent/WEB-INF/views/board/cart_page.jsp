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
	
	$("#btnCartDelete").click(function(){
		var v = $("#btnCartDelete").data("num");
		console.log(v);
		var url = "cart_delete.ajax";
		
		var sData = {
				"book_num" : v
		};
		$.post(url, sData, function(rData){
			if (rData.trim() == "delete_success") {
				getListAgain();
			}
		});
	});
	
	function getListAgain(){
		var url = "cart_list.ajax";
		var sData = {
				"mem_id" : "${mem_id}"
		};
		$.getJSON(url, sData, function(rData){
			$("#cartTable > tbody").empty();
			$.each(rData, function() {
				var tr = "<tr>";
					tr += "<td colspan='2'><img src=images/" + this.book_image + " width='150'/><span style ='font-size:20pt'>" + this.book_name + "</span></td>";
					tr += "<td style='font-size:15pt'>" + this.book_price + "원</td>";
					tr += "<td><input type='text' style='text-align:center; width:50px;' name='book_amount' value=" + this.book_amount + " /></td>";
					tr += "<td><div class='checkbox'><label><input type='checkbox' value='check1'/></label></div><input type='button' id='btnCartDelete' data-num=" + this.book_num + " style='font-weight:bold;font-size:13px;' value='X'/></td>";
					tr += "</tr>";
					console.log(rData);
				$("#cartTable > tbody").append(tr);
			});
		});
	}
	$("input[type=checkbox]").prop("checked", true);
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
				<c:forEach items="${list}" var="cartVo">
					<tr id="targetTr">
						<td colspan="2"><img src="images/${cartVo.book_image}" width="150"/>
						<span style ="font-size:20pt">${cartVo.book_name}</span></td>
						<td style="font-size:15pt">${cartVo.book_price}원</td>
						<td>
						<input type="text" style="text-align:center; width:50px;" name="book_amount" value="${cartVo.book_amount}"/>
						</td>
						<!-- 체크박스 -->
						<td>
						<div class="checkbox">
						  <label><input type="checkbox" value="check1"/></label>
						</div>
						  <input type="button" id="btnCartDelete" data-num="${cartVo.book_num}" style="font-weight:bold;font-size:13px;" value="X"/>
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
			<h3 align="center">
				총 상품 가격  :  51000원
			</h3> 
		</div>
		<div class="col-md-4">
			<!-- <button type="button" class="btn btn-success btn-lg btn-block"> -->
			<button type="button" class="btn btn-primary btn-lg">
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
	<script src="~/bootstrap-select.min.js"></script>
	<script src="~/defaults-ko-KR.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>