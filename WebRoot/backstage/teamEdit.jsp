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
    
    <title>编辑页面</title>
    <style>
    
    
         table, td, tr{border: 1px solid #7EC0E5;}
          table tr td{ background: #f3f3f3;}
          .td_title{  max-width: 80px;font-weight:300;font-family:"微软雅黑" font-size:12px;}
          .td_content{max-width:315px;}
        .td_photo{max-width: 120px;}
         #title{font-family:"微软雅黑";font-size:14px;font-weight:600;}
         evaluate{padding-left:200px;}
         #submit{margin-left:180px;width:80px;border-radius: 3px 3px 3px 3px;border: 1px solid #54959E;font-size:14px;font-weight:600;color:white;background:#468377;}
         #submit:hover{background:#54959E;}
         .label{font-family:"微软雅黑";font-size:12px;font-weight:300;color:red;}
    </style>
     <script type="text/javascript" src='<s:url value="js/jquery-1.9.1.min.js"/>'></script>
    <script type="text/javascript">
   
    window.onload=function(){
    var oForm=document.getElementById("teacherForm");
    oForm.onsubmit=function(){
    if(document.getElementById("teacherName").value===""){
    document.getElementById("nameError").textContent="老师名字不可为空！";
    return false;
    }else if(document.getElementById("birthday").value===""){
    document.getElementById("birthdayError").textContent="出生日期不可为空！";
     return false;
    
    }else if(document.getElementById("diploma").value===""){
     document.getElementById("diplomaError").textContent="专业技术职务不可为空！";
      return false;
    }else if(document.getElementById("courseMajor").value===""){
    document.getElementById("majorError").textContent="学科专业不可为空！";
     return false;
    }else if(document.getElementById("job").value===""){
    document.getElementById("jobError").textContent="课程中承担的工作不可为空！";
     return false;
    }
    else{
    oForm.submit();
    
    }
    }
    
    document.getElementById("select").value="${teacher.sex}";
   	document.getElementById("select")[${teacher.sex}].selected= true;
 
    }
    
    </script>
    
	</head>

<body>
<s:form id="teacherForm" name="teacherForm" action="teachTeamAction_updateTeacherTeam?id=%{id}" method="post" enctype="multipart/form-data">

<table width="100%" border="1">
  <tr>
    <td colspan="3" align="center" id="title">编辑团队成员资料</td>
  </tr>
  <tr>
    <td class="td_title">姓名</td>
    <td class="td_content"><input type="text" name="teachTeam.teacherName" id="teacherName" value="${teacher.teacherName}"><label id="nameError" class="label">*${nameError}</label></td>
    <td rowspan="6" class="td_photo" align="center">
    <s:if test="#request.teacher.self_photo!=null">
    <img src="images/teachers/${teacher.self_photo}" width="114px" height="150px"/>
    </s:if>
    <s:else>
     <img src="images/teachers/default.jpg" width="114px" height="150px"/>
    </s:else>
    <input type="file" name="photo" id="teacherPhoto"/></td>
  </tr>
  <tr>
    <td class="td_title">性别</td>
    <td class="td_content"><select name="teachTeam.sex" id="select">
    
    <option>男</option>
     <option>女</option>
    </select></td>
  </tr>
  <tr>
    <td class="td_title">出生年月</td>
    <td class="td_content"><input type="text" name="teachTeam.birthday" value="${teacher.birthday}" id="birthday"><label id="birthdayError" class="label">*${birthdayError}</label></td>
  </tr>
  <tr>
    <td class="td_title">专业技术职务</td>
    <td class="td_content"><input type="text" name="teachTeam.diploma" value="${teacher.diploma}" id="diploma" size="50"/><label id="diplomaError" class="label">*${diplomaError}</label></td>
  </tr>
   <tr>
    <td class="td_title">学科专业</td>
    <td class="td_content"><input type="text" name="teachTeam.courseMajor" value="${teacher.courseMajor}" id="courseMajor"/><label id="majorError" class="label">*${majorError}</label></td>
  </tr>
  <tr>
    <td class="td_title">教授课程 <s:property value='#payment'/></td>
    <td class="td_content">
    <s:iterator id="gz" value="courseList" status="t">
   <label> ${gz.name}</label><input type="checkbox" name="teachTeam.chooseCourse[${t.index}]" value="${gz.name}" <s:iterator var="sr" value="courseCh"><s:if test="#sr==#gz.name">checked</s:if></s:iterator> />
    负责人<input type="checkbox" name="teachTeam.Manager" value="${gz.name}" class="input_check"  <s:if test="#gz.name==#manage">checked</s:if> />
    </s:iterator>
    <label class="label">${courseError}${managerError}<s:iterator var="sr" value="<s:property value='#payment'/>">${sr}</s:iterator></label></td>
   
  </tr>
  <tr>
    <td class="td_title">本课程中承担的工作</td>
    <td class="td_content"><input type="text" name="teachTeam.job" id="job" value="${teacher.job}" size="50"/><label id="jobError" class="label">* ${jobError}</label></td>
  <td rowspan="6" class="label" align="center">
    			友情提示：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</br>
                              1.打星号的属性不可为空；</br>
                              2.每门课程的课程负责人</br>只能有一个且每个人</br>只能负责一门课程；
    
    </td>
  </tr>
  <tr>
    <td class="td_title">出国访问情况</td>
    <td class="td_content"><input type="text" name="teachTeam.foreignMeeting" value="${teacher.foreignMeeting}" id="meeting" size="50"/></td>
  </tr>
  <tr>
    <td colspan="2" class="td_title">个人评价</td>
  </tr>
  <tr>
    <td colspan="2" class="td_content"><textarea name="teachTeam.evaluate" id="evaluate" cols="80" rows="6">${teacher.evaluate}</textarea></td>
  </tr>
  <tr>
 <td colspan="2"><s:if test="#request.id!=null"><input type="submit" id="submit" value="更新"/></s:if>&nbsp;</td>
  </tr>
</table>
</s:form>

</body>
<script>

 $(function () {
            var allBox = $(".input_check");
            allBox.click(function () {
               if(this.checked || this.checked=='checked'){
               
                   allBox.removeAttr("checked");
              
                   this.checked=true;
                 }
            });
        });
</script>
</html>
	