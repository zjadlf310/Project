package com.kgitbank.board_re.vodao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



import org.springframework.stereotype.Repository;


import com.kgitbank.dbconn.Dbconn;

@Repository("Board_reDAO")
public class Board_reDAO {
	private Connection con;
	private PreparedStatement st;
	private ResultSet rs;
	
	public Board_reDAO() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		con = new Dbconn().getConnection();
	}
	
	//댓글 쓰기
	public boolean Board_reWrite(Board_reVO rvo) throws SQLException {		
		
		String sql = "insert into retable values(?,(SELECT NVL(MAX(board_re),0)+1 FROM retable where board_num=?),?,?,?,?,?,?)";
		st = con.prepareStatement(sql);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sysdate = sdf.format(new Date());
		st.setInt(1, rvo.getBoard_num());
		st.setInt(2, rvo.getBoard_num());
		st.setInt(3, /*rvo.getBoard_re_dab()*/ 0);
		st.setString(4, rvo.getText());
		st.setString(5, rvo.getRe_writer());
		st.setString(6, sysdate);
		st.setString(7, rvo.getFilename());
		st.setString(8, rvo.getOri_filename());
		
		int aa = st.executeUpdate();
		
		if(aa==1) {
			return true;
		}else {
			return false;
		}
	}
	
	//답글쓰기
	public boolean Board_re_dabWrite(Board_reVO rvo) throws SQLException {
		String sql = "insert into retable values(?,?,(SELECT NVL(MAX(board_re_dab),0)+1 FROM retable where board_num=? and board_re=?),?,?,?,?,?)";
		st = con.prepareStatement(sql);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sysdate = sdf.format(new Date());
		st.setInt(1, rvo.getBoard_num());
		st.setInt(2, rvo.getBoard_re());
		st.setInt(3, rvo.getBoard_num());
		st.setInt(4, rvo.getBoard_re());
		st.setString(5, rvo.getText());
		st.setString(6, rvo.getRe_writer());
		st.setString(7, sysdate);
		st.setString(8, rvo.getFilename());
		st.setString(9, rvo.getOri_filename());
		
		int aa = st.executeUpdate();
		
		if(aa==1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	//댓글&답글 수정
	public boolean Board_reUpdate(Board_reVO rvo) throws SQLException {
		if (rvo.getBoard_re_dab()!=0) {
			String sql = "update retable set text = ?, re_writer = ?, re_date = ?, filename = ? , ori_filename = ?"
					+ " where board_num = ? and board_re = ? and board_re_dab=?  ";
			st = con.prepareStatement(sql);	
		}
		else {
			String sql = "update retable set text = ?, re_writer = ?, re_date = ?, filename = ? , ori_filename = ?"
					+ " where board_num = ? and board_re = ? and board_re_dab=0";
			st = con.prepareStatement(sql);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		st.setString(1, rvo.getText());
		st.setString(2, rvo.getRe_writer());
		st.setString(3, sdf.format(new Date()));
		st.setString(4, rvo.getFilename());
		st.setString(5, rvo.getOri_filename());
		st.setInt(6, rvo.getBoard_num());
		st.setInt(7, rvo.getBoard_re());
		
		int aa = st.executeUpdate();
		
		if(aa==1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	//댓글&답글 삭제
	public boolean Board_reDelete(Board_reVO rvo) throws SQLException {
		if (rvo.getBoard_re_dab()!=0) {
			String sql = "delete from retable where board_num = ? and board_re =? and board_re_dab=? ";
			st = con.prepareStatement(sql);
			
			st.setInt(1, rvo.getBoard_num());
			st.setInt(2, rvo.getBoard_re());
			st.setInt(3, rvo.getBoard_re_dab());		
		}
		else {
			String sql = "delete from retable where board_num = ? and board_re =? ";
			st = con.prepareStatement(sql);
			
			st.setInt(1, rvo.getBoard_num());
			st.setInt(2, rvo.getBoard_re());
		}
	
		//이러면 답글까지 다 삭제 가능
		int aa = st.executeUpdate();
		
		if(aa==1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	//한 게시물에 대한 댓글과 답글 모두 가져오기
	public ArrayList<Board_reVO> Board_reList(Board_reVO rvo) throws SQLException {
			
			String sql = "select * from retable where board_num= ? order by board_re desc, board_re_dab asc"; 
			//높은번호부터 받아버리기
			st = con.prepareStatement(sql);
			/*st.setInt(1,rvo.getBoard_num());*/
			st.setInt(1, 1);
			rs = st.executeQuery();
			
			ArrayList<Board_reVO> ar1 = new ArrayList<Board_reVO>();
			
			while(rs.next()) {
				Board_reVO vo1 = new Board_reVO();
				vo1.setBoard_num(rs.getInt("board_num"));
				vo1.setBoard_re(rs.getInt("board_re"));
				vo1.setBoard_re_dab(rs.getInt("board_re_dab"));
				vo1.setText(rs.getString("text"));
				vo1.setRe_writer(rs.getString("re_writer"));
				vo1.setRe_date(rs.getDate("re_date"));
				vo1.setFilename(rs.getString("filename"));
				vo1.setOri_filename(rs.getString("ori_filename"));
				/*//파일가져오는게 걸려...
				vo1.setFile1(rs.get);*/
				
				ar1.add(vo1);
				
			}
			
			return ar1;
	}
		
	//한 개의 댓글 답글 수정보기창
	public Board_reVO Board_redata(Board_reVO rvo) throws SQLException {
			if (rvo.getBoard_re_dab()!=0) {
				String sql = "select * from retable where board_num= ? and board_num_re= ? and board_num_re_dab= ? "; 
				//높은번호부터 받아버리기
				st = con.prepareStatement(sql);
				st.setInt(1,rvo.getBoard_num());
				st.setInt(2, rvo.getBoard_re());
				st.setInt(3, rvo.getBoard_re_dab());			
			}
			else {
				String sql = "select * from retable where board_num= ? and board_re= ? and board_re_dab= 0 "; 
				//높은번호부터 받아버리기
				st = con.prepareStatement(sql);
				st.setInt(1,rvo.getBoard_num());
				st.setInt(2, rvo.getBoard_re());
			}
			
			rs = st.executeQuery();
	
			Board_reVO vo1 = null;
			while(rs.next()) {
				vo1 = new Board_reVO();
				vo1.setBoard_num(rs.getInt("board_num"));
				vo1.setBoard_re(rs.getInt("board_re"));
				vo1.setBoard_re_dab(rs.getInt("board_re_dab"));
				vo1.setText(rs.getString("text"));
				vo1.setRe_writer(rs.getString("re_writer"));
				vo1.setRe_date(rs.getDate("re_date"));
				vo1.setFilename(rs.getString("filename"));
				vo1.setOri_filename(rs.getString("ori_filename"));		
			}
		return vo1;
	}
		
}
