package com.newsrelease.front.action;

import java.util.List;
import java.util.Map;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.newsrelease.front.service.INewsService;
import com.newsrelease.pojo.News;
import com.newsrelease.pojo.Newstype;
import com.newsrelease.util.FileUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope(value = "prototype")
public class NewsAction extends ActionSupport {
	private INewsService service;
	// 分页查询使用参数
	private int pageNo = 1;
	private int pageSize =20;
	private List<News> allNews;
	private int count;
	private List<Newstype> allType;
	private News news;
	private File photo;
	private String photoFileName;
	private int clickNum = 0;
	private String keyword;
	private String column ="newstype.typeid";

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getClickNum() {
		return clickNum;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public List<Newstype> getAllType() {
		return allType;
	}

	public void setAllType(List<Newstype> allType) {
		this.allType = allType;
	}

	@Resource(name = "newsServiceImpl")
	public void setService(INewsService service) {
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

	public List<News> getAllNews() {
		return allNews;
	}

	public void setAllNews(List<News> allNews) {
		this.allNews = allNews;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * 根据当前页和每页条数查询所有新闻
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String findNewsAll() throws Exception {
		Map<String, Object> map = service.findAllNews(pageNo, pageSize);
		allNews = (List<News>) map.get("allNews");
		count = (int) map.get("count");
		return "list";
	}

	 
	 /**
	  * 根据关键字分页查询新闻
	  * @return
	  * @throws Exception
	  */
	@SuppressWarnings("unchecked")
	public String findNewsByKey() throws Exception {
		Map<String, Object> map = (Map<String, Object>) service.findByIdAll(
				pageNo, pageSize,Integer.valueOf(keyword).intValue(), column);
		allNews = (List<News>) map.get("allNews");
		count = (int) map.get("count");
		return "list";
	}
	
	
}
