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
    
    <title>竞赛报名表</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
#toolBar{ margin-top:10px;margin-left:250px;  }
h1{font-size:18px;line-height: 30px;font-weight: 600;text-align: center;}
</style>
  </head>
  <body>
  <h1>竞赛报名表管理</h1>
  <a href="userAction_acmbatchDelete" id="batch">批量删除</a>
  <s:form id="tableForm" name="tableForm" action="userAction_competitionManage" method="post">
   <s:hidden id="pageSize" name="pageSize" value='6'/>
	<s:hidden id="totalCount" name="totalCount" value=''/>
	<s:hidden name="toolBar.pageIndex" id="pageIndex1" value="1"/>
	<s:a action="userAction_exportExcel">将表格导出为EXCEL</s:a>
<table width="100%" border="1" cellpadding="0" cellspacing="1">
  <tr>
    <td>编号</td>
    <td>姓名</td>
    <td>学院</td>
    <td>专业</td>
    <td>班级</td>
    <td>一卡通号</td>
    <td>电话号码</td>
    <td>管理</td>
  </tr>
  <s:iterator id="acm" value="acmUserList">
  <tr>
    <td>${acm.id}</td>
    <td>${acm.userName}</td>
    <td>${acm.academy}</td>
    <td>${acm.major}</td>
    <td>${acm.userClass}</td>
    <td>${acm.cardnumber}</td>
    <td>${acm.phone}</td>
    <td><s:a action="userAction_delete?userId=%{id}">删除</s:a></td>
    
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
						document.getElementById("tableForm").submit();
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
