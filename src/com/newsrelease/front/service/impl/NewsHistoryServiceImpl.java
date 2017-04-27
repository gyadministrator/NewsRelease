package com.newsrelease.front.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newsrelease.back.dao.IUserDAO;
import com.newsrelease.front.dao.INewsDAO;
import com.newsrelease.front.dao.INewsHistoryDAO;
import com.newsrelease.front.service.INewsHisoryService;
import com.newsrelease.pojo.History;
import com.newsrelease.pojo.News;
import com.newsrelease.pojo.User;
@Service
public class NewsHistoryServiceImpl implements INewsHisoryService {
    private INewsHistoryDAO dao;

  




	@Resource(name = "newsHistoryDAOImpl")
	public void setDao(INewsHistoryDAO dao) {
		this.dao = dao;
	}

	@Override
	public void insertHistory(History history) throws Exception {
		dao.doCreate(history);

	}

	@Override
	public void deleteHistory(Integer id) throws Exception {
		dao.doRemove(id);
	}

	@Override
	public Map<String, Object> findHistorysAll(int pageNo, int pageSize)
			throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("allHistory", dao.findAll(pageNo, pageSize));
		map.put("allCount", dao.getAllCount());
		return map;
	}

	@Override
	public List<News> findNews() throws Exception {
		// TODO 自动生成的方法存根
		return dao.findAllNews();
	}

	@Override
	public List<User> finduUsers() throws Exception {
		// TODO 自动生成的方法存根
		return dao.findAllUsers();
	}

	@Override
	public Map<String, Object> findHistorysAll(Integer userid,int pageNo, int pageSize) throws Exception {
//		Map<String, Object> map=new  HashMap<>();
//		Map map2=dao.fidAllHistory(userid);
//		map.put("allHistory", map2.get("all"));
//		//map.put("allHistory", dao.fidAllHistory(userid));
//		map.put("allCount", dao.getAllCount(userid));
//		return map;
		
		Map<String, Object> map=new HashMap<>();
		map.put("allHistory", dao.findAllHistory(userid, pageNo, pageSize));
		map.put("allCount", dao.getAllCount(userid));
		return map;
	}

}
