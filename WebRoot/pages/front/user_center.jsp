<%@page import="com.newsrelease.pojo.User"%>
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
<title>新闻网</title>
<body>
	<!-- 包含登陆和注册界面 -->
  <jsp:include page="login_reg.jsp"></jsp:include>	
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
				<ul class="list-group" style="width:300px;">
					<li class="list-group-item" style=""><span class="badge">${user.name }</span> 用户名:</li>
					<li class="list-group-item"><span class="badge">${user.sex }</span>
						性&nbsp;&nbsp;&nbsp;别:</li>
					<li class="list-group-item"><span class="badge">${user.age }</span>
						年&nbsp;&nbsp;&nbsp;龄:</li>
					<li class="list-group-item"><span class="badge">${user.address }</span>
						地&nbsp;&nbsp;&nbsp;址:</li>
					<li class="list-group-item" style="text-align:center"><a
						href="pages/front/user_update.jsp">编辑信息</a></li>
					<li class="list-group-item" style="text-align:center"><a
						href="pages/front/password_update.jsp">修改密码</a></li>
					<li class="list-group-item" style="text-align:center"><a
						href="pages/front/history_one.action?history.user.userid=${user.userid }">浏览历史</a></li>
					<li class="list-group-item" style="text-align:center"><a
						href="pages/front/password_update.jsp">我的收藏</a></li>
				</ul>
		</div>
	</div>
	<!--底部-->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

