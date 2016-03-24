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
    
    <title>开放/关闭竞赛报名入口</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

  </head>
  
  <body>
  <s:form id="switchForm" name="switchForm" action="courseAction_switchType" method="post">
  
  <input type="submit" id="button" style="margin:50px auto;margin-left:400px; background-color:#01c675;color:#fff;border:1px solid #ccc;padding:5px;" value="<s:if test='#switch.isopen==1'>关闭报名入口</s:if><s:else>开放报名入口</s:else>"/>

  </s:form>
  
  </body>
  <script>
 var omsg='${msg}';
 if(omsg!=""&&omsg!=null){
 alert(omsg);
 }
  var obutton=document.getElementById("button");
  obutton.onclick=function(){
   var msg="是否确定关闭/打开报名入口？";
  if(confirm(msg)){
  return true;
  }else{
  return false;
  }
  }
  
  </script>
</html>
