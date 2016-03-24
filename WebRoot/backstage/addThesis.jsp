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
    
    <title>添加课程组成员发表的教学研究论文</title>
    <style>
    
     table, td, tr{border: 1px solid #7EC0E5;}
          table tr td{ background: #f3f3f3;}
          #table_title{font-family:"微软雅黑";font-size:14px;font-weight:600;text-align:center;}
     .label{font-family:"微软雅黑";font-size:12px;font-weight:300;color:red;}
    </style>
	
	<script type='text/javascript'src="<s:url value='/dwr/util.js'/>"></script>  
 <script type='text/javascript' src="<s:url value='/dwr/engine.js'/>"></script>  
 <script type='text/javascript' src="<s:url value='/dwr/interface/TeachTeamAction.js'/>"></script>
<script type="text/javascript">
 function getList(){ 
      var other=document.getElementById("topic").value;
if(other==0){
   var othermajor=document.getElementById("teach_author");  
   othermajor.options.length=0;  
} 
   var course=document.getElementById("topic").value;  
TeachTeamAction.getTeachTeamList(course,getMajor_callback)  
     
      
      
 }  
 //回调函数
 function getMajor_callback(data){  
  
  var author1=document.getElementById("teach_author");  
   author1.options.length=0;  
  for(var i=0;i<data.length;i++)  
  {  
 var opt=document.createElement("option");  
 opt.value=data[i].teacherName; 
 opt.innerText=data[i].teacherName;  
   //var opt=new option(data[i].title,data[i]);  
   author1.appendChild(opt);  
  }   
   }
  
</script>

  </head>
  
  <body>
  <s:form name="thesisForm" id="thesisForm" action="teachTeamAction_uploadThesis" method="post">
<table width="100%" border="1" cellspacing="1" cellpadding="1">
  <tr>
    <td colspan="2" id="table_title">添加课程组成员主持的教学研究论文</td>
  </tr>
  <tr>
    <td width="24%">论文名称</td>
    <td width="76%"><input type="text" name="thesis.thesisName" id="thesisName" size="80"/><label class="label" id="thesisError">*${thesisError}</label></td>
  </tr>
  <tr>
    <td>发表期刊</td>
    <td><input type="text" name="thesis.issue" id="issue" size="30"/><label class="label" id="issueError">*${issueError}</label></td>
  </tr>
  <tr>
    <td>研究时间</td>
    <td><input type="text" name="thesis.studyTime" id="startTime"/><label class="label" id="timeError">*${timeError}</label></td>
  </tr>
  <tr>
    <td>选择课程</td>
    <td><s:select name="courseOfTopic" id="topic" list="#courseList" onchange="getList();"  headerKey="0" headerValue="-请选择课程-"    listKey="name" listValue="name"/><label class="label" id="topicError">*</label></td>
  </tr>
  <tr>
    <td>主持人</td>
    <td>  <s:select name="thesis.author" id="teach_author"  list="#{}" listKey="teacherName" /><label class="label" id="authorError">*${authorError}</label></td>
  </tr>
  
  <tr>
    <td>名次</td>
    <td> <input type="text" name="thesis.position" id="position"/><label class="label" id="positionError">*${positionError}</label></td>
  </tr>
  
  <tr>
    <td>保存</td>
    <td><input type="submit" name="submit" id="submit" value="保存"/></td>
  </tr>
  
</table>
</s:form>
</body>
<script>


   var oForm=document.getElementById("thesisForm");
oForm.onsubmit=function(){
 if(document.getElementById("thesisName").value==""||(/^\s+$/gi.test(document.getElementById('thesisName').value))){
         document.getElementById("thesisError").textContent="论文名不可为空！";
         return false;
 }else if(document.getElementById("issue").value==""||(/^\s+$/gi.test(document.getElementById('issue').value))){
  document.getElementById("issueError").textContent="发表期刊不可为空！";
         return false;
 }else if(document.getElementById("startTime").value==""||(/^\s+$/gi.test(document.getElementById('startTime').value))){
  document.getElementById("timeError").textContent="研究时间不可为空！";
         return false;  
 }else if(document.getElementById("topic").value==0){
   document.getElementById("topicError").textContent="请选择课程！";
         return false;
 }
 else if(document.getElementById("teach_author").value==""){
  document.getElementById("authorError").textContent="作者不可为空！";
         return false;
         }
 else if(document.getElementById("position").value==""||(/^\s+$/gi.test(document.getElementById('position').value))){
  document.getElementById("positionError").textContent="名次不可为空！";
         return false;
         }
        else{
        document.topicForm.submit();
        } 
}
 
</script>
</html>

