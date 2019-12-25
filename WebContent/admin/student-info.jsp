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
<form action="<%=basePath%>ShowStudentDetail" method="get">
<div class="title"><h2>信息管理</h2></div>    
<div class="table-operate ue-clear">
    <a href="student.jsp" >返回</a>
</div>
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
                <td class="name">${student.getUID()}</td>
            </tr>
        <tr align="center">
            	<td class="num">姓名</td>
                <td class="name">${student.getSname()}</td>
            </tr>
<tr align="center">
            	<td class="num">性别</td>
                <td class="name">${student.getSsex()}</td>
            </tr>
<tr align="center">
            	<td class="num">年龄</td>
                <td class="name">${student.getSage()}</td>
            </tr>
<tr align="center">
            	<td class="num">会员</td>
                <td class="name">${student.getSvip()}</td>
            </tr>
<tr align="center">
            	<td class="num">购买日期</td>
                <td class="name">${student.getSstart()}</td>
            </tr>
<tr align="center">
            	<td class="num">截止日期</td>
                <td class="name">${student.getSstop()}</td>
            </tr>
            <tr align="center">
            	<td class="num">用户账目</td>
                <td class="name">${student.getSaccount()}</td>
            </tr>
        </tbody>
    </table>
</div>
<div class="pagination ue-clear"></div>
</form>
</body>

</html>
