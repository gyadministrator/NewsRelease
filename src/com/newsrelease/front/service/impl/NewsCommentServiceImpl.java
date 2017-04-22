package com.newsrelease.front.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newsrelease.front.dao.INewsCommentDAO;
import com.newsrelease.front.service.INewsCommentService;
import com.newsrelease.pojo.Comment;
import com.newsrelease.pojo.Save;

@Service
public class NewsCommentServiceImpl implements INewsCommentService {
	private INewsCommentDAO newsCommentDAO;

	@Resource(name = "newsCommentDAOImpl")
	public void setNewsCommentDAO(INewsCommentDAO newsCommentDAO) {
		this.newsCommentDAO = newsCommentDAO;
	}

	@Override
	public void insertComment(Comment comment) throws Exception {
		newsCommentDAO.doCreate(comment);
	}

	@Override
	public void deleteComment(Integer id) throws Exception {
		newsCommentDAO.doRemove(id);
	}

	@Override
	public Map<String, Object> findSavesAll(int pageNo, int pageSize)
			throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("allComment", newsCommentDAO.findAll(pageNo, pageSize));
		map.put("allCount", newsCommentDAO.getAllCount());
		return map;
	}
}
