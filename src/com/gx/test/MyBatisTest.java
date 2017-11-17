package com.gx.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.gx.dao.UserMapper;
import com.gx.po.User;
import com.gx.util.MyBatisUtil;
import com.gx.vo.UserVo;

public class MyBatisTest {
    static SqlSessionFactory sqlSessionFactory=null;
	@Before
	public void testBefore() {
		sqlSessionFactory=MyBatisUtil.getSqlSessionFactory();
	}
	/**
	 * 新增
	 */
	@Test
	public void testAdd(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			User user=new User();
			user.setUsername("zhangsan");
			user.setPassword("123456");
			user.setUserid(18);
			userMapper.insert(user);
			sqlSession.commit();//提交事务
		} catch (Exception e) {
			sqlSession.close();
		}
	}
	/**
	 * 单表查询
	 */
	@Test
	public void testGetUser(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			User user=userMapper.selectByPrimaryKey(10);
			System.out.println(user.getUsername());
			//sqlSession.commit();//提交事务
		} catch (Exception e) {
			sqlSession.close();
		}
	}
	@Test
	public void testDeleteId(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			userMapper.deleteByPrimaryKey(10);
			sqlSession.commit();//提交事务
		} catch (Exception e) {
			sqlSession.close();
		}
	}
	@Test
	public void testFindAllVo(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			List<UserVo> vos=userMapper.findUserVoAll();
			for (UserVo userVo : vos) {
				System.out.println(userVo.getUsername());
				System.out.println(userVo.getPowername());
			}
//			sqlSession.commit();//提交事务
		} catch (Exception e) {
			sqlSession.close();
		}
	}
	/**
	 * 带参数
	 */
	@Test
	public void testFindByUsername(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			User user=userMapper.findByUsername("zhangsan");
			System.out.println(user.getPassword());
			//sqlSession.commit();//提交事务
		} catch (Exception e) {
			sqlSession.close();
		}
	}
	/**
	 * 传对象
	 */
	@Test
	public void testFindByUsernameVo(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			User user=userMapper.findByUsername("zhangsan");
			User user1=userMapper.findByUsernameVo(user);
			System.out.println(user1.getPassword());
			//sqlSession.commit();//提交事务
		} catch (Exception e) {
			sqlSession.close();
		}
	}
}
