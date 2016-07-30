package mybatis3.helper;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 创建GetSqlSessionFacctory,对Mybatis核心代码进行封装，
 * 有助于对数据执行CRUD操作。单例的，线程安全的
 * 单例的SqlsessionFactory
 * @author Mr.TianShu
 *
 */
public class SqlSessionFactoryHelper {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	private SqlSessionFactoryHelper(){}
	
	synchronized public static SqlSessionFactory getSqlSessionFactory(){
		try {
			if(sqlSessionFactory == null){
				String resource = "mybatis-config.xml";
				InputStream inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			}else{
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
}
