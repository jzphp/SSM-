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
<form action="<%=basePath%>AdminS" method="post">
<div class="title"><h2>信息管理</h2></div>
<div class="query">
	<div class="query-conditions ue-clear">
        
    <div class="conditions staff ue-clear">
            <label>教师姓名：</label>
            <input type="text" name="username" placeholder="可以直接输入" />
        </div>
        
        <div class="conditions staff ue-clear">
            <label>教师编号：</label>
            <input type="text" name="uid" placeholder="可以直接输入" />
        </div>
    </div>
    <div class="query-btn ue-clear">
    	<input type="submit" value="查询" class="confirm"></input>
    	<%-- <a href="<%=basePath%>AdminS" class="confirm">查询</a> --%>
       
    </div>
</div>
</form>

<div class="table-box">
	<table>
    	<thead>
        	<tr>
            	<th class="uid">教师编号</th>
                <th class="username">教师姓名</th>
                <th class="process">手机号码</th>
                <th class="operate">操作</th>
        </thead>
        <tbody>
         <c:forEach items="${list}" var="teacher">
        	<tr>
            	<td class="uid">${teacher.getUID()}</td>
                <td class="username">${teacher.getTname() }</td>
                <td class="process">${teacher.getUphone()}</td>
                <td class="operate"><a href="ShowTeacherDetail?id=${teacher.getUID()}" class="operate">查看</a></td>
                
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
</html>
