package jike.book.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jike.book.pojo.Author;
import jike.book.pojo.JikeUser;

/**
 * 测试 Mybaties中事务。
 * @author Mr.TianShu
 *
 */
public class TestTransaction {
	
	SqlSession sqlSession = null;
	
	 
	@Before
	public void initSqlSession(){
		try {
			String resource ="mybatis-config.xml";
			Reader  reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession(false);  //打开连接传递一个false,关闭自动提交,默认false
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 
	

	
	
	//测试  MyBaties transaction
	@Test
	public void testLonginSelect(){ 
		
		try {
			JikeUser author001  = new JikeUser();
			author001.setUsername("author001");
			author001.setPassword("123456");
			
			sqlSession.insert("insertUser",author001);
			System.out.println("新加入的jiKeUser ID: "+ author001.getId());  //保存一个对象以后，mybaties会自动返回封装后 的对象。
			
			Author at = new Author();
			at.setJikeUser(author001);
			at.setRealname("一个大牛");
			
			sqlSession.insert("insertAuthor",at);
			sqlSession.commit();
			
			
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			
		} finally {
			closeSqlSession();
		}
		
	}
	
	
	
	
	
	
	@After
	public void closeSqlSession(){
		if(null!=sqlSession)
			sqlSession.close();
	}

}
