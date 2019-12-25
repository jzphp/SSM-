<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>宏睿网</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/muke.css">
<link href="css/myCart.css" type="text/css" rel="stylesheet" />

</head>
<body class="backg_huibai">

	<!-- 顶部 -->
	<div class="width100 float_l height150">
		<div class="width100 float_l height80 line_hei80">
			<!-- 顶部左边 -->
			<div class="float_l">
				<div class="float_l margin_l20">
					<img src="img/logo.png">
				</div>
				<div class="float_l">
					<ul class="ul_li fon_siz16">
						<li><a href="bbs/index.jsp">猿问</a></li>
					</ul>
				</div>
			</div>
			<!-- 顶部中间 -->
			<div class="float_c">
				<div class="float_c">

					<li><h4 align="center">欢迎${user.getUsername()}来到我的购物车</h4></li>

				</div>
			</div>

			<!-- 顶部右边 -->
			<div class="float_r">
				<div class="float_l margin_l30 margin_r40">
					<a href="index.jsp">返回首页</a> |<a href="LoginOutServ">退出</a>
				</div>
			</div>
		</div>
	</div>
	
	<div id="content">
	<form action="PayServ" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="shopping">
			<tr>
				<td class="title_2">订单编号</td>
				<td class="title_3">购买者姓名</td>
				<td class="title_4">购买的课程名称</td>
				<td class="title_5">购买的视频类型</td>
				<td class="title_7">授课人</td>
				<td class="title_8">价格</td>
				<td class="title_1">日期</td>
			</tr>
			<c:forEach items="${listod}" var="li">
				<tr>
					<td class="cart_td_2">${li.oid}</td>
					<td class="cart_td_3">${li.uname}</td>
					<td class="cart_td_4">${li.cname }</td>
					<td class="cart_td_5">${li.ctype}</td>
					<td class="cart_td_7">${li.tname }</td>
					<td class="cart_td_8">${li.cprice }</td>
					<td class="cart_td_1">${li.deta }</td>
				</tr>
			</c:forEach>
			<tr  colspan="7" >
				<td ><a href="index.jsp">返回首页</a></td>
			</tr>
		</table>
		
	</form>
	</div>
	<div class="width100 float_l padding_t30 height193">
		<div class="width_1200 margin_auto">
			<div class="width100 float_l text_c margin_b30">
				<a class="img_backg5" href="#"></a> <a
					class="img_backg6 posi_relative wexinmaxianshi" href="#"><i
					class="weixinweima dis_none"><img src="img/idx-btm.png"></i></a>
				<a class="img_backg7" href="#"></a> <a class="img_backg8" href="#"></a>
			</div>

			<div class="width100 float_l text_c yejiao color_gray">
				<a>关于我们</a> <a>联系我们</a> <a>意见反馈</a> <a href="admin/login.jsp">后台管理</a>
			</div>
			<div
				class="width100 float_l text_c border_t margin_t20 padding_t20 color_gray fon_siz12">
				<span>© 2016 imoroc.com 京ICP备13042132号</span>
			</div>
		</div>
	</div>
</body>
</html>