package com.newsrelease.pojo;

import java.util.Date;

/**
 * Save entity. @author MyEclipse Persistence Tools
 */

public class Save implements java.io.Serializable {

	// Fields

	private Integer saveid;
	private News news;
	private User user;
	private Date saveDate;

	// Constructors

	/** default constructor */
	public Save() {
	}

	/** minimal constructor */
	public Save(News news, User user) {
		this.news = news;
		this.user = user;
	}

	/** full constructor */
	public Save(News news, User user, Date saveDate) {
		this.news = news;
		this.user = user;
		this.saveDate = saveDate;
	}

	// Property accessors

	public Integer getSaveid() {
		return this.saveid;
	}

	public void setSaveid(Integer saveid) {
		this.saveid = saveid;
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

	public Date getSaveDate() {
		return this.saveDate;
	}

	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}

}