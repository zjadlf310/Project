package com.admin.client.Service;

import java.util.ArrayList;

import com.admin.client.DAOVO.ClientVO;
import com.admin.client.page.PageClass;

public interface ClientService {
	public ClientVO adminLogin();
	
	public ArrayList<ClientVO> clientSelectAll();
	
	public int clientDelete(ClientVO cvo);
	
	public int clientInsert200(ClientVO cvo);
	
	public ClientVO clientSerchDataOne(String id);
	
	public int clientTotalCount();
	
	public int clientTotalCount(PageClass pc);
	
	public ArrayList<ClientVO> clientOnePageInfo(PageClass pc);
	
	public int clientUpdate (ClientVO cvo);
}
