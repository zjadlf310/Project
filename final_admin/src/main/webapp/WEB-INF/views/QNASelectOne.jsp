<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/mainFormat.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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

table input {
	text-align: center;
	font-size: 15px;
}
</style>
<body>
	<div class="container">
		<div class="main" align="center">
			<div class="QNAAdmin">
				<h1>게시판 관리</h1>
				<br> <br> <br>
				<form action="#">
					<table border="2">
						<tr>
							<th>QNA 번호</th>
							<th>이름</th>
							<th>이메일</th>
							<th>텍스트</th>
						<tr>
							<td><input type="hidden" value="${avo.getNum()}"
								name="num">${avo.getNum()}</td>
							<td>${avo.getName()}</td>
							<td>${avo.getEmail()}</td>
							<td>${avo.getText()}</td>
						</tr>
					</table>
					<table>
						<tr>
							<td><input type="submit" value="삭제" style="cursor: pointer;"
								formaction="QNADelete"></td>
						<tr>
					</table>
				</form>
			</div>
		</div>

	</div>
</body>
</html>