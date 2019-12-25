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
<div class="width100 float_l height490 img_backg1">
	<div class="width100 float_l height80 line_hei80">
        <!-- 顶部左边 -->
        <div class="float_l">
            <div class="float_l margin_l20">
                <img src="img/logo.png">
            </div>
            <div class="float_l">
                <ul class="ul_li fon_siz16">
                    <li><a href="<%=basePath%>MainServ?model=bbs" style="color:#333333">猿问</a></li>
                </ul>
            </div>
        </div>
        
        <!-- 顶部右边 -->
        <div class="float_r">
        <div class="float_l top_input">
             <form action="<%=basePath%>search.do" method="post">
                <input class="posi_relative" type="text" name="serach" id="" placeholder="请输入想搜索的内容..."/>
               <input type="submit" value="soso" style="border-style:none; width:43px;  height:43px;" />
             </form>
            </div>
            <div class="float_l margin_l40">
               <a href="MainServ?model=car"><img src="img/car.png"></a> 
            </div>
            <div class="float_l margin_l30 margin_r40">
				<c:if test="${user != null }">
					<a href="BbsbaseServ">${user.getUsername()}</a>|
					<a href="<%=basePath%>LoginOutServ?type=out">退出</a>
				</c:if>
				<c:if test="${user == null }">
					<a href="login.jsp" style="color:#333333">登录</a> | <a href="register.jsp" style="color:#333333">注册</a>
				</c:if>
            </div>
        </div>
	</div>
</div>

