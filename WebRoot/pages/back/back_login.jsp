<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<!--
	新闻发布系统的后台管理登录页面
-->
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<title>新闻发布系统管理后台</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	function changeValidateCode(obj) {
		//获取当前的时间作为参数，无具体意义     
		var timenow = new Date().getTime();
		//每次请求需要一个不同的参数，否则可能会返回同样的验证码     
		//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。     
		obj.src = "getRandomPictrue?d=" + timenow; 
		window.location.href = "pages/back/back_login.jsp";
	}
</script>
<script type="text/javascript">
	function checkUserName(obj) {
		var username = obj;
		var checkUserNameResult = document
				.getElementById("checkUserNameResult");
		if (username.trim().length == 0) {
			checkUserNameResult.innerHTML = "用户名不能为空";
			obj.focus();
		} else {
			checkUserNameResult.innerHTML = "";
		}
	}

	function checkPassword(obj) {
		var password = obj;
		var checkPasswordResult = document
				.getElementById("checkPasswordResult");
		if (password.trim().length == 0) {
			checkPasswordResult.innerHTML = "密码不能为空";
			obj.focus();
		} else {
			checkPasswordResult.innerHTML = "";
		}
	}
</script>




<style type="text/css">
.login {
	height: 450px;
	background: #BDCDEF;
	margin-top: 100px;
}

.form-group {
	margin-top: 25px;
}

input[type="submit"] {
	margin-top: 25px;
}

.title {
	padding-top: 10px;
}
</style>

</head>

<body background="images/bg.jpg">
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<!--登录的布局-->
			<div class="col-md-4 login">
				<span><h3 class="title">后台管理中心</h3></span>
				<!-- 用户提示 -->
				<s:if test="message!=null">
					<div class="alert alert-danger alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>提示:&nbsp;&nbsp;${message}</strong>
					</div>
				</s:if>
				<!-- 提示结束 -->
				<form action="pages/back/user_login.action" method="post">
					<!--用户名-->
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-user"></span>
							</div>
							<input type="text" placeholder="请输入用户名" class="form-control"
								name="user.name" onblur="checkUserName(this.value);" />
						</div>
						<span id="checkUserNameResult"
							style="color: red;margin-left:50px; "></span>
					</div>
					<!--密码-->
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-lock"></span>
							</div>
							<input type="password" placeholder="请输入密码" class="form-control"
								name="user.password" onblur="checkPassword(this.value);" />

						</div>
						<span id="checkPasswordResult"
							style="color: red;margin-left:50px;  "></span>
					</div>
					<!--验证码-->
					<div class="form-group">
						<div class="input-group">
							<input type="text" placeholder="请输入右侧验证码" class="form-control"
								name="verifyCode" />
							<div class="input-group-addon">
								<img src="code.action" onclick="changeValidateCode(this)"
									style="height: 20px;width: 50px" />
							</div>
						</div>
					</div>
					<!--登录按钮-->
					<input type="submit" value="登录" class="form-control btn btn-info" />
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>
