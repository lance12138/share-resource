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
    
    <title>习题查看</title>
    
	<style type="text/css">
	.main{ position:relative; float:right; width:770px; height:500px; background:#fff; }
.text_area{ position:absolute; width:768px; height:500px;  border:solid 1px #01c675; color:#01c675; font-size:20px; line-height:480px; text-align:center; font-family:"幼圆"; left:0px;  top:0px; background:#FFF; z-index:0;}
	
	</style>

  </head>
  
  <body>
    <div class="main">
    	${downloadErrors}
        <div class="text_area"> <s:if test="#request.downloadErrors!=null"><span><s:property value="#downloadErrors"/></span></s:if>
        
        <s:else><object width="800" height="400">  
            <param name="flashvars"></param>  
            <param name="allowFullScreen" value="true"></param>  
            <param name="allowscriptaccess" value="always"></param>  
            <embed src="exercises/${title}"  menu="true" loop="true" play="true"    
                allowscriptaccess="always" allowfullscreen="true" width="750" height="500"> </embed>  
        </object> </s:else> </div>
       
    </div>
  </body>
</html>