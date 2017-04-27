package com.newsrelease.front.service;

import java.util.List;
import java.util.Map;

import com.newsrelease.pojo.Comment;
import com.newsrelease.pojo.Save;

/**
 * 新闻点评及收藏模块
 * 
 * @author 高运
 * 
 */
public interface INewsCommentService {

	
	public void insertComment(Comment comment) throws Exception;

	/**
	 * 管理员可以对评论内容进行删除
	 * 
	 * @param id
	 *            评论表的id，用来查找这条评论
	 * @throws Exception
	 */
	public void deleteComment(Integer id) throws Exception;

	/**
	 * 分页显示用户收藏的内容
	 * 
	 * @param pageNo
	 *            当前页号
	 * @param pageSize
	 *            每页显示条数
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findSavesAll(int pageNo, int pageSize)
			throws Exception;

	/**
	 * 通过关键字查询评论
	 * @param pageNo
	 * @param pageSize
	 * @param keyword
	 * @param column
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findKeyAll(final int pageNo,final int pageSize,final int keyword) throws Exception;

}
