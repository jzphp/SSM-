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
    <title>评价</title>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/reset.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/homeHead.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/homePublic.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/myPendding.css"/>
    <script src="<%=basePath%>bbs/js/jquery-1.8.3.min.js"></script>
	<script src="<%=basePath%>bbs/js/jquery.raty.min.js"></script>
	<script src="<%=basePath%>bbs/js/myPending.js"></script>
</head>
<body>
<header class="zyHead">
    <div class="zyHead_cen">
        <a href="<%=basePath%>IndexServ"><img src="img/per-con.png" alt="" class="headPic1"/></a>
        <a href="<%=basePath%>BbsMainServ" class="backIndex">进入猿问</a>
        <a href="<%=basePath%>bbs/cart.jsp" class="backIndex">我的购物车</a>
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
            <li><a href="<%=basePath%>MyWriteServ">我的贴子</a></li>
            <li class="on"><a href="<%=basePath%>MyOrderServ">我的订单</a></li>
            <c:if test="${user.getUclass()==1}">
            <li><a href="<%=basePath%>bbs/upload.jsp">视频上传</a></li>
            </c:if>
        </ul>
    </div>
    <div class="homeCen_right">
        <div class="motai">
            <div class="motai_img"></div>
            <form action="BbsOrderComServ?oid=${oid}" class="motai_con" method="post">
                <div class="clear"></div>
                <p class="order-msg">订单号：<span>${oid}</span><p>
                <p class="arg_con">
                    <span><i>*</i>评价内容：</span>
                    <textarea name="content" id="content" placeholder="对本次服务的感受"></textarea>
                </p>
                <input type="submit" class="submit" value="提交评价" />
            </form>
        </div>
    </div>
</div>
</body>
</html>
