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
    <title>注册</title>
    <link rel="shortcut icon" href="" type="image/x-icon">
    <link rel="stylesheet" charset="UTF-8" href="css/reset.css">
    <link rel="stylesheet" charset="utf-8" href="css/web_pop.css">
    <link rel="stylesheet" charset="UTF-8" href="css/login.css">
</head>
<body>
    <div class="register_header">
        <div class="header_center clearfix">
            <div class="myfl">
                <a href="index.jsp"><img src="img/logo1.png" /></a>
                                <span>用户注册</span>
                            </div>
            <div class="myfr">
                <a href="index.jsp">返回首页</a>
                <span></span>
                <a href="tregedit.jsp">注册教师账号</a>
                <span></span>
                <a href="login.jsp">已有账户，直接<em>登录</em></a>
            </div>
        </div>
    </div>
    <div class="register_content clearfix"
                  style="background:url('img/user_register_bag.png') no-repeat 0 138px;"
             >
                <input type="hidden" value="" id="iserror">
                <form action="RegisterServ" id="my_from" method="post">
            <div class="register_box myfr">
                <div class="title clearfix">
                    <span class="myfl"></span>
                    <h1 class="myfl">宏睿新用户注册</h1>
                    <input type="hidden" value="1" name="memberType" id="registeruser_type">
                    <span class="myfr"></span>
                </div>
                <input type="text" placeholder="请输入您的用户名" name="username" class="username" value="" maxlength="20"/>
                <p class="username_error"></p>
                <input type="password" style="color: #666;" placeholder="请输入您的密码" name="upwd" class="password" maxlength="16" value=""/>
                <p class="password_error"></p>
                <input type="password" style="color: #666;" placeholder="请重复您的密码" name="upwd1" class="password_again" maxlength="16" />
                <p class="password_again_error"></p>
                <input type="text" placeholder="请输入手机号" name="uphone" maxlength="11" class="phone_num" value="" />
                <p class="phone_num_error"></p>
                <input type="text" placeholder="请输入您的邮箱" name="umail" maxlength="20" class="umail" value="" />
               
                <p class="source_error">7</p>
                <div class="my_agreement">
                    <input type="checkbox" name="agreement" value="1" unchecked>我已仔细阅读并同意接受
                    <a href="" target="_blank">《用户使用协议》</a>
               </div>
                <p class="source_error">8</p>
                <input type="submit" value="注册" class="submit_btn">  
                <!-- <a href="javascript:;" class="submit_btn">注册</a> -->
                <!--短信的token--javascript:;>
                <input type="hidden" name="token" value="47016a045c820bc2857e84547b11a380" id="tonkenNum">-->
            </div>
                </form>
    </div>
    <!--错误提示-->
    <div class="normal_pop pop_password" id="pop_load">
        <h3>提示</h3>
        <p class="error" style="font-size: 20px;line-height: 24px;margin: 40px 0 36px;color: #666;">注册失败，请稍后再试</p>
        <i id="true_btn" class="layui-layer-close">确定</i>
    </div>
    <div class="register_bottom">Copright &nbsp;&nbsp;宏睿网 &nbsp;&nbsp;京ICP17003883号-1 &nbsp;&nbsp;版权所有</div>
</body>
<script type="text/javascript" charset="utf-8" src="js/jquery.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8" src="js/layer.js"></script>
<script type="text/javascript" charset="utf-8" src="js/web_method/method.js~v=2"></script>
<script type="text/javascript" charset="UTF-8" src="js/login_register/user_register.js~v=10"></script>
</html>

















