package com.admin.comment.Service;

import java.util.ArrayList;

import com.admin.board.DAOVO.BoardVO;
import com.admin.comment.DAOVO.Board_reVO;

public interface Board_reService {

	public int commentDelete(Board_reVO rvo);
	
	public ArrayList<Board_reVO> commentSerchDatAll(BoardVO bvo);
	
}
