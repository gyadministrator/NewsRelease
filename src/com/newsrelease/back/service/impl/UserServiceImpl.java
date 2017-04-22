package com.newsrelease.back.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newsrelease.back.dao.IUserDAO;
import com.newsrelease.back.service.IUserService;
import com.newsrelease.pojo.User;

@Service
public class UserServiceImpl implements IUserService {

	private IUserDAO userDAO;

	@Override
	public void insert(User user) throws Exception {
		userDAO.doCreate(user);
	}

	@Override
	public void delete(Integer id) throws Exception {
		userDAO.doRemove(id);
	}

	@Override
	public void update(User user) throws Exception {
		userDAO.doUpdate(user);
	}

	@Override
	public Map<String, Object> updatePre(Integer id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", findById(id));
		return map;
	}

	@Override
	public Map<String, Object> list(int pageNo, int pageSize, Integer keyword)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allUser", userDAO.findKeyAll(pageNo, pageSize, keyword));
		map.put("allCount", userDAO.getKeyAllCount(keyword));
		return map;
	}

	@Resource(name = "userDAOImpl")
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User findById(Integer id) throws Exception {
		return userDAO.findById(id);
	}

	@Override
	public boolean login(User user) throws Exception {
		return userDAO.isLogin(user);
	}

	@Override
	public Map<String, Object> list(int pageNo, int pageSize) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allUser", userDAO.findAll(pageNo, pageSize));
		map.put("allCount", userDAO.getAllCount());
		return map;
	}

}
