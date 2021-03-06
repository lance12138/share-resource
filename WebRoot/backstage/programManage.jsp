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
    
    <title>实例项目管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<style>
	 table, td, tr{border: 1px solid #7EC0E5;}
       #search{text-align: center;}
          #table_title{font-family:"微软雅黑";font-size:14px;font-weight:600;text-align:center;}
	</style>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form id="proForm" name="proForm" action="programAction_programManage" method="post">
    <s:hidden id="pageSize" name="PageSize" value='6'/>
	<s:hidden name="toolBar.pageIndex" id="pageIndex1" value="1"/>
	<div id="title" align="center"><h3>实训项目管理</h3></div>
	<div id="search">
	 <s:select list="#courseList" listKey="id" listValue="name" name="courseid"></s:select>
  <input type="submit" value="查询"/>
	</div>
   <table width="100%" border="1" cellspacing="1" cellpadding="1">
  <tr id="table_title" bgcolor="#4097D1" align="center">
    <td>ID</td>
    <td>实例项目标题</td>
    <td>上传时间</td>
    <td >删除</td>
  </tr>
  <s:iterator id="gz" value="backproList" status="st">
  <tr align="center">
    <td>${((toolBar.pageIndex)-1)*(toolBar.pageSize)+st.index+1}</td>
    <td>${gz.pro_title}</td>
    <td>${gz.pro_time}</td>
    <td><a href="programAction_pro_delete?program.pro_id=${gz.pro_id}">删除</a></td>
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
					
						document.getElementById("proForm").submit();
				   	}
			    </script>
			</div> 
</form>
  </body>
</html>
