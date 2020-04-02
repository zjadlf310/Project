<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/mainFormat.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.main {
	margin-left: 232px;
}
table input{
	text-align: center;
	font-size: 15px;
}
</style>
<body>
	<div class="container">
		<div class="main" align="center">
			<h1>회원 관리</h1>
			<br> <br> <br>
			<form action="#">
				<table border="2">
					<tr>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>닉네임</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>이메일</th>
					<tr>
						<td><input type="hidden" value="${cvo.getId()}" name="id">${cvo.getId()}</td>
						<td><input type="text" name="pw" value="${cvo.getPw()}"></td>
						<td><input type="text" name="nickname" value="${cvo.getNickname()}"></td>
						<td><input type="text" name="name" value="${cvo.getName()}"></td>
						<td><input type="text" name="tel" value="${cvo.getTel()}"></td>
						<td><input type="text" name="mail" value="${cvo.getMail()}"></td>

					</tr>
				</table>
				<table>
					<tr>
						<td><input type="submit" value="수정" style="cursor: pointer;" formaction="updateOne"></td>
						<td><input type="submit" value="삭제" style="cursor: pointer;" formaction="deleteOne"></td>
					<tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>