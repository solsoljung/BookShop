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
	
	var msg = "${msg}";
	if(msg == "buy_fail"){
		alert("[재고 부족] 구매를 실패하였습니다.");
	}else{
		
	}
	
	$(".cbox").prop("checked",true);
	
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
			//$(this).prev().val(plusNum);
		});
		
		//값 바뀔 때마다 체크박스 데이터의 개수도 바꿔주는 것
		var myAmount = $(this).parent().parent().next().next().children();
		$(myAmount).data("num",plusNum);
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
		});
		
		//값 바뀔 때마다 체크박스 데이터의 개수도 바꿔주는 것
		var myAmount = $(this).parent().parent().next().next().children();
		$(myAmount).data("num",minusNum);
	});

	$("#btnBuy").click(function(e){
		var arrayParam = new Array();
		var that = $('.cbox:checkbox:checked');
		var checked = $('.cbox:checkbox:checked').map(function(){ 
			return this.value; 
			}).get().join(',');

		$('.cbox:checkbox:checked').each(function(){
			var v = $(this).data("num");
			arrayParam.push(v);
		});

		console.log(arrayParam);
		location.href = "buy_pro.mem?checked=" + checked + "&arrayParam=" + arrayParam;
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
						<th colspan="2">선택/삭제</th>
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
						<td>
							<input type="checkbox" class="cbox" value="${cartVo.book_num}" data-num="${cartVo.book_amount}">
						</td>
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