<!-- 轮播图 -->
<div class="width100 float_l margin_t-405 margin_b40">
	<div class="width_1200 margin_auto">
    	<div class="width100 float_l height460 posi_relative">
        	<div class="width100 float_l">
                <div class="focusBox">
                    <ul class="pic">
                        <li><a><img src="img/uiz21.jpg" /></a></li>
                        <li><a><img src="img/uiz20.jpg" /></a></li>
                    </ul>
                    <a class="prev" href="javascript:void(0)"></a>
                    <a class="next" href="javascript:void(0)"></a>
                    <ul class="hd">
                        <li></li>
                        <li></li>
                    </ul>
                </div>
            </div>
            
            <div class="width_224 float_l height460 posi_absolute backg_jqian padding_t5 bianshou">
            	<div class="width100 float_l tab_qiehuan ">
                	<div class="width100 float_l text_c height64 line_hei64 color_white bianhuabeijing backg_jqian padding_lr20">
                        <div class="width100 float_l text_l height64 line_hei64 color_white border_b_baise fon_siz16">
                            <span>前端开发</span>
                            <span class="float_r">></span>
                        </div>
                    </div>
                    <div class="width_700 float_l lunbofenlei dis_none img_backg15">
                    	<div class="width100 float_l padding40">
                        	<div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">分类目录</span>
                              
                                <ul class="width100 ul_lis float_l">
                                <c:forEach items="${item}" var="c">
                                	<li><a href = "<%=basePath%>DetailServ?type=${c.ctype}">${c.ctype} </a></li>
                                    <li>/</li>
                                </c:forEach>
                                </ul>
                              
                            </div>
                            
                         
                        </div>
                    </div>
                </div>
                
                <div class="width100 float_l tab_qiehuan">
                	<div class="width100 float_l text_c height64 line_hei64 color_white bianhuabeijing backg_jqian padding_lr20">
                        <div class="width100 float_l text_l height64 line_hei64 color_white border_b_baise fon_siz16">
                            <span>后端开发</span>
                            <span class="float_r">></span>
                        </div>
                    </div>
                    <div class="width_700 float_l lunbofenlei dis_none img_backg16">
                    	<div class="width100 float_l padding40">
                        	<div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">分类目录</span>
                                
                                <ul class="width100 ul_lis float_l">
                                 <c:forEach items="${ll}" var="c">
                                	<li><a  href = "<%=basePath%>DetailServ?type=${c.ctype}">${c.ctype} </a></li>
                                    <li>/</li>
                                  </c:forEach>
                                </ul>
                               
                            </div>
                           
                        </div>
                    </div>
                </div>
                
                <div class="width100 float_l tab_qiehuan">
                	<div class="width100 float_l text_c height64 line_hei64 color_white bianhuabeijing backg_jqian padding_lr20">
                        <div class="width100 float_l text_l height64 line_hei64 color_white border_b_baise fon_siz16">
                            <span>移动开发</span>
                            <span class="float_r">></span>
                        </div>
                    </div>
                    <div class="width_700 float_l lunbofenlei dis_none img_backg17">
                    	<div class="width100 float_l padding40">
                        	<div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">分类目录</span>
                               
                                <ul class="width100 ul_lis float_l">
                                  <c:forEach items="${lll}" var="c">
                                	<li><a  href = "<%=basePath%>DetailServ?type=${c.ctype}">${c.ctype} </a></li>
                                    <li>/</li>
                                      </c:forEach>
                                </ul>
                              
                            </div>
                            
                            
                        </div>
                    </div>
                </div>
                
                <div class="width100 float_l tab_qiehuan">
                	<div class="width100 float_l text_c height64 line_hei64 color_white bianhuabeijing backg_jqian padding_lr20">
                        <div class="width100 float_l text_l height64 line_hei64 color_white border_b_baise fon_siz16">
                            <span>人工智能</span>
                            <span class="float_r">></span>
                        </div>
                    </div>
                    <div class="width_700 float_l lunbofenlei dis_none img_backg18">
                    	<div class="width100 float_l padding40">
                        	<div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">分类目录</span>
                                
                                <ul class="width100 ul_lis float_l">
                                 <c:forEach items="${llll}" var="c">
                                	<li><a  href = "<%=basePath%>DetailServ?type=${c.ctype}">${c.ctype} </a></li>
                                    <li>/</li>
                                    </c:forEach>
                                </ul>
                                
                            </div>
                            
                          
                        </div>
                    </div>
                </div>
                
                <div class="width100 float_l tab_qiehuan">
                	<div class="width100 float_l text_c height64 line_hei64 color_white bianhuabeijing backg_jqian padding_lr20">
                        <div class="width100 float_l text_l height64 line_hei64 color_white border_b_baise fon_siz16">
                            <span>物联网</span>
                            <span class=" float_r">></span>
                        </div>
                    </div>
                    <div class="width_700 float_l lunbofenlei dis_none img_backg16">
                    	<div class="width100 float_l padding40">
                        	<div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">分类目录</span>
                              
                                <ul class="width100 ul_lis float_l">
                                  <c:forEach items="${lllll}" var="c">
                                	<li><a  href = "<%=basePath%>DetailServ?type=${c.ctype}">${c.ctype} </a></li>
                                    <li>/</li>
                                   </c:forEach>
                                </ul>
                             
                            </div>
                            
                           
                        </div>
                    </div>
                </div>
                
                <div class="width100 float_l tab_qiehuan">
                	<div class="width100 float_l text_c height64 line_hei64 color_white bianhuabeijing backg_jqian padding_lr20">
                        <div class="width100 float_l text_l height64 line_hei64 color_white border_b_baise fon_siz16">
                            <span>设计 产品 测试</span>
                            <span class="float_r">></span>
                        </div>
                    </div>
                    <div class="width_700 float_l lunbofenlei dis_none img_backg15">
                    	<div class="width100 float_l padding40">
                        	<div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">分类目录</span>
                                
                                <ul class="width100 ul_lis float_l">
                                 <c:forEach items="${llllll}" var="c">
                                	<li><a  href = "<%=basePath%>DetailServ?type=${c.ctype}">${c.ctype} </a></li>
                                    <li>/</li>
                                      </c:forEach>
                                </ul>
                              
                            </div>
                            
                          
                        </div>
                    </div>
                </div>
                
                <div class="width100 float_l tab_qiehuan ">
                	<div class="width100 float_l text_c height64 line_hei64 color_white bianhuabeijing backg_jqian padding_lr20">
                        <div class="width100 float_l text_l height64 line_hei64 color_white border_b_baise fon_siz16">
                            <span>云计算大数据</span>
                            <span class="float_r">></span>
                        </div>
                    </div>
                    <div class="width_700 float_l lunbofenlei dis_none img_backg17">
                    	<div class="width100 float_l padding40">
                        	<div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">分类目录</span>
                               
                                <ul class="width100 ul_lis float_l">
                                  <c:forEach items="${items}" var="c">
                                	<li><a  href = "<%=basePath%>DetailServ?type=${c.ctype}">${c.ctype} </a></li>
                                    <li>/</li>
                                      </c:forEach>
                                </ul>
                              
                            </div>
                        </div>
                    </div>
                </div>   
            </div>
            
        </div>
    </div>
</div>
<script>
	$('.tab_qiehuan').hover(function(){
         $(this).children(".bianhuabeijing").css("background-color","#8a8f93").next().css("display","block")
	},function(){
    	 $(this).children(".bianhuabeijing").css("background-color","#a9aaae").next().css("display","none")
	});
</script>

<script type="text/javascript">
	jQuery(".focusBox").slide({ mainCell:".pic",effect:"left", autoPlay:true, delayTime:500});
</script>



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
            <a href="admin/login.jsp" style="color:#93999F">后台管理</a>
    	</div>
        <div class="width100 float_l text_c border_t margin_t20 padding_t20 color_gray fon_siz12">
        	<span>© 2016 imoroc.com  京ICP备13042132号</span>
        </div>
    </div>
</div>
</body>
</html>