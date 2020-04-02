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
	//ȸ������ �ϳ� Ȯ��
	public static ClientVO clientSerchDataOne(String id){
		return (ClientVO)sqlSessionFactory1.openSession().selectOne("clientSerchDataOne",id);
	}
	//�α��� �޼ҵ�
	public static ClientVO adminLogin(){
		return (ClientVO)sqlSessionFactory1.openSession().selectOne("adminLogin");
	}
	//�ʿ����
	public static ArrayList<ClientVO> clientSerchDatAll(){
		return (ArrayList<ClientVO>) sqlSessionFactory1.openSession().selectList("clientSerchDatAll");
	}
	//ȸ�� ���� üũ
	public static int clientTotalCount(){
		return (Integer)sqlSessionFactory1.openSession().selectOne("clientTotalCount");
	}
	//ȸ�� ���� üũ(Keyword,option����, ������ null)
	public static int clientTotalCount(PageClass pc){
		return (Integer)sqlSessionFactory1.openSession().selectOne("clientTotalCount",pc);
	}
	//�� ������ �� ȸ�� ���� list(Keyword,option����, ������ null)
	public static ArrayList<ClientVO> clientOnePageInfo(PageClass pc){
		return (ArrayList<ClientVO>) sqlSessionFactory1.openSession().selectList("clientOnePageInfo",pc);
	}
	//ȸ�� ���� ����
	public static int clientDelete(ClientVO cvo){
		SqlSession session = sqlSessionFactory1.openSession();
		int r = session.delete("clientDelete",cvo);
		session.commit();
		return r;
	}
	//ȸ�� ���� ����
	public static int clientUpdate(ClientVO cvo){
		SqlSession session = sqlSessionFactory1.openSession();
		int r = session.update("clientUpdate",cvo);
		session.commit();
		return r;
	}

	//���̵����� ����
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
