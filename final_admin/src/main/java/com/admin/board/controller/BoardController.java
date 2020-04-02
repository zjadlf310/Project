package com.admin.board.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.board.DAOVO.BoardVO;
import com.admin.board.Service.BoardService;
import com.admin.client.page.PageClass;
import com.admin.comment.DAOVO.Board_reVO;
import com.admin.comment.Service.Board_reService;

import jake.friend.util.MediaUtils;

@Controller
public class BoardController {

	@Resource(name="BoardService")
	private BoardService bService;
	@Resource(name="Board_reService")
	private Board_reService rService;

	@Resource(name = "uploadPath") // sevelet-context에 등록되어 있음
	private String uploadPath;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "home";
	}*/
	@RequestMapping(value = "boardpaging", method = RequestMethod.GET)

	public String boardpaging(HttpServletRequest req, Model model) {
		boardpagingOnly(req,model);
		return "boardList";
	}
	@RequestMapping(value = "boardSerchDataOne", method = RequestMethod.GET)
	public String selectOne(BoardVO bvo,HttpServletRequest req, Model model) {
		
		int board_number = Integer.parseInt(req.getParameter("board_number"));
		bvo = bService.boardSerchDataOne(board_number);		
		Board_reVO rvo = new Board_reVO();
		ArrayList<Board_reVO> rvoList = new ArrayList<Board_reVO>();
		rvoList = rService.commentSerchDatAll(bvo);
		model.addAttribute("bvo",bvo);
		model.addAttribute("rvoList",rvoList);
		
		return "boardSelectOne";
	}

	@RequestMapping(value = "boardUpdate", method = RequestMethod.GET)
	public String boardUpdate(BoardVO bvo,HttpServletRequest req, Model model)
	{

		bService.boardUpdate(bvo);

		boardpagingOnly(req,model);

		return "boardList";
	}

	@RequestMapping(value = "boardDelete", method = RequestMethod.GET)
	public String boardDelete(BoardVO bvo,HttpServletRequest req, Model model)
	{

		bService.boardDelete(bvo);

		boardpagingOnly(req,model);

		return "boardList";
	}
	@RequestMapping(value = "commentDelete", method = RequestMethod.GET)
	public String commentDelete(Board_reVO rvo,HttpServletRequest req, Model model)
	{
		String[] comment = req.getParameterValues("checkbox");
		for (int i = 0; i < comment.length; i++) {
			rvo.setBoard_re(Integer.parseInt(comment[i]));
			rService.commentDelete(rvo);
		}

		boardpagingOnly(req,model);

		return "boardList";
	}
	public void boardpagingOnly(HttpServletRequest req, Model model) {

		String cstr = req.getParameter("Cpage")==null?"1":req.getParameter("Cpage");
		int Cpage = Integer.parseInt(cstr);
		String keyWord = req.getParameter("keyWord");
		String searchOption = req.getParameter("searchOption");
		PageClass pc = new PageClass(searchOption,keyWord);
		int count = bService.boardTotalCount(pc);
		pc = new PageClass(count,Integer.parseInt(cstr),searchOption,keyWord);
		ArrayList<BoardVO> boardList =bService.boardOnePageInfo(pc);
		model.addAttribute("boardList",boardList);
		model.addAttribute("pc",pc);
	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(@RequestParam("name") String fileName)throws Exception{
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		//logger.info("FILE NAME : " + fileName);
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath+"/"+fileName);
			
			//step: change HttpHeader ContentType
			if(mType != null) {
				//image file(show image)
				headers.setContentType(mType);
			}else {
				//another format file(download file)
				fileName = fileName.substring(fileName.indexOf("_")+1);//original file Name
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\""); 
			}
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
			return entity;
		
	}


}
