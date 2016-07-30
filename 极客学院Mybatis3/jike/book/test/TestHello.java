package jike.book.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jike.book.pojo.JikeUser;

public class TestHello {

	public static void main(String[] args) throws IOException {
		
		String resource ="mybatis-config.xml";
		Reader  reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();
		JikeUser jikeuser = session.selectOne("findById", 1);
		System.out.println(jikeuser.getUsername());
		session.close();
	}

}
