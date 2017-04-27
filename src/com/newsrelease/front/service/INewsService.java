package com.newsrelease.front.service;

import java.util.List;
import java.util.Map;

import com.newsrelease.pojo.News;
import com.newsrelease.pojo.Newstype;

/**
 * 新闻发布修改模块
 * 
 * @author 杨明
 * 
 * */
public interface INewsService {
	/**
	 * 查询所有的新闻类型
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Newstype> findNewsTypes() throws Exception;

	public void insertNews(News news) throws Exception;

	/**
	 * 新闻的插入，新闻发布者使用
	 * 
	 * @param news
	 * */

	public void deleteNews(Integer id) throws Exception;

	/**
	 * 新闻的删除，新闻发布者使用
	 * 
	 * 
	 * @param id
	 *            发布的新闻的id，新闻的唯一标识
	 * @throws exception
	 * */

	public News findbyId(Integer id) throws Exception;

	/**
	 * 通过新闻id查找唯一一个新闻，主要是新闻发布者使用
	 * 
	 * @param id
	 *            新闻的id,新闻的唯一标识
	 * @throws exception
	 * */

	public Map<String, Object> findbyKeyword(int pageNo, int pageSize,
			String keyword, String column) throws Exception;

	 

	/**
	 * 查询所有的新闻，主要由管理员使用
	 * 
	 * @param pageNo
	 *            当前页号
	 * @param pageSize
	 *            每页显示的大小
	 * */
	public Map<String, Object> findAllNews(int pageNo, int pageSize)
			throws Exception;

	/**
	 * 更新新闻
	 * 
	 * @param news
	 * @throws Exception
	 */
	public void update(News news) throws Exception;
	
	public Map<String, Object> findByIdAll(int pageNo, int pageSize,
			int keyword, String column) throws Exception;
	
}
