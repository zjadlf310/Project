<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	String errorcheck = (String)request.getAttribute("errorcheck");
	
	//로그인 실패 (비밀번호, 아이디)
	if(errorcheck.equals("login_fail")){
		out.print("<script>아이디 또는 비밀번호가 맞지않습니다.</script>");
		out.print("<script>window.location.href = 'Login.jsp'</script>");
		
	//닉네임 중복 체크 성공
	} else if(errorcheck.equals("nick_check_ok")){
		out.print("<script>alert('사용가능한 닉네임입니다.')</script>");
		out.print("<script>self.opener = self</script>");
	//닉네임 중복 체크 실패
	} else if(errorcheck.equals("nick_check_fail")){
		out.print("<script>alert('중복된 닉네임입니다.')</script>");
		out.print("<script>window.location.href = 'NickName.jsp'</script>");
	//아이디 중복 체크 성공
	} else if(errorcheck.equals("id_check_ok")){
		out.print("<script>alert('사용가능한 아이디입니다.')</script>");
		out.print("<script>self.opener = self</script>");
		out.print("<script>self.close()</script>");
	//아이디 중복 체크 실패
	} else if(errorcheck.equals("id_check_fail")){
		out.print("<script>alert('중복된 아이디입니다.')</script>");
		out.print("<script>window.location.href = 'IdCheck.jsp'</script>");
	//회원 가입 성공 후, 메인화면에서 로그인으로 이동	
	} else if(errorcheck.equals("join_ok")){
		out.print("<script>alert('가입되셨습니다. 로그인 화면으로 이동합니다.')</script>");
		out.print("<script>window.location.href = 'Main.jsp'</script>");

	//아이디 찾기에서 이름, 번호 일치
	} else if(errorcheck.equals("id_search_ok")){
		out.print("<script>alert('회원님의 아이디는 "+request.getAttribute("sname")+" 입니다.\n확인을 누를 시 로그인 화면으로 이동합니다.')</script>");
		out.print("<script>window.location.href = 'Main.jsp'</script>");
	//아이디 찾기에서 이름, 번호 불일치
	} else if(errorcheck.equals("id_search_fail")){
		out.print("<script>alert('아이디가 존재하지 않거나 회원정보가 맞지 않습니다.\n 다시 시도해주세요.')</script>");
		out.print("<script>window.location.href = 'Search.jsp'</script>");
	//비밀번호 찾기에서 아이디, 이름, 번호 일치
	} else if(errorcheck.equals("pw_search_ok")){
		out.print("<script>window.open('Password.jsp', '_blank', 'width=500px, height=300px')</script>");
	//비밀번호 찾기에서 아이디, 이름, 번호 일치
	} else if(errorcheck.equals("pw_search_fail")){
		out.print("<script>alert('회원정보가 맞지 않습니다.\n다시 시도해주세요.')</script>");
		out.print("<script>window.location.href = 'Search.jsp'</script>");
	
	//비밀번호 변경 성공
	} else if(errorcheck.equals("pw_change_ok")){
		out.print("<script>alert('비밀번호가 변경되셨습니다.\n로그인 페이지로 이동합니다.')</script>");
		out.print("<script>window.location.href = 'Login.jsp'</script>");
	}
	
%>
