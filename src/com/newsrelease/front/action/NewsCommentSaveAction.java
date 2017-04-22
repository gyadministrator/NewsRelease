package com.newsrelease.front.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.newsrelease.front.service.INewsCommentService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope(value = "prototype")
public class NewsCommentSaveAction extends ActionSupport {
	private INewsCommentService commentService;

	@Resource(name = "newsCommentServiceImpl")
	public void setCommentService(INewsCommentService commentService) {
		this.commentService = commentService;
	}

	public String insert() throws Exception {
		return "index";
	}
}
