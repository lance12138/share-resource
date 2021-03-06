<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
 <base href="<%=basePath%>">
	<meta charset="UTF-8">		
	<title>教学教改</title>
		<link type="text/css" rel="stylesheet"
			href="style/teaching_archives.css" />
		<script type="text/javascript" src="js/common.js">
</script>
<STYLE type="text/css">
#title {
	padding-top: 24px;

	height: 30px;
	width: 980px;
	background: white;
}

#title h2 {
	font-size: 18px;
	font-family: YouYuan, "幼圆";
	font-weight: bold;
	text-align: center;
}

#title .h5 {
	font-size: 12px;
	font-family: YouYuan, "幼圆";
	color: gray;
	float: right;
	margin-right: 80px;
	margin-top: 12px;
}

#title .h5 {
	font-size: 12px;
	font-family: YouYuan, "幼圆";
	color: gray;
	float: right;
	margin-right: 80px;
	margin-top: 12px;
}

#news {

	padding-top: 40px;
	padding-bottom: 40px;;
	font-size: 12px;
	background: white;
	width: 980px;
	font-family:"微软雅黑";
}
#news p{
	line-height:1.5em;
}

#nextPage {
	width: 980px;
	height: 60px;
	background: #E3E3E3;

	margin-top: 2px;
}

#nextPage span {
	font-size: 14px;
	margin-left: 20px;
}

#nextPage .innerPage {
	padding-top: 12px;
}
.content{width:980px; height:auto; margin:10px auto; background:#E6E6E6; position:relative;}
.content h1{width:980px; height:30px; font-family:"微软雅黑"; font-size:16px; color:#FFF; background:#01c675; text-align:center; line-height:30px;}

</STYLE>
		<script>

</script>
	</head>

	<body>
		<header id="header"><img id="logo" src="images/logo_white.png" alt="logo" width="340" height="90" /></header>

		<nav id="nav">
		<a href="index.jsp">平台主页</a>
		<a href="#">课程简介</a>
		<a href="#">师资队伍</a>

		<a href="#">实践项目</a>
		<a href="#">作业提交</a>
		<a href="#">在线互动</a>
		</nav>
		<div class="content">
			<h1>教学教改</h1>
			<div id="news">
				<div style="width: 830px; margin-left: 80px;">
					<p>
						${teachTool.teachChange}
					</p>
					
				</div>
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
