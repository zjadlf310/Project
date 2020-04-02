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
                type : "POST",
                dataType : "html",
                cache : false
        };
        
        $.ajax(ajaxOption).done(function(data){
            // Contents 영역 삭제
            $('#get').children().remove();
            // Contents 영역 교체
            $('#get').html(data);
        });
    }
</script>
<title>Insert title here</title>
</head>
<body>
	<!-- 페이징 테스트해보고 넣기 -->
	<section class="board_list myboard" id="get">
		<header>
			<h1>좋아요한 글 목록</h1>
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
				<tr id="board">
					<th class="num">3</th>
					<th>편의시설</th>
					<!-- 아래 img는 첨부파일 표시 유무, 반복문쓸거 같아서 하나만 써놓았어요 -->
					<th class="title"><a onclick="acyncMovePage('')">제목</a><img alt="에러" src="resources/images/picture.png"></th>
					<th>민정원</th>
					<th>20-02-11</th>
					<th>333</th>
				</tr>
				<%-- <tr>
					<c:forEach var="" items="" varStatus="status">
					<tr>
						<th class="num">${status.count }</th>
						<th>카테고리</th>
						<th class="title"><a></a></th>
						<th>이름</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
					</c:forEach>
				</tr> --%>
			</tbody>
		</table>
	</section>
</body>
</html>