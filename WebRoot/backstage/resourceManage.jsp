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
    
    <title>资源管理</title>
    <STYLE type="text/css">
    table{position:relative;margin-top:100px;}
    strong{position:absolute;left:460px;top:30px;}
    #title_research{position:absolute;left:400px;top:60px;}
    #research_button{position:absolute;left:560px;top:60px;}
    #toolBar{position:absolute;top:290px;left:310px;}
    #batch{position:absolute;top:80px;margin-left:150px;}
    #title_select{position:absolute;top:60px;left:280px;}
    #resource_title{position:absolute;top:80px;}
    </STYLE>
		
<script type="text/javascript" src="js/common.js"></script>

  </head>
  
  <body>
  <s:if test="#request.type==1">
  <strong>习题管理</strong>
  </s:if><s:elseif test="#request.type==2">
   <strong>试题管理</strong>
  </s:elseif><s:elseif test="#request.type==3">
  <strong>案例管理</strong>
  </s:elseif><s:else><strong>实验管理</strong></s:else>
  <form action="resourceAction_resoucebatchDelete?type=${type}" method="post">
  <s:select name="cid" id="resource_title" list="#CourseList" 
													listKey="id" listValue="name" />
  <input type="submit" id="batch" value="批量删除">
	</form>
  <form name="resourceForm" id="resourceForm" action="resourceAction_resourceManage?type=${type}" method="post">
    <s:hidden id="pageSize" name="pageSize" value='8'/>
	<s:hidden id="totalCount" name="totalCount" value=''/>
	<s:hidden name="toolBar.pageIndex" id="pageIndex1" value="1"/>
	<select name="downloadSelect" id="title_select">
	<option value="title">按资源名查找</option>
	<option value="courseName">按课程查找</option>
	</select>
  <s:textfield name="resource1.title" id="title_research" />
   <input type="submit" name="research_button" id="research_button" value="搜索"/>
   <table width="100%" border="0" cellpadding="1" cellspacing="1" align="center">
  <tr bgcolor="#ccccff" align="center">
    <td width="5%">ID</td>
    <td width="43%">习题名</td>
    <td width="18%">所属课程</td>
    <td width="14%">上传时间</td>
    <td width="10%">操作</td>
    <td width="10%">编辑</td>
  </tr>
  <s:iterator id="sr" value="resourceList">
  <tr bgcolor="#ccccff" align="center">
    <td>${sr.id}</td>
    <td>${sr.title}</td>
    <td>${sr.courseName}</td>
    <td>${sr.uploadTime}</td>
    <td><s:a action="resourceAction_deleteresource?id=%{id}">删除</s:a></td>
    <td><a href="javascript:expand('习题编辑',${id},'resourceAction_resourceEdit?id=',780,550)">编辑</a></td>
  </tr>
  </s:iterator>
 <div id="toolBar">
					<s:if test="toolBar.pageCount > 0">
					<s:if test="toolBar.pageIndex > 1"><a href='javascript:jumping(1)'>首页</a></s:if><s:else><span class="span">首页</span></s:else>&nbsp;&nbsp;
					<s:if test="toolBar.pageIndex > 1"><a href='javascript:jumping(<s:property value='toolBar.previousPage'/>)'>上一页</a></s:if><s:else><span class="span">上一页</span></s:else>&nbsp;&nbsp;
					<s:if test="toolBar.pageIndex == toolBar.pageCount || toolBar.pageIndex == 0"><span class="span">下一页</span></s:if>
					<s:else><a href='javascript:jumping(<s:property value='toolBar.nextPage'/>)'>下一页</a></s:else>&nbsp;&nbsp;
					<s:if test="toolBar.pageIndex == toolBar.pageCount || toolBar.pageIndex == 0"><span class="span">末页</span></s:if>
					<s:else><a href='javascript:jumping(<s:property value='toolBar.pageCount'/>)'>末页</a></s:else>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
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
				</s:if>
				
				<script language="javascript">
					function jumping(pageIndex){
						document.getElementById("pageIndex1").value=pageIndex;
						document.getElementById("resourceForm").submit();
				   	}
			    </script>
			</div> 
</table>
</form>
  </body>
  <script type="text/javascript">
  var obatch=document.getElementById("batch");
  obatch.onclick=function(){
  var msg="删除不可恢复，你确认要删除吗？";
  if(confirm(msg)){
  return true;
  }else{
  return false;
  }
  
  }
  </script>
</html>
