<%@page import="com.newsrelease.pojo.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新闻网</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/main.css"/>
<link rel="stylesheet" href="css/style.css" />
<script src='//zaole.net/sliding.js'></script>
<script src="//assets.codepen.io/assets/common/stopExecutionOnTimeout-6c99970ade81e43be51fa877be0f7600.js"></script>
<script src="js/jquery-3.2.0.min.js"></script>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script> 
</head>
  
  <body>
   
    <!--导航-->
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="navbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="pages/front/news_findNewsAll.action">首页</a></li>
				<li><a href="pages/front/news_findNewsByKey.action?keyword=3">国内</a></li>
				<li><a href="pages/front/news_findNewsByKey.action?keyword=2">国际</a></li>
				<li><a href="pages/front/news_findNewsByKey.action?keyword=1">体育</a></li>
				<li><a href="pages/front/news_findNewsByKey.action?keyword=5">娱乐</a></li>
				<li><a href="pages/front/news_findNewsByKey.action?keyword=4">专题</a></li>
				<li><a href="pages/back/back_login.jsp">后台管理</a></li>
			</ul>
			<c:if test="${empty user}">
				<ul class="nav navbar-nav navbar-right">

					<li style="margin-right:-25px">
						<a href="javascript:login()" id="loginBtn">登录</a>
						
					</li>
					<li >
						<a href="javascript:reg()" id="regBtn">注册</a>
					</li>

				</ul>
			</c:if>
			<!-- 用户以登陆，显示用户管理中心块 -->	 
			<c:if test="${!empty user }">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"
							role="button" aria-haspopup="true" aria-expanded="false">
							${user.name}
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="pages/front/user_center.jsp">个人中心</a>
							</li>
							<li role="separator" class="divider"></li>
							<li>
								<a onclick="loginOut()">退出</a>
							</li>

						</ul>
					</li>		
				</ul>
			</c:if>
		</div>
	</div>
	</nav>

    <!-- 登陆失败设置登陆页面显示 -->
	<c:if test="${!empty message_login }">
		<%
			session.removeAttribute("message_login");
		%>
		<script type="text/javascript">
			$('#modal').css('display', 'block');
			$('.modal-bg').fadeIn();
		</script>
	</c:if>
	 <!-- 注册失败设置注册页面显示 -->
	<c:if test="${!empty message_reg }">
		<%
			session.removeAttribute("message_reg");
		%>
		<script type="text/javascript">
			$('#modal1').css('display', 'block');
			$('.modal-bg1').fadeIn();
		</script>
	</c:if>
</body>
</html>
