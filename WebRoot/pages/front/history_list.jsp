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
 <script type="text/javascript">
	function changeValidateCode(obj) {
		//获取当前的时间作为参数，无具体意义     
		var timenow = new Date().getTime();
		//每次请求需要一个不同的参数，否则可能会返回同样的验证码     
		//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。     
		obj.src = "getRandomPictrue?d=" + timenow; 
		window.location.href = "pages/front/front_index.jsp";
	}
</script>
<script type="text/javascript">
	function changeValidateCode(obj) {
		//获取当前的时间作为参数，无具体意义     
		var timenow = new Date().getTime();
		//每次请求需要一个不同的参数，否则可能会返回同样的验证码     
		//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。     
		obj.src = "getRandomPictrue?d=" + timenow; 
		window.location.href = "pages/front/front_index.jsp";
		 
	}

</script>
<script type="text/javascript">
	function changeHistoryPage(p,userid) {
		//改变页数
		document.getElementById("pageNo").value = Math.floor(p);
		p = Math.floor(p);
		window.location.href = "pages/front/history_one.action?pageNo="+p+"&history.user.userid="+userid;
	}
</script>
</head>

<body>

  <!-- 包含登陆和注册界面 -->
  <jsp:include page="login_reg.jsp"></jsp:include>
  <!-- 导航 -->
  <jsp:include page="head.jsp"></jsp:include>

    <!-- 主体内容 -->
	<c:if test="${allHistory!=null}">
		<div class="information" style="margin-top:50px">
			<div class="container">
				<div class="row">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th>新闻标题</th>
								<th>浏览时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allHistory}" var="u">
								<tr class="info">


									<td>${u.news.title}</td>
									<td>${u.searchDate}</td>
									<td><a
										href="pages/front/history_deletetwo.action?history.historyid=${u.historyid}&history.user.userid=${user.userid}"
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
						<li><input type="button" value="首页"
							${pageNo==1?"disabled":""}
							onclick="changeHistoryPage(1,${user.userid })"
							class="btn btn-primary" /></li>
						<li></span><input type="button" value="上一页"
							${pageNo==1?"disabled":""}
							onclick="changeHistoryPage(${pageNo-1},${user.userid })"
							class="btn btn-success" /></li>
						<li><input type="button" value="下一页"
							${(count - 1) / pageSize<pageNo?"disabled":""}
							onclick="changeHistoryPage(${pageNo+1},${user.userid })"
							class="btn btn-info" /></li>
						<li><input type="button" value="尾页"
							${(count - 1) / pageSize<pageNo?"disabled":""}
							onclick="changeHistoryPage(${(count - 1) / pageSize + 1},${user.userid })"
							class="btn btn-primary" /></li>
					</ul>
					</nav>

				</div>
			</div>
		</div>
	</c:if>

	<!--底部-->
 <!--底部-->
<jsp:include page="footer.jsp"></jsp:include>
 
</body>
</html>
