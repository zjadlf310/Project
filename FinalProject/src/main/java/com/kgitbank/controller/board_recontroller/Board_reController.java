package com.kgitbank.controller.board_recontroller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kgitbank.board_re.service.Board_reServiceImpl;
import com.kgitbank.board_re.vodao.Board_reVO;

@Controller
public class Board_reController {
	
	@Resource(name="Board_reService")
	private Board_reServiceImpl Board_reService;
	
	//하나의 게시물에 대한 댓글&답글
	@RequestMapping(value = "/Board_reList", method = RequestMethod.GET)
	public String Board_reList(Board_reVO rvo, Model model) throws SQLException, ParseException {
		ArrayList<Board_reVO> rvo1= Board_reService.Board_reList(rvo);
		model.addAttribute("board_relist",rvo1);
		
		return "hihi";
	}
	
	//하나의 댓글&답글
	@RequestMapping(value = "/redata", method = RequestMethod.POST)
	public String Board_re_Data(Board_reVO rvo, Model model) throws SQLException, ParseException {
		Board_reVO rvo1= Board_reService.Board_redata(rvo);
		model.addAttribute("board_redata",rvo1);
		model.addAttribute("rvo", rvo);
		
		return "hihi";
	}
	
	
	@RequestMapping(value = "/Board_reWrite", method = RequestMethod.POST)
	public String Board_reWrite(Board_reVO rvo, Model model) throws SQLException, UnsupportedEncodingException {
		/*rvo.setCharacterEncoding("UTF-8");*/
		/*ModelAndView mav=new ModelAndView();*/
		
		String username = System.getProperty("user.name");
		String uploadPath="c:/Users/"+username+"/Downloads/";
		
		File dir=new File(uploadPath);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		
		MultipartFile mFile= rvo.getFile1();
		String originalFileName = mFile.getOriginalFilename();
		String saveFileName=originalFileName;
		
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
			rvo.setFilename(saveFileName);
			rvo.setOri_filename(originalFileName);
			
		
		} //if-end 파일저장 끝  성공적으로 마치면 isSuccess가 true인 상태
		else {
			model.addAttribute("error1", "댓글의 파일은 업로드 하지 않으셨습니다.");
		}
		
		if(Board_reService.Board_reWrite(rvo)) {
			model.addAttribute("board_relist", Board_reService.Board_reList(rvo));
			return "home";//댓글 작성하려던 게시물로 이동
		}else {
			model.addAttribute("error", "댓글 작성에 실패하였습니다.");
			model.addAttribute("board_relist", Board_reService.Board_reList(rvo));
			return "home";//댓글 작성하려던 게시물로 이동
		}
	
	}
	
	@RequestMapping(value = "/Board_re_dabWrite", method = RequestMethod.POST)
	public String Board_re_dabWrite(Board_reVO rvo, Model model) throws SQLException {

		String username = System.getProperty("user.name");
		String uploadPath="c:/Users/"+username+"/Downloads/";
		
		File dir=new File(uploadPath);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		
		MultipartFile mFile= rvo.getFile1();
		
		String originalFileName = mFile.getOriginalFilename();
		String saveFileName=originalFileName;
		
		
		if (saveFileName != null && !saveFileName.equals("")) {
			if (new File(uploadPath+saveFileName).exists()) {
				saveFileName =saveFileName +"_"+System.currentTimeMillis();
				//파일이름이 같은 파일이 존재할 경우
			
			}
			try {
				mFile.transferTo(new File(uploadPath + saveFileName));
		
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rvo.setFilename(saveFileName);
			rvo.setOri_filename(originalFileName);
			
		
		} //if-end 파일저장 끝  성공적으로 마치면 isSuccess가 true인 상태
		else {
			model.addAttribute("error1", "댓글의 파일은 업로드 하지 않으셨습니다.");
		}
		
		if(Board_reService.Board_re_dabWrite(rvo)) {
			model.addAttribute("board_relist", Board_reService.Board_reList(rvo));
			return "home";	//답글 작성하려던 게시물로 이동
		}else {
			model.addAttribute("board_relist", Board_reService.Board_reList(rvo));
			return "home";  //답글 작성하려던 게시물로 이동
		}
	}
	
	@RequestMapping(value = "/Board_reUpdate", method = RequestMethod.GET)
	public String Board_reUpdate(Board_reVO rvo, Model model) throws SQLException {
		
		String username = System.getProperty("user.name");
		String uploadPath="c:/Users/"+username+"/Downloads/";
		
		File dir=new File(uploadPath);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		
		MultipartFile mFile= rvo.getFile1();
		
		String originalFileName = mFile.getOriginalFilename();
		String saveFileName=originalFileName;
		
		
		if (saveFileName != null && !saveFileName.equals("")) {
			if (new File(uploadPath+saveFileName).exists()) {
				saveFileName =saveFileName +"_"+System.currentTimeMillis();
				//파일이름이 같은 파일이 존재할 경우
			
			}
			try {
				mFile.transferTo(new File(uploadPath + saveFileName));
		
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rvo.setFilename(saveFileName);
			rvo.setOri_filename(originalFileName);
			
		
		} //if-end 파일저장 끝  성공적으로 마치면 isSuccess가 true인 상태
		else {
			model.addAttribute("error1", "댓글의 파일은 업로드 하지 않으셨습니다.");
		}
		
		
		if(Board_reService.Board_reUpdate(rvo)) {
			return "hihi"; 
		}else {
			return "hihi";
		}
	}
	
	@RequestMapping(value = "/Board_reDelete", method = RequestMethod.GET)
	public String Board_reDelete(Board_reVO rvo, Model model) throws SQLException {
		
		if(Board_reService.Board_reDelete(rvo)) {
			return "home";
		}else {
			return "home";
		}
	}
	

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(@RequestParam("name") String fileName)throws Exception{
		
		String username = System.getProperty("user.name");
		String uploadPath="c:/Users/"+username+"/Downloads/";
		
		
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
	
	//파일 업로드 확장자 받기용
	public static class MediaUtils {
		private static Map<String, MediaType> mediaMap;
		static {		// 초기화 블록
			mediaMap = new HashMap<String, MediaType>();
			mediaMap.put("jpg", MediaType.IMAGE_JPEG);
			mediaMap.put("gif", MediaType.IMAGE_GIF);
			mediaMap.put("png", MediaType.IMAGE_PNG);
		}
		
		public static MediaType getMediaType(String type) {
			return mediaMap.get(type);
		}
	}

	

	
	
}
