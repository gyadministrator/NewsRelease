package com.newsrelease.front.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.newsrelease.front.dao.INewsCommentDAO;
import com.newsrelease.pojo.Comment;

@Component
public class NewsCommentDAOImpl extends HibernateDaoSupport implements
		INewsCommentDAO {
	@Autowired
	public NewsCommentDAOImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}

	@Override
	public void doUpdate(Comment vo) throws Exception {
		super.getHibernateTemplate().update(vo);
	}

	@Override
	public Comment findById(Integer id) throws Exception {
		return super.getHibernateTemplate().get(Comment.class, id);
	}

	@Override
	public List<Comment> findKeyAll(int pageNo, int pageSize, String keyword,
			String column) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getKeyAllCount(String keyword, String column) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void doCreate(Comment vo) throws Exception {
		super.getHibernateTemplate().save(vo);
	}

	@Override
	public void doRemove(Integer id) throws Exception {
		super.getHibernateTemplate().delete(findById(id));
	}

	@Override
	public List<Comment> findAll(int pageNo, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
