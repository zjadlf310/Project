package com.kgitbank.front.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgitbank.front.vodao.FrontDAO;
import com.kgitbank.front.vodao.FrontVO;
@Service("frontService")
public class FrontServiceImpl implements FrontService {
	@Autowired
	private FrontDAO frontDAO;
	
	@Override
	public ArrayList<String> APIRoadKind(FrontVO vo) throws IOException, ParseException {
		// TODO Auto-generated method stub
		return frontDAO.APIRoadKind(vo);
	}

	@Override
	public ArrayList<String> APIRoadName(FrontVO vo) throws IOException, ParseException {
		// TODO Auto-generated method stub
		return frontDAO.APIRoadName(vo);
	}

	@Override
	public ArrayList<String> APIRestName(FrontVO vo) throws IOException, ParseException {
		// TODO Auto-generated method stub
		return frontDAO.APIRestName(vo);
	}

	@Override
	public ArrayList<FrontVO> APIList(FrontVO vo) throws IOException, ParseException {
		// TODO Auto-generated method stub
		return frontDAO.APIList(vo);
	}
	
	@Override
	public boolean QA(FrontVO vo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return frontDAO.QA(vo);
	}
	
}
