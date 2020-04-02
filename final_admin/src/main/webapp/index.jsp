<%@page import="com.admin.client.DAOVO.ClientDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style type="text/css">
.container{
position: relative;
width: 100%;
height:900px;
}
.divbox{
position: absolute;
width: auto;
height: auto;
background-color: #ddd;
top : 50%;
left : 50%;
margin: -90px 0 0 -171px;
font-size: 23px;
}
.textbox{
font-size: 23px;
}
</style>
<body>
	<div class = "container">
	
		<div class ="divbox ">
			<form action="login" method="post">
				<table border="2">
					<tr>
						<td>id</td><td><input type="text" name="adminId"  class="textbox"/></td>
					</tr>
					<tr>
						<td>pw</td><td><input type="password" name="adminPW" class="textbox" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="submit" value="로그인" class="textbox" style="cursor: pointer;"/></td>
					</tr>
				</table>
			</form>
		</div>
	</div>



</body>
</html>