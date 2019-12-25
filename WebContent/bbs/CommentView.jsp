<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <li><a href="<%=basePath%>BbsMainServ">进入猿问</a></li>
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
			        <li><a href="<%=basePath%>BbsHomeServ?type=home&uid=${user.getUID()}">${user.getUsername()}</a></li>
			        <li><a href="<%=basePath%>LoginOutServ?type=out">退出</a></li>
		        </ul>
	        </div>
        	<!-- 登入结束-->	
        </c:if>
        <div class="navFix">
            <!--登入开始-->
            <a href="" class="navMe">花花</a>
            <!--登入结束-->
            <!--未登入开始-->
            <!--<a href="" class="navLogin">登录</a>-->
            <!--未登入结束-->
            <a href="" class="navWrite">发新帖</a>
        </div>
    </div>
</header>
<div class="indexMain">
    <div class="indexMain_left">
        <div class="indexMain_left_con">
                    <div class="indexCon_msg">
                <div class="indexCon_msg_pic"></div>
                <div class="indexCon_msg_detail">
                    <a href="">
                        <div class="indexCon_msg_detail_tittle">
                            <span>主题</span>
                            <p>${invatition.getPtheme()}</p>
                        </div>
                         <div class="clear"></div>
                        <div class="indexCon_msg_detail_tittle">
                            <span>内容</span>
                            <p>${invatition.getPcontext()}</p>
                        </div>
                    </a>
                     <div class="clear"></div>
                    <div class="indexCon_msg_detail_other">
                        <ul>
                            <li>${invatition.getPtime()}</li>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <!--有主题图循环开始-->
            <c:forEach items="${list}" var="comment">
            <div class="indexCon_msg">
                <div class="indexCon_msg_pic"></div>
                <div class="indexCon_msg_detail">
                     <div class="indexCon_msg_detail_tittle">
                         <span>评论</span>
                         <p>${comment.getCText()}</p>
                     </div>
                     <div class="clear"></div>
                    <div class="indexCon_msg_detail_other">
                        <ul>
                            <li>${comment.getUsername()}</li>
                            <li>${comment.getCTime()}</li>
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
                <a href="ViewCommentServ?page=${up }&PID=${invatition.getPID()}" class="on">《《</a>
                </c:if>
		   		<c:if test="${page < pageall }">
                <a href="ViewCommentServ?page=${next }&PID=${invatition.getPID()}">》》</a>
                </c:if>
                <a href="javascript:">></a>
            </div>
        </div>
    </div>
    <div class="indexMain_right">
        <div class="indexMain_rightCon">
            <a href="<%=basePath%>WriteComServ?PID=${invatition.getPID()}" class="newMsg">跟帖</a>
            <div class="pwfb">
                <div class="pwfbHead">
                    拍王发布
                </div>
                <div class="pwfbCon"></div>
                <div class="pwfbFooter"></div>
            </div>
            <div class="indexSearch">
                <input type="text" placeholder="请输入关键词"/>
                <input type="submit" value="搜索"/>
            </div>
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