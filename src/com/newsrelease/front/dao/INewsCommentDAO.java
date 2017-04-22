package com.newsrelease.front.dao;

import java.util.List;

import com.newsrelease.dao.IDAO;
import com.newsrelease.pojo.Comment;

public interface INewsCommentDAO extends IDAO<Integer, Comment> {
	@Override
	public void doCreate(Comment vo) throws Exception;

	@Override
	public void doRemove(Integer id) throws Exception;

	@Override
	public List<Comment> findAll(int pageNo, int pageSize) throws Exception;

	@Override
	public int getAllCount() throws Exception;
}
