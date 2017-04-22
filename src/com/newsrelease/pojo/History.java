package com.newsrelease.pojo;

import java.util.Date;

/**
 * History entity. @author MyEclipse Persistence Tools
 */

public class History implements java.io.Serializable {

	// Fields

	private Integer historyid;
	private News news;
	private User user;
	private Date searchDate;

	// Constructors

	/** default constructor */
	public History() {
	}

	/** minimal constructor */
	public History(News news, User user) {
		this.news = news;
		this.user = user;
	}

	/** full constructor */
	public History(News news, User user, Date searchDate) {
		this.news = news;
		this.user = user;
		this.searchDate = searchDate;
	}

	// Property accessors

	public Integer getHistoryid() {
		return this.historyid;
	}

	public void setHistoryid(Integer historyid) {
		this.historyid = historyid;
	}

	public News getNews() {
		return this.news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getSearchDate() {
		return this.searchDate;
	}

	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
	}

}