package com.kgitbank.client.vodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.kgitbank.dbconn.Dbconn;
@Repository("clientDAO")
public class ClientDAO {
	private Connection con;
	private PreparedStatement st;
	private ResultSet rs;
	
	public ClientDAO() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		con = new Dbconn().getConnection();
	}
	
	public boolean IdDoubleCheck(ClientVO vo) throws SQLException {
		String sql = "select id from clientTable where id = ?";
		st = con.prepareStatement(sql);
		st.setString(1, vo.getId());
		rs = st.executeQuery();
		String name = null;
		while(rs.next()) {
			name = rs.getString("id");
		}
		
		if(name !=null) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean NicknameDoubleCheck(ClientVO vo) throws SQLException {
		String sql = "select nickname from clientTable where nickname = ?";
		st = con.prepareStatement(sql);
		st.setString(1, vo.getNickname());
		rs = st.executeQuery();
		String name = null;
		while(rs.next()) {
			name = rs.getString("nickname");
		}
		
		if(name !=null) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean Signup(ClientVO vo) throws SQLException {
		String sql = "insert into clientTable values(?,?,?,?,?,?)";
		st = con.prepareStatement(sql);
		st.setString(1, vo.getName());
		st.setString(2, vo.getNickname());
		st.setString(3, vo.getId());
		st.setString(4, vo.getPw());
		st.setString(5, vo.getTel());
		st.setString(6, vo.getMail());
		
		int aa = st.executeUpdate();
		
		if(aa==1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean Login(ClientVO vo) throws SQLException {
		String sql = "select id,pw from clientTable where id = ? and pw = ?";
		st = con.prepareStatement(sql);
		st.setString(1, vo.getId());
		st.setString(2, vo.getPw());
		rs = st.executeQuery();
		String id = null;
		String pw = null;
		while(rs.next()) {
			id = rs.getString("id");
			pw = rs.getString("pw");
		}
		
		if(id!=null && pw!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean Delete(ClientVO vo) throws SQLException {
		String sql = "delete from clientTable where id = ? and pw = ?";
		st = con.prepareStatement(sql);
		st.setString(1, vo.getId());
		st.setString(2, vo.getPw());
		
		int aa = st.executeUpdate();
		
		if(aa==1) {
			return true;
		}else {
			return false;
		}
	}
	
	public ArrayList<ClientVO> ClientList() throws SQLException {
		String sql = "select * from clientTable ";
		st = con.prepareStatement(sql);
		
		rs = st.executeQuery();
		ArrayList<ClientVO> ar = new ArrayList<ClientVO>();
		while(rs.next()) {
			ClientVO vo = new ClientVO();
			vo.setId(rs.getString("id"));
			vo.setMail(rs.getString("mail"));
			vo.setName(rs.getString("name"));
			vo.setNickname(rs.getString("nickname"));
			vo.setPw(rs.getString("pw"));
			vo.setTel(rs.getString("tel"));
			
			ar.add(vo);
		}
		
		return ar;
	}
	
	public ArrayList<ClientVO> ClientSearchNameList(ClientVO vo) throws SQLException {
		String sql = "select * from clientTable where name = ? ";
		st = con.prepareStatement(sql);
		st.setString(1, vo.getName());
		
		rs = st.executeQuery();
		ArrayList<ClientVO> ar = new ArrayList<ClientVO>();
		while(rs.next()) {
			ClientVO vo1 = new ClientVO();
			vo1.setId(rs.getString("id"));
			vo1.setMail(rs.getString("mail"));
			vo1.setName(rs.getString("name"));
			vo1.setNickname(rs.getString("nickname"));
			vo1.setPw(rs.getString("pw"));
			vo1.setTel(rs.getString("tel"));
			
			ar.add(vo1);
		}
		
		return ar;
	}
	
	public String SearchId(ClientVO vo) throws SQLException {
		String sql = "select * from clientTable where name = ? and tel = ?";
		st = con.prepareStatement(sql);
		st.setString(1, vo.getName());
		st.setString(2, vo.getTel());
		
		rs = st.executeQuery();
		String id = null;
		while(rs.next()) {
			
			id = rs.getString("id");
		}
		if(id!=null) {
			return id;
		}else {
			return "error";
		}
		
	}
	
	public boolean SearchPw(ClientVO vo) throws SQLException {
		String sql = "select * from clientTable where id = ? and name = ? and tel = ?";
		st = con.prepareStatement(sql);
		st.setString(1, vo.getId());
		st.setString(2, vo.getName());
		st.setString(3, vo.getTel());
		
		rs = st.executeQuery();
		String id = null, name = null, tel = null;
		while(rs.next()) {
			id = rs.getString("id");
			name = rs.getString("name");
			tel = rs.getString("tel");
		}
		
		if(id!=null && name!=null && tel!=null) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean UpdatePw(ClientVO vo) throws SQLException {
		String sql = "update clientTable set pw = ? where id = ?";
		st = con.prepareStatement(sql);
		st.setString(1, vo.getPw());
		st.setString(2, vo.getId());
		
		int aa = st.executeUpdate();
		
		if(aa==1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean Update(ClientVO vo) throws SQLException {
		String sql = "update clientTable set pw = ?, nickname = ?, tel = ?, mail = ?  where id = ?";
		st = con.prepareStatement(sql);
		st.setString(1, vo.getPw());
		st.setString(2, vo.getNickname());
		st.setString(3, vo.getTel());
		st.setString(4, vo.getMail());
		st.setString(5, vo.getId());
		
		int aa = st.executeUpdate();
		
		if(aa==1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public ClientVO Session(ClientVO vo) throws SQLException {
		String sql = "select * from clientTable where id = ? and pw = ?";
		st = con.prepareStatement(sql);
		st.setString(1, vo.getId());
		st.setString(2, vo.getPw());
		
		rs = st.executeQuery();
		ClientVO vo1 = new ClientVO();
		while(rs.next()) {
			vo1.setId(rs.getString("id"));
			vo1.setMail(rs.getString("mail"));
			vo1.setName(rs.getString("name"));
			vo1.setNickname(rs.getString("nickname"));
			vo1.setPw(rs.getString("pw"));
			vo1.setTel(rs.getString("tel"));
			
		}
		
		return vo1;
	}
	
}
