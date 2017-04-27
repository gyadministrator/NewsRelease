<%@page import="com.newsrelease.pojo.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.text.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新闻网</title>
<script type="text/javascript">
function isEmpty(){
	var userLogin=<%=session.getAttribute("user")%>;
	var value=document.getElementById("content").value;
	if(userLogin==undefined||userLogin==null){
		$('#modal').css('display', 'block');
		$('.modal-bg').fadeIn();
		return false;
	}else if(value==null||value==""||value==undefined){
		alert("内容不能为空!");
		return false;
	}else{
		alert("能提交!");
		return true;
	}
}
</script>
<script type="text/javascript">
	 
	function changeNewsPage(p,newsid) {
		//改变页数
		document.getElementById("pageNo").value = Math.floor(p);
		p = Math.floor(p);
		window.location.href = "pages/front/comment_list.action?pageNo="+p+"&comment.news.newsid="+newsid;
	}
	 
</script>
</head>
<body>
	<!-- 登陆和注册界面 -->
	<jsp:include page="login_reg.jsp"></jsp:include>
	 <!-- 导航栏 -->
    <jsp:include page="head.jsp"></jsp:include>
    
	<!--主体内容-->
	<c:if test="${!empty news }">
		<div class="container bg-info" style="margin-top: 51px;">
			<div style="margin-top: 100px;">
				<!--标题-->
				<div
					style="text-align: center;margin: 0 auto;font-family: '微软雅黑'; font-size: 20px;">
					${news.title }</div>
				<!--内容-->
				<div style="margin-top: 30px;">${news.content}</div>
				<!--浏览量-->
				<div class="pull-right"
					style="margin-top: 30px;margin-bottom: 30px;">
					浏览量: <font color="#B5002A">10</font>
				</div>
				<!--评论-->
				<div style="margin-top: 100px;margin-left: 20px;">
					<font color="#5A62FB" style="font-size: 16px;">网友评论</font>&nbsp;&nbsp;
					<font color="#999999">文明上网,理性发言</font> <font color="#B5002A"
						class="pull-right">4条评论</font>
				</div>
				<form action="pages/front/comment_insert.action" method="post">
					<div>
						<!--内容框-->
						<textarea rows="3" cols="2" class="form-control" value="发表你的观点吧"
							name="comment.commentContent" id="content"></textarea>
						<input type="submit" value="发表" class="pull-right btn btn-info"
							style="width: 100px; margin-top: 5px;margin-bottom:20px;border: none;"
							onclick="return isEmpty()" /> <input type="hidden"
							name="comment.news.newsid" value="${news.newsid}" /> <input
							type="hidden" name="comment.user.userid" value="${user.userid}" />
						<input type="hidden" name="comment.commentTitle"
							value="${news.title}" /> <input type="hidden"
							name="comment.commentDate"
							value="<%=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())%>" />
						<font color="#5A62FB" style="font-size:12px;">${message}</font>
					</div>
				</form>
				<h4>评论区：</h4>
				<!--评论列表-->
				<c:if test="${empty allComment }">
					<ul class="list-group" style=" margin-top:0px;">
						<li class="list-group-item">暂无评论，抢个沙发吧！</li>
					</ul>
				</c:if>
				<c:if test="${!empty allComment }">
					<ul class="list-group" style="">
						<c:forEach var="c" items="${allComment}">
							<li class="list-group-item">
								<h4>${c.user.name}[${c.user.address}网友]</h4>
								<p>${c.commentContent}</p>
								<h6>${c.commentDate}</h6>
							</li>
						</c:forEach>
					</ul>
					<!-- 分页部分 -->
					<nav class="pull-right" style="margin-right:30px;"> <input
						type="hidden" id="pageNo" name="pageNo" value="${pageNo}" /> <input
						type="hidden" id="pageSize" name="pageSize" value="${pageSize}" />
					<ul class="pagination">
						<li><input type="button" value="首页"
							${pageNo==1?"disabled":""} onclick="changeNewsPage(1,${comment.news.newsid})"
							class="btn btn-primary"  style="withd:30px"/></li>
						<li></span><input type="button" value="上一页"
							${pageNo==1?"disabled":""} onclick="changeNewsPage(${pageNo-1},${comment.news.newsid})"
							class="btn btn-success" /></li>
						<li><input type="button" value="下一页"
							${(count - 1) / pageSize<pageNo?"disabled":""}
							onclick="changeNewsPage(${pageNo+1},${comment.news.newsid})" class="btn btn-info" /></li>
						<li><input type="button" value="尾页"
							${(count - 1) / pageSize<pageNo?"disabled":""}
							onclick="changeNewsPage(${(count - 1) / pageSize + 1},${comment.news.newsid})"
							class="btn btn-primary" /></li>
					</ul>
					</nav>
				</c:if>

			</div>
		</div>
	</c:if>
	<!--底部-->
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>
