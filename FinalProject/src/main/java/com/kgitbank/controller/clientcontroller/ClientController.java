package com.kgitbank.controller.clientcontroller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kgitbank.client.service.ClientServiceImpl;
import com.kgitbank.client.vodao.ClientVO;

@Controller
public class ClientController {
	@Resource(name="clientService")
	private ClientServiceImpl clientService;
	
	@RequestMapping(value = "/getSignup", method = RequestMethod.GET)
	public String Signup(ClientVO vo, Model model) throws SQLException {
		
		if(clientService.Signup(vo)) {
			model.addAttribute("signupsuccess", 100);
			return "Main";
		}else {
			model.addAttribute("signuperror", 101);
			return "Main";
		}
	}
	
	
	@RequestMapping(value = "/getIDCheck", method = RequestMethod.GET)
	public @ResponseBody int IDCheck(@ModelAttribute ClientVO vo,HttpServletRequest req) throws SQLException {
		
		if(clientService.IdDoubleCheck(vo)) {
			return 100;
		}else {
			return 101;
		}
	}
	
	
	@RequestMapping(value = "/getNickNameCheck", method = RequestMethod.GET)
	public @ResponseBody int NickNameCheck(@ModelAttribute ClientVO vo,HttpServletRequest req, HttpSession session) throws SQLException {

		if(clientService.NicknameDoubleCheck(vo)) {
			
			if(session.getAttribute("loginfo")==null) {
				
				return 100;
				
			}else {
				ClientVO vo1=(ClientVO)session.getAttribute("loginfo");
				vo1.setNickname(vo.getNickname());
				session.setAttribute("loginfo", vo1);
				return 100;
			}
		}else {
			return 101;
		}
		
	}
	
	@RequestMapping(value = "/getLogin", method = RequestMethod.GET)
	public String Login(ClientVO vo, Model model, HttpServletRequest req) throws SQLException {
		
		if(vo.getId().equals("admin") && vo.getPw().equals("1234")) {
			return "redirect:http://192.168.58.17:8082/controller/";
		}else {
			if(clientService.Login(vo)) {
				HttpSession session = req.getSession();
				session.setAttribute("loginfo", clientService.Session(vo));
				return "Main";
			}else {
				model.addAttribute("loginerror", "error");
				return "Main";
			}
		}
		
	}
	
	@RequestMapping(value = "/getDelete", method = RequestMethod.GET)
	public String Delete(ClientVO vo, Model model, HttpSession session) throws SQLException {
		
		if(clientService.Delete(vo)) {
			session.removeAttribute("loginfo");
			return "Main";
		}else {
			model.addAttribute("deleterror", "error");
			return "Main";
		}
	}
	
	@RequestMapping(value = "/getClientSearchId", method = RequestMethod.GET)
	public String ClientSearchId(ClientVO vo, Model model) throws SQLException {
		
		model.addAttribute("ID", clientService.SearchId(vo));
		
		return "Main";
	}
	
	@RequestMapping(value = "/getClientSearchPw", method = RequestMethod.GET)
	public String ClientSearchPw(ClientVO vo, Model model) throws SQLException {
		
		if(clientService.SearchPw(vo)) {
			model.addAttribute("id", vo.getId());
			return "Password";
		}else {
			return "Search";
		}
		
		
	}
	
	@RequestMapping(value = "/getClientUpdatePw", method = RequestMethod.GET)
	public String ClientUpdatePw(ClientVO vo, Model model) throws SQLException {
	System.out.println(vo.getPw());
	System.out.println(vo.getId());
	
		if(clientService.UpdatePw(vo)) {
			model.addAttribute("changesuccess", 100);
			return "Main";
		}else {
			model.addAttribute("changeerror", 101);
			return "Main";
		}
	}
	
	@RequestMapping(value = "/getClientUpdate", method = RequestMethod.GET)
	public String ClientUpdate(ClientVO vo, Model model) throws SQLException {
	
		if(clientService.Update(vo)) {
			model.addAttribute("changesuccess", 100);
			return "Main";
		}else {
			model.addAttribute("changeerror", 101);
			return "Main";
		}
	}
	
	@RequestMapping(value = "/NickName", method = RequestMethod.GET)
	public String NickName(ClientVO vo, Model model) throws SQLException {
		
		return "NickName";
	}
	
	@RequestMapping(value = "/IdCheck", method = RequestMethod.GET)
	public String IdCheck(ClientVO vo, Model model) throws SQLException {
		
		return "IdCheck";
	}
	
	@RequestMapping(value = "/getLogout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) throws SQLException {
		HttpSession session = req.getSession();
		session.removeAttribute("loginfo");
		return "Main";
	}


}
