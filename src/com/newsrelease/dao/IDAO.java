package com.newsrelease.dao;

import java.util.List;

/**
 * 公共接口
 * 
 * @author 高运
 * 
 * @param <K>
 * @param <V>
 */
public interface IDAO<K, V> {
	public void doCreate(V vo) throws Exception;

	public void doUpdate(V vo) throws Exception;

	public void doRemove(K id) throws Exception;

	public V findById(K id) throws Exception;

	/**
	 * 分页查询方法
	 * 
	 * @param pageNo
	 *            当前页号
	 * @param pageSize
	 *            每页的记录数
	 * @param keyword
	 *            关键词
	 * @param column
	 *            查询的字段名
	 * @return
	 * @throws Exception
	 */
	public List<V> findKeyAll(int pageNo, int pageSize, String keyword,

	String column) throws Exception;

	/**
	 * 查询全部记录数，用来记录总页数
	 * 
	 * @param keyword
	 * @param column
	 * @return
	 * @throws Exception
	 */
	public int getKeyAllCount(String keyword, String column) throws Exception;

	/**
	 * 不需要关键字查询全部记录
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @throws Exception
	 */
	public List<V> findAll(int pageNo, int pageSize) throws Exception;

	/**
	 * 不需要关键字查询全部记录数
	 * 
	 * @return
	 * @throws Exception
	 */
	public int getAllCount() throws Exception;

}
