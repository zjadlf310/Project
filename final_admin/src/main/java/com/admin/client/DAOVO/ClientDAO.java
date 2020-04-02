package com.admin.client.DAOVO;

/*import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;*/

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.admin.client.page.PageClass;

@Repository
public class ClientDAO {
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
	//회원정보 하나 확인
	public static ClientVO clientSerchDataOne(String id){
		return (ClientVO)sqlSessionFactory1.openSession().selectOne("clientSerchDataOne",id);
	}
	//로그인 메소드
	public static ClientVO adminLogin(){
		return (ClientVO)sqlSessionFactory1.openSession().selectOne("adminLogin");
	}
	//필요없음
	public static ArrayList<ClientVO> clientSerchDatAll(){
		return (ArrayList<ClientVO>) sqlSessionFactory1.openSession().selectList("clientSerchDatAll");
	}
	//회원 숫자 체크
	public static int clientTotalCount(){
		return (Integer)sqlSessionFactory1.openSession().selectOne("clientTotalCount");
	}
	//회원 숫자 체크(Keyword,option포함, 없을시 null)
	public static int clientTotalCount(PageClass pc){
		return (Integer)sqlSessionFactory1.openSession().selectOne("clientTotalCount",pc);
	}
	//한 페이지 들어갈 회원 정보 list(Keyword,option포함, 없을시 null)
	public static ArrayList<ClientVO> clientOnePageInfo(PageClass pc){
		return (ArrayList<ClientVO>) sqlSessionFactory1.openSession().selectList("clientOnePageInfo",pc);
	}
	//회원 정보 삭제
	public static int clientDelete(ClientVO cvo){
		SqlSession session = sqlSessionFactory1.openSession();
		int r = session.delete("clientDelete",cvo);
		session.commit();
		return r;
	}
	//회원 정보 수정
	public static int clientUpdate(ClientVO cvo){
		SqlSession session = sqlSessionFactory1.openSession();
		int r = session.update("clientUpdate",cvo);
		session.commit();
		return r;
	}

	//더미데이터 삽입
	public static int clientInsert200(ClientVO cvo){
		SqlSession session = sqlSessionFactory1.openSession();
		int r ;
		for (int i = 27; i <= 200; i++) {
			cvo.setId("dummy"+i);
			cvo.setPw("1234");
			cvo.setName("dummy"+i);
			cvo.setTel("dummy"+i);
			cvo.setMail("dummy"+i);
			session.insert("clientInsert", cvo);
			session.commit();
		}

		return 0;
	}
}
