package com.newsrelease.front.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.newsrelease.back.service.IUserService;
import com.newsrelease.front.dao.INewsHistoryDAO;
import com.newsrelease.front.service.INewsHisoryService;
import com.newsrelease.pojo.History;
import com.newsrelease.pojo.News;
import com.newsrelease.pojo.User;
import com.opensymphony.xwork2.ActionSupport;
//也表示一个bean
@Controller
//表示不使用单例
@Scope(value="prototype")
public class NewsHistoryAction extends ActionSupport  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4228172501242531450L;
	private List<History>allHistory;
    private INewsHisoryService service;
    private IUserService userService;
	private INewsHistoryDAO dao;
    private int pageNo = 1;
	private int pageSize = 5;
	private int count;
	private User user;
	private News news;
	private History history;
	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	@SuppressWarnings("unchecked")
	public String list()throws Exception{
		Map<String, Object> map=service.findHistorysAll(pageNo, pageSize);
		allHistory=(List<History>) map.get("allHistory");
		count=(int) map.get("allCount");
		return "list";
	}

	@SuppressWarnings("unchecked")
	public String one()throws Exception{
//		Map<String, Object> map=service.findHistorysAll(1);
//		allHistory=(List<History>) map.get("allHistory");
//		count=(int) map.get("allCount");
		user=userService.findById(history.getUser().getUserid());
		System.out.println("*************1**"+user.getName());
	    Map<String, Object> map=service.findHistorysAll(user.getUserid(), pageNo, pageSize);
	    allHistory=(List<History>) map.get("allHistory");
	 	count=(int) map.get("allCount");
		return "one";
		
	}
	
	
	public String delete() throws Exception {
		service.deleteHistory(history.getHistoryid());
		return list();
	}
	public String deletetwo() throws Exception {
		service.deleteHistory(history.getHistoryid());
		return one();
	}
	public List<History> getAllHistory() {
		return allHistory;
	}


	public void setAllHistory(List<History> allHistory) {
		this.allHistory = allHistory;
	}

	@Resource(name="newsHistoryServiceImpl")
	public void setService(INewsHisoryService service) {
		this.service = service;
	}


	public int getPageNo() {
		return pageNo;
	}


	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public News getNews() {
		return news;
	}


	public void setNews(News news) {
		this.news = news;
	}
	@Resource(name="newsHistoryDAOImpl")
	public void setDao(INewsHistoryDAO dao) {
		this.dao = dao;
	}
    public IUserService getUserService() {
		return userService;
	}


    @Resource(name="userServiceImpl")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
}
