<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
 <base href="<%=basePath%>">
	<meta charset="UTF-8">
    
    <title>添加实训项目</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<script type="text/javascript" charset="utf-8" src="ueditor1/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor1/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="ueditor1/lang/zh-cn/zh-cn.js"></script>
	<link rel="stylesheet" type="text/css" href="ueditor1/themes/default/css/ueditor.min.css">

<STYLE type="text/css">
	  table, td, tr{border: 1px solid #7EC0E5;}
          table tr td{ background: #f3f3f3;}
          #title{font-family: "微软雅黑" ;text-align: center;}
            .label{font-family:"微软雅黑";font-size:12px;font-weight:300;color:red;}
	</STYLE>
  </head>
  
  <body>
  <form  id="trainForm" name="trainForm" action="programAction_addProgram" method="post" enctype="multipart/form-data">
   <table width="100%" border="1" cellspacing="1" cellpadding="1">
   <div id="title">
   <h3>添加实训项目</h3>
  </div>
  <tr>
    <td>项目标题</td>
    <td><input type="text" id="pro_title" name="program.pro_title" size="60"/><label class="label" id="titleError">*${titleError}</label></td>
  </tr>
  <tr>
    <td>所属课程</td>
    <td><s:select list="#courseList" listValue="name" listKey="id" name="program.courseId"/></td>
  </tr>
  <tr>
    <td>上传项目视频</td>
    <td><input type="file" name="video" id="pro_video"/><label class="label" id="videoError">*${videoError}</label></td>
  </tr>
  <tr>
    <td>项目描述</td>
    <td>  <script id="editor" type="text/plain" name="program.pro_content"></script><label class="label" id="contentError">*${contentError}</label></td>
  </tr>
  <tr>
    <td>添加</td>
    <td><input type="submit" value="添加"/></td>
  </tr>
</table>
</form>
  </body>
  <script>
   var ue = UE.getEditor('editor', {
    initialFrameWidth:850,
    initialFrameHeight:350,
    autoHeightEnabled: false,
    
});
  var oForm=document.getElementById("trainForm");
	oForm.onsubmit=function(){
    if(document.getElementById("pro_title").value===""||(/^\s+$/gi.test(document.getElementById('pro_title').value))){
         document.getElementById("titleError").textContent="项目标题不可为空！";
         return false;
       }else if(document.getElementById("pro_title").value===""){
       document.getElementById("videoError").textContent="请上传视频！";
       return false;
       }else if(!UE.getEditor('editor').hasContents()){
         document.getElementById("contentError").textContent="请上传视频！";
       return false;
       }
	}
	var omsg='${msg}';
	if(omsg!=""){
	alert(omsg);
	}
  </script>
</html>
