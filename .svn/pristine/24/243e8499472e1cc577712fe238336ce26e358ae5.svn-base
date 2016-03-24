package com.jxust.util;

import java.util.Calendar;

public class Tools {

	public static String renameFileName(String uploadFileName){
		Calendar calendar = Calendar.getInstance();
		System.out.println("uploadFileName:"+uploadFileName);
		
		//获取后缀名
		String suffixName=uploadFileName.substring(uploadFileName.lastIndexOf(".")+1);
		//根据现在的时间来重新命名
		String renamedFileName = String.valueOf(calendar.get(Calendar.YEAR)) + 
		String.valueOf((calendar.get(Calendar.MONTH)+1)) + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + 
		String.valueOf(calendar.get(Calendar.HOUR))+String.valueOf(calendar.get(Calendar.MINUTE))+
		String.valueOf( calendar.get(Calendar.SECOND))+
		String.valueOf(calendar.get(Calendar.MILLISECOND))+"." + suffixName;
		return renamedFileName;
	}
}
