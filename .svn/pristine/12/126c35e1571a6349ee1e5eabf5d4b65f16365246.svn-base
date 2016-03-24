// JavaScript Document

	
$(function() {
	/*
	 * 1. 得到所有的错误信息，循环遍历之。调用一个方法来确定是否显示错误信息！
	 */
	$(".errorClass").each(function() {
		showError($(this));//遍历每个元素，使用每个元素来调用showError方法
	});
	
	
	/*
	 * 3. 输入框得到焦点隐藏错误信息
	 */
	$(".inputClass").focus(function() {
		var labelId = $(this).attr("id") + "Error";//通过输入框找到对应的label的id
		$("#" + labelId).text("");//把label的内容清空！
		showError($("#" + labelId));//隐藏没有信息的label
	});
	
	/*
	 * 4. 输入框失去焦点进行校验
	 */
	$(".inputClass").blur(function() {
		var id = $(this).attr("id");//获取当前输入框的id
		var funName = "validate" + id.substring(0,1).toUpperCase() + id.substring(1) + "()";//得到对应的校验函数名
		eval(funName);//执行函数调用
		//validateLoginname();
	});
	
	/*
	 * 5. 表单提交时进行校验
	 */
	$("#registForm").submit(function() {
		var bool = true;//表示校验通过		
		if(!validateStudentsname()) {
			bool = false;
		}
		if(!validateAcademy()) {
			bool = false;
		}
		if(!validateClassnumber()) {
			bool = false;
		}
		if(!validateTelnumber()) {
			bool = false;
		}
		if(!validateECard()){
			bool=false;
		}
		
		
		return bool;
	});
});

/*
 * 登录名校验方法
 */
function validateStudentsname() {
	var id = "studentsname";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */	
	if(value=="") {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("学生姓名不能为空！");
		showError($("#" + id + "Error"));
		return false;
		
		
	}
	

	return true;
}
/*
 * 学院验方法
 */
function validateAcademy() {
	var id = "acdemy";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */	
	if(value==0) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("请选择学院！");
		showError($("#" + id + "Error"));
		return false;
		
		
	}
	

	return true;
}
/*
班级用户校验
*/
function validateClassnumber(){
	var id="classnumber";
	var value=$("#"+id).val();
	if(value==""){
		$("#"+id+"Error").text("所属班级不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}else if(value.length!=3){
		$("#"+id+"Error").text("请用三位数，如‘122’");
		showError($("#" + id + "Error"));
		return false;
	}
	return true;
}
/*
校验一卡通号
*/
function validateECard(){
	var id="eCard";
	var value=$("#"+id).val();
	if(value==""){
		$("#"+id+"Error").text("学生一卡通号不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}else if(value.length!=10){
		$("#"+id+"Error").text("一卡通号为13位，如'1520123442'");
		showError($("#" + id + "Error"));
		return false;
	}
	$.ajax({
		url:"userAction_validateACM",//要请求的actiont		
		data:{cardnumber:value},//给服务器的参数	
		type:"POST",
		dataType:"json",
		async:false,//是否异步请求，如果是异步，那么不会等服务器返回，我们这个函数就向下运行了。	
	    cache:false,
		success:function(result) {
			if(!result) {//如果校验失败			
			 $("#" + id + "Error").text("用户名已被注册！");
				showError($("#" + id + "Error"));
				return false;
			}
		}
	});
	return true;
}
/*
电话号码校验
*/
function validateTelnumber(){
	var id="telnumber";
	var value=$("#"+id).val();

	if(value==""){
		$("#"+id+"Error").text("电话号码不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	if(value.length!=11){
		$("#"+id+"Error").text("电话号码格式不对，必须为11位！");
		showError($("#" + id + "Error"));
		return false;
	}
	
	
	return true;
}
/*
 * 判断当前元素是否存在内容，如果存在显示，不页面不显示！
 */
function showError(ele) {
	var text = ele.text();//获取元素的内容
	if(!text) {//如果没有内容
		ele.css("display", "none");//隐藏元素
	} else {//如果有内容
		ele.css("display", "");//显示元素
	}
}