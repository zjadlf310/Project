package com.kgitbank.client.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kgitbank.client.vodao.ClientDAO;
import com.kgitbank.client.vodao.ClientVO;
@Service("clientService")
public class ClientServiceImpl implements ClientService {
	@Resource(name="clientDAO")
	private ClientDAO clientDAO;
	
	@Override
	public boolean IdDoubleCheck(ClientVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return clientDAO.IdDoubleCheck(vo);
	}

	@Override
	public boolean NicknameDoubleCheck(ClientVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return clientDAO.NicknameDoubleCheck(vo);
	}

	@Override
	public boolean Signup(ClientVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return clientDAO.Signup(vo);
	}

	@Override
	public boolean Login(ClientVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return clientDAO.Login(vo);
	}

	@Override
	public boolean Delete(ClientVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return clientDAO.Delete(vo);
	}

	@Override
	public ArrayList<ClientVO> ClientList() throws SQLException {
		// TODO Auto-generated method stub
		return clientDAO.ClientList();
	}

	@Override
	public ArrayList<ClientVO> ClientSearchNameList(ClientVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return clientDAO.ClientSearchNameList(vo);
	}

	@Override
	public String SearchId(ClientVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return clientDAO.SearchId(vo);
	}

	@Override
	public boolean SearchPw(ClientVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return clientDAO.SearchPw(vo);
	}

	@Override
	public boolean UpdatePw(ClientVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return clientDAO.UpdatePw(vo);
	}

	@Override
	public ClientVO Session(ClientVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return clientDAO.Session(vo);
	}

	@Override
	public boolean Update(ClientVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return clientDAO.Update(vo);
	}

}
