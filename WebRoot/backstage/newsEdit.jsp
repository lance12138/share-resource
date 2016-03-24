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
    
    <title>新闻列表</title>

<link type="text/css" rel="stylesheet" href="style/backstagemain.css" />
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor1/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor1/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="ueditor1/lang/zh-cn/zh-cn.js"></script>
<link rel="stylesheet" type="text/css" href="ueditor1/themes/default/css/ueditor.min.css">
<script language="javascript" type="text/javascript" src="<s:url value='/js/My97DatePicker/WdatePicker.js'/>"></script>
 <STYLE type="text/css">
 .textfield{border:1px solid #ccc; margin-left:10px;}
 #news_submit{width:80px;line-height:22px;background:#1B7EB8;color:white;font-size:18px;font-size:font-family:YouYuan,"幼圆";border-radius: 3px 3px 3px 3px;}
 </STYLE>
 
  </head>
  
  <body>
  <div id="table" align="center">
<s:form name="newsForm" id="newsForm" method="post">
<table width="100%" height="405" border="1"   align="left" cellpadding="1" cellspacing="2">
  <tr>
    <td height="32" colspan="2" bgcolor="#ccccff" align="center">新闻编辑</td>
  </tr>
  <tr bgcolor="#ccccff">
    <td width="16%" height="28" >新闻标题：</td>
    <td width="84%"><input type="text" value="${news.title}" name="news.title" id="textfield" class="textfield" size="100" readonly="true"/>
    <label for="textfield"></label></td>
  </tr>
  <tr bgcolor="#ccccff">
    <td height="32" >新闻作者：</td>
    <td><input type="text" value="${news.author}" name="news.author" id="textfield2" class="textfield" readonly="true"/>
    <label for="textfield2"></label></td>
  </tr>
  <tr bgcolor="#ccccff">
    <td height="35" >上传时间：</td>
    <td><label for="textfield3"></label>
    <input type="text" id="createTime" maxlength="20" accesskey="^\x20*$" class="textfield"
													name="news.createTime" value="${news.createTime}" cssClass="Wdate w130 bg0" readonly="true">

													<s:param name="value">
														<s:date name="news.createTime" format="yyyy-MM-dd HH:mm" />
													</s:param>
												</input> </td>
  </tr>
  <tr bgcolor="#ccccff">
    <td height="248">编辑新闻：</td>
    <td><script id="editor" type="text/plain" name="news.content">${news.content}</script></td>
  </tr>
   <tr bgcolor="#ccccff">
    <td height="49" >&nbsp;</td>
    <td>&nbsp;</td>
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
