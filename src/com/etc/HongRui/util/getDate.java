package com.etc.HongRui.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/*************************
*@className   getDate.java
*@Date        2019年1月10日
*@author      jiazhi
*@version     V1.0
*@description
*************************/

public class getDate {
	/**
	 * 
	 * @return 时间格式字符串
	 */
	public static String  GetDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间
		return date;
	}
}
