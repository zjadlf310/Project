<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript">
//로그인 Null 체크
	function LoginNullCheck(){
		if(!document.login.main_loginid.value){
			alert("아이디를 입력해주세요.");
			document.login.main_loginid.focus();
			return false;
		} else if(!document.login.main_loginpw.value){
			alert("비밀번호를 입력해주세요.");
			document.login.main_loginpw.focus();
			return false;
		}
	}
/* 	%%%%%%%%%%%%%%%%%%%%%%%%%수정%%%%%%%%%%%%%%%%%%%%%%%%% */
	function button1_click(){
		alert("메시지가 성공적으로 전송되었습니다");
	}


</script>

<title>GAZUA 휴게소</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">


<!-- Custom styles for this template -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/business-frontpage.css">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/controller">GAZUA 휴게소</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/controller">홈
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">사이트 소개</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">휴게소 정보</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">게시판</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">문의 사항</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Header -->
  <header class="bg-primary py-5 mb-5">
    <div class="container h-100">
      <div class="row h-100 align-items-center">
        <div class="col-lg-12">
          <h1 class="display-4 text-white mt-5 mb-2">사진 넣는 곳</h1>
          <p class="lead mb-5 text-white-50"></p>
        </div>
      </div>
    </div>
  </header>

  <!-- Page Content -->
  <div class="container">

    <div class="row">
  		<form action="" name="login" onsubmit="return LoginNullCheck()">
  			<!-- 로그인 부분, onfocus 부분은 input text란 클릭시 내용 지우기 -->  
      		<div class="col-md-8 mb-5">
				<!-- 로그인 안할 시 나오는 부분 -->
				<section class="main_login_section">
					<input class="main_login" type="text" name="id" placeholder="아이디" onfocus="this.value=''; return true;"><br>
					<input class="main_login" type="password" name="pw" placeholder="비밀번호" onfocus="this.value=''; return true;"><br>
					<input type="submit" value="로그인" class="btn btn-primary btn-lg main_logon_btn">
					<a href="Signup">
						<input type="button" value="회원가입" class="btn btn-primary btn-lg main_logon_btn2" id="signup_get">
					</a><br><br>
					<a href="Search.jsp" class="main_login_a">아이디 / 비밀번호 찾기</a>
				</section>
				<!-- 로그인 성공시 나오는 부분 --> 
				<!-- <section class="main_login_section">	
					<h2 class="main_login_a">@@@ 님 환영합니다 !</h2>
					<br><br><br>
					로그아웃 할때 받을 do
					<a href=""><input type="button" value="로그아웃" class="btn btn-primary btn-lg"></a>
					<a href="Mypage.jsp">
						<input type="button" value="마이 페이지" class="btn btn-primary btn-lg main_logon_btn2">
					</a>
				</section> -->	
				<section class="main_login_section main_user"> 
					<!-- ?에는 방문자수 -->
					<span class="main_span">오늘 ?명&nbsp&nbsp&nbsp&nbsp전체 ?명</span><br><br>
					<!-- ?에는 멤버수 -->
					<span class="main_span">접속 멤버 ?명&nbsp&nbsp<input class="btn btn-primary btn-lg" type="button" value="새로고침"></span>
					<br><br>
					<div style="overflow: scroll; width: 200px; height: 200px; background-color: white">여기에 내용을 넣는다</div>
				</section>	
      		</div>
  		</form>
      <div id="get">
      	<div id="map" style="width:750px; height:700px;"></div>
<p>
    <button onclick="hideMarkers()">마커 감추기</button>
    <button onclick="showMarkers()">마커 보이기</button>
</p> 
<!-- <em>클릭한 위치에 마커가 표시됩니다!</em> -->
    
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=49010dfcae926e4fa1ecd465c8810d83"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(36.428679, 127.855409), // 지도의 중심좌표
        level: 12 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


// 지도에 표시된 마커 객체를 가지고 있을 배열입니다
var markers = [];

// 마커 하나를 지도위에 표시합니다 
addMarker('만남의 광장', new kakao.maps.LatLng(37.460612, 127.041870));
addMarker('죽전휴게소', new kakao.maps.LatLng(37.332651, 127.104165));


// 마커를 생성하고 지도위에 표시하는 함수입니다
function addMarker(title, position) {
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
    	title: title,
    	position: position        
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);
    
    // 생성된 마커를 배열에 추가합니다
    markers.push(marker);
}

// 배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수입니다
function setMarkers(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }            
}

// "마커 보이기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에 표시하는 함수입니다
function showMarkers() {
    setMarkers(map)    
}

// "마커 감추기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에서 삭제하는 함수입니다
function hideMarkers() {
    setMarkers(null);    
}
</script>
      </div>
    </div>
  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container text-white">
    	<h1><center>Contact Us</center><br></h1>
  
    	<div class="footer_left">
    	가즈아휴게소 <br>
		서울특별시 종로구 돈화문로 26, 5층(묘동, 단성사) <br>
		02-5959-8081 <br>
		GAZUA828@NAVER.COM <br>
		</div>
		
		<div class="footer_center"><p>
    	영업시간<br>
		평일 : 9시 - 18시<br>
		토요일 : 9시 - 18시<br>
		일요일 : 휴무<br>		
		</p></div>
		
		
		<div class="footer_right">		
		<form name="message" id="messageform">
		
		<div class="row1">
			<div class="name">
				<input type="text" placeholder="이름" id="name" required="" data-validation-required-message="이름을 입력해주세요">
			</div>
			<div class="email">
				<input type="email" placeholder="이메일" id="email" required="" data-validation-required-message="이메일을 입력해주세요">
			</div>
		</div>
		
		<div class="row2">
			<br><br><textarea class="message" placeholder="메시지를 남겨주세요" id="message" required="" data-validation-required-message="보낼 메시지를 입력해주세요"></textarea>
		</div>
		
		<div class="row3" align="center">
			<br><button type="submit" class="btn btn-primary btn-lg"><a onclick="button1_click();">보내기</a></button>
		</div>		
		
		</form>		
		</div>
		
		<br><br><br><br><br><br><br><br><br>
		<div class="footer_bottom">
    	<center>Copyright &copy; Your Website 2019</center>
    	</div>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>


</body>

</html>
