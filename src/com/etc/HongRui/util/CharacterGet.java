/*************************
*@className    CharacterGet.java
*@Date         2019年1月12日
*@author       jiazhi
*@version      V1.0
*@package_name com.etc.HongRui.util
************************/
package com.etc.HongRui.util;

import java.io.UnsupportedEncodingException;

public class CharacterGet {
	//处理GET方法中的乱码问题
		public String getRight(String name) throws UnsupportedEncodingException{
			return new String(name.getBytes("iso-8859-1") , "utf-8") ;
		}
}
