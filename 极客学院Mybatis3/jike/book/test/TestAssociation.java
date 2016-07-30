package jike.book.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import jike.book.pojo.Author;
import mybatis3.helper.SqlSessionHelper;

/**
 * Author类中有JiKeUser对象，关联查询(映射查询，子查询)，映射器XML中配置的Author属性  JiKeUser  
 * 使用到了 SqlSessionHelper，防止在多线程情况下意外。。
 * @author Mr.TianShu
 *
 */
public class TestAssociation {

	
	//测试 联合查询-映射查询(修改映射器XML文件，可以使用2种方法定义的映射器，全属性映射，构造函数映射)
	@Test
	public void testSelectAuthorJoin(){ 
		
		SqlSession sqlSession =SqlSessionHelper.getSqlSession() ;
		
		try {
			
			List<Author> authors = sqlSession.selectList("selectAuthorJoin");  //可以使用2种方法定义的映射器，全属性映射，构造函数映射
			
			for (Author author : authors) {
				System.out.println("作者真实姓名： "+author.getRealname()+",  对应的用户名： "+author.getJikeUser().getUsername());
			}
			
			SqlSessionHelper.commit();

		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			
		} finally {
			SqlSessionHelper.close();
		}
		
	}
	
	
	
	
	
	//测试联合查询中-子查询使用  n+1条语句    selectAuthorJoinUseSubSelect
	@Test
	public void testSelectAuthorJoinUseSubSelect(){ 
		
		SqlSession sqlSession =SqlSessionHelper.getSqlSession() ;
		
		try {
			
			List<Author> authors = sqlSession.selectList("selectAuthorJoinUseSubSelect");  //映射的结果使用 
			
			for (Author author : authors) {
				System.out.println("作者真实姓名： "+author.getRealname());
				//当在mybatis-config.xml中设置了2项懒加载设置后，效果将不一样,没有懒加载，将显示自动查询Author中相关的JiKeUser对象。
				//System.out.println("对应的用户名： "+author.getJikeUser().getUsername());
			}
			
			SqlSessionHelper.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			
		} finally {
			SqlSessionHelper.close();
		}
		
	}
	
	
	 

	
}




























