<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
 <base href="<%=basePath%>">
	<meta charset="UTF-8">
    
    <title>修改密码</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	.Error{color:red;font-size:12px;font-family: "微软雅黑";}
	</style>
	<script>
	window.onload=function(){
		var modifyForm=document.getElementById("modifyForm");
		modifyForm.onclick=function(){
		var textvalue=document.getElementById("textfield").value;
			if(textvalue.length<6){
		  alert("密码必须大于六位！");	
				return false;
			}		
		}
				
	}
	</script>
  </head>
  
  <body>  
  <form name="modifyForm" id="modifyForm" action="userAction_modifyPwd" method="post">
    <input type="hidden" value="${userId}" name="user.id">
    <table width="100%" border="1" cellpadding="1" cellspacing="0" bordercolor="#569BAA" id="table">
  <tr>
    <td colspan="5" align="center" id="title">用户密码修改 </td>
  </tr>
    <tr>
    <td>用户原密码：</td>
    <td colspan="4"><input type="password" name="user.password" size="20"><label class="Error">*${msg}</label>
    
  </tr>
  <tr>
    <td width="17%">新密码：</td>
    <td colspan="4"><label for="textfield"></label>
   <input type="password" name="user.repassword" id="textfield"  height="30"/><label class="Error" id="rePasswordError">*${rePasswordError}</label></td>
  </tr>
   <tr>
    <td>提交：</td>
    <td colspan="4"><input type="submit" id="submit" value="提交"/></td>
  </tr>
</table>
</form>   
  </body>
</html>
