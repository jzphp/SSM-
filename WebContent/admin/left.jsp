<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active")
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>宏睿网信息管理</div>
    
    <dl class="leftmenu">
     <!--菜单--> 
<dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>用户信息
    </div>
    	<ul class="menuson">
        

        <li>
            <div class="header">
            <cite></cite>
            <a href="teacher.jsp" target="rightFrame">教师</a>
            <i></i>
            </div>                

        </li>
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="student.jsp" target="rightFrame">学生</a>
            <i></i>
            </div>                

        </li>
  
        
        </ul>    
    </dd>
   <!--菜单--> 
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>视频处理
    </div>
    	<ul class="menuson">
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="video-del.jsp" target="rightFrame">审核视频</a>
            <i></i>
            </div>
            
        </li>
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="video-del.jsp" target="rightFrame">视频下架</a>
            <i></i>
            </div>                

        </li>
        </ul>    
    </dd>

       <!--菜单--> 
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>论坛管理
    </div>
    	<ul class="menuson">
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="luntan.jsp" target="rightFrame">帖子删除</a>
            <i></i>
            </div>
         	
        </li>
        </ul>    
    </dd>
 
    </dl>
    
</body>
</html>
