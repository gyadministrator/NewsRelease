package com.newsrelease.pojo;

import java.util.Date;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer commentid;
	private News news;
	private User user;
	private String commentTitle;
	private String commentContent;
	private Date commentDate;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(News news, User user, String commentTitle,
			String commentContent, Date commentDate) {
		this.news = news;
		this.user = user;
		this.commentTitle = commentTitle;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
	}

	// Property accessors

	public Integer getCommentid() {
		return this.commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
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

	public String getCommentTitle() {
		return this.commentTitle;
	}

	public void setCommentTitle(String commentTitle) {
		this.commentTitle = commentTitle;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return this.commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

}