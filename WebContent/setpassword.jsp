<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		   <%   
    String path = request.getContextPath();   
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;   
    %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>设置密码</title>
    <link rel="shortcut icon" href="" type="image/x-icon">
    <link rel="stylesheet" charset="UTF-8" href="css/reset.css">
    <link rel="stylesheet" charset="utf-8" href="css/web_pop.css">
    <link rel="stylesheet" charset="UTF-8" href="css/login.css"> 
<script>
	function check(){
		var upwd=document.getElementById("upwd").value;
		var upwd1=document.getElementById("upwd1").value;
		if(upwd == ''){
		      alert('密码不能为空');
		      return false;
		}
		if(upwd1 != upwd) {
		      alert("两次密码不同，请重新输入");
		      return false;
		}
		    
	}
</script> 
</head>
<body>
    <div class="register_header">
        <div class="header_center clearfix">
            <div class="myfl">
                <a href="index.jsp"><img src="img/logo1.png" /></a>
                               
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
                <form action="SetpwdServ"  id="my_from" method="post" onsubmit="return check();">
            <div class="register_box myfr" >
                            <div style="width:10px;height:140px;">
                </div>
                <div class="title clearfix">
                    <span class="myfl"></span>
                    <h1 class="myfl">重新设置密码</h1>
                    <input type="hidden" value="1" name="memberType" id="registeruser_type">
                    <span class="myfr"></span>
                </div>
                <input type="text" name="username" name="username" class="username" value="${verify.getUsername()}" maxlength="20" readonly="readonly"/>
                <input type="password" style="color: #666;" placeholder="请输入您的密码" name="upwd" id="upwd" class="password" maxlength="16" value="" />
                <input type="password" style="color: #666;" placeholder="请重复您的密码" name="upwd1" id="upwd1" class="password_again" maxlength="16" />
							
				<input type="submit" value="提交">  
                <!--  <a href="index.jsp" class="submit_btn" >提交</a>-->
                <div style="width:10px;height:40px;">
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















