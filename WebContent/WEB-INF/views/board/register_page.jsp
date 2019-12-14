<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>회원가입</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
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
if(msg == "register_fail"){
	alert("회원가입에 실패하였습니다.");
}
$(function(){
	var isChecked = false;
	$("#btnCheckId").click(function(){
		var mem_id = $("input[name=mem_id]").val();
		var url = "checkId.ajax";
		var sData = {
				"mem_id" : mem_id
		};
		/* var divEl = $("input[name=mem_id]");
		 
		var divHalfWidth = divEl.width() / 2;
		var divHalfHeight = divEl.height() / 2;
		 
		var divCenterX = divX + divHalfWidth;
		var divCenterY = divY + divHalfHeight;
		console.log(divCenterX);
		console.log(divCenterY); */
		
		$.get(url, sData, function(receiveData){
			var rData = receiveData.trim();
			if(rData == "available_id"){
				$("#idResultSpan").text("사용가능한 아이디 입니다.");
				isChecked = true;
			} else if(rData == "used_id") {
				$("#idResultSpan").text("이미 사용중인 아이디 입니다.");
			}
		});
	});
	
	$("#register_form").submit(function() {
		var mem_pw = $("input[name=mem_pw]").val();
		var mem_pw2 = $("input[name=mem_pw2]").val();
		if (mem_pw != mem_pw2) {
			alert("패스워드가 일치하지 않습니다");
			return false;
		}
		
		if (isChecked == false) {
			alert("아이디 중복 체크를 해주세요.");
			return false;
		}
	});
});
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<!-- 회원가입 폼 시작 -->
	<div class="container">
      <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-5">
        <span class="login100-form-title p-b-34">
						회원가입
					</span>
          <div class="login-box well">
        <form method="post" id="register_form" action="register_pro.sol">
            <div class="form-group">
                <input type="text" name="mem_id" placeholder="아이디*" class="form-control" required/>
            </div>
            <div class="form-group">
                <input type="password" name="mem_pw" placeholder="비밀번호*" class="form-control" required/>
            </div>
            <div class="form-group">
                <input type="password" name="mem_pw2" placeholder="비밀번호 확인*" class="form-control" required/>
            </div>
            <div class="form-group">
                <input type="text" name="mem_name" placeholder="이름*" class="form-control" required/>
            </div>
            <div class="form-group">
                <input type="text" name="mem_phone" placeholder="전화번호" class="form-control" />
            </div>
            <div class="form-group">
                <input type="text" name="mem_address" placeholder="주소" class="form-control" />
            </div>
            <hr />
            <div class="form-group">
                <input type="submit" class="login100-form-btn" value="회원가입"/>
            </div>
        </form>
          </div>
        </div>
        <div class="col-md-3">
        <br>
        <br>
            <input type="button" id="btnCheckId" value="아이디 중복 확인" style="background-color:#DCDCDC"/>
       		<br>
       		<span id="idResultSpan"></span>
        </div>
        </div>
        <div class="col-md-2">
        </div>
      </div>
 
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.min.js"></script>

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<script>
		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});
	</script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>