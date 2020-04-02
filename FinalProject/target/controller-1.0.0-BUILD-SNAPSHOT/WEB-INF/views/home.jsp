<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('select#roadKnd').change(function(){
		$('#roadRouteNm').load("getAPIRoadName", {'roadKind' : $("select#roadKnd").val()},function(){
			$(this).show();
		});
		return false;
	});
});

$(document).ready(function(){
	$('select#roadRouteNm').change(function(){
		$('#entrpsNm').load("getAPIRestName", {'roadName' : $("select#roadRouteNm").val()},function(){
			$(this).show();
		});
		return false;
	});
});
</script>
</head>
<body>
<div>
<form action="getAPIList">
<select name="roadKnd" id="roadKnd">
<option value="">-도로종류-</option>
	<c:forEach var="kind" items="${APIRoadKind}">
		<option value="<c:out value="${kind}"/>"><c:out value="${kind}"/></option>
	</c:forEach>	
</select>
<select id="roadRouteNm" name="roadRouteNm" style="display:none"></select>
<select id="entrpsNm" name="entrpsNm" style="display:none"></select>
<input type="submit" value="검색">
</form>
</div>

</body>
</html>
