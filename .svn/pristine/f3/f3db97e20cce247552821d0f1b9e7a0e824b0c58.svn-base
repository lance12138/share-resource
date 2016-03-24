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
    
    <title>课程资源上传</title>
    <style>
    td {font-family:"微软雅黑";font-size:14px;}
    label{font-family:"微软雅黑";font-size:12px;color:red;}
    </style>
    <script>
    window.onload=function(){
    
    var oForm=document.getElementById("downloadResForm");
    oForm.onsubmit=function(){
    if(document.getElementById("file").value===""){
      document.getElementById("fileUpError").textContent="请先上传文件再上传！";
      return false;
    }else if(document.getElementById("resourseName").value===""||(/^\s+$/gi.test(document.getElementById('resourseName').value))){
     document.getElementById("fileNameError").textContent="文件名称不可为空！";
     return false;
    }else{
    oForm.submit();
    }
    
    }
    }
    </script>
	
  </head>
  
  <body>
  <s:form name="downloadResForm" id="downloadResForm" action="downloadResourceAction_courseResUpload" method="post" enctype="multipart/form-data">
  <table width="100%" border="0" cellpadding="1" cellspacing="1">
  <tr bgcolor="#ccccff">
    <td colspan="3" align="center" style="font-family:'微软雅黑';font-size:14px; font-weight:600;">课程资源上传</td>
  </tr>
  <tr bgcolor="#ccccff">
    <td width="15%">选择课程：</td>
    <td><s:select name="courseName" id="resource_title" list="#courseList" 
													listKey="name" listValue="name" /></td>

  </tr>
  <tr bgcolor="#ccccff">
    <td>选择资源类型：</td>
    <td><s:select name="downloadResource.type" list="#{1:'教学教改',2:'教学课件',3:'重点难点'}" listKey="key" listValue="value"></s:select></td>

  </tr>
  <tr bgcolor="#ccccff">
    <td>上传资源文件：</td>
    <td><input type="file" id="file" name="resource" /><label id="fileUpError">${error}</label></td>
 
  </tr>
  <tr bgcolor="#ccccff">
    <td>文件名称：</td>
    <td><input type="text" id="resourseName" name="downloadResource.ResourceName" size="30"/><label id="fileNameError">${fileNameError}</label></td>
 
  </tr>
  <tr bgcolor="#ccccff">
    <td>确认上传：</td>
    <td><input type="submit" value="提交"></td>
  
  </tr>
</table>
</s:form>
  </body>
</html>
