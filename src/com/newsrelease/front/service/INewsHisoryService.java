package com.newsrelease.front.service;

import java.util.List;
import java.util.Map;

import com.newsrelease.pojo.History;
import com.newsrelease.pojo.News;
import com.newsrelease.pojo.Newstype;
import com.newsrelease.pojo.User;

public interface INewsHisoryService {
     public void insertHistory(History history)throws Exception;
     public void deleteHistory(Integer id)throws Exception;
 	 public Map<String, Object> findHistorysAll(int pageNo, int pageSize)throws Exception;
 	 public List<News> findNews() throws Exception;
 	 public List<User> finduUsers() throws Exception;
 	 public Map<String, Object> findHistorysAll(Integer userid,int pageNo, int pageSize)throws Exception;
}

