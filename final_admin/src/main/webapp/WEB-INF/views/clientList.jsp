<%@page import="org.springframework.ui.Model"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/mainFormat.jsp"%>
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

.clientListForm {
	font-size: 20px;
}

.paging {
	font-size: 20px;
}
</style>

<body>

	<div class="main">

		<div class="content" align="center">
			<h1>회원 관리</h1>
			<br> <br> <br>
			<form action="clientpaging">
				<table border="2" class="clientListForm">
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>이메일</th>
					</tr>
					<c:forEach var="clientList" items="${clientList }"
						varStatus="status">
						<tr>
							<td style="width: 200px;" align="center"><a
								href="clientSerchDataOne?id=${clientList.getId()}">${clientList.getId()}</a></td>
							<td style="width: 100px;" align="center">${clientList.getName()}</td>
							<td style="width: 250px;" align="center">${clientList.getTel()}</td>
							<td style="width: 250px;" align="center">${clientList.getMail()}</td>
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
									<option selected="selected" value="id">아이디
									<option value="idName">아이디+이름
									<option value="idMail">아이디+이메일
							</select> <input type="submit" value="검색"
								style="font-size: 20px; cursor: pointer;"></td>
						</tr>
					</table>
				</div>
			</form>


			<c:if test="${cpage ne '1' }">
				<a
					href="clientpaging?Cpage=${pc.getCpage()-1}&keyWord=${pc.getKeyWord()}&searchOption=${pc.getSearchOption()}"
					class="paging">prev</a>
			</c:if>
			<c:forEach var="i" begin="${pc.getStartPage()}"
				end="${pc.getEndPage()}" step="1">
				<a
					href="clientpaging?Cpage=${i}&keyWord=${pc.getKeyWord()}&searchOption=${pc.getSearchOption()}"
					class="paging"><c:out value="${i}" /></a>
			</c:forEach>
			<c:if test="${cpage ne maxpage }">
				<a
					href="clientpaging?Cpage=${pc.getCpage()+1}&keyWord=${pc.getKeyWord()}&searchOption=${pc.getSearchOption()}"
					class="paging">next</a>
			</c:if>
		</div>

	</div>


</body>
</html>
