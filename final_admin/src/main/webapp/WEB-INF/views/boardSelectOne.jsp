<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/mainFormat.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<div class="boardAdmin">
				<h1>게시판 관리</h1>
				<br> <br> <br>
				<form action="#">
					<table border="2">
						<tr>
							<th>게시글번호</th>
							<th>카테고리</th>
							<th>닉네임</th>
							<th>텍스트</th>
							<th>이미지</th>
						<tr>
							<td><input type="hidden" value="${bvo.getBoard_number()}"
								name="board_number">${bvo.getBoard_number()}</td>
							<td><input type="text" name="category"
								value="${bvo.getCategory()}"></td>
							<td><input type="text" name="title"
								value="${bvo.getTitle()}"></td>
							<td><input type="text" name="text" value="${bvo.getText()}"></td>
							<td><%-- <input type="text" name="img_name"
								value="${bvo.getImg_name()}"> --%>
								<%-- <img src="<spring:url value='/image/dummy.PNG'/>" /> --%>
								<img src = "/controller/display?name=${bvo.getfilename()}" alt = "안나와요"/>
								
								</td>
						</tr>	
					</table>
					<table>
						<tr>
							<td><input type="submit" value="수정" style="cursor: pointer;"
								formaction="boardUpdate"></td>
							<td><input type="submit" value="삭제" style="cursor: pointer;"
								formaction="boardDelete"></td>
						<tr>
					</table>
				</form>
			</div>
			<div class="commentAdmin">
				<br> <br> <br>
				<form action="#">
					<table border="2">
						<tr>
							<th>게시글 번호</th>
							<th>댓글번호</th>
							<th>텍스트</th>
							<th>글쓴이</th>
							<th>게시날자</th>
							<th>파일이름</th>
							<th>체크박스</th>
							<c:forEach var="rvoList" items="${rvoList}">
						<tr>
							<td>${rvoList.getBoard_num()}</td>
							<td>${rvoList.getBoard_re()}</td>
							<td>${rvoList.getText()}</td>
							<td>${rvoList.getRe_writer()}</td>
							<td><fmt:formatDate value="${rvoList.getRe_date()}" pattern="yyyy.MM.dd" /></td>
							<td><img src = "/controller/display?name=${rvoList.getFilename()}" alt = "안나와요"/></td>
							<td align="center" rowspan="2"><input type="checkbox" name="checkbox"
								value="${rvoList.getBoard_re()}"></td>
						</tr>
						</c:forEach>
					</table>
					<table>
						<tr>
							<td><input type="submit" value="삭제" style="cursor: pointer;"
								formaction="commentDelete"></td>
						<tr>
					</table>
				</form>
			</div>
		</div>

	</div>
</body>
</html>