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
     <title>章节管理</title>
    <style>
    table, td, tr{border: 1px solid #7EC0E5;}
        
          #table_title{font-family:"微软雅黑";font-size:14px;font-weight:600;text-align:center;}
    		#title{text-align: center;margin-top:20px;margin-left:20px;}
           #spanDiv{text-align: center;}
           #span{font-family:"微软雅黑";font-size:14px;font-weight:600;}
           body{position:relative;}
           #delete{position:absolute;top:40px;}
           #content{font-family:"微软雅黑";font-size:12px; background: #f3f3f3;}
    </style>


  </head>
  
  <body>
 <form action="courseAction_chapterbatchDelete" method="post">
   <div id="delete">
  <s:select name="courseid" id="resource_title" list="#CourseList" 
													listKey="id" listValue="name" />
  <input type="submit" id="batch" value="批量删除">
  </div>
  </form>
  <s:form id="chapterForm" name="chapterForm" action="courseAction_chapterManage" method="post">
  <s:hidden id="pageSize" name="pageSize" value='8'/>
	<s:hidden name="toolBar.pageIndex" id="pageIndex1" value="1"/>
  <div id="spanDiv"><span id="span">章节管理</span></div>
  <div id="title">
  <s:select list="#CourseList" listKey="id" listValue="name" name="courseid"></s:select>
  <input type="submit" value="查询"/>
  
  </div>
 <table width="100%" border="1" cellspacing="1" cellpadding="1">
  <tr bgcolor="#4097D1" id="table_title">
  	<td>ID</td>
    <td>章节名称</td>
    <td>查看反转课堂知识</td>
    <td>删除</td>
    
  </tr>
  <s:iterator  value="ChapterList" status="st">
  <tr id="content">
  	<td>${((toolBar.pageIndex)-1)*(toolBar.pageSize)+st.index+1}</td>
    <td><a href="preCourseAction_preManage?pre.chapterId=${id}">查看该章课堂知识</a></td>
    <td>${title}</td>
    <td><a href="courseAction_chapterDelete?chapter.id=${id}&&courseid=${courseid}">删除</a></td>
  </tr>
 </s:iterator>
</table>
</s:form>
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
						//document.getElementById("projectForm").action="teachTeamAction_teachTopicManage";
						document.getElementById("chapterForm").submit();
				   	}
			    </script>
			</div> 
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
