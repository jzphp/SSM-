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
    <title>修改密码</title>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/reset.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/homeHead.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/homePublic.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/base.css"/>
    <script>
	function check(){
		var pwd = document.getElementById("pwd").value;
		var oldpwd=document.getElementById("oldpwd").value;
		var upwd=document.getElementById("upwd").value;
		var upwd1=document.getElementById("upwd1").value;
		if(oldpwd==''){
			alert('还未验证您的密码，请输入');
			return false;
		}else {
			if(oldpwd != pwd){
				alert('验证失败，请重新输入');
			    return false;
			}else{
				if(upwd == ''){
					alert('还未输入新密码，请输入');
				    return false;
				}
				if(upwd1 != upwd) {
				    alert("两次密码不同，请重新输入");
				    return false;
				}
			}
		}
	}
</script>
</head>
<body>
<header class="zyHead">
    <div class="zyHead_cen">
        <a href="<%=basePath%>IndexServ"><img src="<%=basePath%>bbs/img/per-con.png" alt="" class="headPic1"/></a>
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
			        <li><a href="<%=basePath%>BbsHomeServ?type=home&uid=${user.getUID()}">${user.getUsername()}</a></li>
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
            <li class="on"><a href="<%=basePath%>BbsbaseServ">基本设置</a></li>
            <li><a href="<%=basePath%>MyWriteServ">我的贴子</a></li>
            <li><a href="<%=basePath%>MyOrderServ">我的订单</a></li>
            <c:if test="${user.getUclass()==1}">
                    <li><a href="<%=basePath%>bbs/upload.jsp">视频上传</a></li>
            </c:if>
        </ul>
    </div>
    <div class="homeCen_right">
        <div class="baseHead">
            <ul>
                <li><a href="<%=basePath%>BbsbaseServ">我的资料</a></li>
                <li><a href="<%=basePath%>bbs/upload_password.jsp" class="on">修改密码</a></li>
            </ul>
        </div>
        <form action="<%=basePath%>BbspwdServ" method="post" onsubmit="return check();">
        <div class="baseCon">
        	<div class="baseCon_son">
                <div class="baseCon_son_left">
                    当前密码
                </div>
                <div class="baseCon_son_right">
                    <input type="password" name="pwd" id="pwd" value="${user.getUpwd()}" readonly="readonly"/>
                </div>
            </div>
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                    验证密码
                </div>
                <div class="baseCon_son_right">
                    <input type="text" name="oldpwd" id="oldpwd" />
                </div>
            </div>
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                    新密码
                </div>
                <div class="baseCon_son_right">
                    <input type="text" name="upwd" id="upwd"/>
                </div>
            </div>
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                    确认密码
                </div>
                <div class="baseCon_son_right">
                    <input type="text" name="upwd1" id="upwd1"/>
                </div>
            </div>
            <input type="submit" value="确认修改" class="upload_sure"/>
        </div>
        </form>
    </div>
</div>
</body>
</html>