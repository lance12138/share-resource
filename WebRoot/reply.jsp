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
<title>论坛回复页面</title>


    <link type="text/css" href="style/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="style/coursepagecommen.css" />
     <script type="text/javascript" charset="utf-8" src="ueditor1/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor1/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="ueditor1/lang/zh-cn/zh-cn.js"></script>
	<!--
	-->
	<link rel="stylesheet" type="text/css" href="ueditor1/themes/default/css/ueditor.min.css">
	 
 <!--主样式-->
    <style type="text/css">
      /*导航部分*/
        nav{
            height:54px;
            background:#fff;
            width:980px;
            margin:2px auto;
            z-index:1;
        }
        nav >a{
            display:block;
            height:54px;
            line-height:54px;
            width:165px; 
            text-align:center;
            float:left;
            border-right:1px solid #dfdfdf;
            color:#a1a1a1; font-size:16px;
            font-family:"微软雅黑"; }
        nav >a:last-child{
            border-right: none;
			 width: 155px;
        }
        nav >.active{
        	background:#01c675;
            border-bottom:4px #00a05e solid;
            height:54px;
            line-height: 54px;
            text-decoration: none;
            color:#fff;
        }
        nav >a:hover{
            background:#01c675;
            border-bottom:4px #00a05e solid;
            height:54px;
            line-height: 54px;
            text-decoration: none;
            color:#fff;
            }



        /*内容*/

        .content{height: auto;}
        button{font-family: "微软雅黑";}
        .container{width: 100%;}
        .body-left{padding: 40px 0; padding-bottom: 0; background:#fff;  }
        .body-right{ padding-top: 40px; position: relative; background-color:#fff; }
        /*贴主*/
        .uper{width: 90%; margin: 0 auto; background-color: #f3f3f3;padding: 10px;border: 2px solid #ccc; box-shadow: 2px 2px 2px #666;}
        /*输入区*/
        .input-area{width: 90%;margin:10px auto; border-radius:5px;height: 200px; border:2px solid #ccc; cursor: pointer;}
        .input-area:hover{ border:2px solid #01c675;}
        .text-form button{font-family: "微软雅黑"; font-size:16px; margin: 10px 10px;}
        .text-form button[type="submit"]{margin-right: 34px;}
        .text-form button span{margin-right: 10px;}
        .glyphicon{margin-right: 5px;}
        .input-area button span{margin-right: 0;}

        /*用户讨论列表*/
        .media-list{width: 90%; margin: 0px auto; margin-top: 80px; }
        .media-list >h1{font-family: "微软雅黑"; font-size:16px; color: #428BCA; padding-top: 10px;}
        .media-list >h1 span{padding-right: 10px;}
        .media-list >.media{border-bottom: 2px solid #ccc; padding: 20px 0;}
        .media-list >.media button{font-size: 14px;font-family: "微软雅黑"; }
        .media-list >.media button span{padding-right: 5px;}

        .media-body >h4{ font-size:16px;font-family: "微软雅黑";}
        .media-body >h6{ margin-left: 0px; color: #428bca;font-family: "微软雅黑";}
        .media-body >p{color: #666; line-height:1.5;margin-top: 15px; text-indent: 2em; padding: 10px 0px; padding-right: 10px; font-family: "微软雅黑";}
        /*跟帖样式*/
        .follows{width: 100%;}
        .follows .media-heading{font-size:14px;}
        .follows .media-heading b{margin: 0 5px;color: #428bca;font-family: "微软雅黑"; }
        .follows .pull-left{font-size:10px;}
        .follows-repeat a:hover{ }

        /*分页导航*/
        .page-navigation{width: 100%; text-align: center; margin-bottom: 0;}
        .pagination li a:hover{
            height: inherit;}

        /*模态框样式*/
        .modal .modal-dialog{width: 1000px;}
        .modal-title{ font-size: 20px;font-family: "微软雅黑"; }

        /*登录框*/
        .panel{border-radius:0; margin:0; width: 300px; box-shadow: 2px 2px 2px #999;}
        .panel-heading h3{font-size: 20px;font-family: "微软雅黑";}
        .panel-fixed{right: 178px; position: fixed; top: 0;}
        .input-group{margin-bottom: 10px;}
        .input-group span{ top: 0px;}
        .panel .checkbox{ font-family: "微软雅黑";font-size: 15px;}
        .panel-body button{width: 46%;}
        .barcode-container{padding: 0; padding-right: 48px; }
        .barcode{width: 150px;}
        .barcode-img{width: 100px;height: 34px;line-height: 34px; border: 1px solid #ccc; border-radius: 5px; text-align: center; }
    </style>
</head>

<body>
<header id="header"><img id="logo" src="images/logo_white.png" alt="logo" width="340" height="90" /></header>
<nav id="cnav">
    <a href="index.jsp">平台主页</a>
     <a href="homeworkUploadAction_addTeacherList">作业提交</a>
    <a href="userAction_academyList">竞赛报名</a>
    <a href="activityAction_addUI">教研活动</a>
    <a class="active" href="forumAction_list">在线互动</a>
    <a href="courseAction_addDownload_homework">下载入口</a>
</nav>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="col-md-8 body-left" id="body-left">

                <div class="media uper">
                    <a class="pull-left" href="#">
                        <img class="media-object" src="images/user/1.png" width="100" height="100" alt="用户头像">
                    </a>
                    <div class="media-body">
                        <h4 class="pull-right">楼主</h4>
                        <h4 class="media-heading"><span class="glyphicon glyphicon-user"></span><span class="username">罗纳尔多</span></h4>
                        <h6 class=" pull-left ">发表于<span class="submit-day">${forum.createTime}</span></h6>
                        <p>
                            ${forum.desciption}
                        </p>


                        </div>
                </div>
                <form class="text-form" id="replyForm" name="replyForm" action="replyAction_addReply?forumId=${forum.id}" method="post">

                    <div class="input-area">
                   
                  <script id="editor" type="text/plain" name="reply.content"></script>
  
                    </div>
                    <button id="text-form-submit" type="submit" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-pencil"></span>回复</button>
                  
                </form>
                <ul class="media-list">
                    <h1><span class="glyphicon glyphicon-list"></span>本楼回复</h1>
                    <hr class="divider"></li>
                  <form id="replyDisForm" name="replyDisForm" action="replyAction_list?forumId=${forum.id}" method="post">
	 <s:hidden id="pageSize" name="pageSize" value='6'/>
	<s:hidden id="totalCount" name="totalCount" value=''/>
	<s:hidden name="toolBar.pageIndex" id="pageIndex1" value="1"/>
                    
                    <s:iterator id="gz" value="replyList" status="st">
                    <li class="media">
                        <a class="pull-left" href="#">
                            <s:if test="#gz.user==null||#gz.user.photo==null">
                            <img class="media-object" src="images/user/1.png" width="100" height="100" alt="用户头像">
                            </s:if><s:else>
                            <img class="media-object" src="images/user/${user.photo}" width="100" height="100" alt="用户头像">
                      </s:else> 
                        </a>
                        <div class="media-body">
                            <h4 class="pull-right">${((toolBar.pageIndex)-1)*(toolBar.pageSize)+st.index+1}#</h4>
                            <h4 class="media-heading"><span class="glyphicon glyphicon-user"></span><span class="username">${user.userName}</span></h4>
                            <h6 class=" pull-left ">发表于<span class="submit-day">${gz.updateTime}</span></h6>
                            <p>
                                ${gz.content}
                            </p>


                           
                        </div>
                    </li>
                   </s:iterator>
                  </form> 
                </ul>
                  <div class="page-navigation">
                    <ul class="pagination pagination-lg">
                          <s:if test="toolBar.pageCount > 0">
                        <li>
						 <s:if test="toolBar.pageIndex > 1">
							  <a href='javascript:jumping(<s:property value='toolBar.previousPage'/>)' aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>	
							</s:if>
							<s:else>
								 <a href="javascript:void(0);" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
							</s:else>
                          
                        </li>
                        <s:bean name="org.apache.struts2.util.Counter" id="counter">
								<s:param name="first" value="1" />
								<s:param name="last" value="toolBar.pageCount" />
								<s:iterator begin="%{toolBar.beginPageIndex}" end="%{toolBar.endPageIndex}" var="num">
									<li <s:if test="toolBar.pageIndex==#request.num"> class="active"</s:if>><a href="javascript:jumping(<s:property/>)" >${num}</a>
									</li>
								</s:iterator>
							</s:bean>
                      
                        <li>
                        	<s:if test="toolBar.pageIndex == toolBar.pageCount || toolBar.pageIndex == 0">
								 <a href="javascript:void(0);" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
							</s:if>
							<s:else>
							  <a href='javascript:jumping(<s:property value='toolBar.nextPage'/>)' aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
					</s:else>
                          
                        </li>
             	</s:if>
                    </ul>
                </div>
                 <script language="javascript">
				function jumping(pageIndex) {
					document.getElementById("pageIndex1").value = pageIndex;
					document.getElementById("replyDisForm").submit();
				}
				</script>
            </div>

            <div class="col-md-4 pull-right body-right" id="body-right">
            
				 <s:if test="#session.user!=null">
                <div id="logined-panel" class="panel panel-default pull-right">
                    <div class="panel-heading">
                        <h3><span class="glyphicon glyphicon-user"></span>用户已登录</h3>
                    </div>
                    <div class="panel-body">
                        <div class="media">
                           <a class="pull-left">
                            <s:if test="#session.user.photo==null">
                                <img class="media-object" src="images/user/1.png" width="100" height="100" alt="用户头像">
                                </s:if><s:else>
                                <img class="media-object" src="images/user/${session.user.photo}" width="100" height="100" alt="用户头像">
                            	</s:else>
                            </a>
                            <div class="media-body">

                                <h4 class="media-heading"><span class="glyphicon glyphicon-user"></span><span class="username">${session.user.userName}</span></h4>
								<a class="user-message" href="replyAction_checkInform"><strong>消息</strong> (<span id="newsTips">0</span>)</a>
                                <p>

                                </p>


                                <button id="user-log-out" type="button" onClick="loginOut()" class="btn btn-primary pull-right"><span  class="glyphicon glyphicon-log-out"></span>退出</button>
                            </div>
                        </div>
                    </div>

                </div>
                </s:if>
            </div>
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
<script src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
		
		$("#body-right").css("height",$("#body-left").css("height"));
        function makePanelFixed( example ){

            $(window).scroll(function(){

                var bodyRight=$("#body-right")
                var top = $(document).scrollTop();

                if(top > example.offset().top-5)
                {

                    example.addClass("panel-fixed");
                }

                if(top < bodyRight.offset().top-5)
                {
                    example.removeClass("panel-fixed");
                }


            });
        }

       
        var loginedPanel=$("#logined-panel");




        makePanelFixed(loginedPanel);


      
    });
</script>

<script src="js/bootstrap/bootstrap.min.js"></script>

<script type="text/javascript">
 function loginOut(){

		window.location.href="userAction_Loginout";

			}
 var ue = UE.getEditor('editor', {
    initialFrameWidth:582,
    initialFrameHeight:100,
    autoHeightEnabled: false,
    
});
  var osubmit=document.getElementById("replyForm");
 
  osubmit.onsubmit=function(){
  if(!UE.getEditor('editor').hasContents()){
    alert("请填写回复内容！");
      return false;
    }else{
    osubmit.submit();
    }
  
 }
  
  $(document).ready(function(){



        $("#body-right").css("height",$("#body-left").css("height"));

        function makePanelFixed( example ){

            $(window).scroll(function(){

                var bodyRight=$("#body-right")
                var top = $(document).scrollTop();

                if(top > example.offset().top)
                {

                    example.addClass("panel-fixed");
                }

                if(top < bodyRight.offset().top-5)
                {
                    example.removeClass("panel-fixed");
                }


            });
        }
        var loginedPanel=$("#logined-panel");

        makePanelFixed(loginedPanel);

        var userLogin=$("#user-login");
        var userLogout=$("#user-log-out");
    

    });
    
    var sessionUser='${session.user}';
 if(sessionUser===''){
 
 }else{
  setInterval("poll()",5000);
    function poll(){  
   $.ajax({
		url:"replyAction_longPolling",//要请求的actiont		
		data:{},//给服务器的参数	
		type:"POST",
		dataType:"json",	
	    cache:false,
		success:function(result) {
			  $("#newsTips").html(result);  
		}
	});
   }
   }
</script>

</body>
</html>
