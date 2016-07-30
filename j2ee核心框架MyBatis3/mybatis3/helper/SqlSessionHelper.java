package mybatis3.helper;

import org.apache.ibatis.session.SqlSession;

/**
 * 线程安全的Sqlsession
 * 每个线程都会有自己拷贝的一份SqlSession对象。
 * @author Mr.TianShu
 *
 */
public class SqlSessionHelper {

	//访问一个变量（通过其 get 或 set 方法）的每个线程都有自己的局部变量，它独立于变量的初始化副本。ThreadLocal 实例通常是类中的私有静态字段，它们希望将状态与某一个线程（例如，用户 ID 或事务 ID）相关联。 
	private static ThreadLocal<SqlSession> tl=new ThreadLocal<SqlSession>();
	
	/**
	 * 获取绑定线程的SqlSession对象
	 * @return
	 */
	public static SqlSession getSqlSession(){
		SqlSession sqlSession = tl.get();
		if(sqlSession == null){
			sqlSession = SqlSessionFactoryHelper.getSqlSessionFactory().openSession();
			tl.set(sqlSession);
		}else{
			
		}
//		System.out.println("获得SqlSession对象的HashCode: "+sqlSession.hashCode());
		return sqlSession;
	}
	
	/**
	 * 线程安全的提交
	 */
	public static void commit(){
		if(tl.get() != null){
			tl.get().commit();
			tl.get().close();
			tl.set(null);
		}
	}
	
	
	/**
	 * 线程安全的关闭
	 */
	public static void close(){
		if(tl.get() != null){
			tl.get().close();
			tl.set(null);
		}
	}
	
	
	
	
	/**
	 * 线程安全的回滚
	 */
	public static void rollback(){
		if(tl.get() != null){
			tl.get().rollback();
			tl.get().close();
			tl.set(null);
		}
	}

}
