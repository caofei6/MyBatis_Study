package com.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.mapping.UserMapperI;
import com.mybatis.model.User;
import com.mybatis.util.MyBatisUtil;

public class TestCRUDByAnnotationMapper {
	
	public void testAdd(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		//得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		User user = new User();
		user.setName("新添加的人");
		user.setAge(20);
		//执行增加操作
		int add = mapper.add(user);
		
		sqlSession.close();
		System.out.println(add);
		
	}
	
	public void testUpdate(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		//得到UserMapperI接口的实现类对象，UserMapperI接口实现类对象由sqlSession.getMapper(UserMappingI.class)动态构建出来
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		User user = new User();
		user.setId(3);
		user.setName("曹菲");
		user.setAge(98);
		//执行修改操作
		int update = mapper.update(user);
		
		sqlSession.close();
		System.out.println(update);
	}
	
	public void testDelete(int id){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		//得到UserMapperI接口的实现类对象，UserMapperI接口实现类对象由sqlSession.getMapper(UserMappingI.class)动态构建出来
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		//执行删除操作
		int retResult = mapper.deleteById(id);
		
		sqlSession.close();
		System.out.println(retResult);
	}
	
	public void testGetUser(int id){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//得到UserMapperI接口的实现类对象，UserMapperI接口实现类对象由sqlSession.getMapper(UserMappingI.class)动态构建出来
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		//执行查询操作
		User user = mapper.getById(id);
		
		sqlSession.close();
		System.out.println(user);
	}

	public void testGetAll(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//得到UserMapperI接口的实现类对象，UserMapperI接口实现类对象由sqlSession.getMapper(UserMappingI.class)动态构建出来
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		//执行查询操作
		
		List<User> lstUsers = mapper.getAll();
		
		sqlSession.close();
		System.out.println(lstUsers);
		
	}
}
