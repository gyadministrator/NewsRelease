<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<!--
	后台新闻管理的主界面
	-->
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<title>新闻发布系统管理后台</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
@media ( min-width : 768px) {
	#slider_sub {
		width: 250px;
		margin-top: 51px;
		position: absolute;
		z-index: 1;
		height: 500px;
	}
}
</style>
<script type="text/javascript">
	function front() {
		window.location.href = "pages/front/front_comment.jsp";
	}
	function login() {
		window.location.href = "pages/back/back_login.jsp";
	}
	function changeNewsPage(p) {
		//改变页数
		document.getElementById("pageNo").value = Math.floor(p);
		p = Math.floor(p);
		window.location.href = "pages/back/news_findNewsAll.action?pageNo=" + p
				+ "";
	}
	function changeUserPage(p) {
		//改变页数
		document.getElementById("pageNo").value = Math.floor(p);
		p = Math.floor(p);
		window.location.href = "pages/back/user_list.action?pageNo=" + p + "";
	}
</script>
</head>

<body>
	<!--导航栏-->
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div>
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="pages/back/back_index.jsp">后台管理中心</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<button type="button" class="btn btn-info navbar-btn"
				onclick="front()">
				<span class="glyphicon glyphicon-th"></span>&nbsp;前台首页
			</button>
			<button type="button" class="btn btn-primary navbar-btn">
				<span class="glyphicon glyphicon-wrench"></span>&nbsp;清除缓存
			</button>
			<a href="pages/back/news_back.action"
				class="btn btn-primary navbar-btn"
				onclick="return window.confirm('你确定要退出吗？');"> <span
				class="glyphicon glyphicon-off"></span>&nbsp;退出登录
			</a>

			<!--用户选择-->
			<div class="pull-right" style="margin-right: 60px;margin-top: 15px;">
				<font color="blue" style="font-size: 16px;">当前管理员:${user.name}
				</font>
			</div>
		</div>
	</div>
	</nav>
	<!--左边菜单栏-->
	<div class="row">
		<div class="col-md-3">
			<div class="navbar-default navbar-collapse" id="slider_sub"
				style="margin-top: 60px;">
				<ul class="nav">
					<li>
						<!-- 搜索功能 --> <!-- 查询到的用户不为空 --> <c:if test="${allUser!=null}">
							<form action="pages/back/user_findUserByKey.action" method="post">
								<div class="input-group mysearch">
									<input type="text" name="keyword" class="form-control"
										placeholder="请输入用户关键字" /> <span class="input-group-btn">
										<button type="submit" class="btn btn-info form-control">
											<span class="glyphicon glyphicon-search"></span>
										</button>
									</span>
								</div>
							</form>
						</c:if> <!-- 查询出新闻不为空 --> <c:if test="${allNews!=null}">
							<form action="pages/back/news_findNewsByKey.action" method="post">
								<div class="input-group mysearch">
									<input type="text" name="keyword" class="form-control"
										placeholder="请输入用户关键字" /> <span class="input-group-btn">
										<button type="submit" class="btn btn-info form-control">
											<span class="glyphicon glyphicon-search"></span>
										</button>
									</span>
								</div>
							</form>
						</c:if>
					</li>
					<!--  -->
					<li><a href="#sub2" class="collapse" data-toggle="collapse"><span
							class="glyphicon glyphicon-home pull-left"></span>新闻管理<span
							class="glyphicon glyphicon-chevron-right pull-right"></span></a>
						<ul id="sub2" class="nav collapse">
							<li><a href="pages/back/news_allNewsType.action"><span
									class="glyphicon glyphicon-info-sign pull-left"></span>&nbsp;添加新闻</a>
							</li>
							<li><a href="pages/back/news_findNewsAll.action"><span
									class="glyphicon glyphicon-chevron-right pull-left"></span>查看新闻</a></li>

						</ul></li>
					<!--  -->
					<li><a href="#sub5" class="collapse" data-toggle="collapse"><span
							class="glyphicon glyphicon-user pull-left"></span>用户管理<span
							class="glyphicon glyphicon-chevron-right pull-right"></span></a>
						<ul id="sub5" class="nav collapse">
							<li><a href="pages/back/user_list.action"><span
									class="glyphicon glyphicon-list-alt pull-left"></span>&nbsp;查看所有用户</a>
							</li>
						</ul></li>
					<!--  -->
					</li>
				</ul>
			</div>
		</div>
	</div>
	<!--中间内容部分-->

	<!-- 所有的用户 -->
	<c:if test="${allUser!=null}">
		<div id="user"
			style="background: #DBDBDB;margin-left:
	270px;margin-top: 60px;">
			<!-- 内容部分 -->
			<table class="table table-condensed">
				<thead>
					<tr>
						<th>序号</th>
						<th>用户名</th>
						<th>密码</th>
						<th>性别</th>
						<th>地址</th>
						<th>注册时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allUser}" var="u">
						<tr class="info">
							<td>${u.userid}</td>
							<td>${u.name}</td>
							<td>${u.password}</td>
							<td>${u.sex}</td>
							<td>${u.address}</td>
							<td>${u.registerDate}</td>
							<td><a
								href="pages/back/user_delete.action?user.userid=${u.userid}"
								onclick="return window.confirm('你确定要删除这个用户吗?')"><span
									class="glyphicon glyphicon-trash"></span>&nbsp;删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 分页 -->
			<nav class="pull-right" style="margin-right:30px;"> <input
				type="hidden" id="pageNo" name="pageNo" value="${pageNo}" /> <input
				type="hidden" id="pageSize" name="pageSize" value="${pageSize}" />
			<ul class="pagination">
				<li><input type="button" value="首页" ${pageNo==1?"disabled":""}
					onclick="changeUserPage(1)" class="btn btn-primary" /></li>
				<li></span><input type="button" value="上一页" ${pageNo==1?"disabled":""}
					onclick="changeUserPage(${pageNo-1})" class="btn btn-success" /></li>
				<li></span><input type="button" value="下一页"
					${(count - 1) / pageSize<pageNo?"disabled":""}
					onclick="changeUserPage(${pageNo+1})" class="btn btn-info" /></li>
				<li><input type="button" value="尾页"
					${(count - 1) / pageSize<pageNo?"disabled":""}
					onclick="changeUserPage(${(count - 1) / pageSize + 1})"
					class="btn btn-primary" /></li>
			</ul>
			</nav>
		</div>
	</c:if>
	<!-- 更新新闻 -->
	<c:if test="${allType!=null}">
		<div style="margin-left:270px;margin-top: 60px;" class="row">
			<!-- 内容部分 -->
			<div class="col-md-6">
				<s:form action="pages/back/news_update.action" method="post"
					enctype="multipart/form-data" namespace="/pages/back"
					theme="simple">
					<s:hidden name="news.newsid" />
					<div>
						<font color="blue">新闻标题:</font><br />
						<s:textarea name="news.title" cols="50" rows="5" />
						<br /> <br />
					</div>
					<div>
						<font color="blue">新闻内容:</font><br />
						<s:textarea name="news.content" class="form-control" cols="100"
							rows="6" />
						<br /> <br />
					</div>
					<div>
						<font color="blue">新闻图片:</font><br />
						<s:file name="photo"></s:file>
						<br /> <img class="img-responsive"
							src="upload/${news.photo==null?'default.png':news.photo}"
							width="100" height="75" /><br /> <br />
					</div>
					<div>
						请选择新闻的类型:
						<s:select name="news.newstype.typeid" list="allType"
							listKey="typeid" listValue="typeName"></s:select>
						<br /> <br />
					</div>
					<s:submit value="修改"
						style="width: 160px;height: 30px;background-color: #30C37C;border:none;" />
				</s:form>
			</div>
		</div>
	</c:if>
	<!-- 显示新闻 -->
	<c:if test="${allNews!=null}">
		<div
			style="background: #DBDBDB;margin-left:
	270px;margin-top: 60px;">
			<!-- 内容部分 -->
			<table class="table table-condensed">
				<thead>
					<tr>
						<th>序号</th>
						<th>新闻标题</th>
						<th>新闻内容</th>
						<th>新闻类型</th>
						<th>发布时间</th>
						<th>点击量</th>
						<th>新闻图片</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allNews}" var="n">
						<tr class="info">
							<td>${n.newsid}</td>
							<td>${n.title}</td>
							<td>${n.content}</td>
							<td>${n.newstype.typeName}</td>
							<td>${n.pubDate}</td>
							<td>${n.clickNum}</td>
							<td><img class="img-responsive"
								src="upload/${n.photo==null?'default.png':n.photo}" width="100"
								height="75" /></td>
							<td><a
								href="pages/back/news_delete.action?news.newsid=${n.newsid}"
								onclick="return window.confirm('你确定要删除这条新闻吗?')"><span
									class="glyphicon glyphicon-trash"></span>&nbsp;删除</a> <a
								href="pages/back/news_updatePre.action?news.newsid=${n.newsid}"><span
									class=""></span><span class="glyphicon glyphicon-edit"></span>修改</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 分页 -->
			<nav class="pull-right" style="margin-right:30px;"> <input
				type="hidden" id="pageNo" name="pageNo" value="${pageNo}" /> <input
				type="hidden" id="pageSize" name="pageSize" value="${pageSize}" />
			<ul class="pagination">
				<li><input type="button" value="首页" ${pageNo==1?"disabled":""}
					onclick="changeNewsPage(1)" class="btn btn-primary" /></li>
				<li></span><input type="button" value="上一页" ${pageNo==1?"disabled":""}
					onclick="changeNewsPage(${pageNo-1})" class="btn btn-success" /></li>
				<li><input type="button" value="下一页"
					${(count - 1) / pageSize<pageNo?"disabled":""}
					onclick="changeNewsPage(${pageNo+1})" class="btn btn-info" /></li>
				<li><input type="button" value="尾页"
					${(count - 1) / pageSize<pageNo?"disabled":""}
					onclick="changeNewsPage(${(count - 1) / pageSize + 1})"
					class="btn btn-primary" /></li>
			</ul>
			</nav>
		</div>
	</c:if>
</body>
</html>
