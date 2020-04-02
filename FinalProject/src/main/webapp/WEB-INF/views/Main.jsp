<%@page import="com.kgitbank.login.vodao.LoginDAO"%>
<%@page import="com.kgitbank.client.vodao.ClientVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kgitbank.front.vodao.FrontVO"%>

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
<%
if(request.getAttribute("loginerror")!=null){
	out.print("<script>alert('아이디와 비밀번호가 일치하지 않습니다.')</script>");
}else if(request.getAttribute("deleterror")!=null){
	out.print("<script>alert('계정삭제에 실패했습니다. 다시 시도해주세요.')</script>");
}else if(request.getAttribute("QAmail")!=null){
	out.print("<script>alert('문의 답변은 메일로 전송됩니다.')</script>");
}else if(request.getAttribute("QAerror")!=null){
	out.print("<script>alert('문의작성에 실패했습니다. 다시 시도해주세요.')</script>");
}else if(request.getAttribute("changesuccess")!=null){
	out.print("<script>alert('정보 수정에 성공했습니다.')</script>");
}else if(request.getAttribute("changeerror")!=null){
	out.print("<script>alert('다시 시도해주세요.')</script>");
}else if(request.getAttribute("signupsuccess")!=null){
	out.print("<script>alert('회원가입에 성공했습니다.')</script>");
}else if(request.getAttribute("signuperror")!=null){
	out.print("<script>alert('다시 시도해주세요.')</script>");
}else if(request.getAttribute("boardDelete")!=null){
	out.print("<script>alert('게시글이 삭제되었습니다.')</script>");
}else if(request.getAttribute("DeleteError")!=null){
	out.print("<script>alert('게시글 삭제에 실패했습니다. 다시 시도해주세요.')</script>");
}else if(request.getAttribute("ID")!=null){
	out.print("<script>alert('회원님의 아이디는 "+request.getAttribute("ID")+" 입니다.')</script>");
}
%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
 <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
<script type="text/javascript">
//로그인 Null 체크
	function LoginNullCheck(){
		if(!document.login.id.value){
			alert("아이디를 입력해주세요.");
			document.login.id.focus();
			return false;
		} else if(!document.login.pw.value){
			alert("비밀번호를 입력해주세요.");
			document.login.pw.focus();
			return false;
		}
	}

	
/* 	function ArrayList(){
	    this.array = new Array();
	    this.add = function(obj){
	        this.array[this.array.length] = obj;
	    };
	    this.iterator = function (){
	        return new Iterator(this);
	    };
	    this.length = function (){
	        return this.array.length;
	    };
	    this.get = function (index){
	        return this.array[index];
	    };
	    this.addAll = function (obj){
	        if (obj instanceof Array){
	            for (var i=0;i<obj.length;i++){
	                this.add(obj[i]);
	            }
	        } else if (obj instanceof ArrayList){
	            for (var i=0;i<obj.length();i++){
	                this.add(obj.get(i));
	            }
	        }
	    };
	}
	 
	function Iterator (arrayList){
	    this.arrayList;
	    this.index = 0;
	    this.hasNext = function (){
	        return this.index < this.arrayList.length();
	    };
	    this.next = function() {
	        return this.arrayList.get(index++);
	    };
	}  */

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
      <a class="navbar-brand" href="/controller/">GAZUA 휴게소</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/controller/">홈
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Introduction">사이트 소개</a>
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
 

<div class="main_right">
      	<div id="map" style="width:730px; height:700px;"></div><br>
<p align="center">
    <button onclick="hideMarkers()">휴게소 감추기</button>
    <button onclick="showMarkers()">휴게소 보이기</button>
</p> 
<!-- <em>클릭한 위치에 마커가 표시됩니다!</em> -->
    
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=49010dfcae926e4fa1ecd465c8810d83"></script>
<%-- 
<%
String [] ar1=(String[])request.getAttribute("entrpsNmList");
String entrpsNm1="";
for(int i=0; i<ar1.length; i++){
	entrpsNm1=ar1[i];
}
%>
 --%>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(36.428679, 127.855409), // 지도의 중심좌표
        level: 12 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


// 지도에 표시된 마커 객체를 가지고 있을 배열입니다
var markers = [];

// 마커를 지도위에 표시합니다 
/* var ar1 = MapMarker.entrpsNm;
	addMarker(ar1[i], new kakao.maps.LatLng(37.460612, 127.041870)); */
	
	
	/* var json = JSON.parse('${jsonList}');
	 console.log(json);
 */
 
/*  var json = JSON.parse('${list}');
	
 for (var i = 0; i < json.size(); i++) {
		JSONObject rest = (JSONObject) json.get(i);
		
		var entrpsNm = (String) rest.get("entrpsNm");    
        var latitude = (String) rest.get("latitude");    
        var hardness = (String) rest.get("hardness");
        
        addMarker(entrpsNm, new kakao.maps.LatLng(latitude, hardness));
 }
  */
 
 
	
<%--  var arrayList = new Array('${ar1}');
 
	var data=<%=ar1%>;
	var list=data.list;
	/* var listLen = json.size;	*/
	var listLen =arrayList.length;
		
	var str = "";
	
	if(listLen >  0){
		for(var a=0; a<listLen; a++){
			addMarker(list[a].getEntrpsNm(), new kakao.maps.LatLng(ar1.get(i).getLatitude(), ar1.get(i).getHardness()));
		}
	}	 --%>
	
/* 	
for(var i=0; i<ar1.size(); i++){
	addMarker(ar1.get(i).getEntrpsNm(), new kakao.maps.LatLng(ar1.get(i).getLatitude(), ar1.get(i).getHardness()));
} */

/* String a=request.getAttribute("MAPRestName");
System.out.println(a); *//* 
addMarker('맛남의 광장', new kakao.maps.LatLng(37.460612, 127.041870));
addMarker('죽전휴게소', new kakao.maps.LatLng(37.332651, 127.104165));  */

<%-- addMarker(<%=entrpsNm1%>, new kakao.maps.LatLng(37.332651, 127.104165));  --%>
<%-- <%
String [] ar1=(String[])request.getAttribute("list");
%>  --%>

<% List<String> dd = (List<String>)request.getAttribute("test"); %>


var list = ${list};
var list2 = ${list2};
var list3 = ${list3};

for (var i = 0; i < list.length; i++) {
	addMarker(list[i], new kakao.maps.LatLng(list2[i], list3[i]));
}


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
		<form action="QAmail"name="message" id="messageform">
		
		<div class="row1">
			<div class="name">
				<input type="text" placeholder="이름" name="name" required="" data-validation-required-message="이름을 입력해주세요" maxlength="20">
			</div>
			<div class="email">
				<input type="email" placeholder="이메일" name="email" required="" data-validation-required-message="이메일을 입력해주세요" maxlength="30">
			</div>
		</div>
		
		<div class="row2">
			<br><br><textarea class="message" placeholder="메시지를 남겨주세요" name="text" required="" data-validation-required-message="보낼 메시지를 입력해주세요" maxlength="500"></textarea>
		</div>
		
		<div class="row3" align="center">
			<br><button type="submit" class="btn btn-primary btn-lg">보내기</button>
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
