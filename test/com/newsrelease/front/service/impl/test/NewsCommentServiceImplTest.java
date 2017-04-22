package com.newsrelease.front.service.impl.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.newsrelease.back.dao.IUserDAO;
import com.newsrelease.back.dao.impl.UserDAOImpl;
import com.newsrelease.front.dao.INewsCommentDAO;
import com.newsrelease.front.dao.INewsDAO;
import com.newsrelease.front.dao.impl.NewsCommentDAOImpl;
import com.newsrelease.front.dao.impl.NewsDAOImpl;
import com.newsrelease.pojo.Comment;
import com.newsrelease.pojo.News;
import com.newsrelease.pojo.User;

public class NewsCommentServiceImplTest {
	private INewsCommentDAO service;
	private IUserDAO dao;
	private INewsDAO newsDAO;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext-hibernate.xml");
		HibernateTemplate hibernateTemplate = (HibernateTemplate) ctx
				.getBean("hibernateTemplate");
		service = new NewsCommentDAOImpl(hibernateTemplate);
		dao = new UserDAOImpl(hibernateTemplate);
		newsDAO = new NewsDAOImpl(hibernateTemplate);
	}

	@Test
	public void testInsertComment() throws Exception {
		Comment comment = new Comment();
		comment.setCommentTitle("测试标题1");
		comment.setCommentContent("测试内容1");
		comment.setCommentDate(new Date());
		User user=new User();
		user.setUserid(1);
		comment.setUser(user);
		News news=new News();
		news.setNewsid(1);
		comment.setNews(news);
		service.doCreate(comment);
	}

	@Test
	public void testDeleteComment() throws Exception {
		service.doRemove(1);
	}

}
