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
    
    <title>作业提交</title>
<link type="text/css" rel="stylesheet" href="style/coursepagecommen.css" />
<link type="text/css" rel="stylesheet" href="style/handuphomework.css" />
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor1/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor1/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="ueditor1/lang/zh-cn/zh-cn.js"></script>
<link rel="stylesheet" type="text/css" href="ueditor1/themes/default/css/ueditor.min.css">
	 

<script>
window.onload=function()
{
	var error=document.getElementById("homeworkError");
	if(error.value===""||error.value===null){
	
	}else{
	alert(error.value);
	}
}
</script>
</head>

<body>&nbsp; 
<header id="header"><img id="logo" src="images/logo_white.png" alt="logo" width="340" height="90" /></header>
<nav id="cnav">
	<a href="index.jsp">平台主页</a>
    <a href="toolsAction_showTeachChange">教学教改</a>
   <a href="homeworkUploadAction_addTeacherList" class="active">作业提交</a>
 <a href="userAction_academyList">竞赛报名</a>
    <a href="activityAction_addUI">教研活动</a>
   <a href="courseAction_addDownload_homework">下载入口</a>
</nav>
<div class="content clearfix">
	<h1>作业提交系统</h1>
	<s:form id="homeworkForm" name="homeworkForm" action="homeworkUploadAction_uploadHomework" method="post" enctype="multipart/form-data">
	<input type="hidden" id="homeworkError" name="error" value="${error}"/>
    <div class="inputarea">
    <li>收件老师:
        	<div class="reset_select">
            	<s:select id="teachterName" name="homework.teacherName" list="#teacherList" listKey="major" listValue="major"/>
            </div>
    </li>
    <li>作业主题:<input type="text" id="topic" name="homework.topic"/> <input class="inputfile" type="file" name="attach" multiple/></li>
    <li class="text_area">
    详细内容:
     <script id="editor" type="text/plain" name="homework.description"></script>
  
    </li>
    <li>
    	<input type="submit" class="homeworksubmit" value="确认提交" />
    </li>
    
    </div>
    </s:form>
</div>

<footer>
	<div class="footer_link">
    	<a href="javascript:void(0);" onclick="AddFavorite(window.location,document.title)">加入收藏</a><a href="backLogin.jsp">进入后台</a>
    
    <script>
    	//  
	
		function AddFavorite(sURL, sTitle)
		{
		
		    try
		    {
		        window.external.addFavorite(sURL, sTitle);
		    }
		    catch (e)
		    {
		        try
		        {
		            window.sidebar.addPanel(sTitle, sURL, "");
		        }
		        catch (e)
		        {
		            alert("加入收藏失败，请使用Ctrl+D进行添加");
		        }
		    }
		}
    
    </script>
    </div>
	<p>
    	Copyright© 2015 江西理工大学.All Rights Reserved.<br />
  		学校地址：江西省赣州市红旗大道86号 邮编：341000<br />
  		制作维护：  江西理工大学信息学院Delta工作室  工作群：85669528 <br />


    </p>
</footer>

</body>
<script>
  var ue = UE.getEditor('editor', {
    initialFrameWidth:750,
    initialFrameHeight:200,
    autoHeightEnabled: false,
    
});

</script>
</html>
