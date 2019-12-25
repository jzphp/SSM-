<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>发表帖子</title>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/reset.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/public.css"/>
    <style type="text/css">
        body{
    background-color: #f2f2f2;
    }
    .writeCon{
        width: 1200px;
        height: auto;
        margin: 0 auto;
        margin-top: 14px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 0 10px #999;
    }
    .writeCon_head{
        width: 100%;
        height: 60px;
        border-radius: 10px;
        background-color: #f8f8f8;
        border-bottom: 1px solid #d7d7d7;
    }
    .writeCon_head p{
        font-size: 14px;
        color: #333;
        line-height: 60px;
        text-indent: 25px;
    }
    .theme{
        width: 1200px;
        height: auto;
        background-color: #F6F6F6;
        border-radius: 5px;
    }
    .theme_h{
        width: 100%;
        height: auto;
        margin:auto 0;
        background-color: #ffffff;
    }
    .theme_h h2{
        margin-top: 10px;
        float: left;
        display: block;
        width: 180px;
        height: 40px;
        background-color: #fefefe;
        text-align: center;
        line-height: 40px;
        font-size: 19px;
        font-family:arial,"Microsoft Yahei","Hiragino Sans GB",sans-serif;
    }
    .theme_h h3{
        margin-top: 10px;
        float: left;
        display: block;
        width: 180px;
        height: 40px;
        text-align: center;
        line-height: 40px;
        font-size: 19px;
        font-family:arial,"Microsoft Yahei","Hiragino Sans GB",sans-serif;
    }
    .theme_h p{
        font-size: 18px;
        padding:10px;
        margin:10px;
        border:1px solid #D7D7D7;
        border-radius: 5px;
        color: #333;
        line-height: 60px;
        text-indent: 25px;
        word-wrap:break-word;
        word-break:break-all;
        overflow: hidden;
    }
    .theme_h input{
        margin-top: 7px;
        float: left;
        display: block;
        height: 40px;
        font-size: 16px;
        width: 600px;
        border-radius: 5px;
    }
    .context{
        top: 5px;
        width: 1200px;
        height:auto;
    }
    .context h2{
    	clear:both;
        display: block;
        height: 80px;
        width: auto;
        text-align: left;
        padding-left:50px;
        line-height: 80px;
        font-size: 28px;
        font-family:arial,"Microsoft Yahei","Hiragino Sans GB",sans-serif;

    }
    input,textarea{
        vertical-align:top;
    }
    .context textarea{
        width: 1000px;
        height: 500px;
        border-radius: 5px;
        margin-left: 100px;
        font-size: 17px;
    }
    .sub{
        width: 100%;
        height: 80px;
        border-radius: 5px;
        background-color: #FFFFFF;
    }
    .reform{
        width: 120px;
        height: 38px;
        background-color: #ff0000;
        border: none;
        border-radius: 5px;
        float: right;
        margin-top: 20px;
        margin-right: 80px;
        color: #fff;
        font-size: 14px;
    }
    .publicFooter{
        margin-top: 55px;
        width: 100%;
        height: 80px;
        text-align: center;
        font-size: 14px;
        color: #666;
        line-height: 80px;
        background: url("../img/footerBg.png") no-repeat center 0;
    }  
    .tixin{
        width: 300px;
        height: 38px;
        float:left;
        font-size: 19px;
        color: #675C5C;
        margin-left:100px;
    }
        
    </style>
    <script src="<%=basePath%>bbs/js/jquery-1.8.3.min.js"></script>
    <script>
        $('[name="nice-select"]').click(function(e){
            $('[name="nice-select"]').find('ul').hide();
            $(this).find('ul').show();
            e.stopPropagation();
        });
        $('[name="nice-select"] li').hover(function(e){
            $(this).toggleClass('on');
            e.stopPropagation();
        });
        $('[name="nice-select"] li').click(function(e){
            var val = $(this).text();
            var dataVal = $(this).attr("data-value");
            $(this).parents('[name="nice-select"]').find('input').val(val);
            $('[name="nice-select"] ul').hide();
            e.stopPropagation();
        });
        $(document).click(function(){
            $('[name="nice-select"] ul').hide();
        });
    </script>
</head>
<body>
<header class="ltHead">
    <div class="ltHead_cen">
        <a href="<%=basePath%>IndexServ"><img src="<%=basePath%>bbs/img/logo.png" alt="" class="headPic1"/></a>
        <ul class="headNav">
            <li><a href="<%=basePath%>BbsMainServ">进入猿问</a></li>
        </ul>
        <!--未登入开始-->
        <c:if test="${user==null}">
	        <div class="ltForm">
	            <a href=""><img src="<%=basePath%>bbs/img/indexForm_bg.png" alt="" class="headPic2"/></a>
	            <ul>
	                <li><a href="">登入</a></li>
	                <li><a href="">注册</a></li>
	            </ul>
	        </div>
        </c:if>
        <!-- 未登入结束-->
        <!-- 登入开始，未登入时以下隐藏-->
        <c:if test="${user!=null}">
        <div class="lt_login">
	        <ul>
		        <li><a href="">${user.getUsername()}</a></li>
		        <li><a href="">退出</a></li>
	        </ul>
        </div>
        </c:if>
        <!-- 登入结束-->
    </div>
</header>
<body>
<form action="NewCommentServ" method="post">
    <input type="hidden" name="UserID" value="${user.getUID()}">
    <div class="writeCon">
        <div class="writeCon_head">
            <p>发新帖</p>
        </div>
    	<div class="theme">
    		<div class="theme_h">
    			<h2>主题：</h2><input type="text" name = "theme" class="input" onKeyDown='if (this.value.length>=20){event.returnValue=false}'>
    		</div>
    	</div>
    	<div class="context"><h2>请输入内容：</h2>
    	<textarea rows="10" cols="30" name = "context" onKeyDown='if (this.value.length>=200){event.returnValue=false}'></textarea>
    	</div>
        <div class="sub">
        	<p class="tixin">注意：最长输入两百个中文字符</p>
            <input type="submit" class="reform" value="发布"/>
        </div>
    </div>
</form>
<footer class="publicFooter">
    <p>Copyrigh &copy; 2017-2018 PaiWang 上海钦合投资管理有限公司版权所有 沪ICP备16032224号-2</p>
</footer>
</body>
</html>