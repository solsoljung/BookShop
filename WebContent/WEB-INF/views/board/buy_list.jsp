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
	$("#btnCartAgain").click(function(){
		location.href = "cart_form.mem";
	});
	
	$("#btnBuy").click(function(e){
		var phone = $("#mem_phone").val();
		var address = $("#mem_address").val();
		if(phone == "" || address == ""){
			alert("결제창에 정보를 입력해주세요.");
		} 
		/* else{
			location.href = "payment.mem";
		} */
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
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="vo">
					<tr class="targetTr">
						<td colspan="2"><img src="upload/${vo.book_image}" width="50"/>
						<span style ="font-size:20pt">${vo.book_name}</span></td>
						<td style="font-size:15pt" class="onePrice">${vo.book_price}</td>
						<td style="font-size:15pt" class="oneAmount">${vo.book_amount}</td>
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
				총 상품 가격  :  <span>${allPrice}</span>원
			</h1> 
		</div>
		<div class="col-md-4">
			<button type="button" class="btn btn-success btn-lg" id="btnCartAgain">
				장바구니로
			</button>
			<br>
			<br>
			<br>
		</div>
		<div class="col-md-2">
		</div>
</div>
</div>
<div class="row">
	<div class="col-md-4">
	</div>
		<div class="col-md-4">
		<br>
		<br>
		<br>
		<br>
		<h1 align="center">결제 정보</h1>
		<br>
		<br>
			<form role="form" style="font-size:20pt" action="payment.mem">
				<input type="hidden" name="allPrice" value="${allPrice}">
				<div class="form-group">
					 
					<label for="exampleInputEmail1">
						휴대폰 번호
					</label>
					<input type="text" class="form-control" name="mem_phone" id="mem_phone" value="${memberVo.mem_phone}"/>
				</div>
				<div class="form-group">
					 
					<label for="exampleInputPassword1">
						주소
					</label>
					<input type="text" class="form-control" name="mem_address" id="mem_address" value="${memberVo.mem_address}"/>
				</div>
				<input type="submit" value="결제하기" id="btnBuy">
			</form>
		</div>
		<div class="col-md-4">
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