package com.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.User;
import com.mybatis.util.MyBatisUtil;

/*
 * 测试增删改查操作
 */
public class TestCRUDByXmlMapper {
	
	public void testAdd(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);            //获取SqlSession并自动提交事务
		/**
		 * 映射sql表示字符串
		 * com.mybatis.mapping.userMapper是userMapper.xml中的mapper标签的namespace属性的值
		 * addUser是insert标签的id属性值，通过insert标签的id属性值就可以找到要执行的Sql
		 */
		String statement = "com.mybatis.mapping.userMapper.addUser";
		User user = new User();
		user.setName("黄靖杰");
		user.setAge(22);
		
		//执行插入操作
		int retResult = sqlSession.insert(statement, user);
		
		sqlSession.close();
		System.out.println(retResult);	
	}
	
	public void testGetUser(int id){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.mybatis.mapping.userMapper.getUser";
		User user = sqlSession.selectOne(statement, id);
		
		sqlSession.close();
		System.out.println(user);
	}
	public void testUpdate(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		/**
		 * 映射sql表示字符串
		 * com.mybatis.mapping.userMapper是userMapper.xml中的mapper标签的namespace属性的值
		 * updateUser是update标签的id属性值，通过update标签的id属性值就可以找到要执行的Sql
		 */
		String statement = "com.mybatis.mapping.userMapper.updateUser";
		User user = new User();
		user.setId(3);
		user.setAge(30);
		user.setName("更改名字成功");
		//执行修改操作
		int retResult = sqlSession.delete(statement, user);
		
		sqlSession.close();
		System.out.println(retResult);
	}
	
	public void testDelete(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		/**
		 * 映射sql表示的字符串
		 * com.mybatis.mapping.userMapper是userMapper.xml中的mapper标签的namespace属性的值
		 * deleteUser是delete标签的id属性值，通过delete标签的id属性值就可以找到要执行的Sql
		 */
		String statement = "com.mybatis.mapping.userMapper.deleteUser";
		//执行删除操作 删除编号为2的同学
		int retResult = sqlSession.delete(statement, 2);
		
		sqlSession.close();
		System.out.println(retResult);
	}
	
	public void testGetAll(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		/**
		 * 映射sql表示的字符串
		 * com.mybatis.mapping.userMapper是userMapper.xml中的mapper标签的namespace属性的值
		 * getAllUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的Sql
		 */
		String statement = "com.mybatis.mapping.userMapper.getAllUser";
		//执行查询操作，将结果封装成List<User>返回
		List<User> lstUsers = sqlSession.selectList(statement);
		
		sqlSession.close();
		System.out.println(lstUsers);
		
	}

}
