<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ page import="java.text.*"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<title>新闻发布系统</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<script src='//zaole.net/sliding.js'></script>
<script src="//assets.codepen.io/assets/common/stopExecutionOnTimeout-6c99970ade81e43be51fa877be0f7600.js"></script>

<script>

	function login() {
		$("#loginBtn").click(function() {
			$('#modal').css('display', 'block');
			$('.modal-bg').fadeIn();
		});
		$('#close').click(function() {
			$('.modal-bg').fadeOut();
			$('#modal').fadeOut();
			return false;
		});
	}
	
	function reg() {
		$("#regBtn").click(function() {
			$('#modal1').css('display', 'block');
			$('.modal-bg1').fadeIn();
		});
		$('#close1').click(function() {
			$('.modal-bg1').fadeOut();
			$('#modal1').fadeOut();
			return false;
		});
	}
	
	function loginOut(){
		var flag=confirm("你确定要退出吗？");
		if(flag){
			<% session.removeAttribute("user");%>
			window.location.href="pages/front/front_comment.jsp";
			return true;
		}	
	}
	
	
</script>

</head>
<body>
	<!--用户登录-->
	 
	<div class="modal-bg" style="display: none;">
		<div id="modal">
			<span>请登录&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">${message_login}</font><a href="#close" id="close">×</a></span>
			<form action="pages/back/user_fontLogin.action" method="post">
				<input id="username" name="user.name" type="textbox"
					placeholder="请输入用户名" required> <input id="password"
					name="user.password" type="password" placeholder="请输入密码" required>
				<a id="forgot-link" href="#">没有账号?</a> <input type="submit"
					value="登录" style="width:80px;border: none;font-family:'微软雅黑';float: right;background: #0FC491;margin-top: 15px;" />
			</form>
		</div>
	</div>
	<!-- 用户注册 -->
	<div class="modal-bg1" style="display: none;">
		<div id="modal1">
			<span>欢迎注册 &nbsp;&nbsp;&nbsp;&nbsp;<font color="red">${message_reg}</font><a href="#close" id="close1">×</a></span>
			<form action="pages/back/user_insert.action" method="post">
				<input id="username" name="user.name" type="textbox"
					placeholder="请输入用户名" required style="margin-top:-10px"> 
			    <input  
					name="user.userType" type="hidden" value="0" required>
					<input  
					name="user.dateStr" type="hidden" value="<%=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())%>" required>
				<input id="password"
					name="user.password" type="password" placeholder="请输入密码" required>
			    <input id="password"
					name="confirm_password" type="password" placeholder="确认密码" required>
				<input type="submit"
					value="注册" style="width:80px;border: none;font-family:'微软雅黑';float:left;background: #0FC491;margin-left:100px;margin-top:0px;" />
			</form>
		</div>
	</div>
	
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
				<li class="active"><a href="pages/front/front_index.jsp">首页</a></li>
				<li><a href="#">国内</a></li>
				<li><a href="#">国际</a></li>
				<li><a href="#">体育</a></li>
				<li><a href="#">娱乐</a></li>
				<li><a href="#">游戏</a></li>
				<li><a href="pages/back/back_login.jsp">后台管理</a></li>
			</ul>
			<%-- <c:if test="${empty user}">
				<script type="text/javascript">
				confirm("用户为空");
					$('#modal').css('display', 'block');
					$('.modal-bg').fadeIn();
				</script>
			</c:if> --%>
			<!-- 用户以登陆，显示用户管理中心块 -->
			 
			<c:if test="${empty user}">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"
							role="button" aria-haspopup="true" aria-expanded="false">
							${user.name}
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="#">个人中心</a>
							</li>
							<li>
								<a href="#">密码修改</a>
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
	<!--主体内容-->
	<div class="divcenter" style="background:rgb(255,255,255);margin-bottom:200px;">
		<div style="margin:0 auto;margin-top: 100px;width:300px">
				<ul class="list-group" style="width:300px;">
					<li class="list-group-item" style=""><span class="badge">张三</span> 用户名:</li>
					<li class="list-group-item"><span class="badge">男</span>
						性&nbsp;&nbsp;&nbsp;别:</li>
					<li class="list-group-item"><span class="badge">20</span>
						年&nbsp;&nbsp;&nbsp;龄:</li>
					<li class="list-group-item"><span class="badge">贵阳</span>
						地&nbsp;&nbsp;&nbsp;址:</li>
					<li class="list-group-item" style="text-align:center"><a
						href="pages/front/user_update.jsp">编辑信息</a></li>
					<li class="list-group-item" style="text-align:center"><a
						href="#">修改密码</a></li>
				</ul>
		</div>
	</div>
	<!--底部-->
	<div style="text-align: center;margin: 0 auto;">
		<footer>
		<div>
			<p>
				<a href="#">关于我们</a> | <a href="#">联系我们</a> | <a href="#">使用帮助</a> |
				<a href="#">用户协议</a> | <a href="#">iPhone/iPad Android</a>
			</p>
			<p>
				<a href="#">地址：贵州省贵阳市花溪区贵州大学北校区野猪林</a> | <a href="#">联系电话：0851-1234567</a>
			</p>
		</div>
		</footer>
	</div>
	
	
</body>
</html>

