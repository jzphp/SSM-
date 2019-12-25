<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的帖子</title>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/reset.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/homeHead.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/homePublic.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/myWrite.css"/>
</head>
<body>
<header class="zyHead">
    <div class="zyHead_cen">
        <a href="<%=basePath%>IndexServ"><img src="<%=basePath%>bbs/img/per-con.png" alt="" class="headPic1"/></a>
        <a href="<%=basePath%>BbsMainServ" class="backIndex">进入猿问</a>
        <a href="<%=basePath%>MainServ?model=car" class="backIndex">我的购物车</a>
        <!--未登入开始-->
        <c:if test="${user==null}">
        	<!--未登入开始-->
	        <div class="ltForm appear">
	            <a href=""><img src="<%=basePath%>bbs/img/indexForm_bg.png" alt="" class="headPic2"/></a>
	            <ul>
	                <li><a href="<%=basePath%>BbsMainServ">登入</a></li>
	                <li><a href="">注册</a></li>
	            </ul>
	        </div>
	        <!-- 未登入结束-->
	        
        </c:if>
        <c:if test="${user!=null }">
        	<!-- 登入开始，未登入时以下隐藏-->
	        <div class="lt_login appear">
		        <ul>
			        <li><a href="<%=basePath%>BbsbaseServ?type=home&uid=${user.getUID()}">${user.getUsername()}</a></li>
			        <li><a href="<%=basePath%>LoginOutServ?type=out">退出</a></li>
		        </ul>
	        </div>
        	<!-- 登入结束-->	
        </c:if>
        <!-- 登入结束-->
    </div>
</header>
<div class="homeCen">
    <div class="homeCen_left">
        <ul>
            <li><a href="<%=basePath%>BbsbaseServ">基本设置</a></li>
            <li class="on"><a href="<%=basePath%>MyWriteServ">我的贴子</a></li>
            <li><a href="<%=basePath%>MyOrderServ">我的订单</a></li>
            <c:if test="${user.getUclass()==1}">
                    <li><a href="<%=basePath%>bbs/upload.jsp">视频上传</a></li>
            </c:if>
        </ul>
    </div>
    <div class="homeCen_right">
        <div class="baseHead">
            <ul>
                <li><a href="myWrite.html" class="on">我的发帖</a></li>
            </ul>
        </div>
        <div class="myWrite_con">
            <div class="writeHead">
                <div class="writeHead1">帖子标题</div>
                <div class="writeHead2">发表时间</div>
                <div class="writeHead3">操作</div>
            </div>
            <c:forEach items="${list}" var="list">
            <div class="writeFoot">
                <div class="writeFoot1"><p><a href="ViewCommentServ?PID=${list.getPID()}">${list.getPtheme()}</a></p></div>
                <div class="writeFoot2">${list.getPtime()}</div>
                <div class="writeFoot3"><a href="BbsDeleteServ?PID=${list.getPID()}&type=mywrite">删除</a></div>
            </div>
            </c:forEach>
        </div>
        <div class="indexFooter">
            <div class="indexFooter_con">
               <a href="javascript:"><</a>
                <c:if test="${page > 1 }">
                <a href="MyWriteServ?page=${up }" class="on">《《</a>
                </c:if>
		   		<c:if test="${page < pageall }">
                <a href="MyWriteServ?page=${next }">》》</a>
                </c:if>
                <a href="javascript:">></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>