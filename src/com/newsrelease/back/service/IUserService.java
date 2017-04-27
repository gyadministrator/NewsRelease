package com.newsrelease.back.service;

import java.util.List;
import java.util.Map;

import com.newsrelease.pojo.User;

public interface IUserService {

	public boolean login(User user) throws Exception;

	public void insert(User user) throws Exception;

	public User findById(Integer id) throws Exception;

	public void delete(Integer id) throws Exception;

	public void update(User user) throws Exception;

	public Map<String, Object> updatePre(Integer id) throws Exception;

	public Map<String, Object> list(int pageNo, int pageSize, Integer keyword)
			throws Exception;

	public Map<String, Object> list(int pageNo, int pageSize) throws Exception;
	public void updatePssword(int id,String password) throws Exception;
}
