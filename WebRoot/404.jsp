<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<title>404 Page not found</title>

<style>
	body{background-color: #272822;}
	.wrap{width: 600px; height: 400px; margin: 80px auto;border: 1px solid #ccc; background-color: #fff; box-shadow: black 15px 15px 15px; border-radius: 5px;}
	.up{width: 100%;height: 250px; border-bottom: 1px dashed #01c675;padding-top: 80px; }
	.up p{text-align:center;color: #25A84A;font-family: "幼圆";font-size: 26px;font-weight:900;}
	.up-left{float:left;width:45%;height: 150px; }
	.up-right{text-align:left;float: right; width: 55%;height: 150px;font-family:"微软雅黑"; font-size: 130px;font-weight: bold;color: #25A84A; }
	.up-left-up{text-align:right;color: #90CC99;font-family: "幼圆";font-size: 93px;font-weight: bold; }
	.up-left-down{text-align:right;color: #90CC99;font-family: "幼圆";font-size: 40px; font-weight: bold;}
	.down{text-align: center;color: #333;font-family:"微软雅黑"; font-size: 18px;}

</style>
</head>
<body>
	<div class="wrap">
		<div class="up">
			<div class="up-left">
				<div class="up-left-up">
					Page
				</div>
				<div class="up-left-down">
					Not Found
				</div>	
			</div>
			<div class="up-right">
				404
			</div>
			<p>您访问的页面可能搬家了...........</p>
		</div>
		<div class="down">
			<p>请<a href="index.jsp" >返回首页</a>或联系工作人员！</p>
			
		</div>
	</div>
</body>
</html>