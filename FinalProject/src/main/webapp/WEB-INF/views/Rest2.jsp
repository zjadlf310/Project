<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript">
$(document).ready(function(){
	$('#back').click(function(){
		$('#get').load('Rest');
		return false;
	});
});
</script>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>GAZUA 휴게소</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/business-frontpage.css"></head>
<body>
	<div class="rest2" id="get">
		<h1>휴게소 정보</h1><br><br>
		<h2>${list.roadRouteDrc}</h2><br><br>
		${list.phoneNumber}<br><br>
		주소<br><br>
		쉼터 : ${list.shltrYn}<br><br>
		대표 음식 : ${list.rprsntvRstrt}<br><br>
		경정비소, 화물 휴게소<br><br>
		편의 시설<br><br>
		주유소<br><br>
		<a href="" id="back"><input class="button" type="button" value="목록"></a>
	</div>
</body>
</head>		
</html>