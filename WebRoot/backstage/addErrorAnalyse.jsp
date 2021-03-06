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
    
    <title>添加错误分析</title>
    
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
          #title{font-family: "微软雅黑" ;font-size:16px; font-weight: 600;}
            .label{font-family:"微软雅黑";font-size:12px;font-weight:300;color:red;}
            
	</STYLE>
  </head>
  

<body>
<s:form id="analyseForm" name="analyseForm" action="errorAnalyseAction_addErrorAnalyse" method="post" enctype="multipart/form-data">
<table width="100%" border="1" cellspacing="1" cellpadding="1">
  <tr>
    <td colspan="2" align="center" id="title">添加错误分析</td>
  </tr>
  <tr>
    <td>错误案例名</td>
    <td><input type="text" name="analyse.error_name" id="error_name" size="60"/><label class="label">${nameError}</label></td>
  </tr>
  <tr>
    <td>所属课程</td>
    <td><s:select id="courseSelect" name="analyse.courseId" list="#courseList" listKey="id" listValue="name"/></td>
  </tr>
  <tr>
    <td>大图</td>
    <td><input type="file" name="errorPhoto" id="large_error_photo"/><label class="label">${photoError}</label></td>
  </tr>
  <tr>
    <td>缩略图</td>
    <td><input type="file" name="thumbnail" id="thumbnail"/><label class="label">${littlephotoError}</label></td>
  </tr>
  <tr>
    <td>错误分析</td>
    <td><script id="editor" type="text/plain" name="analyse.error_analyse"></script><label class="label">${analyseError}</label></td>
  </tr>
  <tr>
    <td colspan="2"><input type="submit" id="submit" value="添加"/></td>
  </tr>
</table>
</s:form>
</body>
<script type="text/javascript">

var oForm=document.getElementById("analyseForm");
oForm.onsubmit=function(){
	if(document.getElementById("error_name").value===""||(/^\s+$/gi.test(document.getElementById('error_name').value))){
   alert("请填写错误案例名！");
    return false;
    }else if(document.getElementById("large_error_photo").value===""){
    alert("请上传大图！");
    return false;
    }else if(document.getElementById("thumbnail").value===""){
    alert("请上传缩略图！");
    return false;
    }else if(!UE.getEditor('editor').hasContents()){
    alert("请填写错误分析！");
    return false;
    }
}


var ue = UE.getEditor('editor', {
    initialFrameWidth:950,
    initialFrameHeight:250,
    autoHeightEnabled: false,
    
});
var msg='${addmsg}';
if(msg!=""){
alert(msg);
}
var oerror='${uploadError}';
if(oerror!=""){
alert(oerror);
}
</script>
</html>
