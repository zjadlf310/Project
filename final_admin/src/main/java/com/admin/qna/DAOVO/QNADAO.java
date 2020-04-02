package com.admin.qna.DAOVO;

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
public class QNADAO {
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
	//�Խñ� ���� üũ
	public static int QNATotalCount(){
		return (Integer)sqlSessionFactory1.openSession().selectOne("QNATotalCount");
	}
	//�Խñ� ���� üũ(Keyword,option����, ������ null)
	public static int QNATotalCount(PageClass pc){
		return (Integer)sqlSessionFactory1.openSession().selectOne("QNATotalCount",pc);
	}
	//�� ������ �� �Խñ� ���� list(Keyword,option����, ������ null)
	public static ArrayList<QNAVO> QNAOnePageInfo(PageClass pc){
		return (ArrayList<QNAVO>) sqlSessionFactory1.openSession().selectList("QNAOnePageInfo",pc);
	}
	//�Խñ� �ϳ� Ȯ��
	public static QNAVO QNASerchDataOne(int num){
		return (QNAVO)sqlSessionFactory1.openSession().selectOne("QNASerchDataOne",num);
	}
	
	//�Խñ� �����
	public static int QNADelete(QNAVO bvo) {
		SqlSession session = sqlSessionFactory1.openSession();
		int r = session.delete("QNADelete",bvo);
		session.commit();
		return r;
	}
}
