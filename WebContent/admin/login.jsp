<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%   
    String path = request.getContextPath();   
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;   
   %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" charset="utf-8" href="css/reset.css">
    <link rel="stylesheet" charset="utf-8" href="css/reg.css">
   <style>
         span{text-align:center;float:right;width:300px;}
   </style>
</head>
<body>
    <div class="login_header">
        <div class="header_center clearfix">
            <div class="myfl">
                <a href="index.jsp"><img src="images/logo1.png"/></a>
                <span>管理员登陆</span>
            </div>
            <div class="myfr">
             <a href="javascript:;" class="collection_web">收藏网站</a>
            </div>
        </div>
    </div>
    <div class="login_content clearfix">
        <input type="hidden" id="memberType" value="" />
        <form action="<%=basePath %>LoginAD" method="post">
            <input type="hidden" name="memberType" id="parameter" value="1"/>
            <div class="login_box myfr">
                <p class="tabchange clearfix">
                    <span class="myfl sign_select" id="usertype">管理员登录</span>
                </p>
                <p class="system_error"></p>
                <input type="text" name="nick" value="" placeholder="手机号/用户名" id="username"/>
                <p class="username_error"><span>用户名不能为空!</span></p>
                <input type="password" placeholder="登录密码" id="password" name="password" maxlength="16" value=""/>
                <p class="password_error"><span>密码不能为空!</span></p>
                <p class="forget_password clearfix"><a href="" class="myfr">忘记密码？</a></p>
                <input type="submit" value="立即登录" class="submit_btn">
               
            </div>
        </form>
    </div>
    <div class="login_bottom">Copright &nbsp;&nbsp;宏睿网 &nbsp;&nbsp;京ICP17003883号-1 &nbsp;&nbsp;版权所有</div>
</body>
<script type="text/javascript" charset="utf-8" src="js/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/web_method/method.js"></script>
<script type="text/javascript" charset="utf-8" src="js/login_register/login.js~v=1"></script>
</html>



















