<%@page import="com.etc.HongRui.Listener.SessionCount"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="com.etc.HongRui.Listener.SessionCount.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html> 
<head lang="en">
    <meta charset="utf-8">
    <title>论坛首页</title>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/reset.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/public.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/index.css"/>
</head>
<body>
<header class="ltHead">
    <div class="ltHead_cen">
        <a href="<%=basePath%>IndexServ"><img src="<%=basePath%>bbs/img/logo.png" alt="" class="headPic1"/></a>
        <ul class="headNav">
            <li><a href="<%=basePath%>BbsMainServ">首页</a></li>
            <li><a>当前在线人数：<%= SessionCount.getActiveSession() %></a><li>
        </ul>
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
        <div class="navFix">
            <!--登入开始-->
            
            <c:if test="${ user!=null }">
            	<a class="navMe" href="<%=basePath%>BbsbaseServ?type=home&uid=${user.getUID()}">${user.getUsername()}</a>
            </c:if>
            <c:if test="${ user==null }">
            	<a href="<%=basePath%>BbsMainServ">登录</a>
            </c:if>
            <a href="<%=basePath%>BbsMainServ?type=wrtie&uclass=${user.getUclass()}" class="navWrite">发新帖</a>
        </div>
    </div>
</header>
<div class="indexMain">
    <div class="indexMain_left">
        <div class="indexMain_left_con">
            <!--有主题图循环开始-->
            <c:forEach items="${list}" var="invatition">
            <div class="indexCon_msg">
                <div class="indexCon_msg_pic"></div>
                <div class="indexCon_msg_detail">
                    <a href="ViewCommentServ?PID=${invatition.getPID()}">
                        <div class="indexCon_msg_detail_tittle">
                            <span>主题</span>
                            <p>${invatition.getPtheme()}</p>
                        </div>
                    </a>
                    <div class="clear"></div>
                    <div class="indexCon_msg_detail_other">
                        <ul>
                            <li>${invatition.getUsername()}</li>
                            <li>${invatition.getPtime()}</li>
                            <li>21</li>
                            <li>28</li>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            </c:forEach>
            <!--有主题图循环结束-->
            <!--无主题图循环开始-->
<!--             <div class="indexCon_msg">
                <div class="indexCon_msg_pic"></div>
                <div class="indexCon_msg_detail">
                    <a href="">
                        <div class="indexCon_msg_detail_tittle">
                            <span>竞拍</span>
                            <p>关注上海车牌竞拍方面的资讯，对当月竞拍分析发表独到见解</p>
                        </div>
                    </a>
                    <div class="indexCon_msg_detail_other">
                        <ul>
                            <li>花开花落</li>
                            <li>1天前</li>
                            <li>21</li>
                            <li>28</li>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
            </div> -->
            <!--无主题图循环结束-->
        </div>
        <div class="indexFooter">
            <div class="indexFooter_con">
                <a href="javascript:"><</a>
                <c:if test="${page > 1 }">
                <a href="BbsMainServ?page=${up }" class="on">《《</a>
                </c:if>
		   		<c:if test="${page < pageall }">
                <a href="BbsMainServ?page=${next }">》》</a>
                </c:if>
                <a href="javascript:">></a>
            </div>
        </div>
    </div>
    <div class="indexMain_right">
        <div class="indexMain_rightCon">
            <a href="<%=basePath%>BbsMainServ?type=wrtie&uclass=${user.getUclass()}" class="newMsg">发新帖</a>
            <div class="pwfb">
                <div class="pwfbHead">
                    拍王发布
                </div>
                <div class="pwfbCon"></div>
                <div class="pwfbFooter"></div>
            </div>
            <form action="BbsSeacherServ" method="post">
	            <div class="indexSearch">
	                <input type="text" name = "search" placeholder="请输入关键词"/>
	                <input type="submit" value="搜索"/>
	            </div>
            </form>
            <div class="indexPublic">
                <div class="indexPublic_head">
                    本周热议
                </div>
                <div class="indexPublic_con">
                    <ul class="weekHot">
                        <li><a href="">关注上海车牌竞拍方面的资讯</a><span>29</span></li>
                        <li><a href="">关注上海车牌竞拍方面的资讯</a><span>29</span></li>
                        <li><a href="">关注上海车牌竞拍方面的资讯</a><span>29</span></li>
                        <li><a href="">关注上海车牌竞拍方面的资讯</a><span>29</span></li>
                        <li><a href="">关注上海车牌竞拍方面的资讯</a><span>29</span></li>
                        <li><a href="">关注上海车牌竞拍方面的资讯</a><span>29</span></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<footer class="publicFooter">
    <p>Copyrigh &copy; 2017-2018 PaiWang 上海钦合投资管理有限公司版权所有 沪ICP备16032224号-2</p>
</footer>

<script src="js/jquery-1.8.3.min.js"></script>
<script>
    $(".indexMain_left_btn li a").click(function(){
        $(".indexMain_left_btn li a").removeClass("on");
        $(this).addClass("on");
    });
    window.onscroll=function(){
        var scrolls=document.body.scrollTop||document.documentElement.scrollTop;
        var slided=60;
        if(scrolls>=slided){
            $(".appear").hide();
            $(".navFix").show();
            $(".ltHead").addClass("navTop");
        }else{
            $(".appear").show();
            $(".navFix").hide();
            $(".ltHead").removeClass("navTop");
        }
    };
</script>

</body>
</html>