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

    <title>错误剖析</title>
    <link type="text/css" href="style/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="style/coursepagecommen.css" />
    <script type="text/javascript" src="js/common.js"></script>
    <style>
        /*导航部分*/
        nav {
            height: 54px;
            background: #fff;
            width: 980px;
            margin: 2px auto;
            z-index: 1;
        }


        nav a {
            display: block;
            height: 54px;
            line-height: 54px;
            width: 163px;
            text-align: center;
            float: left;
            border-right: 1px solid #dfdfdf;
            color: #a1a1a1;
            font-size: 16px;
            font-family: "微软雅黑";
        }
        nav :last-child{
        width: 165px;
    }

        nav a:hover, .active {
            text-decoration: none;
            background: #01c675;
            border-bottom: 4px #00a05e solid;
            height: 54px;
            color: #fff;
        }


        .content{ height: auto;background-color: #f3f3f3; padding-bottom: 40px; position: relative;}
        .wrap {
            width: 100%;

        }

        .error-analysis-list {
            width: 100%;
            margin: 0px 35px;
            padding-top: 20px;
        }

        .error-analysis-items {
            width: 92%;
            margin-bottom: 20px;
            background-color: #fff;
            padding: 20px 40px;
            border-radius: 5px;
            box-shadow: #333 2px 2px 2px;
            font-family:"微软雅黑";


        }
        .error-analysis-items h3{
            font-size: 16px;
            margin-bottom: 10px;
        }
        .item-body {
            width: 100%;
            overflow: hidden;
        }
        .item-body h3{
            float: left;
            width: 200px;
        }
        .item-body .text{
            float: left;
            text-indent: 2em;
            width: 500px;
            
        }
        .item-body a{
            float: right;
        }

        /*翻页*/

        .toolbar{position:absolute; bottom:0; width:100%; height:38px; background:#f3f3f3; margin:0 auto; line-height:35px; }
        .toolbar > a{display:block;float:left;margin-top:2px; width:80px; height:20px; line-height:20px; text-align:center;margin-right:10px;font-size:14px; font-family:Verdana; color:#fff;}
        .toolbar > a:hover{ background:#01c675; color:#fff;}
        .toolbar .active{ background:#01c675; color:#fff;}
        .toolbar .pre{ position:absolute; top:5px; display:block;  background:#01c675; width:80px; height:26px; line-height:26px; left:400px;font-family:"微软雅黑";font-size:14px;}
        .toolbar .next{ position:absolute; top:5px; display:block; background:#01c675; width:80px; height:26px;line-height:26px;  left:500px;font-family:"微软雅黑";font-size:14px;}
        .toolbar .pre:hover{ border:2px solid #9F0;  text-decoration:none;}
        .toolbar .next:hover{  border:2px solid #9F0; text-decoration:none;}

        .jumpbox{ position:absolute; height:32px; line-height:32px; font-family:"微软雅黑";font-size:14px; color:#01c675; left:600px; top:5px;}
        .jumpbox input{ border:1px solid #ccc; width:18px; height:10px; line-height:10px; padding:4px 4px;font-family:"微软雅黑";font-size:12px;border-radius:5px; -moz-border-radius:5px;}
        .jumpbox a{ color:#ccc;}
        .jumpbox a:hover{ color:#01c675;}

        /*模态框样式*/
        .modal .modal-dialog {

            margin: 0px auto;
            margin-left: 190px;
            width: 1000px;
        }

        .modal-title {
            font-size: 20px;
            font-family: "微软雅黑";
        }
        .modal-title {
            color: #01c675;
            font-size: 20px;
            font-family: "微软雅黑";
        }
        .modal-body{padding:20px 60px;}
        .modal-body ul li a {
            color: #666;
            text-decoration: none;
            font-size: 16px;
            font-family: "微软雅黑";
            margin-bottom: 10px;
        }

        .modal-body ul li a:hover {
            color: #01c675;
        }

    </style>

</head>

<body>

<header id="header"><img id="logo" src="images/logo_white.png" alt="logo" width="340" height="90" /></header>
<nav id="cnav">
    <a href="index.jsp">平台主页</a>
    <a href="courseAction_enterCourse?courseid=${courseid}">课程简介</a>
      <a href="teachTeamAction_addUI?courseid=${courseid}">师资队伍</a>
    <a href="programAction_list?courseid=${courseid}">实践项目</a>
    <a href="homeworkUploadAction_addTeacherList">作业提交</a>
   <a href="forumAction_list">在线互动</a>
</nav>
<div class="content" id="content">
       <div class="toolbar">
 <s:if test="toolBar.pageCount > 0">
						 <s:if test="toolBar.pageIndex > 1">
        <a class="pre" href='javascript:jumping(<s:property value='toolBar.previousPage'/>)'>上一页</a>   	
							</s:if>
							<s:else>
								 <a href="javascript:void(0);" class="pre">上一页</a>   	
							</s:else>
 <s:if test="toolBar.pageIndex == toolBar.pageCount || toolBar.pageIndex == 0">
								 <a href="javascript:void(0);" class="next">下一页</a>                 
							</s:if>
							<s:else>
							  <a href='javascript:jumping(<s:property value='toolBar.nextPage'/>)' class="next">下一页</a>      
					</s:else>
      
        <div class="jumpbox">
       
          转到:
					<s:bean name="org.apache.struts2.util.Counter" id="counter">
					   	<s:param name="first" value="1" />
					   	<s:param name="last" value="toolBar.pageCount" />
					  	<select name="select" onchange="self.location.href=this.options[this.selectedIndex].value">
						   	<s:iterator>
						     	<option value="javascript:jumping(<s:property/>)" 
									<s:if test="toolBar.pageIndex == current-1">selected</s:if> >
									第  <s:property/> 页
								</option>
						   	</s:iterator>
						</select>
					</s:bean>
        </div>
				</s:if>
			<script language="javascript">
					function jumping(pageIndex){
						document.getElementById("pageIndex1").value=pageIndex;
						//document.getElementById("projectForm").action="teachTeamAction_teachTopicManage";
						document.getElementById("analyseForm").submit();
				   	}
			    </script>	
    </div>
    <h1>错误剖析</h1>
    <s:form action="errorAnalyseAction_enterErrorAnalyse" id="analyseForm" name="analyseForm" method="post">
    <s:hidden id="pageSize" name="pageSize" value='6'/>
	<s:hidden name="toolBar.pageIndex" id="pageIndex1" value="1"/>
    <div class="wrap">
    
        <div class="error-analysis-list">
        <s:iterator value="analyseList">
            <div class="error-analysis-items">
                <h3>${error_name}&minus;<span class="error-analysis-num">1</span></h3>
                <div class="item-body">
                    <div class="text">
                    ${error_analyse}
                    </div>
                    
                       
                    <a  href="" onclick="poplarge('${error_photo}');" data-toggle="modal" data-target="#text-inputer"><img src="ErrorPhoto/${thumbnail}" width="300" height="150" alt="错误缩略图" /></a>
                </div>


            </div>
	</s:iterator>

        </div>
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
<!-- 点击弹出Modal -->
<div class="modal fade" id="text-inputer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">本章要点</h4>
            </div>
            <form class="text-form">
                <div class="modal-body">
                    
                        <img src=""  id="large_photo" width="890" height="500" alt="错误分析原图"/>
                   
                </div>
                <div class="modal-footer">

                    <button id="text-form-reset" type="reset" data-dismiss="modal" aria-label="Close" class="btn btn-default pull-right"><span class="glyphicon glyphicon-repeat"></span>返回</button>

                </div>
            </form>
        </div>
    </div>
</div>

<script>

</script>
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script>
 function poplarge(photo_url){
 var photo="ErrorPhoto/"+photo_url;
 $("#large_photo").attr("src",photo);
 }

</script>

</body>
</html>
