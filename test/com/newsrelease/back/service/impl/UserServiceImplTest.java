package com.newsrelease.back.service.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.newsrelease.back.dao.IUserDAO;
import com.newsrelease.back.dao.impl.UserDAOImpl;
import com.newsrelease.pojo.User;

public class UserServiceImplTest {
	private IUserDAO service;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext-hibernate.xml");
		HibernateTemplate hibernateTemplate = (HibernateTemplate) ctx
				.getBean("hibernateTemplate");
		service = new UserDAOImpl(hibernateTemplate);
	}

	@Test
	public void testInsert() throws Exception {
		User user = new User();
		user.setName("wuyongtai");
		user.setPassword("123456");
		user.setAge(23);
		user.setSex("男");
		user.setUserType(1);
		user.setAddress("贵州贵阳市");
		user.setRegisterDate(new Date());
		service.doCreate(user);
	}

	@Test
	public void testDelete() throws Exception {
		service.doRemove(14);
	}

	@Test
	public void testUpdate() throws Exception {
		User user=service.findById(14);
		user.setAddress("贵州贵州大学测试");
		service.doUpdate(user);
	}

	@Test
	public void testUpdatePre() throws Exception {
		// 无测试必要
	}

	@Test
	public void testList() throws Exception {
		List<User> all = service.findKeyAll(1,10,1);
		System.out.println(all.size());
		for (int i = 0; i < all.size(); i++) {
			System.out.println(all.get(i).getName()+" "+all.get(i).getPassword());
		}
	}

	@Test
	public void testFindById() throws Exception {
		User user = service.findById(1);
		System.out.println(user.getName());
	}

}
