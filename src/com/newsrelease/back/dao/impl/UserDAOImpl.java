package com.newsrelease.back.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

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

import com.newsrelease.back.dao.IUserDAO;
import com.newsrelease.pojo.User;

@Component
public class UserDAOImpl extends HibernateDaoSupport implements IUserDAO {

	@Autowired
	public UserDAOImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}

	/**
	 * 添加一个用户 vo：User对象
	 */
	@Override
	public void doCreate(User vo) throws Exception {
		super.getHibernateTemplate().save(vo);
	}

	/**
	 * 修改用户信息
	 */
	@Override
	public void doUpdate(User vo) throws Exception {
		super.getHibernateTemplate().update(vo);
	}

	/**
	 * 删除一个用户
	 */
	@Override
	public void doRemove(Integer id) throws Exception {
		super.getHibernateTemplate().delete(findById(id));
	}

	/**
	 * 通过关键字用户id查询用户
	 */
	@Override
	public User findById(Integer id) throws Exception {
		return super.getHibernateTemplate().get(User.class, id);
	}

	/**
	 * 分页查询功能 pageNo:当前页 pageSize:每页显示条数 keyword:查询关键词 column:查询表字段
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findKeyAll(final int pageNo, final int pageSize,
			final Integer keyword) throws Exception {
		@SuppressWarnings("rawtypes")
		List all = super.getHibernateTemplate().executeFind(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "FROM User as u WHERE u.userType=?";
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
	 * 根据关键字查询全部条数，用作分页查询
	 * 
	 * keyword:查询关键词 column:查询表字段
	 */
	@Override
	public int getKeyAllCount(Integer keyword) throws Exception {
		String hql = "SELECT COUNT(u) FROM User as u WHERE u.userType=?";
		@SuppressWarnings("rawtypes")
		List all = super.getHibernateTemplate().find(hql, keyword);
		return ((Long) all.get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll(int pageNo, int pageSize) throws Exception {
		DetachedCriteria c = DetachedCriteria.forClass(User.class);
		@SuppressWarnings("rawtypes")
		List all = super.getHibernateTemplate().findByCriteria(c,
				(pageNo - 1) * pageSize, pageSize);
		return all;
	}

	/**
	 * 查询全部用户记录数
	 */
	@Override
	public int getAllCount() throws Exception {
		String hql = "SELECT COUNT(u) FROM User as u";
		@SuppressWarnings("rawtypes")
		List all = super.getHibernateTemplate().find(hql);
		return ((Long) all.get(0)).intValue();
	}

	@Override
	public boolean isLogin(User user) throws Exception {
		String hql = "FROM User as n WHERE n.name=? and n.password=?";
		@SuppressWarnings("unchecked")
		List<User> allUser = (List<User>) super.getHibernateTemplate().find(
				hql, user.getName(), user.getPassword());
		if (allUser != null && allUser.size() > 0) {
			User result = (User) allUser.get(0);
			user.setAddress(result.getAddress());
			user.setAge(result.getAge());
			user.setSex(result.getSex());
			user.setUserType(result.getUserType());
			user.setUserid(result.getUserid());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String str=sdf.format(result.getRegisterDate());
			user.setRegisterDate(sdf.parse(str));
			user.setDateStr(str);
			return true;

		}
		return false;
	}

	@Override
	public List<User> findKeyAll(int pageNo, int pageSize, String keyword,
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
	 /**
	  * 修改密码
	  * @param id 用户id
	  * @param password 新密码
	  * @throws Exception
	  */
	public void updatePssword(int id,String password) throws Exception {
		  User user=findById(id);
		  user.setPassword(password);
		  doUpdate(user);
	}
}
