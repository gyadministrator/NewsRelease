package com.newsrelease.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String name;
	private String password;
	private String sex;
	private String address;
	private Integer age;
	private Integer userType;
	private Date registerDate;
	private String dateStr;
	private Set saves = new HashSet(0);
	private Set histories = new HashSet(0);
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, String password, String sex, Integer userType,
			Date registerDate) {
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.userType = userType;
		this.registerDate = registerDate;
	}

	/** full constructor */
	public User(String name, String password, String sex, String address,
			Integer age, Integer userType, Date registerDate, Set saves,
			Set histories, Set comments) {
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.address = address;
		this.age = age;
		this.userType = userType;
		this.registerDate = registerDate;
		this.saves = saves;
		this.histories = histories;
		this.comments = comments;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
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

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

}