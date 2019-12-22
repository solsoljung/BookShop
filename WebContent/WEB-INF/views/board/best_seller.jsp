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
	$(".myTaget").click(function(){
		var v = $(this).data("num");
		console.log(v);
		/* var c = ${map.get("count")};
		console.log(c);
		if(${map.get("count")} == v){
			$(this).css("background-color", "yellow");
		} */
		location.href = "best.sol?search_keyword=${search_keyword}&now_page=" + v;
	});
	var url = request.getHeader("REFERER");
	console.log(url);
});
<%
String url = request.getHeader("REFERER");
Boolean result = false;

if(url.contains("content")){
	result = true;
}

pageContext.setAttribute("result", result);
%>
</script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid">
<br>
<br>
<div class="row">
		<div class="col-md-5">
		</div>
		<div class="col-md-3" align="center">
<c:if test="${empty search_keyword}">
			<ul class="nav">
			<c:forEach begin='0' end='${map.get("count")-1}' varStatus='status'>
  				<li class="nav-item" style="font-size:25px;">
					<a class="nav-link active myTaget" data-num="${status.count}" 
					href="#">${(status.index*10)+1}위▽</a>
				</li>
 			</c:forEach>
			</ul>
</c:if>
<c:if test="${!empty search_keyword&&map.get('count') ne 0&&pageScope.result eq false}">
			<h3>${search_keyword}(으)로 검색한 결과입니다.</h3>
</c:if>
		</div>
		<div class="col-md-4">
		</div>
	</div>
<br>
<br>
<br>
	<!-- 여기부턴 베스트 셀러 반복할 부분 -->
	<div class="row">
	<c:set var="index" value="${map.get('best_index')}"/>
	<c:forEach items="${list}" var="bestVo">
		<div class="col-md-2">
		</div>
		<div class="col-md-1">
			<h1 align="right">${index}</h1>
		</div>
		<c:set var="index" value="${index+1}"/>
		<div class="col-md-2">
		<img src="upload/${bestVo.book_image}" width="300"/>
		</div>
		<div class="col-md-5">
			<h1><a href="content.sol?book_num=${bestVo.book_num}" style="color:#595959;">
				${bestVo.book_name}
				</a>
			</h1>
			<hr>
			<h4>${bestVo.book_writer}</h4>
			<h4>${bestVo.book_price}</h4>
			<h4>★★★★★</h4>
			<hr>
			<c:choose>
				 	<c:when test="${not empty mem_id}">
<a href="cart.mem?book_num=${bestVo.book_num}&book_amount=1" class="btn btn-lg btn-link" type="button">장바구니 담기</a>
<a href="buy_pro.mem?checked=${bestVo.book_num}&arrayParam=1" class="btn btn-lg btn-link" type="button">바로 구매</a>
					</c:when>
					<c:otherwise>
<a href="login.sol" class="btn btn-lg btn-link" type="button">장바구니 담기</a>
<a href="login.sol" class="btn btn-lg btn-link" type="button">바로 구매</a>
					</c:otherwise>
			</c:choose>
		</div>
		<div class="col-md-2">
		</div>
		<br>
		<hr>
		<br>
		</c:forEach>
		<hr>
	</div>
		<c:if test="${!empty search_keyword}">
		<br>
		<br>
		<br>
	<div class="row">
		<div class="col-md-5">
		</div>
		<div class="col-md-3" align="center">
			<ul class="nav">
			<c:choose>
				<c:when test='${map.get("count") eq 0}'>
					<h3>${search_keyword}(으)로 검색한 결과가 없습니다.</h3>
				</c:when>
				<c:otherwise>
			<c:forEach begin='0' end='${map.get("count")-1}' varStatus='status'>
  				<li class="nav-item" style="font-size:25px;">
					<a class="nav-link active myTaget" data-num="${status.count}" 
					href="#">${status.count}</a>
				</li>
 			</c:forEach>
 			</c:otherwise>
 			</c:choose>
			</ul>
		</div>
		<div class="col-md-4">
		</div>
	</div>
		</c:if>
	<!-- 베스트셀러 끝! -->
	<br>
	<br>
	<br>
	<br>
</div>
</body>
</html>