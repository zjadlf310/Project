package com.admin.client.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.admin.client.DAOVO.ClientVO;
import com.admin.client.Service.ClientService;
import com.admin.client.page.PageClass;

@Controller
public class ClientController {

	@Resource(name="ClientService")
	private ClientService cService;


	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);


	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String adminLogin(ClientVO cvo,HttpServletRequest req, Model model) {
		cvo = cService.adminLogin();
		String id = req.getParameter("adminId");
		String pw = req.getParameter("adminPW");
		if(cvo.getId().equals(id)&&cvo.getPw().equals(pw)) {
			clientpagingOnly(req,model);

			return "clientList";
		}
		else
			return "error";
	}
	@RequestMapping(value = "clientpaging", method = RequestMethod.GET)

	public String clientpaging(HttpServletRequest req, Model model) {
		clientpagingOnly(req,model);
		return "clientList";
	}

	@RequestMapping(value = "clientSerchDataOne", method = RequestMethod.GET)

	public String selectOne(ClientVO cvo,HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		cvo = cService.clientSerchDataOne(id);
		model.addAttribute("cvo",cvo);
		return "clientSelectOne";
	}
	@RequestMapping(value = "deleteOne", method = RequestMethod.GET)
	public String deleteOne(ClientVO cvo,HttpServletRequest req, Model model) {
		
		cService.clientDelete(cvo);
		
		clientpagingOnly(req,model);

		return "clientList";
	}
	@RequestMapping(value = "updateOne", method = RequestMethod.GET)
	public String updateOne(ClientVO cvo,HttpServletRequest req, Model model) {

		cService.clientUpdate(cvo);

		clientpagingOnly(req,model);

		return "clientList";
	}


	@RequestMapping(value = "insert200", method = RequestMethod.GET)
	public String insert200(HttpServletRequest req, Model model) {
		ClientVO cvo = new ClientVO();
		cService.clientInsert200(cvo);
		return "clientList";
	}
	public void clientpagingOnly(HttpServletRequest req, Model model) {
		
		String cstr = req.getParameter("Cpage")==null?"1":req.getParameter("Cpage");
		int Cpage = Integer.parseInt(cstr);
		String keyWord = req.getParameter("keyWord");
		String searchOption = req.getParameter("searchOption");
		PageClass pc = new PageClass(searchOption,keyWord);
		int count = cService.clientTotalCount(pc);
		pc = new PageClass(count,Integer.parseInt(cstr),searchOption,keyWord);
		ArrayList<ClientVO> clientList =cService.clientOnePageInfo(pc);
		model.addAttribute("clientList",clientList);
		model.addAttribute("pc",pc);
	}
}
