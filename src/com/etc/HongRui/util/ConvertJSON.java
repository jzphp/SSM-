/*************************
*@className    ConvertList.java
*@Date         2019年1月15日
*@author       jiazhi
*@version      V1.0
*@package_name com.etc.HongRui.util
************************/
package com.etc.HongRui.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ConvertJSON {
	
	/**
	 * 
	 * @param name
	 * @param list
	 * @return json格式的字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String convertList(ArrayList<String> list) throws UnsupportedEncodingException{
		String json = null;
		json="{";
		int i =0;
		for (String a : list) {
			json=json+",\""+i+"\":\""+a+"\"";
			i++;
		}
		json=json+"}";
		StringBuilder sb = new StringBuilder(json);
		int i1 = sb.indexOf("{");
		json=json.substring(0, i1+1)+json.substring(i1+2);
		return json;
	}
}
