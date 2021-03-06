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
    
    <title>错误分析管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<STYLE type="text/css">
	
         table, td, tr{border: 1px solid #7EC0E5;}
          table .content{ background: #f3f3f3;}
          #table_title{ max-width: 80px;font-weight:300;font-family:"微软雅黑" font-size:12px;}
          h2{text-align: center;margin-top:20px;}
          #select_div{margin-top:30px;text-align: center;}
	</STYLE>
  </head>
  
 
<body>
<h2>错误分析管理</h2>
<form id="errorManageForm" name="errorManageForm" action="errorAnalyseAction_errorAnalyseManage" method="post">
 <s:hidden id="pageSize" name="pageSize" value='6'/>
	<s:hidden name="toolBar.pageIndex" id="pageIndex1" value="1"/>
	<div id="select_div">
	<s:select list="#courseList" name="analyse.courseId" listKey="id" listValue="name"/>
	<input type="submit" value="搜索"/>
	</div>
<table width="100%" border="1" cellspacing="1" cellpadding="1">
  <tr id="table_title" bgcolor="#4097D1">
    <td>ID</td>
    <td>错误案例名称</td>
    <td>缩略图</td>
    <td>删除</td>
  </tr>
  <s:iterator id="gz" value="errorList">
  <tr class="content">
    <td>${error_id}</td>
    <td>${error_name}</td>
    <td><img alt="缩略图" src="ErrorPhoto/${thumbnail}" width="100" height="50"></td>
    <td><a href="errorAnalyseAction_error_delete?analyse.error_id=${error_id}">删除</a></td>
  </tr>
  </s:iterator>
</table>
</form>
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
						document.getElementById("errorManageForm").submit();
				   	}
			    </script>
			</div> 
</body>
</html>
