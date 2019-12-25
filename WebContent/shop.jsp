<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%   
    String path = request.getContextPath();   
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;   
   %>
<base href="<%=basePath%>">
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>宏睿网</title>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/muke.css">
<link href="css/myCart.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
//提交订单
function checksub(){
	//进行逻辑判断--当购物车没有记录时，不能点击提交，当没有选择商品时，不能提交
	var oInput=document.getElementsByName("cartCheckBox");
	var myTableTr=document.getElementById("shopping").getElementsByTagName("tr"); 
	 var b="";
	 var a=0;
	if(myTableTr.length<=2){
		confirm("购物车还没有记录，请去添加购物车！！！");
	 }else{
		 for (var i=0;i<oInput.length;i++){
			    var  aa;
			    if(oInput[i].checked==true){
			    	aa=oInput[i].value;
			    	b+=aa;
			    	b+="-";
			    	
			    }else{
			    	a+=1;
			    }
		  }	
		 if(a==oInput.length){
				confirm("您还没有选择商品！！！");
			}
		 else{
				//location.href = "CheckOutServ?b=" + b ; 
				//将选中的商品用String连接起来（b），提交时交给CheckOutServ来操作
				location.href = "CheckOutServ?b=" + b; 
			}
	 }
	
}
function selectSingle(){
	var total=0.0;
	var check = document.getElementsByName("cartCheckBox");
	var myTableTr=document.getElementById("shopping").getElementsByTagName("tr"); 
	var k=0;
	var myArray=new Array();
	var oInput=document.getElementsByName("cartCheckBox");
	 for (var i=0;i<oInput.length;i++){
	   if(oInput[i].checked==false){
		  k=1;
		  break;
	    }   
	}
	 //k是为了当单选全部点击时触发checkall()方法
	if(k==0){
		document.getElementById("allCheckBox").checked=true;
		checkall();
		}
	else{
		document.getElementById("allCheckBox").checked=false;
		 for (var j=0;j<oInput.length;j++){
			  if(check[j].checked){
			    price=myTableTr[j+1].getElementsByTagName("td")[3].innerHTML;
			    total+=Number(price);
		     }else{
			     total+=Number(0);
		     }  
		} 
		 //单选时将计算价格显示到界面上
		 document.getElementById("total").value=total; 
		}
}
//全选
function checkall() {
	var total=0.0;
	//获取到全选的对象
	var checkall = document.getElementById("allCheckBox");
	//获取到被选对象
	var check = document.getElementsByName("cartCheckBox");
	//获取当前表单的值
	var myTableTr=document.getElementById("shopping").getElementsByTagName("tr"); 
	for(var i = 0 ; i < check.length ; i++){
		if(check[i].checked = checkall.checked){
			price=myTableTr[i+1].getElementsByTagName("td")[3].innerHTML;
			total+=Number(price);
		}else{
			total+=Number(0);
		}
	 }    
	//document.getElementById("total").innerHTML=total;
	//全选时将计算价格显示到界面上
	document.getElementById("total").value=total;
}




//全选的删除
function deleChoice(){
	 //获取需要删除的列的id的值
	 var choice = confirm("确定要删除所选内容吗？") ;
	 if(choice){
		  //获取到被选对象
	      	var check = document.getElementsByName("cartCheckBox") ;
	    	 var strs = "" ;
	      	 for(var i = 0 ; i < check.length ; i++){
	      		//判断所选的对象，如果是所选，则获取到当前的id值并添加到字符串中
	    		 if(check[i].checked){
	    			 strs += check[i].value + ",";
	    		 }       		
	    	 }
	      	  //删除操作提交给DeleServ操作,参数传递为delechoice为多个个记录删除
	      	location.href = "DeleServ?strs=" + strs + "&type=delechoice" ; 
	 }    
}
//单个删除
function dele(id){
    //制作一个对话框，做删除操作
     if( confirm("确定要删除么？") ){
    	  // alert(id) ;
    	  //删除操作提交给DeleServ操作,参数传递为deleone为单个记录删除
    	 location.href = "DeleServ?id=" + id  + "&type=deleone";
     }     
}

</script>
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
					<a href="index.jsp">返回首页</a>
					|<a href="LoginOutServ">退出</a>
				</div>
			</div>
		</div>
	</div>
	<h5 align="center">${result }</h5>
	<div id="content">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			id="shopping">
			<tr>
				<td class="title_1"><input id="allCheckBox" type="checkbox"
					name="allCheckBox" onclick="checkall()" />全选</td>
					
				<td class="title_2">课程名称</td>
				<td class="title_3">授课人</td>
				<td class="title_4">单价（元）</td>
				<td class="title_5">视频数量</td>
				<td class="title_7">操作</td>
			</tr>
		<!-- <form action="CheckOutServ" method="post" onsubmit="return check();"> -->	
			<c:forEach items="${list}" var="li">
				<tr>
					<td class="cart_td_1"><input name="cartCheckBox"
						id="cartCheckBox" type="checkbox" value="${li.gid}"
						onclick="selectSingle()" /></td>
					<td class="cart_td_2">${li.cname}</td>
					<td class="cart_td_4">${li.tname}</td>
					<td class="cart_td_5">${li.cprice}</td>
					<td class="cart_td_6">1</td>
					<td class="cart_td_8"><input type="button" value="删除"
						onclick="dele('${li.gid}')" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3"><a href="javascript:deleChoice()"><img
						src="img/taobao_del.jpg" alt="delete" /></a></td>
				<td colspan="5" class="shopend">
					<input type="text" id="total" class="yellow" style="border:0px;" value="" disabled="false"></label> 元<br />
				 <!--	<input type="submit" value="订单提交">-->
				  
					  <input name=" " type="image" src="img/taobao_subtn.jpg"  onclick="checksub()"/></td>
			</tr>
		</table>
		<!-- </form> -->
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