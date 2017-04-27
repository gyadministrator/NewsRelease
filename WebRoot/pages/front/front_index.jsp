<%@page import="org.apache.struts2.ServletActionContext"%>
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
	 
	function changeNewsPage(p) {
		//改变页数
		document.getElementById("pageNo").value = Math.floor(p);
		p = Math.floor(p);
		window.location.href = "pages/front/news_findNewsAll.action?pageNo=" + p
				+ "";
	}
	 
</script>
<style type="text/css">
  .media-body a:hover{
     text-decoration:underline;
   }
</style>
</head>

<body>
 
  <!-- 包含登陆和注册界面 -->
  <jsp:include page="login_reg.jsp"></jsp:include>
  <jsp:include page="head.jsp"></jsp:include>

<!--主体-->
<div class="information" style="margin-top:50px">
    <div class="container">
        <div class="row">
            <c:forEach items="${allNews}" var="news">
            <div class="col-md-6">
                <div class="media">
                    <!-- 图片 -->
                    <div class="media-left">
                        <a href="upload/${news.photo==null?'1.png':news.photo}"><img src="upload/${news.photo==null?'1.png':news.photo}" class="media-object"></a>
                    </div>
                    <div class="media-body">
                        <a href="pages/front/comment_newsShow.action?comment.news.newsid=${news.newsid}&history.news.newsid=${news.newsid}&history.user.userid=${user.userid}"><h4 class="media-heading">${news.title }</h4></a>
                        <p class="media-middle">
                            ${news.newstype.typeName}
                        </p>
                        <div class="media-bottom">

                            <p>${news.pubDate}&nbsp;&nbsp;评论 0</p>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
            
            <!-- 分页部分 -->
				<nav class="pull-right" style="margin-right:30px;"> <input
					type="hidden" id="pageNo" name="pageNo" value="${pageNo}" /> <input
					type="hidden" id="pageSize" name="pageSize" value="${pageSize}" />
				<ul class="pagination">
					<li><input type="button" value="首页" ${pageNo==1?"disabled":""}
						onclick="changeNewsPage(1)" class="btn btn-primary" /></li>
					<li></span><input type="button" value="上一页"
						${pageNo==1?"disabled":""} onclick="changeNewsPage(${pageNo-1})"
						class="btn btn-success" /></li>
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
    </div>
</div>

<!--底部-->
<jsp:include page="footer.jsp"></jsp:include>
  
</body>
</html>
