package com.newsrelease.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer newsid;
	private Newstype newstype;
	private String title;
	private String content;
	private String photo;
	private Date pubDate;
	private Integer clickNum;
	private Set saves = new HashSet(0);
	private Set histories = new HashSet(0);
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(Newstype newstype, String title, String content, Date pubDate,
			Integer clickNum) {
		this.newstype = newstype;
		this.title = title;
		this.content = content;
		this.pubDate = pubDate;
		this.clickNum = clickNum;
	}

	/** full constructor */
	public News(Newstype newstype, String title, String content, String photo,
			Date pubDate, Integer clickNum, Set saves, Set histories,
			Set comments) {
		this.newstype = newstype;
		this.title = title;
		this.content = content;
		this.photo = photo;
		this.pubDate = pubDate;
		this.clickNum = clickNum;
		this.saves = saves;
		this.histories = histories;
		this.comments = comments;
	}

	// Property accessors

	public Integer getNewsid() {
		return this.newsid;
	}

	public void setNewsid(Integer newsid) {
		this.newsid = newsid;
	}

	public Newstype getNewstype() {
		return this.newstype;
	}

	public void setNewstype(Newstype newstype) {
		this.newstype = newstype;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Integer getClickNum() {
		return this.clickNum;
	}

	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}

	public Set getSaves() {
		return this.saves;
	}

	public void setSaves(Set saves) {
		this.saves = saves;
	}

	public Set getHistories() {
		return this.histories;
	}

	public void setHistories(Set histories) {
		this.histories = histories;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}