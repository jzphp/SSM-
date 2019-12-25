<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>忘记密码</title>
    <link rel="shortcut icon" href="" type="image/x-icon">
    <link rel="stylesheet" charset="UTF-8" href="css/reset.css">
    <link rel="stylesheet" charset="utf-8" href="css/web_pop.css">
    <link rel="stylesheet" charset="UTF-8" href="css/login.css">
</head>
<body>
    <div class="register_header">
        <div class="header_center clearfix">
            <div class="myfl">
                <a href="index.html"><img src="img/logo1.png" /></a>
                               
                            </div>
            <div class="myfr">
                <a href="index.jsp">返回首页</a>
                <span></span>
                <a href="login.jsp">返回登录</a>
                
            </div>
        </div>
    </div>
    <div class="register_content clearfix"
                  style="background:url('img/user_register_bag.png') no-repeat 0 138px;"
             >
                <input type="hidden" value="" id="iserror">
                <form action="ForgetpwdServ" id="my_from" method="post">
            <div class="register_box myfr" >
                            <div style="width:10px;height:150px;">
                </div>
                <div class="title clearfix">
                    <span class="myfl"></span>
                    <h1 class="myfl">用户验证</h1>
                    <input type="hidden" value="1" name="memberType" id="registeruser_type">
                    <span class="myfr"></span>
                </div>
                <input type="text" placeholder="请输入您的用户名" name="username" class="username" value="" maxlength="20"/>
                <input type="text" placeholder="请输入您的手机号" name="uphone" maxlength="11" class="phone_num" value="" />

                <p class="message_code_error"></p>
                <input type="text" placeholder="请输入您的邮箱" name="umail" maxlength="20" class="umail" value="" />
                <!--  <input type="text" class="qq_num" name="qq" maxlength="15" placeholder="请输入您正在使用的QQ号" value="">-->
                
                <p class="source_error">7</p>
               
                <p class="source_error">8</p>
                <input type="submit" value="验证"/>  
                <!--  <a href="javascript:;" class="submit_btn" >提交</a>-->
                <div style="width:10px;height:60px;">
                </div>

            </div>
                </form>
    </div>
    <div class="register_bottom">Copright &nbsp;&nbsp;宏睿网 &nbsp;&nbsp;京ICP17003883号-1 &nbsp;&nbsp;版权所有</div>
</body>
<script type="text/javascript" charset="utf-8" src="js/jquery.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8" src="js/layer.js"></script>
<script type="text/javascript" charset="utf-8" src="js/web_method/method.js~v=2"></script>
<script type="text/javascript" charset="UTF-8" src="js/login_register/user_register.js~v=10"></script>
</html>















