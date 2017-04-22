package com.newsrelease.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Newstype entity. @author MyEclipse Persistence Tools
 */

public class Newstype implements java.io.Serializable {

	// Fields

	private Integer typeid;
	private String typeName;
	private Set newses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Newstype() {
	}

	/** minimal constructor */
	public Newstype(String typeName) {
		this.typeName = typeName;
	}

	/** full constructor */
	public Newstype(String typeName, Set newses) {
		this.typeName = typeName;
		this.newses = newses;
	}

	// Property accessors

	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set getNewses() {
		return this.newses;
	}

	public void setNewses(Set newses) {
		this.newses = newses;
	}

}