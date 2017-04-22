package com.newsrelease.front.service;

import java.util.Map;

import com.newsrelease.pojo.Save;

public interface INewsSaveService {
	/**
	 * 保存用户收藏的内容
	 * 
	 * @param save
	 * @throws Exception
	 */
	public void saveCollect(Save save) throws Exception;

	/**
	 * 删除收藏
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteCollect(Integer id) throws Exception;

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

}
