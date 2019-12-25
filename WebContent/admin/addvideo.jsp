<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
           <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
  <p>&nbsp</p>
   <p>&nbsp</p>
   <p>&nbsp</p>
   <p>&nbsp</p>
   <h2  align = "center">请添加需要上传的视频信息</h2>
  <div align = "center">
  <form action = "<%=basePath %>AddServ" method = "post" enctype="multipart/form-data" >     
			<table border = "1">
			   <tr>
			      <td>视频ID</td>
			      <td><input type = "text" name = "id" /></td>
			   </tr>
			   <tr>
			       <td>视频名称</td>
			       <td><input type = "text" name = "name"/></td>
			   </tr>
			   <tr>
			      <td>课程ID</td>
			      <td><input type = "text" name = "cid"/></td>
			   </tr>
			    <tr>
			      <td>视频长度</td>
			      <td><input type = "text" name = "vlength"/></td>
			   </tr>
			    <tr>
			      <td>路径</td>
			      <td><input type = "file" name = "path"/></td>
			   </tr>
			   <tr>
			     <td colspan = "2"  align = "center"><input type = "submit" value = "提交"/></td>
			   </tr>
			</table>
  </form>
</body>
</html>