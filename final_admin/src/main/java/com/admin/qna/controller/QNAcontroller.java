package com.admin.qna.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.admin.client.page.PageClass;
import com.admin.qna.DAOVO.QNAVO;
import com.admin.qna.Service.QNAservice;

@Controller
public class QNAcontroller {

	@Resource(name="QNAservice")
	QNAservice QNAservice;
	
	@RequestMapping(value = "QNApaging", method = RequestMethod.GET)

	public String QNApaging(HttpServletRequest req, Model model) {
		QNApagingOnly(req,model);
		return "QNAList";
	}
	@RequestMapping(value = "QNASerchDataOne", method = RequestMethod.GET)
	public String SerchDataOne(QNAVO avo,HttpServletRequest req, Model model) {
		
		int num = Integer.parseInt(req.getParameter("num"));
		avo = QNAservice.QNASerchDataOne(num);		
		model.addAttribute("avo",avo);
		
		
		return "QNASelectOne";
	}

	@RequestMapping(value = "QNADelete", method = RequestMethod.GET)
	public String QNADelete(QNAVO avo,HttpServletRequest req, Model model)
	{

		QNAservice.QNADelete(avo);

		QNApagingOnly(req,model);

		return "QNAList";
	}

	public void QNApagingOnly(HttpServletRequest req, Model model) {

		String cstr = req.getParameter("Cpage")==null?"1":req.getParameter("Cpage");
		int Cpage = Integer.parseInt(cstr);
		String keyWord = req.getParameter("keyWord");
		String searchOption = req.getParameter("searchOption");
		PageClass pc = new PageClass(searchOption,keyWord);
		int count = QNAservice.QNATotalCount(pc);
		pc = new PageClass(count,Integer.parseInt(cstr),searchOption,keyWord);
		ArrayList<QNAVO> QNAList =QNAservice.QNAOnePageInfo(pc);
		model.addAttribute("QNAList",QNAList);
		model.addAttribute("pc",pc);
	}

}
