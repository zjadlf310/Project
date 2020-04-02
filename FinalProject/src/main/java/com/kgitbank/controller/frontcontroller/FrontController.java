package com.kgitbank.controller.frontcontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kgitbank.front.service.FrontServiceImpl;
import com.kgitbank.front.vodao.FrontVO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class FrontController {
	
	@Resource(name="frontService")
	private FrontServiceImpl frontService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(FrontVO vo, Model model) throws IOException, ParseException {
		
		return "Main";
	}
	
	@RequestMapping(value = "/getAPIRoadKind", method = RequestMethod.GET)
	public String APIRoadKind(FrontVO vo, Model model) throws IOException, ParseException {
		
		model.addAttribute("APIRoadKind", frontService.APIRoadKind(vo));
		
		return "Rest";
	}
	
	
	@RequestMapping(value = "/getAPIRoadName", method = RequestMethod.GET)
	public String APIRoadName(HttpServletRequest req, Model model) throws IOException, ParseException {
		
		FrontVO vo = new FrontVO();
		vo.setRoadKnd((String) req.getParameter("roadKind"));
		model.addAttribute("APIRoadName",frontService.APIRoadName(vo));
		
		return "RoadName";
		
	}
	
	@RequestMapping(value = "/getAPIRestName", method = RequestMethod.GET)
	public String APIRestName(HttpServletRequest req, Model model) throws IOException, ParseException {
		
		FrontVO vo = new FrontVO();
		vo.setRoadRouteNm((String) req.getParameter("roadName"));
		model.addAttribute("APIRestName",frontService.APIRestName(vo));
		
		return "RestName";
		
	}
	
	@RequestMapping(value = "/getAPIList", method = RequestMethod.GET)
	public @ResponseBody ArrayList<FrontVO> APIList(FrontVO vo, Model model) throws IOException, ParseException {
		
		return frontService.APIList(vo);
		
	}
	
	@RequestMapping(value = "/QAmail", method = RequestMethod.GET)
	public String QA(FrontVO vo, Model model) throws ClassNotFoundException, SQLException {
		
		if(frontService.QA(vo)) {
			model.addAttribute("QAmail","QA");
			return "Main";
		}else {
			model.addAttribute("QAerror","QA");
			return "Main";
		}
		
	}
	
	@RequestMapping(value="/Signup")
	public String Signup() {
		return "Signup";
	}

	@RequestMapping(value="/NickName")
	public String NickName() {
		return "NickName";
	}
	
	@RequestMapping(value="/IdCheck")
	public String IdCheck() {
		return "IdCheck";
	}
	
	@RequestMapping(value="/Search")
	public String Search() {
		return "Search";
	}
	
	@RequestMapping(value="/Introduction")
	public String Introduction() {
		return "Introduction";
	}
	
	@RequestMapping(value="/QA")
	public String QA() {
		return "QA";
	}
	
	@RequestMapping(value="/Confirm")
	public String Confirm() {
		return "Confirm";
	}
	
	@RequestMapping(value="/Mypage")
	public String Mypage() {
		return "Mypage";
	}
	
	@RequestMapping(value="/Change")
	public String Change() {
		return "Change";
	}
	
	@RequestMapping(value="/End")
	public String End() {
		return "End";
	}

	@RequestMapping(value="/Rest2")
	public String Rest2() {
		
		return "Rest2";
	}
	
	@RequestMapping(value="/Board_Write")
	public String Board_Write() {
		
		return "Board_Write";
	}
}
