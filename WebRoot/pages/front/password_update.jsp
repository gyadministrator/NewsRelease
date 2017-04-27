<%@page import="com.newsrelease.pojo.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新闻发布系统</title>

</head>
<body>
	<!-- 包含登陆和注册界面 -->
  <jsp:include page="login_reg.jsp"></jsp:include>
  <!-- 导航栏 -->
  <jsp:include page="head.jsp"></jsp:include>
  <!-- 如果用户为空，请先登录 -->
   <c:if test="${empty user}">
		<script type="text/javascript">
			$('#modal').css('display', 'block');
			$('.modal-bg').fadeIn();
		</script>
	</c:if>
	<!--主体内容-->
	<div class="divcenter" style="background:rgb(255,255,255);margin-bottom:200px;">
		<div style="margin:0 auto;margin-top: 100px;width:300px">
		<form action="pages/back/user_passwordUpdate.action" method="post">
				<ul class="list-group" style="width:300px;border: none">
					<li class="list-group-item" style="">旧密码:&nbsp;&nbsp;&nbsp;<input type="password" name="old_password" style="width:150px;height:30px;"></li>	
					<li class="list-group-item" style="">新密码:&nbsp;&nbsp;&nbsp;<input type="password" name="new_password" style="width:150px;height:30px"></li>
					<li class="list-group-item" style="">确&nbsp;&nbsp;&nbsp;认:&nbsp;&nbsp;&nbsp;<input type="password" name="confirm_password" style="width:150px;height:30px"></li>	
					<li class="list-group-item" style="text-align:center"><input
					type="submit" value="修改"
					style="border: none;font-family:'微软雅黑';background: #0FC491;color:rgb(252,253,255)">
					<input type="hidden" name="user.userid" style="width:150px;height:30px;" value="${user.userid }">
					<input type="hidden" name="user.password" style="width:150px;height:30px;" value="${user.password }">
					<font color="#0FC491">${message}</font></li>
					 
				</ul>
		</form>
		</div>
	</div>
	<!--底部-->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

