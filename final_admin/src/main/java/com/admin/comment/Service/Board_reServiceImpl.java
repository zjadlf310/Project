package com.admin.comment.Service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.admin.board.DAOVO.BoardVO;
import com.admin.comment.DAOVO.Board_reDAO;
import com.admin.comment.DAOVO.Board_reVO;

@Service("Board_reService")
public class Board_reServiceImpl implements Board_reService{
	
	@Resource(name="Board_reDAO")
	private Board_reDAO board_reDAO;

	@Override
	public int commentDelete(Board_reVO rvo) {
		
		return board_reDAO.commentDelete(rvo);
	}

	@Override
	public ArrayList<Board_reVO> commentSerchDatAll(BoardVO bvo) {
		
		return board_reDAO.commentSerchDatAll(bvo);
	}


}
