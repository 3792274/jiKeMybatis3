package jike.book.test;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jike.book.pojo.JikeUser;
import mybatis3.helper.SqlSessionHelper;

/**
 * 测试查询
 * @author Mr.TianShu
 */
public class TestSelect {

	
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
	
	 
	

	
	
	//测试简单查询  ,通过hashmap传递参数   ' or 1=1#
	@Test
	public void testLonginSelect(){
		HashMap<String, String> hMap=new HashMap<>();
		hMap.put("username", "极客学院");
		hMap.put("password", "123456789");
		
		JikeUser jikeUser = sqlSession.selectOne("loginSelect",hMap);
		
		System.err.println(jikeUser.getId());
		sqlSession.commit();
	}
	
	

	
	//测试简单查询-通过对象属性传递参数     
	@Test
	public void testLongin2(){
		JikeUser jikeUser = new JikeUser();
		jikeUser.setUsername("极客学院");
		jikeUser.setPassword("123456789");
		
		jikeUser = sqlSession.selectOne("login2",jikeUser);
		
		System.err.println(jikeUser.getId());
		sqlSession.commit();
	}
	
	
	
 
	
	//测试简单查询-查询所有记录集合List
	@Test
	public void getAllJiKeUserList(){
		List<JikeUser> jikeUserList=  sqlSession.selectList("selectJiKeUserList");
		for (JikeUser jikeUser : jikeUserList) {
			System.out.println("用户名称： "+jikeUser.getUsername());
		}
		sqlSession.commit();
	}
	
	
	
	
	// resultMap 解决复杂映射查询时的映射问题  
	@Test
	public void selectUsersUseResultMap(){
		List<JikeUser> jikeUserList=  sqlSession.selectList("selectUsersUseResultMap");
		for (JikeUser jikeUser : jikeUserList) {
			System.out.println("用户名称： "+jikeUser.getUsername());
		}
		sqlSession.commit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@After
	public void closeSqlSession(){
		if(null!=sqlSession)
			sqlSession.close();
	}



}
