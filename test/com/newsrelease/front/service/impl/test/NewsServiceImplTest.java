package com.newsrelease.front.service.impl.test;

import java.util.Date;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.newsrelease.front.dao.INewsDAO;
import com.newsrelease.front.dao.impl.NewsDAOImpl;
import com.newsrelease.pojo.News;
import com.newsrelease.pojo.Newstype;

public class NewsServiceImplTest {
	private INewsDAO dao;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext-hibernate.xml");
		HibernateTemplate hibernateTemplate = (HibernateTemplate) ctx
				.getBean("hibernateTemplate");
		this.dao = new NewsDAOImpl(hibernateTemplate);
	}

	@Test
	public void testSetNewsNewsDAO() {

	}

	@Test
	public void testInsertNews() throws Exception {
		News news = new News();
		Newstype newstype = new Newstype();
		newstype.setTypeid(1);

		//news.setNewsid(5);
		news.setTitle("小米6下周开卖，你买单吗？");
		news.setContent("测试");
		news.setClickNum(0);
		news.setPubDate(new Date());
		news.setNewstype(newstype);

		dao.doCreate(news);
	}

	@Test
	public void testDeleteNews() throws Exception {
		dao.doRemove(1);
	}

	@Test
	public void testFindbyId() throws Exception {
		News news = dao.findById(2);
		System.out.println(news.getTitle() + " " + news.getContent());
	}

	@Test
	public void testFindbyKeyword() throws Exception {
		System.out.println(dao.findKeyAll(0, 10, "小米", "title"));
	}

	@Test
	public void testFindsendAll() throws Exception {
		System.out.println(dao.findAll(0, 10));
	}

	@Test
	public void testFindAllNews() throws Exception {
		System.out.println(dao.findAll(1, 5));
		System.out.println("-------------------------");
		System.out.println(dao.getAllCount());
	}

}
