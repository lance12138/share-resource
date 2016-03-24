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
    
    <title>消息中心</title>


    <link type="text/css" href="style/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="style/coursepagecommen.css" />
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->




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
        .uper{text-align:center;width: 90%; margin: 0 auto; background-color:#F5F5F5;padding: 10px;border: 2px solid #ccc; }
        .uper h1{font-size: 20px;font-family: "微软雅黑";}
        .uper span{top:4px;}
        /*输入区*/
        .input-area{width: 90%;margin:10px auto; border-radius:5px;height: 200px; border:2px solid #ccc; cursor: pointer;}
        .input-area:hover{ border:2px solid #01c675;}
        .text-form button{font-family: "微软雅黑"; font-size:16px; margin: 10px 10px;}
        .text-form button[type="submit"]{margin-right: 34px;}
        .text-form button span{margin-right: 10px;}
        .glyphicon{margin-right: 5px;}
        .input-area button span{margin-right: 0;}

        /*用户讨论列表*/
        .media-list{width: 90%; margin: 0px auto; margin-top: 10px; }
        .media-list >h1{font-family: "微软雅黑"; font-size:16px; color: #428BCA; padding-top: 10px;}
        .media-list >h1 span{padding-right: 10px;}
        .media-list >.media{border-bottom: 2px solid #ccc; padding: 20px 0;}
        .media-list >.media button{font-size: 14px;font-family: "微软雅黑"; }
        .media-list >.media button span{padding-right: 5px;}

        .media-body >h4{ font-size:16px;font-family: "微软雅黑";}
        .media-body >h6{ margin-left: 0px; color: #428bca;font-family: "微软雅黑";}
        .media-body >p{color: #666; line-height:1.5;margin-top: 15px; padding: 10px 0px; padding-right: 10px; font-family: "微软雅黑";font-size: 14px;}
        .source-text{border:1px solid #ccc;background-color:#f3f3f3; width: 100%; overflow:hidden; white-space:nowrap; text-overflow:ellipsis; padding:2px 10px; border-radius:2px;margin-bottom: 10px;font-family: "微软雅黑";font-size: 16px;}
        .source-text span{font-weight: bold;}
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
                    
                    <h1><span class="glyphicon glyphicon-volume-up"></span>消息中心</h1>
                </div>
               
                <ul class="media-list">
                <s:form id="replynewsForm" name="replynewsForm" action="replyAction_checkInform" method="post">
                   <s:hidden id="pageSize" name="pageSize" value='6'/>
	               <s:hidden name="toolBar.pageIndex" id="pageIndex1" value="1"/>
                    <h1><span class="glyphicon glyphicon-list"></span>消息列表</h1>
                    <hr class="divider"/>
                    <s:iterator value="newReplyList" id="gz">
                    <li class="media">
                        <a class="pull-left">
                            <img class="media-object" src="images/user/${gz.userphoto}" width="60" height="60" alt="用户头像">
                        </a>
                        <div class="media-body">
                            
                            <h4 class="media-heading"><span class="glyphicon glyphicon-user"></span><span class="username">${gz.userName}</span></h4>
                            <h6 class=" pull-left ">发表于${gz.msg_time}</h6>
                            <p>
                                ${gz.msg_content}
                            </p>
                            <div class="source-text">
                                <span>原帖：</span>
                                &nbsp;&nbsp;${gz.forumContent}
                            </div>

                            <button type="button" class="btn btn-primary pull-right" onClick="reply('${gz.forumId}')"><span class="glyphicon glyphicon-edit"></span>回复</button>
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
	document.getElementById("replynewsForm").submit();
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

                                <p>

                                </p>


                                <button id="user-log-out" type="button" onClick="loginOut()" class="btn btn-primary pull-right" ><span  class="glyphicon glyphicon-log-out"></span>退出</button>
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
        <a href="javascript:void(0);">加入收藏</a><a href="javascript:void(0);">进入后台</a>
    </div>
    <p>
        Copyright© 2011 江西理工大学.All Rights Reserved.<br />
        学校地址：江西省赣州市红旗大道86号 邮编：341000<br />
        制作维护：  江西理工大学信息学院333工作室  Email：517821485@qq.com <br />


    </p>
</footer>


<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">

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
    
     function loginOut(){

		window.location.href="userAction_Loginout";

			}
	function reply(forumId){
	alert(forumId);
	window.location.href="replyAction_list?forumId="+forumId;
	
	}
</script>

<script src="js/bootstrap/bootstrap.min.js"></script>

<script type="text/javascript">

</script>
</body>
</html>
