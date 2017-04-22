package com.newsrelease.front.dao;

import java.util.List;

import com.newsrelease.dao.IDAO;
import com.newsrelease.pojo.News;
import com.newsrelease.pojo.Newstype;

public interface INewsDAO extends IDAO<Integer, News> {
	public List<Newstype> findAllNewsTypes() throws Exception;

}
