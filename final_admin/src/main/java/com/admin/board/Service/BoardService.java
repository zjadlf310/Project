package com.admin.board.Service;

import java.util.ArrayList;

import com.admin.board.DAOVO.BoardVO;
import com.admin.client.page.PageClass;

public interface BoardService {

	public ArrayList<BoardVO> boardSelectAll();
	
	public int boardDelete(BoardVO bvo);
	
	public int boardInsert200(BoardVO bvo);
	
	public BoardVO boardSerchDataOne(int board_number);
	
	public int boardTotalCount();
	
	public int boardTotalCount(PageClass pc);
	
	public ArrayList<BoardVO> boardOnePageInfo(PageClass pc);
	
	public int boardUpdate (BoardVO bvo);
}
