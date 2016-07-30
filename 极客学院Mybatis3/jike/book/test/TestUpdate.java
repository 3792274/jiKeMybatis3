package jike.book.test;

import java.io.Reader;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jike.book.map.JikeUserMapperInterface;
import jike.book.pojo.JikeUser;


/**
 * 增加、删除、修改 测试
 * @author Mr.TianShu
 *
 */
public class TestUpdate {
	
	 SqlSession sqlSession = null;
	
	 
	@Before
	public void initSqlSession(){
		try {
			String resource ="mybatis-config.xml";
			Reader  reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	//测试添加
	@Test
	public void testInsert(){
		  JikeUser jikeUser = new JikeUser();
		  jikeUser.setUsername("极客学院");
		  jikeUser.setPassword("000000");
		  
		  sqlSession.insert("insertUser",jikeUser );
		  sqlSession.commit();
	}
	
	
	
	//测试修改
	@Test
	public void testUpdate(){
		  JikeUser jikeUser = new JikeUser();
		  jikeUser.setUsername("极客学院");
		  jikeUser.setPassword("666666");
		  jikeUser.setId(1);
		  
		  sqlSession.insert("updateUser",jikeUser );
		  sqlSession.commit();
	}
	
	
	
	//测试删除
	@Test
	public void testDelete(){
		JikeUserMapperInterface jikeUserMapperInterface = sqlSession.getMapper(JikeUserMapperInterface.class);
		int i = jikeUserMapperInterface.deleteUser(3);
		System.err.println("成功删除   "+i+"  条记录");
		sqlSession.commit();
	}
	

	
	
	
	
	
	
	
	
	@After
	public void closeSqlSession(){
		if(null!=sqlSession)
			sqlSession.close();
	}

}




































