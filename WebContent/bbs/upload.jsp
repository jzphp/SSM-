<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>我的消息</title>

    <link rel="stylesheet" href="<%=basePath%>bbs/css/reset.css" />
    <link rel="stylesheet" href="<%=basePath%>bbs/css/homeHead.css" />
    <link rel="stylesheet" href="<%=basePath%>bbs/css/homePublic.css" />
    <link rel="stylesheet" href="<%=basePath%>bbs/css/myMsg.css" />
    <script type="text/javascript" src="<%=basePath%>bbs/js/jquery-1.8.3.min.js"></script>
    
<script type="text/javascript">

$(document).ready(function(){
    $('#file').click(function(){
        $.ajax({
            url:'<%=basePath%>UploadServ',
            type:'GET',
            data:'type=1',
            dataType:'text',
            success:function(data){
            	if(data!=null){
	                var i =0;
	                var a = $.parseJSON(data);
	                $("#one").find("option").remove();
	                $.each(a,function(index, el) {
	                    $("#one").append("<option value='"+el+"'>"+el+"</option>");
	                });
            	}
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });     
    });
    $('#one').mouseout(function(){
        var $v = $('#one option:selected').val();
        if($v!='请选择'){
            $.ajax({
                url:'<%=basePath%>UploadServ',
                type:'GET',
                data:'type=2&CCtype='+$v,
                dataType:'text',
                success:function(data){
                	if(data!=null){
	                    var i =0;
	                    var a = $.parseJSON(data);
	                    $("#two").find("option").remove();
	                    $.each(a,function(index, el) {
	                        $("#two").append("<option value='"+el+"'>"+el+"</option>");
	                    });
                	}
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                }
            });
        }else{
        	confirm("请联系管理员添加课程！");
        }       
    });
    $('#two').mouseout(function(){
        var $v = $('#one option:selected').val();
        var $x = $('#two option:selected').val();
        console.log($x);
        console.log($v);
        if($v!='请选择'){
            $.ajax({
                url:'<%=basePath%>UploadServ',
                type:'GET',
                data:'type=3&CCtype='+$v+'&Ctype='+$x,
                dataType:'text',
                success:function(data){
                	if(data!=null){
	                    var i =0;
	                    var a = $.parseJSON(data);
	                    $("#three").find("option").remove();
	                    $.each(a,function(index, el) {
	                        $("#three").append("<option value='"+el+"'>"+el+"</option>");
	                    });
                	}
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                }
            });
        }else{
        	confirm("请联系管理员添加课程！");
        }       
    });
    $("#three").mouseout(function(){
    	var $z = $('#three option:selected').val();
    	if($z!=null){
    		$("#Cname").val($z);
    	}else{
    		confirm("请联系管理员添加课程！");
    	}
    });
});

function checkContent(form, evt){
	var $a = $('#one option:selected').val();
	var $b = $('#two option:selected').val();
	var $c = $('#three option:selected').val();
	if($a==null || $a=='请选择'){
		confirm("请联系管理员");
		evt.preventDefault();
	}else if($b==null || $a=='请选择'){
		confirm("请联系管理员");
		evt.preventDefault();
	}else if($c==null || $a=='请选择'){
		confirm("请联系管理员");
		evt.preventDefault();
	}else if($('#videoName').val()==null){
		confirm("请输入视频名称");
		evt.preventDefault();
	}else if($("#videoLength").val()==null){
		confirm("请输入视频长度");
		evt.preventDefault();
	}
}

</script>
</head>
<body>
    <header class="zyHead">
        <div class="zyHead_cen">
            <a href="<%=basePath%>IndexServ"><img src="img/per-con.png" alt="" class="headPic1" /></a> 
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
                <li><a href="<%=basePath%>BbsbaseServ">基本设置</a></li>
                <li><a href="<%=basePath%>MyWriteServ">我的贴子</a></li>
                <li><a href="<%=basePath%>MyOrderServ">我的订单</a></li>
                <c:if test="${user.getUclass()==1}">
                    <li class="on"><a href="<%=basePath%>bbs/upload.jsp">视频上传</a></li>
            </c:if>
            </ul>
        </div>
        <div class="homeCen_right">
            <div class="baseHead">
                <p>上传</p>
            </div>
            <div class="myWrite_con">
                <form action="<%=basePath%>UploadServ" method="post" enctype="multipart/form-data" onSubmit="javascript:checkContent(this, event)">
                    <table>
                        <tr class="myMsgCon" id="filetr">
                            <td>视频文件：</td>
                            <td><input type="file" name="file" id="file"></td>
                        </tr>
                        <tr class="myMsgCon">
                            <td>一级名称：</td>
                            <td><select name="one" id="one">
                                    <option>请选择</option>
                                </select>
                            </td>
                        </tr>
                        <tr class="myMsgCon">
                            <td>二级名称：</td>
                            <td><select name="two" id="two">
                                    <option>请选择</option>
                                </select>
                            </td>
                        </tr>
                        <tr class="myMsgCon">
                            <td>课程名称：<input type="hidden" name="Cname" id="Cname"></td>
                            <td><select name="three" id="three">
                                    <option>请选择</option>
                                </select>
                            </td>
                        </tr>
                       <tr class="myMsgCon">
                            <td>视频名称</td>
                            <td><input type="text" id="videoName" name="videoName"></td>
                        </tr>
                        <tr class="myMsgCon">
                            <td>视频长度</td>
                            <td><input type="text" id="videoLength" name="videoLength">分钟</td>
                        </tr>
                        <tr class="myMsgCon">
                            <td colspan="2" style="text-align: center;">
                           		 <input type="submit" value="提交">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</body>
</html>