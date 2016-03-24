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
	<title>论坛页面</title>


    <link type="text/css" href="style/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="style/coursepagecommen.css" />
    <script type="text/javascript" charset="utf-8" src="ueditor1/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor1/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="ueditor1/lang/zh-cn/zh-cn.js"></script>
	
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
        .body-right{ padding-top: 50px; position: relative; background-color:#fff; }
        /*贴主*/
        .uper{width: 90%; margin: 0 auto; background-color: #f3f3f3;padding: 10px;border: 2px solid #ccc; box-shadow: 2px 2px 2px #666;}
        /*输入区*/
        .input-area{width: 89%;overflow:hidden;margin:10px auto; border-radius:5px;height: 254px; border:2px solid #ccc; cursor: pointer;}
        .input-area input[type="text"]{border-radius:5px 5px 0 0; color:666;font-size:14px; font-family:"微软雅黑";padding:2px 5px; width:100%;border:none;height:30px;}
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
        .panel-fixed{right: 200px; position: fixed; top: 0;}
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
                <form class="text-form" id="text-form"  action="forumAction_addForumTheme" method="post">

                    <div class="input-area">
                    <input id="text-title" class="text-title" name="forum.title" type="text" placeholder="请输入发帖标题" />
                    <script id="editor" type="text/plain" name="forum.desciption"></script>
  
             	
                    </div>
                    <button id="text-form-submit" type="submit" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-pencil"></span>发帖</button>
                  
                </form>
                <ul class="media-list">
                    <h1><span class="glyphicon glyphicon-list"></span>课程讨论</h1>
                    <hr class="divider"></li>
                    <s:form id="forumForm" name="forumForm" action="forumAction_list" method="post">
	 <s:hidden id="pageSize" name="pageSize" value='8'/>
	<s:hidden id="totalCount" name="totalCount" value=''/>
	<s:hidden name="toolBar.pageIndex" id="pageIndex1" value="1"/>
	<s:iterator value="forumList" id="gz" status="st">
                    <li class="media">
                        <a class="pull-left" >
                        <s:if test="#gz.users==null||#gz.users.photo==null">
                            <img class="media-object" src="images/user/1.png" width="100" height="100" alt="用户头像">
                            </s:if><s:else>
                            <img class="media-object" src="images/user/${users.photo}" width="100" height="100" alt="用户头像">
                      </s:else> 
                        </a>
                        <div class="media-body">
                            <h4 class="pull-right">${((toolBar.pageIndex)-1)*(toolBar.pageSize)+st.index+1}#</h4>
                            <h4 class="media-heading"><span class="glyphicon glyphicon-user"></span><span class="username">${users.userName}</span> ${gz.title}</h4>
                          
                            <h6 class=" pull-left ">发表于<span class="submit-day">${gz.createTime} </span></h6>
                            <p>
                                ${gz.desciption}
                            </p>


                            <button type="button" class="btn btn-primary pull-right" onclick="reply(${gz.id})"><span class="glyphicon glyphicon-edit"></span>回复</button>
                        </div>
                    </li>
                    </s:iterator>
                    </s:form>
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
	document.getElementById("forumForm").submit();
}
</script>
            </div>
            <div class="col-md-4 pull-right body-right" id="body-right">
            <input type="hidden" id="Loginerror" value="${bbsloginError}"/>
            <s:if test="#session.user==null">
                <div id="login-panel" class="panel panel-default pull-right">
                    <div class="panel-heading">
                        <h3>请登录您的账户</h3>
                    </div>
                    <div class="panel-body">
                       <form action="userAction_userbbsLogin" method="post">

                            <div class="input-group">
                                <span class="input-group-addon glyphicon glyphicon-user" ></span>
                                <input type="text" id="username" name="user.userName" class="form-control" placeholder="请输入用户名" aria-describedby="basic-addon1">
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon glyphicon glyphicon-lock" ></span>
                                <input type="password" id="password" name="user.password" class="form-control" placeholder="请输入密码" aria-describedby="basic-addon1">
                            </div>
         
                            <button type="button" id="user-regist" onClick="regist()" class="btn btn-default pull-left">注册账户</button>
                            <button type="submit" id="user-login" onClick="login()" class="btn btn-primary pull-right">登录账户</button>
                        </form>
                    </div>

                </div>
			</s:if>
			<s:else>
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
                <script>
                	        
					        //var loginedPanel=$("#logined-panel");
					        //alert();
					        //makePanelFixed(loginedPanel);
					        
                </script>
                </s:else>
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
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript">
  
    $(function(){
		
		function jisuanshijian(time){
			alert('${gz.createTime}');
		}
		
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
       var loginPanel=$("#login-panel");
       loginPanel.css("display","block");
        makePanelFixed(loginPanel);
        



        var userLogin=$("#user-login");
        var userLogout=$("#user-log-out");
        
		
    });

function regist(){
window.location.href="userRegist.jsp";

}
    
function login(){

if(!validateUsername()){
return false;
}
if(!validatePassword()){
return false;
}

}

/*
 * 登录名校验方法
 */
function validateUsername() {
	var id = "username";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */	
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		alert("账号不能为空！");
		return false;
		
		
	}
	return true;
}

/*
 *密码校验方法
 */
function validatePassword() {
	var id = "password";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */	
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		alert("密码不能为空！");
		return false;	
	}
	if(value.length<6){
	alert("密码不可小于六位！");
	return false;
	}
	return true;
}
//回复
     function reply(id){
    document.forumForm.action="replyAction_list?forumId="+id;
    
    document.forumForm.submit();
    }
   // var osubmit=$("#text-form");
     
      /*初始化ueditor*/
      window.onload=function(){
     var ue = UE.getEditor('editor', {
    initialFrameWidth:582,
    initialFrameHeight:100,
    autoHeightEnabled: false,
    
});}
    function loginOut(){

window.location.href="userAction_Loginout";

}
    
  $("#text-form").submit(function(){
  if($("#text-title").val()===''||(/^\s+$/gi.test($("#text-title").val()))){
  alert("请填写帖子标题！");
  return false;
  }
  if(!UE.getEditor('editor').hasContents()){
    alert("请填写帖子内容！");
      return false;
    }
 
 });
 var ologinerror=$("#Loginerror").val();
 if(ologinerror!=""){
 alert(ologinerror);
 }
 var oforumError='${forumError}';
 if(oforumError!=''){alert(oforumError);}
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
