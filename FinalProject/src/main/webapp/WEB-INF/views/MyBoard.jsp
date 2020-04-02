<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>GAZUA 휴게소</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/business-frontpage.css">
<script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
<script type="text/javascript">
	function acyncMovePage(url){
        // ajax option
        var ajaxOption = {
                url : url,
                async : true,
                type : "GET",
                dataType : "html",
                cache : false
        };
        
        $.ajax(ajaxOption).done(function(data){
            // Contents 영역 삭제
            $('#board_list').children().remove();
            // Contents 영역 교체
            $('#board_list').html(data);
        });
    }
</script>
<title>Insert title here</title>
</head>
<body>
	<!-- 페이징 테스트해보고 넣기 -->
	<section class="board_list">
			<header>
				<h1>게시판</h1>
			</header>
			<table class="type09">
				<thead>
					<tr>
						<th scope="col">No.</th>
						<th scope="col">카테고리</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${My_list}">
					<tr>
						<th class="num" id="boardnum">${list.board_number}</th>
						<th>${list.category}</th>
						<th class="title"><a href="Board_View?board_number=${list.board_number}">${list.title}</a>
							<c:if test="${not empty list.filename}">	
								<img alt="에러" src="resources/images/picture.png">
							</c:if>
						</th>
						<th>${list.writer }</th>
						<th>${list.w_date }</th>
						<th>${list.view_cnt }</th>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
</body>
</html>