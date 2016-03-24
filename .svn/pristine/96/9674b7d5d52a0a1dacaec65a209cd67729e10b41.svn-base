// JavaScript Document

	

//获取类
function getByClass(oParent,sClass)
{
	var aEle=oParent.getElementsByTagName('*');
	var aResult=[];
	
	for(var i=0; i<aEle.length;i++)
	{
		if(aEle[i].className==sClass)
		{
			aResult.push(aEle[i]);
		}
	}
	return aResult;
}

//获取行间样式
function getStyle(obj,name){
	if(obj.currentStyle)
	{
		return obj.currentStyle[name];
	}
	else
	{
		return getComputedStyle(obj,false)[name];
	}
	}
//弹窗
function expand(name,id,url,iWidth,iHeight){
 
  uri=url+id;
  var iTop = (window.screen.height-30-iHeight)/2; //获得窗口的垂直位置;  
		var iLeft = (window.screen.width-10-iWidth)/2; //获得窗口的水平位置;  
 window.open(uri,name,'height='+iHeight+',,innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+', toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
}
function jump(name,type,courseId,iWidth,iHeight){
 
  url="courseAction_editDetail?type="+type+"&&courseId="+courseId;
  var iTop = (window.screen.height-30-iHeight)/2; //获得窗口的垂直位置;  
		var iLeft = (window.screen.width-10-iWidth)/2; //获得窗口的水平位置;  
 window.open(url,name,'height='+iHeight+',,innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+', toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
}


//完美移动
function startMove(obj,json,fnEnd){
	
	clearInterval(obj.timer);
		obj.timer=setInterval(function(){
		var bStop=true;
		for(var attr in json)
		{
			var cur=0;
			if(attr=='opacity')
			{
				cur=Math.round( parseFloat(getStyle(obj,attr))*100);
			}
			else
			{
				cur=parseInt(getStyle(obj,attr));
			}
			
			var speed=(json[attr]-cur)/5;
			speed=speed>0?Math.ceil(speed):Math.floor(speed);
			if(cur!=json[attr])
			{
				bStop=false;
			}
			
			if(attr=='opacity')
			{
				obj.style.filter='alpha(opacity:'+(cur+speed)+')';
				obj.style.opacity=(cur+speed)/100;
			}
			else
			{
				obj.style[attr]=cur+speed+'px';
			}
		}
		
		if(bStop)
		{
				clearInterval(obj.timer);
				
				if(fnEnd)
				fnEnd();
		}
			
		},30)
	
}