package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.model.User;

public class Test{
	
	public static void main(String[] args) throws IOException{
/*		String resource = "/com/mybatis/util/conf.xml";
		InputStream inputStream = Test.class.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
		String statement = "com.mybatis.mapping.userMapper.getUser";
		User user = session.selectOne(statement, 2);
		System.out.println(user);*/
		
		
		TestCRUDByXmlMapper testCRUD = new TestCRUDByXmlMapper();
		testCRUD.testDelete();
		testCRUD.testGetAll();
	}
}