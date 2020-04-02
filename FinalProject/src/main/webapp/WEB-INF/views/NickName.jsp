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
	$("#Nick_Check").keydown(function(event) {
		if (event.keyCode == '13') {
			$("#check").trigger("click");
		}
	})
});

$(document).ready(function(){
    $("#check").on("click", function(){
    	if(!document.getElementById("nickname").value){
    		alert("닉네임을 입력해주세요.")
    		document.getElementById("nickname").focus();
    	}else{
    		let queryString = $("#nickname").serialize();
        	$.ajax({
        		url: "/controller/getNickNameCheck",
        		type: "GET",
        		dataType: "json",
        		data: queryString,
        		success: function(result){
        			if(result==100){
        				var aa = document.getElementById("nickname").value;
        				opener.document.getElementById("nickname").value=aa;
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
<title>닉네임 중복 확인</title>
</head>
<body align="center">
	<div id="Nick_Check">
		<h4>사용할 닉네임을 입력해주세요.</h1><br>
		사용할 닉네임 : <br><br>
		<input type="text" name="nickname" id="nickname" maxlength="30"><br><br>
		<input type="button" id="check" value="확인">
	</div>
</body>
</html>