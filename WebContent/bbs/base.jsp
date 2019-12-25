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
    <title>我的资料</title>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/reset.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/homeHead.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/homePublic.css"/>
    <link rel="stylesheet" href="<%=basePath%>bbs/css/base.css"/>
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
			        <li>
						 <a href="javascript:">
                		<c:if test="${user.getUclass()=='0'}">
                    	学生 : ${user.getUsername()}
                    	</c:if>
                    	<c:if test="${user.getUclass()=='1'}">
                    	教师 : ${user.getUsername()}
                    	</c:if>
               			 </a>
					</li>
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
                <li><a href="<%=basePath%>BbsbaseServ" class="on">我的资料</a></li>
                <li><a href="<%=basePath%>bbs/upload_password.jsp">修改密码</a></li>
            </ul>
        </div>
    <form action="<%=basePath%>UpdatebaseServ?type=${user.getUclass()}" method="post">
        <div class="baseCon">
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                    用户ID
                </div>
                <div class="baseCon_son_right">
                    <input type="text" name="uid" value="${user.getUID()}" readonly="readonly"/>
                </div>
            </div>
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                     用户名
                </div>
                <div class="baseCon_son_right">
                    <c:if test="${user.getUclass()=='0'}">
                    <input type="text" name="username" value="${peo.username}" readonly="readonly"/>
                    </c:if>
                    <c:if test="${user.getUclass()=='1'}">
                    <input type="text" name="tusername" value="${peoteacher.username}" readonly="readonly"/>
                    </c:if>
                </div>
            </div>
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                    姓名
                </div>
                <div class="baseCon_son_right">
                    <c:if test="${user.getUclass()=='0'}">
                    <input type="text" name="sname" value="${peo.sname}"/>
                    </c:if>
                    <c:if test="${user.getUclass()=='1'}">
                    <input type="text" name="tname" value="${peoteacher.tname}"/>
                    </c:if>
                </div>
            </div>
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                    性别
                </div>
                <div class="baseCon_son_right">
                    <c:if test="${user.getUclass()=='0'}">
                    <input type="text" name="ssex" value="${peo.ssex}"/>
                    </c:if>
                    <c:if test="${user.getUclass()=='1'}">
                    <input type="text" name="tsex" value="${peoteacher.tsex}"/>
                    </c:if>
                </div>
            </div>
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                    年龄
                </div>
                <div class="baseCon_son_right">
                    <c:if test="${user.getUclass()=='0'}">
                    <input type="text" name="sage" value="${peo.sage}"/>
                    </c:if>
                    <c:if test="${user.getUclass()=='1'}">
                    <input type="text" name="tage" value="${peoteacher.tage}"/>
                    </c:if>
                </div>
            </div>
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                    手机号
                </div>
                <div class="baseCon_son_right">
                    <c:if test="${user.getUclass()=='0'}">
                    <input type="text" name="uphone" value="${peo.uphone}"/>
                    </c:if>
                    <c:if test="${user.getUclass()=='1'}">
                    <input type="text" name="tuphone" value="${peoteacher.uphone}"/>
                    </c:if>
                </div>
            </div>
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                    电子邮箱
                </div>
                <div class="baseCon_son_right">
                    <c:if test="${user.getUclass()=='0'}">
                    <input type="text" name="umail" value="${peo.umail}"/>
                    </c:if>
                    <c:if test="${user.getUclass()=='1'}">
                    <input type="text" name="tumail" value="${peoteacher.umail}"/>
                    </c:if>
                </div>
            </div>
            <input type="submit" value="确认修改" class="upload_sure"/>
        </div>
        </form>
    </div>
</div>
</body>
</html>