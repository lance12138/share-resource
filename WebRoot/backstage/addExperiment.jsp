<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
 <base href="<%=basePath%>">
	<meta charset="UTF-8">
    
    <title>实验上传</title>
    <style>
    .label{font-family: '微软雅黑' font-size:12px;color:red;}
    
    </style>
    	<script type="text/javascript">
    	window.onload=function(){
    	var btn=document.getElementById("button");
    	btn.onclick=function(){
    	if(document.getElementById("experUp").value==""){
    	document.getElementById("expermentUpError").textContent="请先上传实验再提交！！";
    	return false;
    	}else{
    	document.ExperimentForm.submit();
    	}
    	}
    	}
    	</script>
  </head>
  
  <body>
 
    <s:form action="resourceAction_addExercises?type=4" name="ExperimentForm" id="ExperimentForm" method="post" enctype="multipart/form-data">
<table width="100%" border="0" cellpadding="1" cellspacing="1">
  <tr  bgcolor="#ccccff" >
    <td colspan="2" align="center"><strong>实验上传</strong></td>
  </tr>
  <tr  bgcolor="#ccccff" >
    <td width="18%">选择课程</td>
    <td width="82%"><s:select name="resource1.title" id="resource_title" list="#CourseList" 
													listKey="name" listValue="name" /><label class="label">${experimentError}</label></td>
  </tr>
  <tr  bgcolor="#ccccff" >
    <td>案例上传</td>
    <td><input type="file" id="experUp" name="exercise" multiple/><lable id="expermentUpError" class="label">${expermentUpError}</lable></td>
  </tr>
  <tr  bgcolor="#ccccff" >
    <td>确认上传</td>
    <td><input type="button" id="button" value="确认上传"/></td>
  </tr>
</table>
   
  
   </s:form>
  </body>
</html>
