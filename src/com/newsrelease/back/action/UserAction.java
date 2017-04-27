package com.newsrelease.back.action;

 
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.newsrelease.back.service.IUserService;
import com.newsrelease.pojo.User;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope(value = "prototype")
public class UserAction extends ActionSupport {
	private IUserService service;
	private List<User> allUser;
	private User user;
	//确认密码，用作注册使用
	private String confirm_password;
	//旧密码，用作修改密码
	private String old_password;
	//新密码
	private String new_password;
	//验证码参数
	private String verifyCode;
	// 提示信息参数
	private String message;
	private String message_reg;
	private String message_login;
	// 跳转路径参数，指导forward.jsp的跳转
	private String url;

	// 分页查询使用参数
	private int pageNo = 1;
	private int pageSize = 5;
	private Integer keyword = 0;
	private String column = "userType";
	private int count;

	/**
	 * 用户注册处理方法
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		if (!confirm_password.equals(user.getPassword())) {
			message_reg = "两次输入的密码不一致!";
			user=null;
		} else {		
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			user.setRegisterDate(new Timestamp(sdf.parse(user.getDateStr()).getTime()));
			service.insert(user);
			ServletActionContext.getRequest().getSession()
			.setAttribute("user", user);
			message_reg = "注册成功";
		}
		ServletActionContext.getRequest().getSession()
		.setAttribute("message_reg", message_reg);
		url=url.substring(url.indexOf("/", 2)+1);
		return "forward";
	}

	/**
	 * 根据关键字查询全部数据
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String list() throws Exception {
		Map<String, Object> map = service.list(pageNo, pageSize, keyword);
		allUser = (List<User>) map.get("allUser");
		count = (int) map.get("allCount");
		return "list";
	}

	/**
	 * 点击修改操作，触发的action
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updatePre() throws Exception {
		Map<String, Object> map = service.updatePre(user.getUserid());
		user = (User) map.get("user");
		return "update";
	}

	/**
	 * 用户修改操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		user.setRegisterDate(new Timestamp(sdf.parse(user.getDateStr()).getTime()));
		service.update(user);
		message = "修改成功！";
		url="pages/front/user_update.jsp";
		ServletActionContext.getRequest().getSession()
		.setAttribute("user", user);
		return "forward";
	}

	/**
	 * 删除某用户操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		service.delete(user.getUserid());
		return list();
	}

	/**
	 * 管理员登陆处理方法
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		boolean flag = false;
		flag = service.login(user);
		// 获取验证码
		String code = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("verifyCode");
		if (!verifyCode.equals(code)) {
			message = "验证码不正确，请重新输入！";
			user=null;
			return "input";
		}
		if (flag && user.getUserType()==1) {
			ServletActionContext.getRequest().getSession()
					.setAttribute("user", user);
			return "suc";
		} else {
			user=null;
			message = "用户名或密码不正确，请重新登陆！";
		}
		return "input";
	}

	/**
	 * 前台普通用户登录处理方法
	 * @return
	 * @throws Exception
	 */
	public String fontLogin() throws Exception {
		boolean flag = false;	
		flag = service.login(user);
		// 获取验证码
		url=url.substring(url.indexOf("/", 2)+1);
		String code = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("verifyCode");
		if (!verifyCode.equals(code)) {
			message_login= "验证码不正确，请重新输入！";
			user=null;
			ServletActionContext.getRequest().getSession()
			.setAttribute("message_login", message_login);
			return "forward";
		}	
		if (flag) {		
			ServletActionContext.getRequest().getSession()
					.setAttribute("user", user);	
			ServletActionContext.getRequest().getSession().removeAttribute("message_login");
		} else {
			user=null;	 	
			message_login ="用户名或密码不正确，请重新登陆！";
			ServletActionContext.getRequest().getSession()
			.setAttribute("message_login", message_login);
		}	
		if(url.equals("pages/front/front_index.jsp")){
			url="pages/front/news_findNewsAll.action";
		}
		return "forward";
	}
	
    public String passwordUpdate()throws Exception{
    	if(!old_password.equals(user.getPassword())){
    		message="旧密码不正确，请重新输入！";
    	}else if(!new_password.equals(confirm_password)){
    		message="新密码两次输入不一致！";
    	}else{
    		service.updatePssword(user.getUserid(),new_password);
    		message="修改成功";
    		user.setPassword(new_password);
    		ServletActionContext.getRequest().getSession()
    		.setAttribute("user", user);
    	}
    	return "update";
    }
	public IUserService getService() {
		return service;
	}

	@Resource(name = "userServiceImpl")
	public void setService(IUserService service) {
		this.service = service;
	}

	public List<User> getAllUser() {
		return allUser;
	}

	public void setAllUser(List<User> allUser) {
		this.allUser = allUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public Integer getKeyword() {
		return keyword;
	}

	public void setKeyword(Integer keyword) {
		this.keyword = keyword;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public String getMessage_reg() {
		return message_reg;
	}

	public void setMessage_reg(String message_reg) {
		this.message_reg = message_reg;
	}

	public String getMessage_login() {
		return message_login;
	}

	public void setMessage_login(String message_login) {
		this.message_login = message_login;
	}

	public String getOld_password() {
		return old_password;
	}

	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
}
