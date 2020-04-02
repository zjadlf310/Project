package com.kgitbank.login.vodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.kgitbank.dbconn.Dbconn;

@Repository("LoginDAO")
public class LoginDAO {
	
	private Connection con;
	private PreparedStatement str;
	private ResultSet rs;
	public LoginDAO() throws ClassNotFoundException, SQLException {
		con=new Dbconn().getConnection();
	}

	public void strClose() throws SQLException {
		if(str !=null) {
			str.close();
		}
		if(con !=null) {
			con.close();
		}
		if(rs !=null) {
			rs.close();
		}
	}

	
	public void setTotalCount() throws SQLException
    {

        try {
            // 쿼리생성
            // 총 방문자수를 증가시키기 위해 테이블에 현재 날짜 값을 추가시킨다.
            String sql = "INSERT INTO VISIT (V_DATE) VALUES (sysdate)";

            // 자동 커밋을 false로 한다.
            con.setAutoCommit(false);
            
            str = con.prepareStatement(sql);
            // 쿼리 실행
            str.executeUpdate();
            // 완료시 커밋
            con.commit(); 
            
        } catch (SQLException sqle) {
            // 오류시 롤백
            con.rollback(); 
            throw new RuntimeException(sqle.getMessage());
        } 
    } // end setTotalCount()
    
    /**
     * 총 방문자수를 가져온다.
     * @return totalCount : 총 방문자 수
     */
    public int getTotalCount()
    {
     
        int totalCount = 0;
        
        try {
            
            // 테이블의 테이터 수를 가져온다.
            // 데이터 수 = 총 방문자 수
            String sql = "SELECT COUNT(*) AS TotalCnt FROM VISIT";
            
            str = con.prepareStatement(sql);
            rs = str.executeQuery();
            
            // 방문자 수를 변수에 담는다.
            if (rs.next()) 
                totalCount = rs.getInt("TotalCnt");
            
            return totalCount;
            
        } catch (Exception sqle) {
            throw new RuntimeException(sqle.getMessage());
        } 
      
    } // end getTotalCount()
    
    /**
     * 오늘 방문자 수를 가져온다.
     * @return todayCount : 오늘 방문자
     */
    public int getTodayCount()
    {
        int todayCount = 0;
        try {
            String sql = "SELECT COUNT(*) AS TodayCnt FROM VISIT WHERE TO_DATE(V_DATE, 'YYYY-MM-DD') = TO_DATE(sysdate, 'YYYY-MM-DD')"; 
            str = con.prepareStatement(sql);
            rs = str.executeQuery();
            
            // 방문자 수를 변수에 담는다.
            if (rs.next()) 
                todayCount = rs.getInt("TodayCnt");
            
            return todayCount;
            
        } catch (Exception sqle) {
            throw new RuntimeException(sqle.getMessage());
        } 
    }// end getTodayCount()

    
	
	
	
	
}
