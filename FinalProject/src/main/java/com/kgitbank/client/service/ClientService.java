package com.kgitbank.client.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kgitbank.client.vodao.ClientVO;

public interface ClientService {
	public boolean IdDoubleCheck(ClientVO vo) throws SQLException;
	
	public boolean NicknameDoubleCheck(ClientVO vo) throws SQLException;
	
	public boolean Signup(ClientVO vo) throws SQLException;
		
	public boolean Login(ClientVO vo) throws SQLException;
	
	public boolean Delete(ClientVO vo) throws SQLException;
	
	public ArrayList<ClientVO> ClientList() throws SQLException;
	
	public ArrayList<ClientVO> ClientSearchNameList(ClientVO vo) throws SQLException;
	
	public String SearchId(ClientVO vo) throws SQLException;
	
	public boolean SearchPw(ClientVO vo) throws SQLException;
	
	public boolean UpdatePw(ClientVO vo) throws SQLException;
	
	public boolean Update(ClientVO vo) throws SQLException;
	
	public ClientVO Session(ClientVO vo) throws SQLException;
}
