package jike.book.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import jike.book.pojo.JiKeReader;
import jike.book.pojo.JikeUser;
import mybatis3.helper.SqlSessionHelper;

/**
 * 测试动态SQL,JiKeReader.xml
 * @author Mr.TianShu
 */
public class TestDynamicSQL {


	// 如果 Reader.money 不为空，查 money>Reader.money
	@Test
	public void testSelectReaderMoney(){ 
		
		SqlSession sqlSession =SqlSessionHelper.getSqlSession() ;
		
		try {
			
			 JiKeReader jiKeReader = new JiKeReader();  //new JiKeReader()就按快捷键 Ctrl+2,选择L,自动生成 JiKeReader jiKeReader =
//			 jiKeReader.setMoney(200);   //对象作为查询语句传递给查询,如果不设置值，则执行SQL发生改变
			 
			 List<JiKeReader> jiKeReaderList = sqlSession.selectList("selectReaderMoney",jiKeReader);
			
			 
			 for (JiKeReader tempJikeReader : jiKeReaderList) {
				System.err.println("用户Reader ID： "+ tempJikeReader.getReaderID());  
				//因为没有映射关系(resultMap)，不能查出来JiKeUser相关信息
			}
			 
			 
			SqlSessionHelper.commit();

		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			
		} finally {
			SqlSessionHelper.close();
		}
		
	}
	
	
	
	
	
	
	
	
	// SQL拼装，使用choose多路选择 拼装SQL、Where 去掉and、,使用Trim代替Where
	@Test
	public void testSelectJiKeUserChooseWhereTrim(){ 
		
		SqlSession sqlSession =SqlSessionHelper.getSqlSession() ;
		
		try {
			
			JikeUser jikeUser = new JikeUser();  
			jikeUser.setUsername("%j%");
			jikeUser.setId(5);
			
			
			//使用choose动态SQL标签
//			List<JikeUser> jikeUserList = sqlSession.selectList("selectJiKeUserChoose",jikeUser);
			
			
			//使用 Where动态标签
//			List<JikeUser> jikeUserList = sqlSession.selectList("selectJiKeUserWhere",jikeUser);
		
			
			//使用Trim代替where
			List<JikeUser> jikeUserList = sqlSession.selectList("selectJiKeUserTrim",jikeUser);
			
			for (JikeUser tempJikeUser : jikeUserList) {
				System.err.println("用户ID： "+ tempJikeUser.getId());  
				//因为没有映射关系(resultMap)，不能查出来JiKeUser相关信息
			}
			
			
			SqlSessionHelper.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			
		} finally {
			SqlSessionHelper.close();
		}
		
	}
	
	
	// SQL拼装，测试 Set更新，智能去掉逗号,Trim替换Set,updateJiKeUserTrim
	@Test
	public void testUpdateJiKeUserSetTrim(){ 
		
		SqlSession sqlSession =SqlSessionHelper.getSqlSession() ;
		
		try {
			
			JikeUser jikeUser = new JikeUser(); 
			jikeUser.setId(335);
			jikeUser.setPassword("我是密码5");
//			jikeUser.setUsername("我是用户名5");
			
			//使用Set动态组件SQL
//			sqlSession.update("updateJiKeUserSet",jikeUser);
			
			//使用Trim代替Set动态组合SQL
			sqlSession.update("updateJiKeUserTrim",jikeUser);
			
			
			SqlSessionHelper.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			
		} finally {
			SqlSessionHelper.close();
		}
		
	}
	
	
	
	
	
	
	// 动态 SQl 测试  Foreach
	@Test
	public void testSelectJiKeUserForeach(){ 
		
		SqlSession sqlSession =SqlSessionHelper.getSqlSession() ;
		
		try {
			
			//创建list的查询条件
			ArrayList<Integer> ides = new ArrayList<>();
			ides.add(2);
			ides.add(5);
			ides.add(9);
			 
			List<JikeUser> jikeuserList = sqlSession.selectList("selectJiKeUserForeach",ides);
			for (JikeUser jikeUser : jikeuserList) {
				System.out.println("用户 ID： "+jikeUser.getId()+", 用户名： "+jikeUser.getUsername());
			}
			
			SqlSessionHelper.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			
		} finally {
			SqlSessionHelper.close();
		}
	}
	
	
	// 动态 SQl 测试  Foreach,批量插入，批量赋值
	@Test
	public void testInsertJiKeUserForeach(){ 
		
		SqlSession sqlSession =SqlSessionHelper.getSqlSession() ;
		
		try {
			
			//创建list的插入内容
			ArrayList<JikeUser> jikeUserList = new ArrayList<>();
			JikeUser ju01=new JikeUser("极客01用户名","极客01密码");
			JikeUser ju02=new JikeUser("极客02用户名","极客02密码");
			JikeUser ju03=new JikeUser("极客03用户名","极客03密码");
			jikeUserList.add(ju01);
			jikeUserList.add(ju02);
			jikeUserList.add(ju03);
			
			sqlSession.insert("insertJiKeUserForeach",jikeUserList);
			SqlSessionHelper.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			
		} finally {
			SqlSessionHelper.close();
		}
	}
	
	
	
}




























