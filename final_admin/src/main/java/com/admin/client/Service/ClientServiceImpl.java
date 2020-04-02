package com.admin.client.Service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.admin.client.DAOVO.ClientDAO;
import com.admin.client.DAOVO.ClientVO;
import com.admin.client.page.PageClass;
@Service("ClientService")
public class ClientServiceImpl implements ClientService{
	
	@Resource
	private ClientDAO cdao;
	
	
	
	@Override
	public ClientVO adminLogin() {
		
		return cdao.adminLogin();
	}

	@Override
	public ArrayList<ClientVO> clientSelectAll() {
		ArrayList<ClientVO> clientList = cdao.clientSerchDatAll();
		return clientList;
	}

	@Override
	public int clientDelete(ClientVO cvo) {
		
		return cdao.clientDelete(cvo);
	}

	@Override
	public ClientVO clientSerchDataOne(String id) {
		
		return cdao.clientSerchDataOne(id);
	}

	@Override
	public int clientTotalCount() {
		return cdao.clientTotalCount();
	}

	@Override
	public int clientTotalCount(PageClass pc) {
		return cdao.clientTotalCount(pc);
	}
	
	@Override
	public ArrayList<ClientVO> clientOnePageInfo(PageClass pc) {
		
		return cdao.clientOnePageInfo(pc);
	}

	@Override
	public int clientInsert200(ClientVO cvo) {
		
		return cdao.clientInsert200(cvo);
	}

	@Override
	public int clientUpdate(ClientVO cvo) {
		return cdao.clientUpdate(cvo);
	}



}
