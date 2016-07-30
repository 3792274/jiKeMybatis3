package jike.book.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import jike.book.pojo.Author;
import jike.book.pojo.JikeUser;
import jike.book.pojo.Visit;
import mybatis3.helper.SqlSessionHelper;

/**
 * 测试JiKeUser中新增加的 List<Visit> 集合查询
 * @author Mr.TianShu
 *
 */
public class TestCollection {

	

	//测试JiKeUser中新增加的 List<Visit> 集合查询
	@Test
	public void testSelectVisitin(){ 
		
		SqlSession sqlSession =SqlSessionHelper.getSqlSession() ;
		
		try {
			
			List<JikeUser> jikeUsers = sqlSession.selectList("selectVisit");   
			
			for (JikeUser jikeUser : jikeUsers) {
				System.out.println("用户名： "+jikeUser.getUsername());
				
				for (Visit visit : jikeUser.getVisitList()) {
					System.out.println("登录时间： "+visit.getVisitDate()+",  登录IP： "+visit.getVisitIP());
				}
				
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
