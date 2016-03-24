// JavaScript Document
window.onload=function()
{
	//导航JS
	
	var oNav= document.getElementById('nav');
	var aNavBtns=oNav.getElementsByTagName('a');
	var oSearchBtn=document.getElementById('search_btn');
	var iSearchIndex=0;
	var iIntroduceMoerIndex=0;
	
	var oSearchBox=document.getElementById('search_box');
	var oSearchInput=document.getElementById('search_input');
	
	
	
	
	//导航搜索按钮
	oSearchBtn.onmousemove=function()
	{
		oSearchBtn.style.height=10+'px';
		oSearchBtn.style.background='#01c675';
		oSearchBtn.style.borderBottom='4px #00a05e solid';
		oSearchBtn.getElementsByTagName('span')[0].className='active';
		
	}
	
	oSearchBtn.onmouseout=function()
	{
		oSearchBtn.style.height=14+'px';
		oSearchBtn.style.background='#fff';
		oSearchBtn.style.borderBottom='none';
		oSearchBtn.getElementsByTagName('span')[0].className='';
	}
	oSearchBtn.onclick=function()
	{
		if(iSearchIndex%2==0)
			startMove(oSearchBox,{opacity:100});
		else
			startMove(oSearchBox,{opacity:0});
		iSearchIndex++;
	}
	
	//搜索输入框提示js
	oSearchInput.onfocus=function()
	{
		if(this.value==this.defaultValue)
		{
			
			this.value='';
			this.style.color='#a1a1a1'
		}
		
	}
	
	oSearchInput.onblur=function()
	{
		if(!this.value)
		{
			this.value=this.defaultValue;
			this.style.color='#ccc';
		}
	}
	
	
	
	//输入框限制
	
	var oStudentsName=document.getElementById('studentsname');
	var oClassNumber=document.getElementById('classnumber');
	var oTelNumber=document.getElementById('telnumber');
	
	oStudentsName.onkeyup=function()
	{
		this.value=this.value.replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,'');
	};
	oStudentsName.onbeforepast=function()
	{
		this.clipboardData.setData('text',this.clipboardData.getData('text').replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,''));
	};
	oClassNumber.onkeyup=function()
	{
		this.value=this.value.replace(/[^\d]/g,'')
	};
	oClassNumber.onbeforepaste=function()
	{
		this.clipboardData.setData('text',this.clipboardData.getData('text').replace(/[^\d]/g,'')) ;
		
	}
	oTelNumber.onkeyup=function()
	{
		this.value=this.value.replace(/[^\d]/g,'') ;
	}
	oTelNumber.onbeforepaste=function()
	{
		this.clipboardData.setData('text',this.clipboardData.getData('text').replace(/[^\d]/g,''))	;
	}
	
	//姓名输入框提示js
	oStudentsName.onfocus=function()
	{
		if(this.value==this.defaultValue)
		{
			
			this.value='';
			this.style.color='#666'
		}
		
	}
	
	oStudentsName.onblur=function()
	{
		if(!this.value)
		{
			this.value=this.defaultValue;
			this.style.color='#ccc';
		}
	}
	
	//班级输入框提示js
	oClassNumber.onfocus=function()
	{
		if(this.value==this.defaultValue)
		{
			
			this.value='';
			this.style.color='#666'
		}
		
	}
	
	oClassNumber.onblur=function()
	{
		if(!this.value)
		{
			this.value=this.defaultValue;
			this.style.color='#ccc';
		}
	}
	
	//号码输入框提示js
	oTelNumber.onfocus=function()
	{
		if(this.value==this.defaultValue)
		{
			
			this.value='';
			this.style.color='#666'
		}
		
	}
	
	oTelNumber.onblur=function()
	{
		if(!this.value)
		{
			this.value=this.defaultValue;
			this.style.color='#ccc';
		}
	}
	
}