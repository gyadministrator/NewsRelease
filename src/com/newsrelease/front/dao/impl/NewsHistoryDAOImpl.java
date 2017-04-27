package com.newsrelease.front.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.newsrelease.front.dao.INewsHistoryDAO;
import com.newsrelease.pojo.History;
import com.newsrelease.pojo.News;
import com.newsrelease.pojo.Newstype;
import com.newsrelease.pojo.User;
@Component
public class NewsHistoryDAOImpl extends HibernateDaoSupport implements INewsHistoryDAO {

	
	@Autowired
	public NewsHistoryDAOImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}

	@Override
	public void doCreate(History vo) throws Exception {
	super.getHibernateTemplate().save(vo);
		
	}

	@Override
	public void doUpdate(History vo) throws Exception {
	super.getHibernateTemplate().update(vo);
		
	}

	@Override
	public void doRemove(Integer id) throws Exception {
		super.getHibernateTemplate().delete(findById(id));
		
	}

	@Override
	public History findById(Integer id) throws Exception {
		
		return super.getHibernateTemplate().get(History.class, id);
	}

	@Override
	public List<History> findKeyAll(int pageNo, int pageSize, String keyword,
			String column) throws Exception {
		
		DetachedCriteria c = DetachedCriteria.forClass(History.class);
		c.add(Restrictions.like(column, "%" + keyword + "%"));
		@SuppressWarnings("unchecked")
		List<History> all = super.getHibernateTemplate().findByCriteria(c,
				(pageNo - 1) * pageSize, pageSize);
		return all;
	}

	@Override
	public int getKeyAllCount(String keyword, String column) throws Exception {
		String hql = "SELECT COUNT(n) FROM History AS n WHERE n." + column
				+ " LIKE ?";
		@SuppressWarnings("rawtypes")
		List all = super.getHibernateTemplate().find(hql, "%" + keyword + "%");
		return ((Long) all.get(0)).intValue();
		
	}

	@Override
	public List<History> findAll(int pageNo, int pageSize) throws Exception {
		DetachedCriteria c = DetachedCriteria.forClass(History.class);
		@SuppressWarnings("unchecked")
		List<History> all = super.getHibernateTemplate().findByCriteria(c,
				(pageNo - 1) * pageSize, pageSize);
		return all;
	
	}

	@Override
	public int getAllCount() throws Exception {
		String hql = "SELECT COUNT(n) FROM History AS n";
		@SuppressWarnings("rawtypes")
		List all=super.getHibernateTemplate().find(hql);
		return ((Long)all.get(0)).intValue();
	}

	@Override
	public List<News> findAllNews() throws Exception {
		return super.getHibernateTemplate().loadAll(News.class);
	}

	@Override
	public List<User> findAllUsers() throws Exception {
	
		return super.getHibernateTemplate().loadAll(User.class);
	}

	@Override
	public Map<String, Object> fidAllHistory(Integer userid) throws Exception {
		String hql = "SELECT historyid, searchDate FROM History WHERE userid=?";
		@SuppressWarnings("rawtypes")
		List all=super.getHibernateTemplate().find(hql,userid);
		
		System.out.println("******************************"+all.get(0));
		Map<String, Object> map=new HashMap<String, Object>();
	    map.put("all", all);
		return map;
		
		
		
	}

	
	@Override
	public int getAllCount(Integer userid) throws Exception {
		String hql = "SELECT COUNT(searchDate) FROM History  WHERE userid=?";
		@SuppressWarnings("rawtypes")
		List all=super.getHibernateTemplate().find(hql,userid);
            System.out.println("0000000000000000000000000000000"+((Long)all.get(0)));
		return ((Long)all.get(0)).intValue();
	}

	

	@Override
	public List<History> findAllHistory(final Integer userid,final int pageNo, final int pageSize) throws Exception {
         
//		DetachedCriteria c = DetachedCriteria.forClass(History.class);
//		c.add(Restrictions.eq("historyid", userid));
//		@SuppressWarnings("unchecked")
//		List<History> all = super.getHibernateTemplate().findByCriteria(c,
//				(pageNo - 1) * pageSize, pageSize);
//		return all;
		@SuppressWarnings("rawtypes")
		List all = super.getHibernateTemplate().executeFind(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "FROM History as u WHERE u.user.userid=?";
						Query query = session.createQuery(hql);
						query.setInteger(0, userid);
						query.setFirstResult((pageNo - 1) * pageSize);
						query.setMaxResults(pageSize);
						return query.list();
					}
				});
		return all;
	}


}
