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
    
    <title>教研活动列表</title>
   
	  
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	body{position:relative;}
	#tr_title{font-family: "微软雅黑";font-size:14px;font-weight:600;text-align: center;}
	.title{position:absolute;left:450px;top:50px;font-size:16px;font-family:"微软雅黑"}
	 #title_research{position:absolute;left:400px;top:90px;}
	 table{position:absolute;top:120px;border: 0;background:#blue;font-size:12px;font-family:"微软雅黑"}
	 #research_button{position:absolute;top:90px;left:570px;}
	 #toolBar{position:absolute;top:400px;left:300px;}
	</style>

</head>
  
  <body>
  <strong align="center" class="title">教研活动列表</strong>
  <s:form name="activityManageForm" id="activityManageForm" action="activityAction_acManage" method="post">
   <s:hidden id="pageSize" name="pageSize" value='5'/>
	<s:hidden id="totalCount" name="totalCount" value=''/>
	<s:hidden name="toolBar.pageIndex" id="pageIndex1" value="1"/>
	<a href="activityAction_ac_deleteAll" id="batch">全部删除</a>
<table width="100%" border="0" cellpadding="1" cellspacing="1" align="center">
  <tr bgcolor="#ccccff" id="tr_title">
    <td width="6%">ID</td>
    <td width="55%">文章标题</td>
    <td width="13%">发表时间</td>
    <td width="9%">删除教研活动</td>
  </tr>
  <s:iterator id="sr" value="activityList" status='st'>
  <tr bgcolor="#ccccff" >
    <td><s:property value="#st.index+1"/></td>
    <td>${sr.ac_name}</td>
    <td>${sr.ac_time}</td>
    <td><s:a action="activityAction_ac_delete?activity.ac_id=%{ac_id}">删除</s:a></td>
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
						document.getElementById("activityManageForm").submit();
				   	}
			    </script>
			</div> 
</table>
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
