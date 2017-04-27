package com.newsrelease.front.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
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
	public List<Comment> findKeyAll(final int pageNo,final int pageSize,final int keyword) throws Exception {
		@SuppressWarnings("rawtypes")
		List all = super.getHibernateTemplate().executeFind(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "FROM Comment as c WHERE c.news.newsid=?";
						Query query = session.createQuery(hql);
						query.setInteger(0, keyword);
						query.setFirstResult((pageNo - 1) * pageSize);
						query.setMaxResults(pageSize);
						return query.list();
					}
				});
		return all;
	}

	/**
	 * 根据关键字查询记录数
	 */
	@Override
	public int getKeyAllCount(String keyword, String column) throws Exception {
		String hql = "SELECT COUNT(c) FROM Comment as c WHERE c."+column+" LIKE "+keyword;
		@SuppressWarnings("rawtypes")
		List all = super.getHibernateTemplate().find(hql);
		return ((Long) all.get(0)).intValue();
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
		DetachedCriteria c = DetachedCriteria.forClass(Comment.class);
		@SuppressWarnings("rawtypes")
		List all = super.getHibernateTemplate().findByCriteria(c,
				(pageNo - 1) * pageSize, pageSize);
		return all;
	}

	@Override
	public int getAllCount() throws Exception {
		String hql = "SELECT COUNT(u) FROM Comment as u";
		@SuppressWarnings("rawtypes")
		List all = super.getHibernateTemplate().find(hql);
		return ((Long) all.get(0)).intValue();
	}

	@Override
	public List<Comment> findKeyAll(int pageNo, int pageSize, String keyword,
			String column) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}
	 
}
