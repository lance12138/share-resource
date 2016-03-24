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
    
    <title>添加出版教材</title>
   
	<style>
    
     table, td, tr{border: 1px solid #7EC0E5;}
          table tr td{ background: #f3f3f3;}
          #table_title{font-family:"微软雅黑";font-size:14px;font-weight:600;text-align:center;}
     .label{font-family:"微软雅黑";font-size:12px;font-weight:300;color:red;}
    </style>
	
	
  </head>
  
  <body>
  <s:form name="materialForm" id="materialForm" action="teachTeamAction_uploadMaterial" method="post">
<table width="100%" border="1" cellspacing="1" cellpadding="1">
  <tr>
    <td colspan="2" id="table_title">添加出版教材</td>
  </tr>
  <tr>
    <td width="24%">教材名称</td>
    <td width="76%"><input type="text" name="material.materialName" id="materialName" size="80"/><label class="label" id="materialnameError">*${materialnameError}</label></td>
  </tr>
  <tr>
    <td>出版社</td>
    <td><input type="text" name="material.product" id="product" size="30"/><label class="label" id="productError">*${productError}</label></td>
  </tr>
  <tr>
    <td>出版时间</td>
    <td><input type="text" name="material.productTime" id="productTime"/><label class="label" id="timeError">*${timeError}</label></td>
  </tr>
  <tr>
    <td>选择课程</td>
    <td><s:select name="material.courseId" id="topic" list="#courseList"   headerKey="0" headerValue="-请选择课程-"    listKey="id" listValue="name"/><label class="label" id="topicError">*${courseError}</label></td>
  </tr>

  <tr>
    <td>使用人数</td>
    <td> <input type="text" name="material.usingCount" id="usingCount"/><label class="label" id="usingCountError">*${usingCountError}</label></td>
  </tr>
  
  <tr>
    <td>保存</td>
    <td><input type="submit" name="submit" id="submit" value="保存"/></td>
  </tr>
  
</table>
</s:form>
</body>
<script>


  var oForm=document.getElementById("materialForm");
oForm.onsubmit=function(){
 if(document.getElementById("materialName").value==""||(/^\s+$/gi.test(document.getElementById('materialName').value))){
         document.getElementById("materialnameError").textContent="出版教材名不可为空！";
         return false;
 }else if(document.getElementById("product").value==""||(/^\s+$/gi.test(document.getElementById('product').value))){
  document.getElementById("productError").textContent="出版社不可为空！";
         return false;
 }else if(document.getElementById("productTime").value==""||(/^\s+$/gi.test(document.getElementById('productTime').value))){
  document.getElementById("timeError").textContent="出版时间不可为空！";
         return false;  
 }else if(document.getElementById("topic").value==0){
   document.getElementById("topicError").textContent="请选择课程！";
         return false;
 }
 else if(document.getElementById("usingCount").value==""||(/^\s+$/gi.test(document.getElementById('usingCount').value))){
  document.getElementById("usingCountError").textContent="使用人数不可为空！";
         return false;
         }
        else{
        document.materialForm.submit();
        } 
}
 var msg='${materialmsg}';
 if(msg!=''&&!(/^\s+$/gi.test(msg))){
 alert(msg);
 }
</script>
</html>

