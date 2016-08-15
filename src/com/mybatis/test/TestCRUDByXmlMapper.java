package com.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.User;
import com.mybatis.util.MyBatisUtil;

/*
 * ������ɾ�Ĳ����
 */
public class TestCRUDByXmlMapper {
	
	public void testAdd(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);            //��ȡSqlSession���Զ��ύ����
		/**
		 * ӳ��sql��ʾ�ַ���
		 * com.mybatis.mapping.userMapper��userMapper.xml�е�mapper��ǩ��namespace���Ե�ֵ
		 * addUser��insert��ǩ��id����ֵ��ͨ��insert��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�Sql
		 */
		String statement = "com.mybatis.mapping.userMapper.addUser";
		User user = new User();
		user.setName("�ƾ���");
		user.setAge(22);
		
		//ִ�в������
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
		 * ӳ��sql��ʾ�ַ���
		 * com.mybatis.mapping.userMapper��userMapper.xml�е�mapper��ǩ��namespace���Ե�ֵ
		 * updateUser��update��ǩ��id����ֵ��ͨ��update��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�Sql
		 */
		String statement = "com.mybatis.mapping.userMapper.updateUser";
		User user = new User();
		user.setId(3);
		user.setAge(30);
		user.setName("�������ֳɹ�");
		//ִ���޸Ĳ���
		int retResult = sqlSession.delete(statement, user);
		
		sqlSession.close();
		System.out.println(retResult);
	}
	
	public void testDelete(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		/**
		 * ӳ��sql��ʾ���ַ���
		 * com.mybatis.mapping.userMapper��userMapper.xml�е�mapper��ǩ��namespace���Ե�ֵ
		 * deleteUser��delete��ǩ��id����ֵ��ͨ��delete��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�Sql
		 */
		String statement = "com.mybatis.mapping.userMapper.deleteUser";
		//ִ��ɾ������ ɾ�����Ϊ2��ͬѧ
		int retResult = sqlSession.delete(statement, 2);
		
		sqlSession.close();
		System.out.println(retResult);
	}
	
	public void testGetAll(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		/**
		 * ӳ��sql��ʾ���ַ���
		 * com.mybatis.mapping.userMapper��userMapper.xml�е�mapper��ǩ��namespace���Ե�ֵ
		 * getAllUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�Sql
		 */
		String statement = "com.mybatis.mapping.userMapper.getAllUser";
		//ִ�в�ѯ�������������װ��List<User>����
		List<User> lstUsers = sqlSession.selectList(statement);
		
		sqlSession.close();
		System.out.println(lstUsers);
		
	}

}
