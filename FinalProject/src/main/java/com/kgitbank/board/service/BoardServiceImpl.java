package com.kgitbank.board.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kgitbank.board.vodao.BoardDAO;
import com.kgitbank.board.vodao.BoardVO;
@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;

	@Override
	public boolean BoardWrite(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return boardDAO.BoardWrite(vo);
	}

	@Override
	public boolean BoardDelete(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return boardDAO.BoardDelete(vo);
	}

	@Override
	public boolean BoardView_cnt(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return boardDAO.BoardView_cnt(vo);
	}

	@Override
	public ArrayList<BoardVO> BoardList() throws SQLException, ParseException {
		// TODO Auto-generated method stub
		return boardDAO.BoardList();
	}

	@Override
	public ArrayList<BoardVO> BoardSearch_Category(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return boardDAO.BoardSearch_Category(vo);
	}

	@Override
	public ArrayList<BoardVO> BoardSearch_title(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return boardDAO.BoardSearch_title(vo);
	}

	@Override
	public ArrayList<BoardVO> BoardSearch_writer(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return boardDAO.BoardSearch_writer(vo);
	}

	@Override
	public boolean BoardUpdate(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return boardDAO.BoardUpdate(vo);
	}

	@Override
	public String Filename(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return boardDAO.BoardFilename(vo);
	}

	@Override
	public ArrayList<BoardVO> MyList(BoardVO vo) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		return boardDAO.MyList(vo);
	}

	@Override
	public BoardVO Board_View(BoardVO vo) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		return boardDAO.Board_View(vo);
	}
}
