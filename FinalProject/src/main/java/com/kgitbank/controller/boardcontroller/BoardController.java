package com.kgitbank.controller.boardcontroller;

import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kgitbank.board.service.BoardServiceImpl;
import com.kgitbank.board.vodao.BoardVO;

@Controller
public class BoardController {
	@Resource(name="boardService")
	private BoardServiceImpl boardService;
	
	@RequestMapping(value = "/getBoard_Write", method = RequestMethod.GET)
	public String BoardWrite(BoardVO vo, Model model) throws SQLException, ParseException {
		if(vo.getFile()!=null) {
			String username = System.getProperty("user.name");
			String uploadPath="c:/Users/"+username+"/Downloads/";
			
			File dir=new File(uploadPath);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}
			
			MultipartFile mFile= vo.getFile();
			String saveFileName=mFile.getOriginalFilename();
			
		/*	rvo.setFilename(saveFileName);
			rvo.setOri_filename(originalFileName);
			*/
			if (saveFileName != null && !saveFileName.equals("")) {
				if (new File(uploadPath+saveFileName).exists()) {
					saveFileName =saveFileName +"_"+System.currentTimeMillis();
					//파일이름이 같은 파일이 존재할 경우
				}
				try {
					mFile.transferTo(new File(uploadPath + saveFileName));
				
				}catch(Exception e) {
					e.printStackTrace();
				}
				vo.setFilename(saveFileName);
			}
		}
		if(boardService.BoardWrite(vo)) {
			model.addAttribute("boardWrite", "error");
			model.addAttribute("board_list", boardService.BoardList());
			
			return "Board_List";
		}else {
			model.addAttribute("WriteError", "error");
			model.addAttribute("board_list", boardService.BoardList());
			return "Board_List";
		}
	}
	
	@RequestMapping(value = "/Board_Delete", method = RequestMethod.GET)
	public String BoardDelete(BoardVO vo, Model model) throws SQLException {
		
		if(boardService.BoardDelete(vo)) {
			model.addAttribute("boardDelete", "error");
			return "Main";
		}else {
			model.addAttribute("DeleteError", "error");
			return "Main";
		}
	}
	
	@RequestMapping(value = "/Board_Update", method = RequestMethod.GET)
	public String BoardUpdate(BoardVO vo, Model model) throws SQLException, ParseException {
		
		if(boardService.Filename(vo)==null) {
			String username = System.getProperty("user.name");
			String uploadPath="c:/Users/"+username+"/Downloads/";
			
			File dir=new File(uploadPath);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}
			
			MultipartFile mFile= vo.getFile();
			String saveFileName=mFile.getOriginalFilename();
			
			if (saveFileName != null && !saveFileName.equals("")) {
				if (new File(uploadPath+saveFileName).exists()) {
					saveFileName =saveFileName +"_"+System.currentTimeMillis();
					//파일이름이 같은 파일이 존재할 경우
				}
				try {
					mFile.transferTo(new File(uploadPath + saveFileName));
				
				}catch(Exception e) {
					e.printStackTrace();
				}
				vo.setFilename(saveFileName);
				
			
			} else {
				model.addAttribute("error1", "댓글의 파일은 업로드 하지 않으셨습니다.");
			}
		}
		
		if(boardService.BoardUpdate(vo)) {
			model.addAttribute("boardUpdate", "error");
			model.addAttribute("board_list", boardService.BoardList());
			return "Board_List";
		}else {
			model.addAttribute("UpdateError", "error");
			model.addAttribute("board_list", boardService.BoardList());
			return "Board_List";
		}
	}
	
	@RequestMapping(value = "/Board_View_cnt", method = RequestMethod.GET)
	public String BoardView_cnt(BoardVO vo, Model model) throws SQLException {
		if(boardService.BoardView_cnt(vo)) {
			return "home";
		}else {
			return "home";
		}
	}
	
	
	@RequestMapping(value = "/Board_List", method = RequestMethod.GET)
	public String BoardList(HttpServletRequest req, Model model) throws SQLException, ParseException {
		
		model.addAttribute("board_list", boardService.BoardList());
		
		return "Board_List";
	}
	
	@RequestMapping(value = "/Board_Search", method = RequestMethod.GET)
	public String BoardSearch_Category(BoardVO vo, Model model,HttpServletRequest req) throws SQLException, ParseException {
		if(req.getAttribute("option").equals("category")) {
			
			model.addAttribute("board_search_category", boardService.BoardSearch_Category(vo));
			return "Board_List";
		
		}else if(req.getAttribute("option").equals("title")) {
			
			model.addAttribute("board_list", boardService.BoardSearch_title(vo));
			return "Board_List";
			
		}else if(req.getAttribute("option").equals("writer")) {
		
			model.addAttribute("board_list", boardService.BoardSearch_writer(vo));
			return "Board_List";
		
		}else {
			model.addAttribute("SearchError", 101);
			model.addAttribute("board_list", boardService.BoardList());
			return "Board_List";
		}
		
	}
	
	@RequestMapping(value = "/Board_like", method = RequestMethod.GET)
	public String like(HttpServletRequest req, Model model) throws SQLException, ParseException {
		
		model.addAttribute("board_list", boardService.BoardList());
		
		return "Like";
	}
	
	@RequestMapping(value = "/Board_View", method = RequestMethod.GET)
	public String Board_View(BoardVO vo, Model model) throws SQLException, ParseException {
		
		if(boardService.BoardView_cnt(vo)) {
			model.addAttribute("board_data", boardService.Board_View(vo));
			return "Board_View";
		}else {
			model.addAttribute("viewError", 101);
			model.addAttribute("board_list", boardService.BoardList());
			return "Board_List";
		}
		
	}
	
	@RequestMapping(value = "/Board_Change", method = RequestMethod.GET)
	public String Board_Change(BoardVO vo, Model model) throws SQLException, ParseException {
		
		model.addAttribute("board_data", boardService.Board_View(vo));
		
		return "Board_Change";
		
		
	}
	
	@RequestMapping(value = "/MyBoard", method = RequestMethod.GET)
	public String MyList(@ModelAttribute BoardVO vo, Model model) throws SQLException, ParseException {
		
		model.addAttribute("My_list", boardService.MyList(vo));
		
		return "MyBoard";
	}
	
}
