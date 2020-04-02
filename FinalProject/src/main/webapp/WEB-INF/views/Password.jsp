<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script type="text/javascript">
	function PWNull(){
		if(!document.PW_Check.pw.value){
			alert("새로 설정할 비밀번호를 입력해주세요.");
			document.PW_Check.pw.focus();
			return false;
		} 
	}
</script>
</head>
<body align="center">
	<form action="getClientUpdatePw" name="PW_Check" onsubmit="return PWNull()">
		새로 이용할 비밀번호를 입력해주세요.<br>
		다음 로그인시 새로 설정한 비밀번호로 로그인할 수 있습니다.<br><br><br>
		새로 이용할 비밀번호 :<br>
		<input id=a type="password" name="pw" pattern="(?=.*\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{6,20}"
				title="특수문자를 포함한 6-20자 영문 대소문자로 설정하세요"><br><br>
		<input type="hidden" name="id" value="${id}">
		<input type="submit" value="확인">
	</form>
</body>
</html>