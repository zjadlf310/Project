package com.kgitbank.visit;


import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.stereotype.Controller;

import com.kgitbank.login.vodao.LoginDAO;

@Controller
public class VisitSessionListener implements HttpSessionListener
{

	@Override
    public void sessionCreated(HttpSessionEvent sessionEve) {
        // 세션이 새로 생성되면 execute() 실행한다.
        if(sessionEve.getSession().isNew()){
            try {
				execute(sessionEve);
			} catch (Exception e ) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
        }
    }
 
    private void execute(HttpSessionEvent sessionEve) throws ClassNotFoundException, SQLException 
    {
        try {
        	
        	LoginDAO dao=new LoginDAO();
            // 전체 방문자 수 증가
        	dao.setTotalCount();
            
            // 총 방문자 수
            int totalCount = dao.getTotalCount();
            // 오늘 방문자 수
            int todayCount = dao.getTodayCount();
            System.out.println(totalCount);
            System.out.println(todayCount);
            HttpSession session = sessionEve.getSession();
            
            session.setAttribute("totalCount", totalCount);         
            session.setAttribute("todayCount", todayCount);
 
            
        } catch (Exception e) {
            System.out.println("===== 방문자 카운터 오류 =====\n");
            e.printStackTrace();
        }
    }
   
    @Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
    	
    }
}
