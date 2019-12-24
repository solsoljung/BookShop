<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <title>구매 내역</title>
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
	
	
});

</script>
<%
String url = request.getHeader("REFERER");
Boolean result = false;
System.out.println(url);
if(url.contains("buy_pro")){
	result = true;
}

pageContext.setAttribute("result", result);
%>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<br>
<br>
<h1 align="center">나의 구매내역</h1>
<br>
<br>
<br>
<c:if test="${pageScope.result eq true}">
	<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
구매완료! <span style="font-weight:bold;">
<fmt:formatNumber value="${now_buy_point}" pattern="#,###"></fmt:formatNumber>
</span> 포인트가 적립되었습니다.</h3>		
</c:if>
<br>
<br>
<br>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			<table class="table" id="cartTable" style="">
				<thead>
					<tr style="font-size:10pt">
						<th>주문번호</th>
						<th>주문 일시</th>
						<th>주소</th>
						<th>총결제액</th>
						<th>적립 포인트</th>
						<th>상품명</th>
						<th>구매 수량</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="sta" value="0"/>
				<c:forEach items="${list}" var="vo">
					<tr>
						<c:if test="${sta  == 0}">
							<td rowspan="${map.get(vo.buy_info_num)}">${vo.buy_info_num}</td>
							<td rowspan="${map.get(vo.buy_info_num)}">${vo.buy_date}</td>
							<td rowspan="${map.get(vo.buy_info_num)}">${vo.mem_address}</td>
							<td rowspan="${map.get(vo.buy_info_num)}">${vo.buy_all_price}원</td>
							<td rowspan="${map.get(vo.buy_info_num)}">${vo.buy_point}</td>
						</c:if>
						
					<c:set var="sta" value="${sta+1}"/>
						<c:if test="${sta == map.get(vo.buy_info_num)}">
					<c:set var="sta" value="0"/>
						</c:if>
							<td>${vo.book_name}</td>
							<td>${vo.book_amount}</td>
					</tr>
					</c:forEach>
				</tbody>
				
			</table>
		</div>
		<div class="col-md-2">
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		<br>
		<br>
		<br>
		<br>
			<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
현재 나의 포인트: <span style="font-weight:bold;"><fmt:formatNumber value="${all_point}" pattern="#,###"></fmt:formatNumber></span> POINT</h1>
		</div>
	</div>
	<br>
	<hr>
	<br>
</div>
	<script src="~/bootstrap-select.min.js"></script>
	<script src="~/defaults-ko-KR.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>	