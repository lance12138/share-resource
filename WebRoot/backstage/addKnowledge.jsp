<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
 <base href="<%=basePath%>">
	<meta charset="UTF-8">
    <title>添加微知识</title>
    
	 <style>
     .label{font-family: '微软雅黑'; font-size:12px;color:red;}
    
    </style>
    <script type='text/javascript'src="<s:url value='/dwr/util.js'/>"></script>  
 	<script type='text/javascript' src="<s:url value='/dwr/engine.js'/>"></script>  
 	<script type='text/javascript' src="<s:url value='/dwr/interface/CourseAction.js'/>"></script>
    
    <script type="text/javascript">
     function getList(){  
   var course=document.getElementById("name").value;  
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
   chapter.appendChild(opt);  
  }   
    
 }
    	window.onload=function(){
    	var btn=document.getElementById("button");
    	btn.onclick=function(){
    	if(document.getElementById("title").value===""||(/^\s+$/gi.test(document.getElementById('title').value))){
    	document.getElementById("titleError").textContent="题目不可为空！";
    	//alert(document.getElementById("caseUpError").textContent);
    	return false;
    	}else if(document.getElementById("name").value===0){
    	document.getElementById("caseError").textContent="请选择课程！";
    	//alert(document.getElementById("caseUpError").textContent);
    	return false;
    	}else if(document.getElementById("course_chapter").value===""){
    	document.getElementById("chapterError").textContent="请选择章节！";
    	//alert(document.getElementById("caseUpError").textContent);
    	return false;
    	}else if(document.getElementById("answer").value===""||(/^\s+$/gi.test(document.getElementById('answer').value))){
    	document.getElementById("answerError").textContent="知识解答不可为空！";
    	return false;
    	}else{
    	document.knowledgeForm.submit();
    	}
    	}
   
    var omessage=document.getElementById("message").value;
    if(omessage!=''){
    alert(omessage);
    }
    	}
    	</script>
  </head>
  
  <body>
 
    <s:form action="knowledgeAction_addknowledge" name="knowledgeForm" id="knowledgeForm" method="post">
    <input type="hidden" name="message" id="message" value="${message}"/>
<table width="100%" border="0" cellpadding="1" cellspacing="1">
  <tr  bgcolor="#ccccff" >
    <td colspan="2" align="center"><strong>微知识上传</strong></td>
  </tr>
  <tr  bgcolor="#ccccff" >
    <td width="18%">选择课程</td>
    <td width="82%"><s:select name="courseName" id="name" list="#courseList" 
							onchange="getList();"				 headerKey="0" headerValue="-请选择课程-"   		listKey="name" listValue="name" /><label id="caseError"  class="label"></label></td>
  </tr>
   <tr  bgcolor="#ccccff" >  
    <td>选择章节名称：</td>  
    <td><s:select name="knowledge.chapterId" id="course_chapter" list="#{}"   
                                                    listKey="id" /><label id="chapterError"  class="label">${chapterError}</label></td>  
  </tr>  
  <tr  bgcolor="#ccccff" >
    <td>微知识题目</td>
    <td><input type="text" name="knowledge.title"  id="title" size="80"/><label id="titleError" class="label" >${titleError}</label></td>
  </tr>
  <tr  bgcolor="#ccccff" >
    <td>微知识解答</td>
    <td><textarea rows="6" cols="60" id="answer" name="knowledge.anwser"></textarea><label id="answerError" class="label">${explainError}</label></td>
  </tr>
  <tr  bgcolor="#ccccff" >
    <td>确认上传</td>
    <td><input type="button" id="button" value="确认上传"/></td>
  </tr>
</table>
   
  
   </s:form>
  </body>
</html>