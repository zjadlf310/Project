package com.admin.board.DAOVO;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.admin.client.page.PageClass;

@Repository
public class BoardDAO {
	private static SqlSessionFactory	sqlSessionFactory1;	
	static {
		String myxml="Mybatis-config.xml";
		InputStream istream=null;

		try {
			istream = Resources.getResourceAsStream(myxml);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(istream);
	}

	//게시글 숫자 체크
	public static int boardTotalCount(){
		return (Integer)sqlSessionFactory1.openSession().selectOne("boardTotalCount");
	}
	//게시글 숫자 체크(Keyword,option포함, 없을시 null)
	public static int boardTotalCount(PageClass pc){
		return (Integer)sqlSessionFactory1.openSession().selectOne("boardTotalCount",pc);
	}
	//한 페이지 들어갈 게시글 정보 list(Keyword,option포함, 없을시 null)
	public static ArrayList<BoardVO> boardOnePageInfo(PageClass pc){
		return (ArrayList<BoardVO>) sqlSessionFactory1.openSession().selectList("boardOnePageInfo",pc);
	}
	//게시글 하나 확인
	public static BoardVO boardSerchDataOne(int board_number){
		return (BoardVO)sqlSessionFactory1.openSession().selectOne("boardSerchDataOne",board_number);
	}
	//게시글 쓰기
	public static int BoardWrite(BoardVO bvo) {
		SqlSession session = sqlSessionFactory1.openSession();
		int r = session.insert("boardinsert",bvo);
		session.commit();
		return r;
	}
	//게시글 지우기
	public static int BoardDelete(BoardVO bvo) {
		SqlSession session = sqlSessionFactory1.openSession();
		int r = session.delete("boardDelete",bvo);
		session.commit();
		return r;
	}
	//게시글 수정
	public static int BoardUpdate(BoardVO bvo) {
		SqlSession session = sqlSessionFactory1.openSession();
		int r = session.update("boardUpdate",bvo);
		session.commit();
		return r;
	}


}
