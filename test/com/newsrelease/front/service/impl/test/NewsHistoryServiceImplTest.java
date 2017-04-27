package com.newsrelease.front.service.impl.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.newsrelease.front.dao.INewsHistoryDAO;
import com.newsrelease.front.dao.impl.NewsHistoryDAOImpl;
import com.newsrelease.pojo.History;
import com.newsrelease.pojo.News;
import com.newsrelease.pojo.User;

public class NewsHistoryServiceImplTest {
     private INewsHistoryDAO dao;
     
     @Before
 	public void init() {
 		ApplicationContext ctx = new ClassPathXmlApplicationContext(
 				"applicationContext-hibernate.xml");
 		HibernateTemplate hibernateTemplate = (HibernateTemplate) ctx
 				.getBean("hibernateTemplate");
 		this.dao = new NewsHistoryDAOImpl(hibernateTemplate);
 	}

	@Test
	public void testInsertHistory() throws Exception {
		User user=new User();
		user.setUserid(1);
		News news=new News();
		news.setNewsid(5);
		History history=new History();
		history.setNews(news);
		history.setUser(user);
		history.setSearchDate(new  Date());
		dao.doCreate(history);
	}

	@Test
	public void testDeleteHistory() throws Exception {
		dao.doRemove(2);
	}

}
