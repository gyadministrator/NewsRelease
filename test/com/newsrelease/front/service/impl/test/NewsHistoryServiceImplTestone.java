package com.newsrelease.front.service.impl.test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.newsrelease.front.dao.INewsHistoryDAO;
import com.newsrelease.front.dao.impl.NewsHistoryDAOImpl;
import com.newsrelease.front.service.INewsHisoryService;
import com.newsrelease.pojo.History;

public class NewsHistoryServiceImplTestone {
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
	public void testFindHistorysAllInteger() throws Exception{
		Map<String,Object> map= dao.fidAllHistory(1);
	    System.out.println(map.get("all"));  
	    System.out.println( dao.getAllCount(1));
	
	  
	}

}
