<%@page import="org.springframework.ui.Model"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<style>
.nav {
	position: fixed;
	top: 0;
	left: 0;
	bottom: 0;
	z-index: 1000;
	display: inline-block;
	padding: 0 20px;
	overflow: hidden;
	background-color: #0059ab;
	width: 200px;
	height: auto;
	font-size: 22px;
	color: white;
	padding-top: 150px;
}

.main {
	margin-left: 232px;
}

.banner {
	font-size: 50px;
	font: bold;
	display: block;
	margin-left: 232px;
}

.content {
	display: block;
}
</style>
<body>
	<div class="nav">
		<ul>
			<!-- <li><a href="productInsert200" style="color: white;">더미데이터 넣기</a></li> -->
			<li><a href="clientpaging?Cpage=1" style="color: white;">회원관리</a></li>
			<li><a href="boardpaging?Cpage=1" style="color: white;">게시판 관리</a></li>
			<li><a href="QNApaging?Cpage=1" style="color: white;">QNA 관리</a></li>
		</ul>
	</div>
	<div class="banner" align="center">A D M I N</div>
</body>
</html>
