package com.newsrelease.front.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newsrelease.front.dao.INewsDAO;
import com.newsrelease.front.service.INewsService;
import com.newsrelease.pojo.News;
import com.newsrelease.pojo.Newstype;

@Service
public class NewsServiceImpl implements INewsService {
	private INewsDAO newsDAO;

	@Resource(name = "newsDAOImpl")
	public void setNewsNewsDAO(INewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	@Override
	public void insertNews(News news) throws Exception {
		// TODO Auto-generated method stub
		newsDAO.doCreate(news);
	}

	@Override
	public void deleteNews(Integer id) throws Exception {
		// TODO Auto-generated method stub
		newsDAO.doRemove(id);
	}

	@Override
	public News findbyId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		News news = newsDAO.findById(id);
		return news;
	}

	@Override
	public Map<String, Object> findbyKeyword(int pageNo, int pageSize,
			String keyword, String column) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allNews",
				newsDAO.findKeyAll(pageNo, pageSize, keyword, column));
		map.put("count", newsDAO.getKeyAllCount(keyword, column));
		return map;
	}

	@Override
	public List<News> findsendAll(int pageNo, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return newsDAO.findAll(pageNo, pageSize);
	}

	@Override
	public Map<String, Object> findAllNews(int pageNo, int pageSize)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allNews", newsDAO.findAll(pageNo, pageSize));
		map.put("count", newsDAO.getAllCount());
		return map;
	}

	@Override
	public List<Newstype> findNewsTypes() throws Exception {
		return newsDAO.findAllNewsTypes();
	}

	@Override
	public void update(News news) throws Exception {
		newsDAO.doUpdate(news);
	}

}
