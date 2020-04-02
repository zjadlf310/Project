package com.kgitbank.board_re.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kgitbank.board_re.vodao.Board_reDAO;
import com.kgitbank.board_re.vodao.Board_reVO;

@Service("Board_reService")
public class Board_reServiceImpl implements Board_reService{
	
	@Resource(name="Board_reDAO")
	private Board_reDAO board_reDAO;

	@Override
	public boolean Board_reWrite(Board_reVO rvo) throws SQLException {
		// TODO Auto-generated method stub
		return board_reDAO.Board_reWrite(rvo);
	}

	@Override
	public boolean Board_re_dabWrite(Board_reVO rvo) throws SQLException {
		// TODO Auto-generated method stub
		return board_reDAO.Board_re_dabWrite(rvo);
	}

	@Override
	public boolean Board_reDelete(Board_reVO rvo) throws SQLException {
		// TODO Auto-generated method stub
		return board_reDAO.Board_reDelete(rvo);
	}

	@Override
	public boolean Board_reUpdate(Board_reVO rvo) throws SQLException {
		// TODO Auto-generated method stub
		return board_reDAO.Board_reUpdate(rvo);
	}

	@Override
	public ArrayList<Board_reVO> Board_reList(Board_reVO rvo) throws SQLException {
		// TODO Auto-generated method stub
		return board_reDAO.Board_reList(rvo);
	}

	@Override
	public Board_reVO Board_redata(Board_reVO rvo) throws SQLException {
		// TODO Auto-generated method stub
		return board_reDAO.Board_redata(rvo);
	}



}
