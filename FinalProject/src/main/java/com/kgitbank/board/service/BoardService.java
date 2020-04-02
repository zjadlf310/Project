package com.kgitbank.board.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.kgitbank.board.vodao.BoardVO;

public interface BoardService {
	
	public boolean BoardWrite(BoardVO vo) throws SQLException;
	
	public boolean BoardDelete(BoardVO vo) throws SQLException;
	
	public boolean BoardUpdate(BoardVO vo) throws SQLException;
	
	public boolean BoardView_cnt(BoardVO vo) throws SQLException;
	
	public ArrayList<BoardVO> BoardList() throws SQLException, ParseException;
	
	public ArrayList<BoardVO> BoardSearch_Category(BoardVO vo) throws SQLException;
	
	public ArrayList<BoardVO> BoardSearch_title(BoardVO vo) throws SQLException;
	
	public ArrayList<BoardVO> BoardSearch_writer(BoardVO vo) throws SQLException;
	
	public String Filename(BoardVO vo) throws SQLException;
	
	public ArrayList<BoardVO> MyList(BoardVO vo) throws SQLException, ParseException;
	
	public BoardVO Board_View(BoardVO vo) throws SQLException, ParseException;
}
