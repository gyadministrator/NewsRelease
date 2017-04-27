package com.newsrelease.front.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.newsrelease.front.service.INewsCommentService;
import com.newsrelease.front.service.INewsHisoryService;
import com.newsrelease.front.service.INewsService;
import com.newsrelease.pojo.Comment;
import com.newsrelease.pojo.History;
import com.newsrelease.pojo.News;
import com.newsrelease.pojo.User;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope(value = "prototype")
public class NewsCommentSaveAction extends ActionSupport {
	private INewsCommentService service;
	private INewsService newsService;
	private Comment comment;
	private INewsHisoryService hisoryService;
	private History history;
	private User user;
	private News news;
    private List<Comment> allComment;
    // 分页查询使用参数
 	private int pageNo = 1;
 	private int pageSize =5;
 	private int count;
 	
    //消息提示参数
 	private String message;
 
 	//查询用参数
 	private String column;
 	private String keyword;
    /**
     * 发表评论处理方法
     * @return
     * @throws Exception
     */
    public String insert() throws Exception {
    	if(comment.getCommentContent().equals(""))
    		message="内容不能为空！";
		else {
			service.insertComment(comment);
			message = "发表成功！";
		}
		return list();
	}
    
    public String list()throws Exception{
    	Map<String, Object> map=new HashMap<String, Object>();
//    	map=service.findSavesAll(pageNo, pageSize);
    	map=service.findKeyAll(pageNo, pageSize,comment.getNews().getNewsid());
    	allComment=(List<Comment>) map.get("allComment");
    	ServletActionContext.getRequest().getSession().setAttribute("allComment",allComment);	
    	count=(Integer)map.get("allCount");
    	ServletActionContext.getRequest().getSession().setAttribute("count",count);	
    	return "show";
    }   
    
    /**
	 * 查看新闻详细处理方法
	 * @return
	 * @throws Exception
	 */
	public String newsShow()throws Exception{
		news=newsService.findbyId(comment.getNews().getNewsid());
		ServletActionContext.getRequest().getSession().setAttribute("news",news);	
		//用户登录的情况下点击新闻的话，添加浏览历史
		if(history.getUser().getUserid()!=null){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");		
			history.setSearchDate(new Timestamp(sdf.parse(sdf.format(new Date())).getTime()));
		   hisoryService.insertHistory(history);
		}
		return list();
	}
    
	@Resource(name = "newsCommentServiceImpl")
	public void setService(INewsCommentService service) {
		this.service = service;
	}
	
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}




	public List<Comment> getAllComment() {
		return allComment;
	}

	public void setAllComment(List<Comment> allComment) {
		this.allComment = allComment;
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




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	@Resource(name="newsServiceImpl")
	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}
    @Resource(name="newsHistoryServiceImpl")
	public void setHisoryService(INewsHisoryService hisoryService) {
		this.hisoryService = hisoryService;
	}

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
