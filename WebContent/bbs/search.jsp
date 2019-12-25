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
    <title>搜索</title>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/reset.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/public.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/search.css"/>
</head>
<body>
<header class="ltHead">
    <div class="ltHead_cen">
        <a href="<%=basePath%>IndexServ"><img src="<%=basePath%>bbs/img/logo.png" alt="" class="headPic1"/></a>
        <ul class="headNav">
            <li><a href="<%=basePath%>BbsMainServ">进入猿问</a></li>
        </ul>
        <c:if test="${user == null}">
			<div class="ltForm">
				<a href=""><img src="<%=basePath%>bbs/img/indexForm_bg.png" alt="" class="headPic2"/></a>
				<ul>
					<li><a href="<%=basePath%>login.jsp">登入</a></li>
					<li><a href="<%=basePath%>trgister.jsp">注册</a></li>
				</ul>
			</div>
        </c:if>

        <!-- 未登入结束-->
        <!-- 登入开始，未登入时以下隐藏-->
        <c:if test="${user!=null }">
        	<div class="lt_login">
	            <ul>
	                <li><a href="BbsHomeServ">${user.getUsername()}</a></li>
	                <li><a href="LoginOutServ">退出</a></li>
	            </ul>
        	</div>
        </c:if>
        <!-- 登入结束-->
    </div>
</header>
<div class="searchBody">
<form action="BbsSeacherServ" method="post">
    <div class="writePending">
        <div class="newPending_head">
            <div class="tzHeng"></div>
            <div class="newPending_head_tittle">搜索</div>
        </div>
        <div class="writePending_con">
            <input type="text" name = "search" placeholder="请输入关键词"/>
            <input type="submit" value="搜索"/>
        </div>
    </div>
</form>
    <div class="indexMain_left_con">
    <c:forEach items="${list}" var="list">
        <!--无主题图循环开始-->
        <div class="indexCon_msg">
            <div class="indexCon_msg_pic"></div>
            <div class="indexCon_msg_detail">
                <a href="ViewCommentServ?PID=${list.getPID()}">
                    <div class="indexCon_msg_detail_tittle">
                        <span>主题：</span>
                        <p>${list.getPtheme()}</p>
                    </div>
                </a>
                <div class="indexCon_msg_detail_other">
                    <ul>
                        <li>${list.getUsername()}</li> 
                        <li>${list.getPtime()}</li>
                    </ul>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        </c:forEach>
        <!--无主题图循环结束-->
    </div>
            <div class="indexFooter">
            <div class="indexFooter_con">
                <a href="javascript:"><</a>
                <c:if test="${page > 1 }">
                <a href="BbsSeacherServ?page=${up }" class="on">《《</a>
                </c:if>
		   		<c:if test="${page < pageall }">
                <a href="BbsSeacherServ?page=${next }">》》</a>
                </c:if>
                <a href="javascript:">></a>
            </div>
        </div>
</div>
</body>
</html>