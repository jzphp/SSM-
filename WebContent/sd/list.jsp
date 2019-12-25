<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>宏睿网</title>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/muke.css">
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>

</head>
<body class="backg_huibai">
<!-- 顶部 -->
<div class="width100 float_l img_backg1">
	<div class="width100 float_l height80 line_hei80">
        <!-- 顶部左边 -->
        <div class="float_l">
            <div class="float_l margin_l20">
                <img src="img/logo.png">
            </div>
            <div class="float_l">
                <ul class="ul_li fon_siz16">
                    <li></li>
                    <li> <div class="float_l margin_300">
                <a href="index.jsp" style="color:#333333">返回首页</a>
            </div></li>
                    <li><a href="bbs/index.jsp" style="color:#333333">猿问</a></li>
                    <li></li>
                </ul>
            </div>
        </div>
        
       
	</div>
</div>

<div class="width100 float_l margin_b40">
	<div class="width_1200 margin_auto">
                    <!-- 章节小节 -->
                           <ul class="video" style="text-align:center;">
                           <c:forEach items="${item}" var="video">
                               <li data-media-id="16703">
                                   <a href="<%=basePath%>PlayingServ?type= ${video.path}" class="J-media-item">
                        
                                   ${video.videoName}
     								<button class="r moco-btn moco-btn-red preview-btn">开始学习</button>                                   
                                	</a>
                               </li>
                              </c:forEach>
                           </ul>
                    <!-- 章节小节 end -->
</div>
</div>
<!-- 页脚 -->
<div class="width100 float_l padding_t30 height193">
	<div class="width_1200 margin_auto">
    	<div class="width100 float_l text_c margin_b30">
        	<a class="img_backg5" href="#"></a>
            <a class="img_backg6 posi_relative wexinmaxianshi" href="#"><i class="weixinweima dis_none"><img src="img/idx-btm.png"></i></a>
            <a class="img_backg7" href="#"></a>
            <a class="img_backg8" href="#"></a>
        </div>
        <div class="width100 float_l text_c yejiao color_gray">
            <a>关于我们</a>
            <a>联系我们</a>
            <a>意见反馈</a>
    	</div>
        <div class="width100 float_l text_c border_t margin_t20 padding_t20 color_gray fon_siz12">
        	<span>© 2016 imoroc.com  京ICP备13042132号</span>
        </div>
    </div>
</div>
</body>
</html>