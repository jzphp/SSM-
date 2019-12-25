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
</head>

<body>
<form action="<%=basePath%>ShowTeacherDetail" method="get">
<div class="title"><h2>信息管理</h2></div>    
<div class="table-operate ue-clear">
    <a href="teacher.jsp" >返回</a>
</div>
</form>
<div class="table-box">
	<table align="center" border=1 width=300px>
    	<thead>
        	<tr>
            	<th class="num">属性</th>
                <th class="name">信息</th>
            </tr>
        </thead>
       
        <tbody>
        
        	<tr align="center">
            	<td class="num">用户编号</td>
                <td class="name">${teacher.getUID()}</td>
            </tr>
        <tr align="center">
            	<td class="num">姓名</td>
                <td class="name">${teacher.getTname()}</td>
            </tr>
<tr align="center">
            	<td class="num">手机号</td>
                <td class="name">${teacher.getUphone()}</td>
            </tr>
<tr align="center">
            	<td class="num">年龄</td>
                <td class="name">${teacher.getTage()}</td>
            </tr>
            <tr align="center">
            	<td class="num">性别</td>
                <td class="name">${teacher.getTsex()}</td>
            </tr>
            <tr align="center">
            	<td class="num">教育背景</td>
                <td class="name">${teacher.getTbackground()}</td>
            </tr>
            <tr align="center">
            	<td class="num">上传课程数</td>
                <td class="name">${teacher.getTcourse()}</td>
            </tr>
            <tr align="center">
            	<td class="num">账户金额</td>
                <td class="name">${teacher.getTmonery()}</td>
            </tr>

        </tbody>
        
    </table>
</div>
<div class="pagination ue-clear"></div>
</body>

</html>
