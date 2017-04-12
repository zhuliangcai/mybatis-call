package cn.itheima.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	public static SqlSession getSqlSession() throws Exception {
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sessionFactory = builder.build(Resources.getResourceAsReader("mybatis-config.xml"));
		
		return sessionFactory.openSession();
	}

}
