<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.springframework.ui.Model"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/mainFormat.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpage" value="${pc.getCpage()}"></c:set>
<c:set var="maxpage" value="${pc.getEndPage()}"></c:set>
<html>
<head>
<title>Home</title>
</head>
<style>
.main {
	margin-left: 232px;
}

.content {
	display: block;
}

.boardListForm {
	font-size: 20px;
}

.paging {
	font-size: 20px;
}
</style>

<body>

	<div class="main">

		<div class="content" align="center">
			<h1>게시판 관리</h1>
			<br> <br> <br>
			<form action="boardpaging">
				<table border="2" class="boardListForm">
					<tr>
						<th>번호</th>
						<th>카테고리</th>
						<th>타이틀</th>
						<th>내용</th>
						<th>날짜</th>
					</tr>
					<c:forEach var="boardList" items="${boardList }"
						varStatus="status">
						<tr>
							<td style="width: 200px;" align="center"><a
								href="boardSerchDataOne?board_number=${boardList.getBoard_number()}">${boardList.getBoard_number()}</a></td>
							<td style="width: 100px;" align="center">${boardList.getCategory()}</td>
							<td style="width: 250px;" align="center">${boardList.getTitle()}</td>
							<td style="width: 250px;" align="center">${boardList.getText()}</td>
							<td style="width: 250px;" align="center"><fmt:formatDate value="${boardList.getW_date()}" pattern="yyyy.MM.dd" /></td>
						</tr>
					</c:forEach>
				</table>
				<div class="submitForm" align="center">
					<table>
						<tr>
							<td style="width: 826px;"><input type="text" name="keyWord"
								style="font-size: 20px;" value="${pc.getKeyWord()}"> <input
								type="hidden" name="Cpage" value="1"> <select
								style="font-size: 20px; padding-bottom: 7px;"
								name="searchOption">
									<option selected="selected" value="writer ">작성자
									<option value="title">제목
									<option value="titleText">제목+내용
							</select> <input type="submit" value="검색"
								style="font-size: 20px; cursor: pointer;"></td>
						</tr>
					</table>
				</div>
			</form>


			<c:if test="${cpage ne '1'}">
				<a
					href="boardpaging?Cpage=${pc.getCpage()-1}&keyWord=${pc.getKeyWord()}&searchOption=${pc.getSearchOption()}"
					class="paging">prev</a>
			</c:if>
			<c:forEach var="i" begin="${pc.getStartPage()}"
				end="${pc.getEndPage()}" step="1">
				<a
					href="boardpaging?Cpage=${i}&keyWord=${pc.getKeyWord()}&searchOption=${pc.getSearchOption()}"
					class="paging"><c:out value="${i}" /></a>
			</c:forEach>
			<c:if test="${cpage ne maxpage }">
				<a
					href="boardpaging?Cpage=${pc.getCpage()+1}&keyWord=${pc.getKeyWord()}&searchOption=${pc.getSearchOption()}"
					class="paging">next</a>
			</c:if>
		</div>

	</div>


</body>
</html>
