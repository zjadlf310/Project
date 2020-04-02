<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<c:forEach var="list" items="${APIList}">
${list.entrpsNm}
${list.roadKnd}
${list.roadRouteNo}
${list.roadRouteNm}
${list.roadRouteDrc}
${list.latitude}
${list.hardness}
${list.restAreaType}
${list.operOpenHhmm}
${list.operCloseHhmm}
${list.ocpatAr}
</c:forEach>
</div>	
</body>
</html>