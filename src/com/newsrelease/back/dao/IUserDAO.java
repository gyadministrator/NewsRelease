package com.newsrelease.back.dao;

import java.util.List;

import com.newsrelease.dao.IDAO;
import com.newsrelease.pojo.User;

public interface IUserDAO extends IDAO<Integer, User> {
	public boolean isLogin(User User) throws Exception;

	public List<User> findKeyAll(int pageNo, int pageSize, Integer keyword) throws Exception;

	public int getKeyAllCount(Integer keyword) throws Exception;
	public void updatePssword(int id,String password) throws Exception;
}
