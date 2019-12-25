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
    <title>我的订单</title>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/reset.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/homeHead.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/homePublic.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/myOrder.css"/>
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
            <li><a href="<%=basePath%>MyWriteServ">我的贴子</a></li>
            <li class="on"><a href="<%=basePath%>MyOrderServ">我的订单</a></li>
            <c:if test="${user.getUclass()==1}">
                    <li><a href="<%=basePath%>bbs/upload.jsp">视频上传</a></li>
            </c:if>
        </ul>
    </div>
    <div class="homeCen_right">
        <div class="baseHead">
            <ul>
                <li><a class="on">订单</a></li>
            </ul>
        </div>
        <div class="myWrite_con">
            <div class="msg-tittle">
                <div class="order_top">订单编号</div>
                <div class="product_top">购买产品</div>
                <div class="book_top">下单时间</div>
                <div class="now_top">金额</div>
                <div class="operate_top">评论状态</div>
            </div>
            <c:forEach items="${list}" var="list">
            <div class="msg-con">
                <div class="order">${list.oid}</div>
                <div class="product">${list.coursename}</div>
                <div class="pay">${list.otime}</div>
                <div class="book">${list.omoney}</div>
                <div class="operate">
                	<c:if test="${list.ostatus==0}">
                		<a href="BbsOrderComServ?OID=${list.oid}" class="payfor">去评价</a>
                	</c:if>
                    <c:if test="${list.ostatus==1}">
                    	 <button class="cancel_order bad-thing">已评价</button>
                    </c:if>
                </div>
            </div>
            </c:forEach>
        </div>
        <div class="indexFooter">
            <div class="indexFooter_con">
                <a href="javascript:"><</a>
                <c:if test="${page > 1 }">
                <a href="MyOrderServ?page=${up }" class="on">《《</a>
                </c:if>
		   		<c:if test="${page < pageall }">
                <a href="MyOrderServ?page=${next }">》》</a>
                </c:if>
                <a href="javascript:">></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>