<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <style>
    
   
    #osubmit{ text-align: center;}
    </style>
    <title>添加教学教改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<script type="text/javascript" charset="utf-8" src="ueditor1/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor1/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="ueditor1/lang/zh-cn/zh-cn.js"></script>
	<link rel="stylesheet" type="text/css" href="ueditor1/themes/default/css/ueditor.min.css">
  </head>
  
  <body>
  <form action="toolsAction_addTeachChange" method="post">
   <script id="editor" type="text/plain" name="tool.teachChange"></script>
 	<input type="submit" id="osubmit" value="添加"/>
 	</form>
  </body>
  <script>
   var ue = UE.getEditor('editor', {
    initialFrameWidth:900,
    initialFrameHeight:350,
    autoHeightEnabled: false,
    
});
  </script>
</html>
