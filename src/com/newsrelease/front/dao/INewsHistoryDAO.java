package com.newsrelease.front.dao;

import java.util.List;
import java.util.Map;

import com.newsrelease.dao.IDAO;
import com.newsrelease.pojo.History;
import com.newsrelease.pojo.News;
import com.newsrelease.pojo.Newstype;
import com.newsrelease.pojo.User;

public interface INewsHistoryDAO extends IDAO<Integer, History>{
	@Override
	public void doCreate(History vo) throws Exception;

	@Override
	public void doRemove(Integer id) throws Exception;

	@Override
	public List<History> findAll(int pageNo, int pageSize) throws Exception;

	@Override
	public int getAllCount() throws Exception;
	public int getAllCount(Integer userid) throws Exception;
	public List<News> findAllNews() throws Exception;
	public List<User> findAllUsers() throws Exception;
	public Map<String, Object> fidAllHistory(Integer userid) throws Exception;
	public List<History> findAllHistory(Integer userid,int pageNo, int pageSize)throws Exception;
}
