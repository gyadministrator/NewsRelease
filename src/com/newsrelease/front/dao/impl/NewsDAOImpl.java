package com.newsrelease.front.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.newsrelease.front.dao.INewsDAO;
import com.newsrelease.pojo.News;
import com.newsrelease.pojo.Newstype;

@Component
public class NewsDAOImpl extends HibernateDaoSupport implements INewsDAO {

	@Autowired
	public NewsDAOImpl(HibernateTemplate hibernaTemplate) {
		super.setHibernateTemplate(hibernaTemplate);
	}

	@Override
	public void doCreate(News vo) throws Exception {
		super.getHibernateTemplate().save(vo);
	}

	@Override
	public void doUpdate(News vo) throws Exception {
		super.getHibernateTemplate().update(vo);
	}

	@Override
	public void doRemove(Integer id) throws Exception {
		super.getHibernateTemplate().delete(findById(id));
	}

	@Override
	public News findById(Integer id) throws Exception {

		News news = super.getHibernateTemplate().get(News.class, id);
		return news;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> findKeyAll(int pageNo, int pageSize, String keyword,
			String column) throws Exception {

		DetachedCriteria c = DetachedCriteria.forClass(News.class);
		c.add(Restrictions.like(column,keyword));
		List<News> all = super.getHibernateTemplate().findByCriteria(c,
				(pageNo - 1) * pageSize, pageSize);
		return all;
	}

	@Override
	public int getKeyAllCount(String keyword, String column) throws Exception {
		String hql = "SELECT COUNT(n) FROM News AS n WHERE n." + column
				+ " LIKE ?";
		@SuppressWarnings("rawtypes")
		List all = super.getHibernateTemplate().find(hql,keyword);
		return ((Long) all.get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> findAll(int pageNo, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		DetachedCriteria c = DetachedCriteria.forClass(News.class);
		List<News> all = super.getHibernateTemplate().findByCriteria(c,
				(pageNo - 1) * pageSize, pageSize);
		return all;
	}

	@Override
	public int getAllCount() throws Exception {
		String hql = "SELECT COUNT(n) FROM News AS n";
		@SuppressWarnings("rawtypes")
		List all = super.getHibernateTemplate().find(hql);
		return ((Long) all.get(0)).intValue();
	}

	@Override
	public List<Newstype> findAllNewsTypes() throws Exception {
		return super.getHibernateTemplate().loadAll(Newstype.class);
	}

	public List<News> findByIdAll(int pageNo, int pageSize,int keyword,
			String column) throws Exception {

		DetachedCriteria c = DetachedCriteria.forClass(News.class);
		c.add(Restrictions.like(column,keyword));
		List<News> all = super.getHibernateTemplate().findByCriteria(c,
				(pageNo - 1) * pageSize, pageSize);
		return all;
	}

	@Override
	public int getByIdCount(int id, String column) throws Exception {
		String hql = "SELECT COUNT(n) FROM News AS n WHERE n." + column
				+ " LIKE ?";
		@SuppressWarnings("rawtypes")
		List all = super.getHibernateTemplate().find(hql,id);
		return ((Long) all.get(0)).intValue();
	}
	
}
