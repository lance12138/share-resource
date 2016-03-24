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
   <title>没有微视频</title>
<link rel="stylesheet" type="text/css"  href="style/vediopage.css" />
<script type="text/javascript" src="js/common.js"></script>
<script src="js/jquery-1.9.1.min.js"></script>
<style>
 .content {
 	height:500px;
 }
 .content h1{
 	padding-top:20%;padding-left:-200px;font-family:"微软雅黑";color:#01C675;
 	}
</style>
</head>

<body>
&gt;<header id="header"><img id="logo" src="images/logo_white.png" alt="logo" width="340" height="90" /></header>
<nav id="cnav">
	<a href="index.jsp">平台主页</a>
   <a href="courseAction_enterCourse?courseid=${course.id}">课程简介</a>
    <a href="teachTeamAction_addUI?courseid=${course.id}">师资队伍</a>
    <a href="programAction_list?courseid=${course.id}">实践项目</a>
    <a href="homeworkUploadAction_addTeacherList">作业提交</a>
   <a href="forumAction_list">在线互动</a>
   <a href="#">在线互动</a>
</nav>
<div class="content">
	<h1>没有视频，请联系管理员！</h1>     
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
</html>
