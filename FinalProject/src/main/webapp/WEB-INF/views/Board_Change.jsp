<%@page import="com.kgitbank.client.vodao.ClientVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript">
function CancelConfirm(){
	var con=confirm("글쓰기를 취소하시겠습니까?");
	if(con==true){
		location.href="Board_List";
	}
	else{
		return false;
	}
}

	function WriteNullCheck(){
		if(!document.write.write_area.value){
			alert("지역 카테고리를 선택해주세요.");
			document.write.write_area.focus();
			return false;
		} else if(!document.write.write_exp.value){
			alert("고속도로 카테고리를 선택해주세요.");
			document.write.write_exp.focus();
			return false;
		} else if(!document.write.title.value){
			alert("제목을 입력해주세요.");
			document.write.write_title.focus();
			return false;
		} else if(!document.write.write_text.value){
			alert("내용을 입력해주세요.");
			document.write.write_text.focus();
			return false;
		} 
	}
</script>
<script src="<c:url value="/resources/ckeditor/ckeditor.js" />"></script>
<script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
<title></title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">
<!-- Custom styles for this template -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/business-frontpage.css"></head>		
<body>
      	<div class="board_write">
		<form action="Board_Update" name="write" onsubmit="return WriteNullCheck()">
			<h1>게시글 작성</h1>
			<br><br>
			<table>
				<tr>
					<td>
						<h5>카테고리</h5>
					</td>
					<td>
					<!-- API되면 고치기 -->
						<select name="category">
							<option value="">==지역 선택==</option>
							<option value="dkdkd">dkdk</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<h5>제목</h5>
					</td>
					<td colspan="3">
						<input type="text" name="title" placeholder="제목을 입력하세요." maxlength="100" value="${board_data.title}">
					</td>
				</tr>
				<tr>
					<td>
						<h5>파일 첨부</h5>
					</td>
					<td>
						<input type="text" name="write_file_name" readonly>
					</td>
					<td>
						<input type="button" value="파일 첨부" name="write_file_btn" class="btn btn-primary btn-lg">
					</td>
				</tr>
			</table>
			<textarea class="ckeditor" id="test" name="write_text" maxlength="500">${board_data.text}</textarea>
			<script type="text/javascript">
				CKEDITOR.replace('test',{height:500});
			</script>
			<!-- 폰트는 ckeditor.js파일에서 찾을 수 있음
			 	  다운받은 폰트 적용은 되는데 클라이언트에서도 나오는 지는 모르겠음 -->

			<table id="table">
				<tr>
					<td>
						<input type="hidden" value="${loginfo.nickname}" name="writer">
						<input type="hidden" value="${board_data.board_number}" name="board_number">
						<input type="submit" value="확인" name="write_ok" class="btn btn-primary btn-lg">
		 			</td>
		 			<td>
						<input type="button" value="취소" name="write_no" class="btn btn-primary btn-lg" onclick="CancelConfirm()">
					</td>
		 		</tr>
		 	</table>
		</form>
	</div>
</body>
</html>