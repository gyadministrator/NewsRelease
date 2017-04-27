<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.text.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login_reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page"> 
<link rel="stylesheet" href="css/style.css" />
<script src="js/login.js"></script>
<script>
	function loginOut() {
		var flag = confirm("你确定要退出吗？");
		if (flag) {			
	        window.location.href = "pages/front/loginOut.jsp";
			return true;
		}
	}
</script>
<script>
	function noReg() {
		
			$('.modal-bg').fadeOut();
			$('#modal').css('display', 'none');
			$('#modal').fadeOut();
			
			$('#modal1').css('display', 'block');
			$('.modal-bg1').fadeIn();
	}
</script>

</head>
  
  <body>
   	<!--用户登录-->
	 
	<div class="modal-bg" style="display: none;">
		<div id="modal">
			<span>请登录&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">${message_login}</font><a href="javascript:login()" id="close">×</a></span>
			<form action="pages/back/user_fontLogin.action" method="post">
				<input id="username" name="user.name" type="textbox"
					placeholder="请输入用户名" required> <input id="password"
					name="user.password" type="password" placeholder="请输入密码" required>
				<!-- 验证码 -->
				<input type="text" placeholder="请输入右侧验证码" name="verifyCode"
					style="width:190px;" /> <img
					src="code.action" onclick="changeValidateCode(this)"
					style="height:36px;width:50px;margin-left:-15px" />
			     <a id="forgot-link" href="javascript:noReg()">没有账号?</a>
			      <input type="submit"
					value="登录" style="width:80px;border: none;font-family:'微软雅黑';float: right;background: #0FC491;margin-top: 15px;" />
					<input  
					name="url" type="hidden" value="<%=request.getRequestURI()%>" required>
			</form>		
		</div>		
	</div>
	<!-- 用户注册 -->
	<div class="modal-bg1" style="display: none;">
		<div id="modal1">
			<span>欢迎注册 &nbsp;&nbsp;&nbsp;&nbsp;<font color="red">${message_reg}</font><a href="javascript:reg()" id="close1">×</a></span>
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
					<input  
					name="url" type="hidden" value="<%=request.getRequestURI()%>" required>
			</form>
		</div>	
	</div>
  </body>
</html>
