package com.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.mapping.UserMapperI;
import com.mybatis.model.User;
import com.mybatis.util.MyBatisUtil;

public class TestCRUDByAnnotationMapper {
	
	public void testAdd(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		//�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		User user = new User();
		user.setName("����ӵ���");
		user.setAge(20);
		//ִ�����Ӳ���
		int add = mapper.add(user);
		
		sqlSession.close();
		System.out.println(add);
		
	}
	
	public void testUpdate(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		//�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿ�ʵ���������sqlSession.getMapper(UserMappingI.class)��̬��������
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		User user = new User();
		user.setId(3);
		user.setName("�ܷ�");
		user.setAge(98);
		//ִ���޸Ĳ���
		int update = mapper.update(user);
		
		sqlSession.close();
		System.out.println(update);
	}
	
	public void testDelete(int id){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		//�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿ�ʵ���������sqlSession.getMapper(UserMappingI.class)��̬��������
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		//ִ��ɾ������
		int retResult = mapper.deleteById(id);
		
		sqlSession.close();
		System.out.println(retResult);
	}
	
	public void testGetUser(int id){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿ�ʵ���������sqlSession.getMapper(UserMappingI.class)��̬��������
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		//ִ�в�ѯ����
		User user = mapper.getById(id);
		
		sqlSession.close();
		System.out.println(user);
	}

	public void testGetAll(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿ�ʵ���������sqlSession.getMapper(UserMappingI.class)��̬��������
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		//ִ�в�ѯ����
		
		List<User> lstUsers = mapper.getAll();
		
		sqlSession.close();
		System.out.println(lstUsers);
		
	}
}
