package cn.itheima.mybatis.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.itheima.mybatis.mapper.UserDao;
import cn.itheima.mybatis.util.MyBatisUtil;

public class CallBackTest {

	@Test
	public void callBackTest() throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUserCount是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "cn.itheima.mybatis.mapper.UserDao.getUserCount";// 映射sql的标识字符串
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("sexid", 1);
		parameterMap.put("usercount", -1);
		sqlSession.selectOne(statement, parameterMap);
		Integer result = parameterMap.get("usercount");
		System.out.println(result);
		sqlSession.close();
	}

	@Test
	public void callBackTest2() throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("sexid", 1);
		parameterMap.put("usercount", -1);
		userDao.getUserCount(parameterMap);
		Integer result = parameterMap.get("usercount");
		System.out.println(result + "-- mapper");
		sqlSession.close();
	}

}
