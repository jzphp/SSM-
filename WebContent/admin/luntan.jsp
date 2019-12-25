
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%   
    String path = request.getContextPath();   
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;   
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
<script type="text/javascript" >
function dele(id){
	//制作一个对话框，作删除操作
	if(confirm("确定要删除吗？")){
		//alter(id);
		//删除操作提交给DeleServ操作，参数传递给deleone为单个记录删除
		location.href="LunDelete?id="+id+"&type=deleone";	
	}
}

</script>
</head>

<body>
<form action="<%=basePath%>AdminL" method="post">
<div class="title"><h2>信息管理</h2></div>
<div class="query">
	<div class="query-conditions ue-clear">
        <div class="conditions name ue-clear">
          <!--  <label>帖子类别：</label>
            <div class="select-wrap">
                <div class="select-title ue-clear"><span>请选择</span><i class="icon"></i></div>
                <ul class="select-list">
                    <li>JSP</li>
                    <li>C#</li>
                    <li>JAVA</li>
                </ul>
            </div>
        </div>  
         --> 
    <div class="conditions staff ue-clear">
            <label>帖子主题：</label>
            <input type="text"  name="ptheme" placeholder="可以直接输入" />
        </div>
    <!--  <div class="conditions time ue-clear">
            <label>上传时间：</label>
            <div class="time-select">
            	<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"  placeholder="开始时间" />
                <i class="icon"></i>
            </div>
            <span class="line">-</span>
            <div class="time-select">
            	<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"  placeholder="开始时间" />
                <i class="icon"></i>
            </div>
        </div>
          -->  
        <div class="conditions staff ue-clear">
            <label>帖子ID：</label>
            <input type="text"  name="pID" placeholder="可以直接输入" />
        </div>
    </div>
    <div class="query-btn ue-clear">
    <input type="submit" value="查询" class="confirm"></input>
    	<%--<a href="<%=basePath%>AdminL" class="confirm">查询</a>--%>
        
    </div>
</div>
</form>
<div class="table-operate ue-clear">
    <a href="javascript:;" class="del">删除</a>
    <a href="javascript:;" class="edit">编辑</a>
    <a href="javascript:;" class="count">统计</a>
    <a href="javascript:;" class="check">审核</a>
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
            	<th class="pID">帖子编号</th>
                <th class="ptheme">帖子主题</th>
                <th class="process">所属类别</th>
                <th class="node">上传时间</th>
                <th class="operate">操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="invatition">
        	<tr>
            	<td class="pID">${invatition.getPID()}</td>
                <td class="ptheme">${invatition.getPtheme()}</td>
                <td class="process">${invatition.getPcontext()}</td>
                <td class="node">${invatition.getPtime()}</td>
                <td align="center">
                <input type="button" value="删除" onclick="dele('${invatition.getPID()}')" />
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div class="pagination ue-clear"></div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript">
$(".select-title").on("click",function(){
	$(".select-list").hide();
	$(this).siblings($(".select-list")).show();
	return false;
})
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
})

$('.pagination').pagination(100,{
	callback: function(page){
		alert(page);	
	},
	display_msg: true,
	setPageNo: true
});

$("tbody").find("tr:odd").css("backgroundColor","#eff6fa");

showRemind('input[type=text], textarea','placeholder');
</script>
</html>
