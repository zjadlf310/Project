<%@page import="com.kgitbank.login.vodao.LoginDAO"%>
<%@page import="com.kgitbank.client.vodao.ClientVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<%
ClientVO login = null;
login=(ClientVO)session.getAttribute("loginfo");
LoginDAO dao=new LoginDAO();
int aa=dao.getTotalCount();
int bb=dao.getTodayCount();
session.setAttribute("totalCount",aa);
session.setAttribute("todayCount",bb);
String nik;
	if(login==null){
		nik="";
	}
	else{
		nik=login.getNickname();
	}
%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>사이트 소개</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">
<!-- Custom styles for this template -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/business-frontpage.css">
<script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>

<script type="text/javascript">
function MyPageMove(url, data){
	
    var ajaxOption = {
            url : url,
            async : true,
            type : "GET",
            dataType : "html",
            cache : false,
            data : {'writer' : data}
    };
    
    $.ajax(ajaxOption).done(function(data){
        // Contents 영역 삭제
        $('#mypage').children().remove();
        // Contents 영역 교체
        $('#mypage').html(data);
    });
}
</script>
</head>		
<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/controller/">GAZUA 휴게소</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="/controller/">홈
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Introduction">사이트 소개
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="getAPIRoadKind">휴게소 정보</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Board_List">게시판</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="QA">문의 사항</a>
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
  		<form action="getLogin" name="login" onsubmit="return LoginNullCheck()">
  			<!-- 로그인 부분, onfocus 부분은 input text란 클릭시 내용 지우기 -->  
      		<div class="col-md-8 mb-5">
			<%if(session.getAttribute("loginfo")==null){%>
				<!-- 로그인 안할 시 나오는 부분 -->
				<section class="main_login_section">
					<input class="main_login" type="text" name="id" placeholder="아이디" onfocus="this.value=''; return true;" maxlength="20"><br>
					<input class="main_login" type="password" name="pw" placeholder="비밀번호" onfocus="this.value=''; return true;" maxlength="30"><br>
					<input type="submit" value="로그인" class="btn btn-primary btn-lg main_logon_btn">
					<a href="Signup">
						<input type="button" value="회원가입" class="btn btn-primary btn-lg main_logon_btn2">
					</a><br><br>
					<a href="Search" class="main_login_a">아이디 / 비밀번호 찾기</a>
				</section>
			<%}
			else {%>	
				<!-- 로그인 성공시 나오는 부분 --> 
				 <section class="main_login_section">	
					<h2 class="main_login_a"><%=login.getNickname()%> 님 환영합니다 !</h2>
					<br><br><br>
					<!-- 로그아웃 할때 받을 do -->
					<a href="getLogout"><input type="button" value="로그아웃" class="btn btn-primary btn-lg"></a>
					<a href="Confirm">
						<input type="button" value="마이 페이지" class="btn btn-primary btn-lg main_logon_btn2">
					</a>
				</section>
			<%} %>
				<section class="main_login_section main_user"> 
					<!-- ?에는 방문자수 -->
					<span class="main_span">오늘 <%=session.getAttribute("todayCount")%>명&nbsp&nbsp&nbsp&nbsp전체 <%=session.getAttribute("totalCount")%>명</span><br><br>
					<!-- ?에는 멤버수 -->
					<span class="main_span"><textarea id="count" ></textarea><!-- <input class="btn btn-primary btn-lg" type="button" value="새로고침"> --></span>
					<br><br>
					<textarea id="messageTextArea"  style="overflow: scroll; width: 200px; height: 200px; background-color: white"></textarea>
				</section>	
      		</div>
  		</form>
      <div id="mypage" class="mypage">
		<center><h1>마이 페이지</h1></center><br>
		<section>			
			<table>
				<tr>
					<td><%=login.getNickname()%> 님 환영합니다 !</td>
					<td><input type="button" value="회원정보수정" class="btn btn-primary btn-lg" onClick="location.href='Change'">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="회원탈퇴" onClick="location.href='End'"></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="button" value="내가 쓴 글 목록" class="btn btn-primary btn-lg" onclick="MyPageMove('MyBoard', '<%=login.getNickname()%>')"> &nbsp;&nbsp;&nbsp;&nbsp;사용자가 쓴 글을 확인할 수 있으며 수정, 삭제할 수 있습니다.
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="button" value="좋아요한 글 목록" class="btn btn-primary btn-lg" onclick="MyPageMove('Like', '<%=login.getNickname()%>')"> &nbsp;&nbsp;&nbsp;&nbsp;좋아요한 글을 확인할 수 있으며 좋아요 취소가 가능합니다.
					</td>
				</tr>
			</table>
			
		</section>
		</div>	
	</div>	
    </div>  <!-- /.container -->

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
				<input type="text" placeholder="이름" id="name" required="" data-validation-required-message="이름을 입력해주세요" maxlength="20">
			</div>
			<div class="email">
				<input type="email" placeholder="이메일" id="email" required="" data-validation-required-message="이메일을 입력해주세요" maxlength="30">
			</div>
		</div>
		
		<div class="row2">
			<br><br><textarea class="message" placeholder="메시지를 남겨주세요" id="message" required="" data-validation-required-message="보낼 메시지를 입력해주세요" maxlength="500"></textarea>
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
  <script>
//session nikname 값
var croodx = '<%=nik%>';
var count = document.getElementById("count");
// 「WebSocketEx」는 프로젝트 명
// 「broadsocket」는 호스트 명
// WebSocket 오브젝트 생성 (자동으로 접속 시작한다. - onopen 함수 호출)

var webSocket = new WebSocket("ws://192.168.58.17:8081/controller/broadsocket");

// 콘솔 텍스트 에리어 오브젝트
var messageTextArea = document.getElementById("messageTextArea");

function dosend(obj)
{
	 webSocket.send(obj);
} 

// WebSocket 서버와 접속이 되면 호출되는 함수
webSocket.onopen = function(message) {
	// 콘솔 텍스트에 메시지를 출력한다.
	messageTextArea.value= "";
if (!croodx) {
	console.log("세션 아이디 없음");
} else {
	dosend(croodx);
}

};

function countset(obj)
	{
		document.getElementById("count").value=obj;
	} 	
	
// WebSocket 서버로 부터 메시지가 오면 호출되는 함수
webSocket.onmessage = function(message) {
	messageTextArea.value = "";
	var dady=message.data;
	var jbSplit = dady.split('~');
	//여기서 리스트로 받은 갚을 textarea빼고 들어가야돼.
  for ( var i in jbSplit ) {
	  if (i==0) {
		count ="접속멤버 "+jbSplit[0]+"명  ";
		countset(count);
		}
	  else{
			messageTextArea.value += jbSplit[i] + "\r\n";
	  }
	}
};
</script>
</body>

</html>
