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
    
    <title>添加反转课堂知识</title>
   
	<style>
    
     table, td, tr{border: 1px solid #7EC0E5;}
          table tr td{ background: #f3f3f3;}
          #table_title{font-family:"微软雅黑";font-size:14px;font-weight:600;text-align:center;}
     .label{font-family:"微软雅黑";font-size:12px;font-weight:300;color:red;}
    </style>
	<script type='text/javascript'src="<s:url value='/dwr/util.js'/>"></script>  
 <script type='text/javascript' src="<s:url value='/dwr/engine.js'/>"></script>  
 <script type='text/javascript' src="<s:url value='/dwr/interface/CourseAction.js'/>"></script>  
 <script>  
 function getList(){  
   var course=document.getElementById("course").value;  
     if(course==0){
      var chapter=document.getElementById("course_chapter");  
  chapter.options.length=0; 
     }
CourseAction.getChapterList(course,getChapter_callback)  
     
      
      
 }  
 function getChapter_callback(data){  
  var chapter=document.getElementById("course_chapter");  
  chapter.options.length=0; 
  for(var i=0;i<data.length;i++)  
  {  

 var opt=document.createElement("option")  
 opt.value=data[i].id;  
 opt.innerText=data[i].title;  
   //var opt=new option(data[i].title,data[i]);  
   chapter.appendChild(opt);  
  }
  }   
	</script>
  </head>
  
  <body>
  <form name="preForm" id="preForm" action="preCourseAction_addPrecourse" method="post">
<table width="100%" border="1" cellspacing="1" cellpadding="1">
  <tr>
    <td colspan="2" id="table_title">添加反转课堂知识</td>
  </tr>
  <tr>
    <td>选择课程</td>
    <td><s:select  id="course" list="#CourseList"  onchange="getList();" name="courseName" headerKey="0" headerValue="-请选择课程-"    listKey="name" listValue="name"/><label class="label" id="topicError">*${courseError}</label></td>
  </tr>
   <tr  bgcolor="#ccccff" >  
    <td>选择章节名称：</td>  
    <td><s:select name="pre.chapterId" id="course_chapter" list="#{}"   
                                                    listKey="id" listValue="title"/><label class="label" id="chapterError">*${chapterError}</label></td>  
  </tr>  
  
  <tr>
    <td width="24%">知识名称</td>
    <td width="76%"><input type="text" name="pre.preknowledge" id="preknowledge" size="80"/><label class="label" id="preError">*${preError}</label></td>
  </tr>
  <tr>
    <td>保存</td>
    <td><input type="submit" id="presubmit" value="保存"/></td>
  </tr>
  
</table>
</form>
</body>
<script>


  var oForm=document.getElementById("preForm");
oForm.onsubmit=function(){
  if(document.getElementById("preknowledge").value==""||(/^\s+$/gi.test(document.getElementById('preknowledge').value))){
  document.getElementById("preError").textContent="反转课堂知识不可为空！";
         return false;
 }else if(document.getElementById("course").value==0){
   document.getElementById("topicError").textContent="请选择课程！";
         return false;
 }
 else if(document.getElementById("course_chapter").value==""){
  document.getElementById("chapterError").textContent="请选择章节！";
         return false;
         }
        else{
        document.oForm.submit();
        } 
}
 var msg='${premsg}';
 if(msg!=''&&!(/^\s+$/gi.test(msg))){
 alert(msg);
 }

</script>
</html>

