<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
 <base href="<%=basePath%>">
	<meta charset="UTF-8">
    
    <title>优课上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

 <style>
    td {font-family:"微软雅黑";font-size:14px;}
    label{font-family:"微软雅黑";font-size:12px;color:red;}
    </style>
  </head>
  
  <body>
  <form name="otherForm" id="otherForm" action="toolsAction_othersUpload?uclass=1" method="post" enctype="multipart/form-data">
  <table width="100%" border="0" cellpadding="1" cellspacing="1">
  <tr bgcolor="#ccccff">
    <td colspan="3" align="center" style="font-family:'微软雅黑';font-size:14px; font-weight:600;">腾云优课上传</td>
  </tr>
  <tr bgcolor="#ccccff">
    <td>上传资源文件：</td>
    <td><input type="file" id="file" name="other" /><label id="fileUpError">${otherError}</label></td>
 
  </tr>
  <tr bgcolor="#ccccff">
    <td>确认上传：</td>
    <td><input type="submit" value="提交"></td>
  
  </tr>
</table>
</form>
  </body>
</html>
