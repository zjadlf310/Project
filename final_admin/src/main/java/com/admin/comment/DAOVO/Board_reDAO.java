package com.admin.comment.DAOVO;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.admin.board.DAOVO.BoardVO;
import com.admin.client.DAOVO.ClientVO;

@Repository("Board_reDAO")
public class Board_reDAO {
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
	//코멘트 삭제
	public static int commentDelete(Board_reVO rvo){
		SqlSession session = sqlSessionFactory1.openSession();
		int r = session.delete("commentDelete",rvo);
		session.commit();
		return r;
	}
	//코멘트 모두 가져오기
	public static ArrayList<Board_reVO> commentSerchDatAll(BoardVO bvo){
		return (ArrayList<Board_reVO>) sqlSessionFactory1.openSession().selectList("commentSerchDatAll",bvo);
	}
}
