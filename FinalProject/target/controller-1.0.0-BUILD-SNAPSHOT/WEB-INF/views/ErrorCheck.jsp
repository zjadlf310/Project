<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	String errorcheck = (String)request.getAttribute("errorcheck");
	
	//�α��� ���� (��й�ȣ, ���̵�)
	if(errorcheck.equals("login_fail")){
		out.print("<script>���̵� �Ǵ� ��й�ȣ�� �����ʽ��ϴ�.</script>");
		out.print("<script>window.location.href = 'Login.jsp'</script>");
		
	//�г��� �ߺ� üũ ����
	} else if(errorcheck.equals("nick_check_ok")){
		out.print("<script>alert('��밡���� �г����Դϴ�.')</script>");
		out.print("<script>self.opener = self</script>");
	//�г��� �ߺ� üũ ����
	} else if(errorcheck.equals("nick_check_fail")){
		out.print("<script>alert('�ߺ��� �г����Դϴ�.')</script>");
		out.print("<script>window.location.href = 'NickName.jsp'</script>");
	//���̵� �ߺ� üũ ����
	} else if(errorcheck.equals("id_check_ok")){
		out.print("<script>alert('��밡���� ���̵��Դϴ�.')</script>");
		out.print("<script>self.opener = self</script>");
		out.print("<script>self.close()</script>");
	//���̵� �ߺ� üũ ����
	} else if(errorcheck.equals("id_check_fail")){
		out.print("<script>alert('�ߺ��� ���̵��Դϴ�.')</script>");
		out.print("<script>window.location.href = 'IdCheck.jsp'</script>");
	//ȸ�� ���� ���� ��, ����ȭ�鿡�� �α������� �̵�	
	} else if(errorcheck.equals("join_ok")){
		out.print("<script>alert('���ԵǼ̽��ϴ�. �α��� ȭ������ �̵��մϴ�.')</script>");
		out.print("<script>window.location.href = 'Main.jsp'</script>");

	//���̵� ã�⿡�� �̸�, ��ȣ ��ġ
	} else if(errorcheck.equals("id_search_ok")){
		out.print("<script>alert('ȸ������ ���̵�� "+request.getAttribute("sname")+" �Դϴ�.\nȮ���� ���� �� �α��� ȭ������ �̵��մϴ�.')</script>");
		out.print("<script>window.location.href = 'Main.jsp'</script>");
	//���̵� ã�⿡�� �̸�, ��ȣ ����ġ
	} else if(errorcheck.equals("id_search_fail")){
		out.print("<script>alert('���̵� �������� �ʰų� ȸ�������� ���� �ʽ��ϴ�.\n �ٽ� �õ����ּ���.')</script>");
		out.print("<script>window.location.href = 'Search.jsp'</script>");
	//��й�ȣ ã�⿡�� ���̵�, �̸�, ��ȣ ��ġ
	} else if(errorcheck.equals("pw_search_ok")){
		out.print("<script>window.open('Password.jsp', '_blank', 'width=500px, height=300px')</script>");
	//��й�ȣ ã�⿡�� ���̵�, �̸�, ��ȣ ��ġ
	} else if(errorcheck.equals("pw_search_fail")){
		out.print("<script>alert('ȸ�������� ���� �ʽ��ϴ�.\n�ٽ� �õ����ּ���.')</script>");
		out.print("<script>window.location.href = 'Search.jsp'</script>");
	
	//��й�ȣ ���� ����
	} else if(errorcheck.equals("pw_change_ok")){
		out.print("<script>alert('��й�ȣ�� ����Ǽ̽��ϴ�.\n�α��� �������� �̵��մϴ�.')</script>");
		out.print("<script>window.location.href = 'Login.jsp'</script>");
	}
	
%>
