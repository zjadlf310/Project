package com.kgitbank.board_re.service;

import java.sql.SQLException;

import java.util.ArrayList;

import com.kgitbank.board_re.vodao.Board_reVO;

public interface Board_reService {
	public boolean Board_reWrite(Board_reVO rvo) throws SQLException;
	
	public boolean Board_re_dabWrite(Board_reVO rvo) throws SQLException;
	
	public boolean Board_reDelete(Board_reVO rvo) throws SQLException;
		
	public boolean Board_reUpdate(Board_reVO rvo) throws SQLException;
	
	public ArrayList<Board_reVO> Board_reList(Board_reVO rvo) throws SQLException;
	
	public Board_reVO Board_redata(Board_reVO rvo) throws SQLException;
}
