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
    
    <title>添加题目</title>
  <style>
  #table{border-color:#569BAA; }
  .Error{color:red;font-size:10px;font-weight:600;font-family:"微软雅黑" ;}
  #tip{color:red;}
  #title{font-weight:600;font-family:"微软雅黑" ;}
  #submit{font-weight:300;font-size:16px;font-family:"微软雅黑";color:white;background:#1B7EB8;border-radius: 3px 3px 3px 3px;border:0;}
  </style>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script>
window.onload=function(){

 var submit=document.getElementById("submit");
 submit.onclick=function(){
 if(document.getElementById("textfield").value==""||(/^\s+$/gi.test(document.getElementById('textfield').value))){
 document.getElementById("questionError").innerText="题目不能为空!";
 return false;
 }
 else if(document.getElementById("questiontype").value==""||(/^\s+$/gi.test(document.getElementById('questiontype').value))){

 document.getElementById("typeError").innerText="题目类型不能为空！";
 return false;
 }else if(document.getElementById("questiontype").value<3){ if(document.getElementById("textfield2").value==""||(/^\s+$/gi.test(document.getElementById('textfield2').value))||
 document.getElementById("textfield3").value==""||(/^\s+$/gi.test(document.getElementById('textfield3').value))||
 document.getElementById("textfield4").value==""||(/^\s+$/gi.test(document.getElementById('textfield4').value))||
 document.getElementById("textfield5").value==""||(/^\s+$/gi.test(document.getElementById('textfield5').value))
 ){
 document.getElementById("answerError").innerText="答案选项不能为空！";
 return false;
 }}else if(document.getElementById("answer").value==""||document.getElementById("answer").value==null){
  document.getElementById("resultError").innerText="正确答案不能为空!";
  return false;
 }
 else{
 document.questionForm.submit();
 }
  
 }
 
}
</script>
  </head>
  
  <body>
  <form name="questionForm" id="questionForm" action="questionAction_addQuestion" method="post">
    <table width="100%" border="1" cellpadding="1" cellspacing="0" bordercolor="#569BAA" id="table">
  <tr>
    <td colspan="5" align="center" id="title">在线测试题目添加 <label class="Error">${questionError}</label></td>
  </tr>
    <tr>
    <td>选择课程：</td>
    <td colspan="4"><s:select name="course.name" list="#courseNameList" listKey="name" listValue="name"></s:select>
    
  </tr>
  <tr>
    <td width="17%">添加题目：</td>
    <td colspan="4"><label for="textfield"></label>
   <input type="text" name="question.question" id="textfield" size="100" height="30"/><label class="Error" id="questionError">${topicError}</label></td>
  </tr>
   <tr>
    <td>选择题目类型：</td>
    <td colspan="4"><select name="question.questionType" id="questiontype">
    <option value=1>1</option>
    <option value=2>2</option>
    <option value=3>3</option>
    </select>
   <label class="Error" id="typeError">${typeError}</label><label class="Error" id="answerError">${answerError}</label>  
  </tr>
  <tr>
    <td>设置选项：</td>
    <td width="23%">A：
      <label for="textfield2"></label>
    <input type="text" name="question.option_A" id="textfield2" /></td>
    <td width="20%">B：
      <label for="textfield3"></label>
    <input type="text" name="question.option_B" id="textfield3" /></td>
    <td width="20%">C：
      <label for="textfield4"></label>
    <input type="text" name="question.option_C" id="textfield4" /></td>
    <td width="20%">D：
      <label for="textfield5"></label>
    <input type="text" name="question.option_D" id="textfield5" /></td>
  </tr>
  <tr>
    <td>正确答案：</td>
    <td colspan="4"><select name="question.answer" id="answer">
    <option>A</option>
    <option>B</option>
    <option>C</option>
    <option>D</option>
    <option>是</option>
    <option>否</option>
    </select>
    <label class="Error" id="resultError">${resultError}</label>
    </td>
  </tr>
 
   <tr>
    <td>提交：</td>
    <td colspan="4"><input type="submit" id="submit" value="提交"/></td>
  </tr>
   <tr>
    <td colspan="5" id="tip">友情提示：一、判断题可不需要添选项。</br>
                                                                    &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;  二、题目类型： 1、单选题，2、多选题，3、判断题</br>
                                                                            &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;   三、判断题正确答案请用 1、是，2、否，的格式                                                  </td>
  </tr>
</table>
</form>
</body>
</html>

  </body>
</html>
