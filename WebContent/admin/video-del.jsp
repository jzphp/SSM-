<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/info-mgt.css" />
<link rel="stylesheet" href="css/WdatePicker.css" />
<title>后台管理系统</title>
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">

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
	      	 confirm(strs);
	      	  //删除操作提交给DeleServ操作,参数传递为delechoice为多个个记录删除
	      	location.href = "DeleVideoServ?strs=" + strs + "&type=delechoice" ; 
	 }    
}

function dele(id){
    //制作一个对话框，做删除操作
     if( confirm("确定要删除么？") ){
    	  // alert(id) ;
    	  //删除操作提交给DeleServ操作,参数传递为deleone为单个记录删除
    	  var path = "DeleVideoServ?id=" + id  + "&type=deleone";
    	  console.log(path);
    	 location.href = path;
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
		document.getElementById("checkall").checked=true;
		checkall();
		}
	else{
		document.getElementById("checkall").checked=false;
		} 
		
}

function checkall() {
	//获取到全选的对象
	var checkall = document.getElementById("checkall");
	//获取到被选对象
	var check = document.getElementsByName("cartCheckBox");
	//获取当前表单的值
	var myTableTr=document.getElementById("shopping").getElementsByTagName("tr"); 
	 for(var i = 0 ; i < check.length ; i++){
		 check[i].checked = checkall.checked ;
	 }  
}
</script>

</head>

<body>
<form action = "<%=basePath%>ShowVideoServ" method = "get">
<div class="title"><h2>信息管理</h2></div>
<div class="query">
	<div class="query-conditions ue-clear">
        <div class="conditions name ue-clear">
            <label>视频编号：</label>
            <input type="text" name="id"  value="" placeholder="可以直接输入" />
        </div>
    	<div class="conditions staff ue-clear">
            <label>视频名称：</label>
            <input type="text" name="name"  value="" placeholder="可以直接输入" />
        </div>
    </div>
    <div class="query-btn ue-clear">
        <input type="submit" value="查询" class="submit_btn" ></input>
    </div>  
</div>

<div class="table-box">
<table border="1" width="100%" id="shopping">
	<input id="checkall" type="checkbox"
					name="allCheckBox" onclick="checkall()" />全选
	<input type = "button" value = "删除所选内容" onclick = "deleChoice()"/>
	   
		<tr>
		    <td align="center"></td>
			<td align="center">视频ID</td>
			<td align="center">视频名称</td>
			<td align="center">课程名称</td>
			<td align="center">视频长度</td>
			<td align="center">路径</td>
			<td align="center">操作</td>
		</tr>
		 <c:forEach items="${list}" var="video">		
		<tr>
			<td ><input name="cartCheckBox"
						id="cartCheckBox" type="checkbox" value="${video.videoID}"
						onclick="selectSingle()" /></td>
			<td align="center">${video.videoID }</td>
			<td align="center">${video.videoName}</td>
			<td align="center">${video.CID}</td>
			<td align="center">${video.VLength}</td>
			<td align="center">${video.path}</td>
			<td align="center"><!--<a href="ShowVideoDetailServ?id=${video.videoID}">查询</a> -->
			<input type="button" value="删除"
						onclick="dele('${video.videoID }')" />
			</td>
		</tr>
		</c:forEach>
	</table>
</div>
<div class="pagination ue-clear"></div>
</form>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>

</html>
