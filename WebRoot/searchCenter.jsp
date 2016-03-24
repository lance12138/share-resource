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
    
  <title>查询中心</title>
<script type="text/jscript" src="js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="style/pagecommen.css" />
<script type="text/jscript" src="js/common.js"></script>
<style type="text/css">
    /* 查询中心 */
    .content{ background:#fff; height:auto;position:relative;}

    .content h1 a{ cursor:pointer; float:left; height:30px; width:490px;color:#fff; z-index:1; }
    .content h1 .active{cursor:pointer; background:#fff; width:488px;color:#01c675;}
    .download_top_bar{ width:980px; height:77px; padding:0 10px; }
    .basic_info{ width:960px; height:30px; line-height:30px; color:#01c675; font-family:"微软雅黑"; font-size:12px; text-align:right;}
    .tool_bar{ width:938px; height:45px; background:#f7f7f7;color:#666; border:1px solid #ccc; position:relative; padding: 0 30px; line-height:45px; border-radius:5px 0px 0px 5px;  -moz-border-radius:5px; font-family:"微软雅黑"; padding-right:0; }
    .tool_bar .left_bar{ float:left; border-right:1px solid #E5E5E5; width:524px;}
    .tool_bar .right_bar{float:left;padding:0 10px; border-left:1px solid #fff;}

    .file_area{ width:980px; height:450px;overflow-y:auto; overflow-x:hidden; }
    .file_area .file_area_content{ width:940px; height:auto; background:#fff; padding:0 10px;}
    .file_area .file_area_content li{ cursor:pointer;width:960px; height:40px; border-bottom:1px solid #ccc; line-height:40px;}

    .file_area .file_area_content li a{color: #01c675;font-family:"微软雅黑"; font-size:12px; text-decoration: underline;}
    .file_left{ float:left; width:374px; padding-left:11px;white-space: nowrap;overflow: hidden;text-overflow: ellipsis; }
    .file_left input[type="checkbox"]{cursor:pointer; margin-right:4px;}
    .file_right{float:left;margin-left:180px; width: 390px;}
    #download {float:right; margin-top: 5px; border: 1px solid #009e5d; height:30px; background-color:#01c675;  color:#fff; padding:0 10px;font-family:"微软雅黑"; font-size:12px; margin-right:5px;  cursor:pointer;text-decoration: none;}
    #download:hover{ background:#009e5d; }
     #fileView{width:650px;height:450px;border:1px solid #01c675;z-index:5;position:absolute;top:50px;left:150px;background:#ccc;display:none;border-radius:10px;}
     #exit{width:40px;height:20px;brder:1px solid #ccc;position:absolute;top:0px;left:610px;z-index:7;border-radius:10px;background:#BE2D2D;font-family:"微软雅黑";font-size:14px;font-weight:300;color:white;}
     #dialogTitle{width:650px;height:20px;background:#01c675;position:absolute;top:0px;left:0px;z-index:6;border-top-right-radius:10px;border-top-left-radius:10px;}
     #dialogTitle a{margin-left:20px;font-weight:600;font-family: "微软雅黑";font-size:14px;}
     
</style>

<script>

window.onload=function()
{
	//导航JS
	
	var oNav= document.getElementById('nav');
	var aNavBtns=oNav.getElementsByTagName('a');
	var oSearchBtn=document.getElementById('search_btn');
	var iSearchIndex=0;
	var iIntroduceMoerIndex=0;
	
	var oSearchBox=document.getElementById('search_box');
	var oSearchInput=document.getElementById('search_input');
	
	
	
	
	//导航搜索按钮
	oSearchBtn.onmousemove=function()
	{
		oSearchBtn.style.height=10+'px';
		oSearchBtn.style.background='#01c675';
		oSearchBtn.style.borderBottom='4px #00a05e solid';
		oSearchBtn.getElementsByTagName('span')[0].className='active';
		
	}
	oSearchBtn.onmouseout=function()
	{
		oSearchBtn.style.height=14+'px';
		oSearchBtn.style.background='#fff';
		oSearchBtn.style.borderBottom='none';
		oSearchBtn.getElementsByTagName('span')[0].className='';
	}
	oSearchBtn.onclick=function()
	{
		if(iSearchIndex%2==0)
			{
				oSearchBox.style.display='block';
				startMove(oSearchBox,{opacity:100});
			}
			
		else{
				oSearchBox.style.display='none';
				startMove(oSearchBox,{opacity:0});
			}
			
		iSearchIndex++;
		
	}
	
	//搜索输入框提示js
	oSearchInput.onfocus=function()
	{
		if(this.value==this.defaultValue)
		{
			
			this.value='';
			this.style.color='#a1a1a1'
		}
		
	}
	oSearchInput.onblur=function()
	{
		if(!this.value)
		{
			this.value=this.defaultValue;
			this.style.color='#ccc';
		}
	}
	var oerror=document.getElementById("error").value;
	if(oerror!=""){
	alert(oerror);
	}
	
	
}
</script>

</head>

<body>
<header id="header"><img id="logo" src="images/logo_white.png" alt="logo" width="340" height="90" /></header>
<nav id="nav">
	<a href="index.jsp" >平台主页</a>
    <a href="toolsAction_showTeachChange">教学教改</a>
    <a href="homeworkUploadAction_addTeacherList">作业提交</a>
    <a href="userAction_academyList">竞赛报名</a>
    <a href="activityAction_addUI">教研活动</a>
    <a href="courseAction_addDownload_homework">下载入口</a>
    <a href="javascript:void(0);" id="search_btn" class="active"><span></span></a>
    
    
</nav>
<div class="search_box" id="search_box">
<form action="downloadResourceAction_SelectAll" method="post">
<input type="text" id="search_input" name="search_input" value="请输入需搜索的内容" />
<input type="button" id="search_submit" value="GO" />
</form>
</div>
<div class="content">
	<h1>
	查询中心
    </h1>
	<div class="download_top_bar">
    	<div  class="basic_info">
        	
            全部文件（共${count}个）
        </div>
        <div class="tool_bar">
        	<div class="left_bar">
            	文件名称
            </div>

            <div class="right_bar">
            	上传日期
            </div>
        </div>
    </div>
    <div class="file_area">
    	<div class="file_area_content">
    	<input type="hidden" name="error" id="error" value="${error}"/>
    	<s:iterator id="gz" value="keyList">
        		<li>
            	<div class="file_left"><a href="downloadResourceAction_resourceDownload?resourceId=${id}&downloadId=${type}&courseid=${courseId}">${gz.resourceName}</a></div>
               
                <div class="file_right">${gz.uploadDate}

                </div>
               
            </li>
            
           </s:iterator>
        </div>


    </div>
    <div id="fileView">
    
    </div>
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
