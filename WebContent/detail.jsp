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
                    <li><a href="<%=basePath%>MainServ?model=bbs" style="color:#333333">猿问</a></li>
                    <li></li>
                </ul>
            </div>
        </div>
        
        <!-- 顶部右边 -->
         
        <div class="float_r">

          <div class="float_l margin_l40">
               <a href="MainServ?model=car"><img src="img/car.png"></a> 
            </div>


            <div class="float_l margin_l30 margin_r40">
				<c:if test="${user != null }">
					<a href="login.jsp">${user.getUsername()}</a>
						| <a href="LoginOutServ">退出</a>
				</c:if>
				<c:if test="${user == null }">
					<a href="login.jsp" style="color:#333333">登录</a> | <a href="regester.jsp" style="color:#333333">注册</a>
				</c:if>
            </div>
        </div>
	</div>
</div>
<!-- 实战推荐 -->
<div class="width100 float_l margin_b40">
	<div class="width_1200 margin_auto">
    	<div class="width100 float_l margin_b20">
        	<div class="float_l">
            	<span class="fon_siz16">实战推荐</span>
            </div>
            
        </div>
   
      <div class="width100 float_l">
          <% int i=1;%>
        <c:forEach items ="${list}" var="course">
       <%if (i % 4== 0){%>
		<%}%>
			<td >
        	<div class="width_224 height172 float_l margin_r20 border_shadow jingguoxianshi over_pos bianshou">
            	<div class="width100 float_l img_100 z_inx_1">
                	<img src="img/uiz7.jpg">
                </div>
                <div class="img_backg2 donghua">
                    <span class="margin_t15 float_l "><a href = "<%=basePath%>PlayServ?price=${course.cprice}&id=${course.cid}">${course.cname}</a></span>
                    <span class="float_l fon_siz12 line_hei16 color_gray margin_t5 posi_relative ">${course.cintroduce}</span>
                </div>
                <div class="width100 float_l padding_lr20 height48 fon_siz12 line_hei48 z_inx_3 posi_relative backg_white">
                    <span class="float_l color_red">${course.cprice}</span>
                    <span class="float_r color_gray"><a href="AddCarServ?model=addcar&cid=${course.cid}" >添加购物车</a> </span>
            	</div>
            </div>    
            </td>
			<%i++;%>
</c:forEach> 
    </div>
</div>
<!-- 免费好课 -->

<div class="width100 float_l margin_b40">
	<div class="width_1200 margin_auto">
    
    	<div class="width100 float_l margin_b20">
        	<div class="float_l">
            	<span class="fon_siz16">免费好课</span>
            </div>
           
        </div>
      
        <div class="width100 float_l">
         <c:forEach items ="${list1}" var="c">
          <%if (i % 4== 0){%>
			<%}%>
			<td >
        	<div class="width_224 height172 float_l margin_r20 border_shadow jingguoxianshi over_pos bianshou">
            	 
            	<div class="width100 float_l img_100 z_inx_1">
                	<img src="img/uiz7.jpg">
                </div>
                <div class="img_backg2 donghua">
                    <span class="margin_t15 float_l "><a  href = "<%=basePath%>PlayServ?price=${c.cprice}&id=${c.cid}">${c.cname}</a></span>
                    <span class="float_l fon_siz12 line_hei16 color_gray margin_t5 posi_relative ">${c.cintroduce}</span>
                </div>
                <div class="width100 float_l padding_lr20 height48 fon_siz12 line_hei48 z_inx_3 posi_relative backg_white">
                    <span class="float_l color_red">${c.cprice}</span>
            	</div>
            	
            </div>  
              </td>		
              	<%i++;%>
            </c:forEach>
    </div>

        
    </div>
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