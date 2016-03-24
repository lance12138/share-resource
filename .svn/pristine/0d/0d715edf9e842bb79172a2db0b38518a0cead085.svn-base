<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
 <base href="<%=basePath%>">
	<meta charset="UTF-8">
    
    <title>作业管理</title>
   
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	#title{font-size:18px;font-family:"微软雅黑";font-weight:600;}
	.upload{text-decoration: none;}
	</style>
<script>
window.onload=function(){

var errorValue=document.getElementById("error").value;
if(errorValue!=null&&errorValue!=""){
alert(errorValue);
}

}

</script>
  </head>
  	
  <body>
  <s:form id="homeworkManageForm" name="homeworkManageForm" action="homeworkUploadAction_backAddHomework" method="post">
    <s:hidden id="pageSize" name="pageSize" value='8'/>
	<s:hidden id="totalCount" name="totalCount" value=''/>
	<s:hidden name="toolBar.pageIndex" id="pageIndex1" value="1"/>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
  <input type="hidden" name="error" id="error" value="${error}"/>
  <tr>
    <td colspan="10" align="center" id="title" height="40px" style="border: hidden;">学生作业管理
   
    </td>
  </tr>
  <tr>
    <td colspan="5" style="border-top: hidden;border-right:hidden;border-left:hidden;" height="80px">
    <table width="125%" border="0" cellpadding="0" cellspacing="0">
      <tr>
       <a href="homeworkUploadAction_batchhomeworkDelete" id="batch">批量删除</a>
        <td width="39%" align="right"><label for="select"></label>
          <select name="homeworkselect" id="homeworkselect">
          <option value="teacherName">按任课老师查询</option>
          <option value="studentClass">按学生班级查询</option>
          <option value="studentName">按学生姓名查询</option>
          <option value="topic">按作业主题查询</option>	`
          </select> &nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td width="25%"><label for="textfield"></label>
          <input type="text" name="homework.search" id="textfield" size="30"/></td>
        <td width="36%"><input type="submit" value="查询"/></td>
      
      </tr>
    </table></td>
  </tr>
  <tr align="center">
    <td width="10%" height="40px" bgcolor="#CCCCCC">学生姓名</td>
    <td width="10%" height="40px" bgcolor="#CCCCCC">学生班级</td>
    <td width="30%" height="40px" bgcolor="#CCCCCC">作业主题</td>
    <td width="20%" height="40px" bgcolor="#CCCCCC">作业描述</td>
    <td width="10%" height="40px" bgcolor="#CCCCCC">课程老师</td>
    <td width="20%" height="40px" bgcolor="#CCCCCC">作业下载</td>
    <td width="20%" height="40px" bgcolor="#CCCCCC">删除</td>
  </tr>
  <s:iterator id="back" value="backHomeworkList" >
  <tr>
    <td>${back.studentName}</td>
    <td>${back.studentClass}</td>
    <td>${back.topic}</td>
    <td>${back.description}</td>
    <td>${back.teacherName}</td>
    <td><s:iterator value="attachVector" id="gz"><s:if test="#back.id==#gz.attachId"><a href="homeworkUploadAction_homeworkDownload?fileId=${gz.id}" class="upload" title="点击下载">${gz.file}</a></br></s:if></s:iterator></td>
    <td><a href="homeworkUploadAction_delete?homework.id=${id}">删除</a></td>
  </tr>
  </s:iterator>
</table>
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
						document.getElementById("homeworkManageForm").submit();
				   	}
			    </script>
			</div> 
</s:form>
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
