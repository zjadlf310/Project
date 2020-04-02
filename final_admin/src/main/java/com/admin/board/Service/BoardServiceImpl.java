package com.admin.board.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.board.DAOVO.BoardDAO;
import com.admin.board.DAOVO.BoardVO;
import com.admin.client.page.PageClass;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO bdao;
	
	public int BoardWrite(BoardVO bvo)
	{
		
		return bdao.BoardWrite(bvo);
		
	}

	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		
		return null;
	}

	@Override
	public int boardDelete(BoardVO bvo) {
		
		return bdao.BoardDelete(bvo);
	}

	@Override
	public int boardInsert200(BoardVO bvo) {
		
		return 0;
	}

	@Override
	public BoardVO boardSerchDataOne(int board_number) {
		
		return bdao.boardSerchDataOne(board_number);
	}

	@Override
	public int boardTotalCount() {
		
		return bdao.boardTotalCount();
	}

	@Override
	public int boardTotalCount(PageClass pc) {
		
		return bdao.boardTotalCount(pc);
	}

	@Override
	public ArrayList<BoardVO> boardOnePageInfo(PageClass pc) {
		
		return bdao.boardOnePageInfo(pc);
	}

	@Override
	public int boardUpdate(BoardVO bvo) {
		
		return bdao.BoardUpdate(bvo);
	}
}
