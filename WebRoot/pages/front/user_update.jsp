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
<title>新闻发布系统</title>
</head>
<body>
	<!-- 包含登陆和注册界面 -->
	<jsp:include page="login_reg.jsp"></jsp:include>
	<!--导航-->
	<jsp:include page="head.jsp"></jsp:include>
	<!-- 如果用户为空，请先登录 -->
	<c:if test="${empty user}">
		<script type="text/javascript">
			$('#modal').css('display', 'block');
			$('.modal-bg').fadeIn();
		</script>
	</c:if>
	<!-- 主体 -->
	<div class="divcenter" style="background:rgb(255,255,255);margin-bottom:200px;">
		<div style="margin:0 auto;margin-top: 100px;width:300px">
		<form action="pages/back/user_update.action" method="post">
			<ul class="list-group" style="width:300px;">
				<li class="list-group-item" style="">
				 用户名:&nbsp;&nbsp; <input type="text" name="user.name" value="${user.name }" style="width:150px;height:30px" readonly="true">
				 </li>
				<li class="list-group-item">性&nbsp;&nbsp;&nbsp;别:&nbsp;&nbsp; <select
					style="width:48px" name="user.sex">
						<option value="男"
							<c:if test="${user.sex==男}">selected="selected"</c:if>>男</option>
						<option value="女"
							<c:if test="${user.sex==女}">selected="selected"</c:if>>女</option>
				</select>
				</li>
				<li class="list-group-item">年&nbsp;&nbsp;&nbsp;龄:&nbsp;&nbsp; <select
					name="user.age"><c:forEach var="i" begin="1" end="120">
							<option value="${i }"
								<c:if test="${user.age==i}">selected="selected"</c:if>>${i }</option>
						</c:forEach>
				</select>
				</li>
				<li class="list-group-item">地&nbsp;&nbsp;&nbsp;址:&nbsp;&nbsp;<input
					type="text" name="user.address" value="${user.address }"
					style="width:150px;height:30px"> 
					<input
					name="user.userType" type="hidden" value="0" required> <input
					name="user.dateStr" type="hidden" value="${user.dateStr}" required>
					<input
					name="user.userid" type="hidden" value="${user.userid }" required> <input
					name="user.password" type="hidden" value="${user.password}" required>
				</li>

				<li class="list-group-item" style="text-align:center"><input
					type="submit" value="修改"
					style="border: none;font-family:'微软雅黑';background: #0FC491;color:rgb(252,253,255)"></li>
				 
			</ul>
			</form>
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

