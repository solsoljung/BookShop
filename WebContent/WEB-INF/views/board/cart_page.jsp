<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <title>장바구니</title>
<style>
.titleFont {
  font-weight: bold;
  color: 	#6495ED;
  font-size: 64px;

}
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
			<table class="table">
				<thead>
					<tr style="font-size:10pt">
						<th colspan="2">상품명</th>
						<th>가격</th>
						<th>수량</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2"><img src="images/3.jpg" width="150"/>
						<span style ="font-size:20pt">작가들의 비밀스러운 삶</span></td>
						<td style="font-size:15pt">14900원</td>
						<!-- 셀렉박스 -->
						<td>
						<div class="dropdown">
				 
						<button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
							수량
						</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							 <a class="dropdown-item disabled" href="#">1개</a> <a class="dropdown-item" href="#">2개</a> <a class="dropdown-item" href="#">3개</a>
						</div>
						</div>
						</td>
						<!-- 셀렉박스 끝 -->
						<!-- 체크박스 -->
						<td>
						<div class="checkbox">
						  <label><input type="checkbox" value="check1"/></label>
						</div>
						</td>
						<!-- 체크박스 끝-->
					</tr>
					<tr>
						<td colspan="2"><img src="images/4.jpg" width="150"/>
						<span style ="font-size:20pt">사랑을 위한 되풀이</span></td>
						<td>13200원</td>
						<!-- 셀렉박스 -->
						<td>
						<div class="dropdown">
				 
						<button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
							수량
						</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							 <a class="dropdown-item disabled" href="#">1개</a> <a class="dropdown-item" href="#">2개</a> <a class="dropdown-item" href="#">3개</a>
						</div>
						</div>
						</td>
						<!-- 셀렉박스 끝 -->
						<!-- 체크박스 -->
						<td>
						<div class="checkbox">
						  <label><input type="checkbox" value="check1"/></label>
						</div>
						</td>
						<!-- 체크박스 끝-->
					</tr>
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
		</div>
		<div class="col-md-2">
		</div>
	</div>
</div>
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>