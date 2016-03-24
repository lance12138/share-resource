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
    
    <title>新闻发表</title>

<link type="text/css" rel="stylesheet" href="style/backstagemain.css" />
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor1/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor1/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="ueditor1/lang/zh-cn/zh-cn.js"></script>
	<!--
	-->
	<link rel="stylesheet" type="text/css" href="ueditor1/themes/default/css/ueditor.min.css">
<script language="javascript" type="text/javascript" src="<s:url value='/js/My97DatePicker/WdatePicker.js'/>"></script>
 <STYLE type="text/css">
 .textfield{border:1px solid #ccc; margin-left:10px;}
 #news_submit{width:80px;line-height:22px;background:#1B7EB8;color:white;font-size:18px;font-family:YouYuan,"幼圆";border-radius: 3px 3px 3px 3px;}
 #title{font-size:18px;font-weight:bold;}
 </STYLE>
 <script type="text/javascript">
 window.onload=function(){
 var osubmit=document.getElementById("news_submit");
   osubmit.onclick=function(){
   
    if(document.getElementById("news_title").value==''||(/^\s+$/gi.test(document.getElementById('news_title').value))){
    alert("请填写新闻标题");
      return false;
    }else if(document.getElementById("news_author").value==''||(/^\s+$/gi.test(document.getElementById('news_author').value))){
    alert("请填写新闻作者");
      return false;
    }else if(document.getElementById("createTime").value==''){
    alert("请填写编写时间");
      return false;
    }else if(!UE.getEditor('editor').hasContents()){
    alert("请填写新闻内容");
      return false;
    }
    else{
       document.newsForm.submit();
    }
   }
 }
 </script>
  </head>
  
  <body>
  <div id="table" align="center">
 <s:form id="newsForm" name="newsForm" action="newsAction_save" method="post">
<table width="100%" height="405" border="1" align="left" cellpadding="1" cellspacing="2">
  <tr>
    <td height="32" colspan="2" bgcolor="#ccccff" align="center" id="title">上传新闻</td>
  </tr>
  <tr bgcolor="#ccccff">
    <td width="16%" height="28" >新闻标题：</td>
    <td width="84%"><input type="text" name="news.title" id="news_title" class="textfield" size="100" />&nbsp;<label style="color:red;">*</label>
    <label for="textfield"></label></td>
  </tr>
  <tr bgcolor="#ccccff">
    <td height="32" >新闻作者：</td>
    <td><input type="text" name="news.author" id="news_author" class="textfield"/>&nbsp;<label style="color:red;">*</label>
    <label for="textfield2"></label></td>
  </tr>
  <tr bgcolor="#ccccff">
    <td height="35" >上传时间：</td>
    <td><label for="textfield3"></label>
    <input type="text" id="createTime" maxlength="20" accesskey="^\x20*$" class="textfield"
													name="news.createTime" cssClass="Wdate w130 bg0" readonly="true"
													onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})">

													<!--<s:param name="value">
														<s:date name="bo.zksj" format="yyyy-MM-dd HH:mm" />
													</s:param>
												--></input><label style="color:red;">*</label> </td>
  </tr>
  <tr bgcolor="#ccccff">
    <td height="248">编辑新闻：</td>
    <td><script id="editor" type="text/plain" name="news.content">${news.content}</script>
  </td>
  </tr>
  <tr bgcolor="#ccccff">
    <td height="49" >发表新闻：</td>
    <td><input type="button" id="news_submit" value="发表新闻" class="textfield"></input></td>
  </tr>
  
  
</table>
</s:form>
</div>
  </body>
  <script>
   var ue = UE.getEditor('editor', {
    initialFrameWidth:850,
    initialFrameHeight:350,
    autoHeightEnabled: false,
    
});
  </script>
</html>
