<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <title>솔 책방 메인페이지</title>
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
var msg = "${param.msg}";
if(msg == "login_fail"){
	alert("로그인 실패");
}
$(function(){
	$("#btnSearch").click(function(){
		var search = $("#searchTarget").val();
		location.href="best.sol?search_keyword=" + search;
	});
	
	 $('#carousel-359360').find('.carousel-item').first().addClass('active');
});
</script>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
<br>
<!-- 검색 -->
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
		<div class="card-body row no-gutters align-items-center">
                                    <div class="col-auto">
                                        <i class="fas fa-search h4 text-body"></i>
                                    </div>
                                    <!--end of col-->
                                    <div class="col">
                                        <input class="form-control form-control-lg form-control-borderless" id="searchTarget" style="text-align:center;" type="search" placeholder="책 제목, 작가, 내용으로 검색합니다.">
                                    </div>
                                    <!--end of col-->
                                    <div class="col-auto">
                                        <button class="btn btn-lg btn-success" type="submit" id="btnSearch">Search</button>
                                    </div>
                                    <!--end of col-->
                                </div>
		</div>
		<div class="col-md-2">
		</div>
	</div>
</div>
<br>
	<!-- 검색 끝 -->
<!-- 여기부터 회전목마 -->
<br>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-1">
		</div>
		<div class="col-md-10">
			<div class="carousel slide" id="carousel-359360" data-interval="3000">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-359360" class="active">
					</li>
					<li data-slide-to="1" data-target="#carousel-359360">
					</li>
					<li data-slide-to="2" data-target="#carousel-359360">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100" alt="Carousel Bootstrap First" src="images/tree.jpg" />
						<div class="carousel-caption">
							<h4>
								이번 크리스마스에
							</h4>
							<p>
								책으로 고마움을 전하는건 어떠세요?
							</p>
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" alt="Carousel Bootstrap Second" src="images/back.jpg" />
						<div class="carousel-caption">
							<h2>
								솔 책방
							</h2>
							<p>
								지금 나온 책들을 만나보세요!
							</p>
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" alt="Carousel Bootstrap Third" src="images/book_light.jpg" />
						<div class="carousel-caption">
							<h4>
								포인트 두배 적립기간 입니다.
							</h4>
							<p>
								인기 작가의 책을 먼저 만나보세요!
							</p>
						</div>
					</div>
				</div> <a class="carousel-control-prev" href="#carousel-359360" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-359360" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
			</div>
		</div>
		<div class="col-md-1">
		</div>
	</div>
</div>
<br>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>