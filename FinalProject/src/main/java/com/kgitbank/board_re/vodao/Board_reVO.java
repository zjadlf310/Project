package com.kgitbank.board_re.vodao;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;



public class Board_reVO {
	
	private int board_num;    
	private int board_re; //0
    private int board_re_dab;//0
    private String text;	//내용
    private String re_writer;	//글쓴이
    private Date re_date;	//날짜값
    private String filename; //저장 파일이름
    private String ori_filename; //원래 파일 이름
    
    private MultipartFile file1; 
    
    
    public Board_reVO(){
   /* 	super();*/
    }
  /*  public Board_reVO(int board_num, int board_re, int board_re_dab, String text, String re_writer,Date re_date,String filename, String o_filename  ,MultipartFile file1 ){
    	this.board_num=board_num;
    	this.board_re=board_re;
    	this.board_re_dab=board_re_dab;
    	this.text=text;
    	this.re_writer=re_writer;
    	this.re_date=re_date;
    	this.filename=filename;
    	this.o_filename=o_filename;
    	this.file1=file1;
    }*/
    
    public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public int getBoard_re() {
		return board_re;
	}
	public void setBoard_re(int board_re) {
		this.board_re = board_re;
	}
	public int getBoard_re_dab() {
		return board_re_dab;
	}
	public void setBoard_re_dab(int board_re_dab) {
		this.board_re_dab = board_re_dab;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getRe_writer() {
		return re_writer;
	}
	public void setRe_writer(String re_writer) {
		this.re_writer = re_writer;
	}
	public Date getRe_date() {
		return re_date;
	}
	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public String getOri_filename() {
		return ori_filename;
	}
	public void setOri_filename(String ori_filename) {
		this.ori_filename = ori_filename;
	}

}
