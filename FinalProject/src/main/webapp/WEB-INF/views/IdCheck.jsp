<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#Id_Check").keydown(function(event) {
		if (event.keyCode == '13') {
			$("#check").trigger("click");
		}
	})
});

$(document).ready(function(){
    $("#check").on("click", function(){
    	if(!document.getElementById("id").value){
    		alert("닉네임을 입력해주세요.")
    		document.getElementById("id").focus();
    	}else{
    		let queryString = $("#id").serialize();
        	$.ajax({
        		url: "/controller/getIDCheck",
        		type: "GET",
        		dataType: "json",
        		data: queryString,
        		success: function(result){
        			if(result==100){
        				opener.document.getElementById("id").value=document.getElementById("id").value;
        				alert('사용가능한 이름입니다.');
        				self.opener = self;
        				self.close();
        			}else if(result==101){
        				alert('이미 사용중인 이름입니다.')
        			}
        		}
            })
    	}
    	
    })    
});

</script>
<title>아이디 중복 확인</title>
</head>
<body align="center">
	<div id="Id_Check" onsubmit="IdNullCheck()">
		<h4>사용할 ID를 입력해주세요.</h1><br>
		사용할 ID : <br><br>
		<input type="text" id="id" name="id" maxlength="20"><br><br>
		<input type="button" id="check" value="확인">
	</div>
</body>
</html>