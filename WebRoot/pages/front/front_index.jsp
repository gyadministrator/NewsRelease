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
  <!-- 包含登陆和注册界面 -->
  <jsp:include page="login_reg.jsp"></jsp:include>
<!--导航-->
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="navbar" >
            <ul class="nav navbar-nav">
                <li class="active"><a href="pages/front/front_index.jsp">首页</a></li>
                <li><a href="#">国内</a> </li>
                <li><a href="#">国际</a> </li>
                <li><a href="#">体育</a> </li>
                <li><a href="#">娱乐</a> </li>
                <li><a href="#">游戏</a> </li>
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
			<!-- 用户已登陆，显示用户管理中心块 -->		 
			<c:if test="${!empty user}">
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
							<li>
								<a href="">密码修改</a>
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


<!--主体-->
<div class="information">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/1.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">日媒：日本两护卫舰或将与美航母举行联合训练</h4></a>
                        <p class="media-middle">
                            国际新闻&nbsp;&nbsp;护卫舰&nbsp;&nbsp;防卫省&nbsp;&nbsp;美国航母
                        </p>
                        <div class="media-bottom">

                            <p>6小时前&nbsp;&nbsp;评论 0</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/2.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">意大利修正遗嘱法案 尊重病人选择“安乐死”</h4></a>
                        <p class="media-middle">
                            国际新闻&nbsp;&nbsp;安乐死&nbsp;&nbsp;意大利&nbsp;&nbsp;遗嘱
                        </p>
                        <div class="media-bottom">

                            <p>8小时前&nbsp;&nbsp;评论 2</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/3.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">女子车窗抛物并辱骂环卫工 城管已将其找到拟处罚</h4></a>
                        <p class="media-middle">
                            国内新闻&nbsp;&nbsp;环卫工&nbsp;&nbsp;车窗抛物&nbsp;&nbsp;城管
                        </p>
                        <div class="media-bottom">

                            <p>2小时前&nbsp;&nbsp;评论 258</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/4.jpg" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">沉迷游戏的少年:我和德玛西亚最后的告别</h4></a>
                        <p class="media-middle">
                            游戏新闻&nbsp;&nbsp;英雄联盟&nbsp;&nbsp;教育&nbsp;&nbsp;感想
                        </p>
                        <div class="media-bottom">

                            <p>2小时前&nbsp;&nbsp;评论 852</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/1.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">日媒：日本两护卫舰或将与美航母举行联合训练</h4></a>
                        <p class="media-middle">
                            国际新闻&nbsp;&nbsp;护卫舰&nbsp;&nbsp;防卫省&nbsp;&nbsp;美国航母
                        </p>
                        <div class="media-bottom">

                            <p>6小时前&nbsp;&nbsp;评论 0</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/2.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">意大利修正遗嘱法案 尊重病人选择“安乐死”</h4></a>
                        <p class="media-middle">
                            国际新闻&nbsp;&nbsp;安乐死&nbsp;&nbsp;意大利&nbsp;&nbsp;遗嘱
                        </p>
                        <div class="media-bottom">

                            <p>8小时前&nbsp;&nbsp;评论 2</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/3.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">女子车窗抛物并辱骂环卫工 城管已将其找到拟处罚</h4></a>
                        <p class="media-middle">
                            国内新闻&nbsp;&nbsp;环卫工&nbsp;&nbsp;车窗抛物&nbsp;&nbsp;城管
                        </p>
                        <div class="media-bottom">

                            <p>2小时前&nbsp;&nbsp;评论 258</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/4.jpg" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">沉迷游戏的少年:我和德玛西亚最后的告别</h4></a>
                        <p class="media-middle">
                            游戏新闻&nbsp;&nbsp;英雄联盟&nbsp;&nbsp;教育&nbsp;&nbsp;感想
                        </p>
                        <div class="media-bottom">

                            <p>2小时前&nbsp;&nbsp;评论 852</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/1.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">日媒：日本两护卫舰或将与美航母举行联合训练</h4></a>
                        <p class="media-middle">
                            国际新闻&nbsp;&nbsp;护卫舰&nbsp;&nbsp;防卫省&nbsp;&nbsp;美国航母
                        </p>
                        <div class="media-bottom">

                            <p>6小时前&nbsp;&nbsp;评论 0</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/2.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">意大利修正遗嘱法案 尊重病人选择“安乐死”</h4></a>
                        <p class="media-middle">
                            国际新闻&nbsp;&nbsp;安乐死&nbsp;&nbsp;意大利&nbsp;&nbsp;遗嘱
                        </p>
                        <div class="media-bottom">

                            <p>8小时前&nbsp;&nbsp;评论 2</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/3.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">女子车窗抛物并辱骂环卫工 城管已将其找到拟处罚</h4></a>
                        <p class="media-middle">
                            国内新闻&nbsp;&nbsp;环卫工&nbsp;&nbsp;车窗抛物&nbsp;&nbsp;城管
                        </p>
                        <div class="media-bottom">

                            <p>2小时前&nbsp;&nbsp;评论 258</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/4.jpg" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">沉迷游戏的少年:我和德玛西亚最后的告别</h4></a>
                        <p class="media-middle">
                            游戏新闻&nbsp;&nbsp;英雄联盟&nbsp;&nbsp;教育&nbsp;&nbsp;感想
                        </p>
                        <div class="media-bottom">

                            <p>2小时前&nbsp;&nbsp;评论 852</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/1.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">日媒：日本两护卫舰或将与美航母举行联合训练</h4></a>
                        <p class="media-middle">
                            国际新闻&nbsp;&nbsp;护卫舰&nbsp;&nbsp;防卫省&nbsp;&nbsp;美国航母
                        </p>
                        <div class="media-bottom">

                            <p>6小时前&nbsp;&nbsp;评论 0</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/2.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">意大利修正遗嘱法案 尊重病人选择“安乐死”</h4></a>
                        <p class="media-middle">
                            国际新闻&nbsp;&nbsp;安乐死&nbsp;&nbsp;意大利&nbsp;&nbsp;遗嘱
                        </p>
                        <div class="media-bottom">

                            <p>8小时前&nbsp;&nbsp;评论 2</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/3.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">女子车窗抛物并辱骂环卫工 城管已将其找到拟处罚</h4></a>
                        <p class="media-middle">
                            国内新闻&nbsp;&nbsp;环卫工&nbsp;&nbsp;车窗抛物&nbsp;&nbsp;城管
                        </p>
                        <div class="media-bottom">

                            <p>2小时前&nbsp;&nbsp;评论 258</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/4.jpg" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">沉迷游戏的少年:我和德玛西亚最后的告别</h4></a>
                        <p class="media-middle">
                            游戏新闻&nbsp;&nbsp;英雄联盟&nbsp;&nbsp;教育&nbsp;&nbsp;感想
                        </p>
                        <div class="media-bottom">

                            <p>2小时前&nbsp;&nbsp;评论 852</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/1.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">日媒：日本两护卫舰或将与美航母举行联合训练</h4></a>
                        <p class="media-middle">
                            国际新闻&nbsp;&nbsp;护卫舰&nbsp;&nbsp;防卫省&nbsp;&nbsp;美国航母
                        </p>
                        <div class="media-bottom">

                            <p>6小时前&nbsp;&nbsp;评论 0</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/2.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">意大利修正遗嘱法案 尊重病人选择“安乐死”</h4></a>
                        <p class="media-middle">
                            国际新闻&nbsp;&nbsp;安乐死&nbsp;&nbsp;意大利&nbsp;&nbsp;遗嘱
                        </p>
                        <div class="media-bottom">

                            <p>8小时前&nbsp;&nbsp;评论 2</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/3.png" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">女子车窗抛物并辱骂环卫工 城管已将其找到拟处罚</h4></a>
                        <p class="media-middle">
                            国内新闻&nbsp;&nbsp;环卫工&nbsp;&nbsp;车窗抛物&nbsp;&nbsp;城管
                        </p>
                        <div class="media-bottom">

                            <p>2小时前&nbsp;&nbsp;评论 258</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="media">
                    <div class="media-left">
                        <a href="#"><img src="images/4.jpg" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">沉迷游戏的少年:我和德玛西亚最后的告别</h4></a>
                        <p class="media-middle">
                            游戏新闻&nbsp;&nbsp;英雄联盟&nbsp;&nbsp;教育&nbsp;&nbsp;感想
                        </p>
                        <div class="media-bottom">

                            <p>2小时前&nbsp;&nbsp;评论 852</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!--底部-->
<footer id="footer">
    <div class="container">
        <p>
            关于我们 | 联系我们 | 使用帮助 | 用户协议 | iPhone/iPad Android
        </p>
        <p>
            地址：贵州省贵阳市花溪区贵州大学北校区野猪林 | 联系电话：0851-1234567
        </p>
    </div>
</footer>

</body>
</html>
