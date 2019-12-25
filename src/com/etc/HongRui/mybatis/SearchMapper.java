/*************************
*@className    SearchMapper.java
*@Date         2019年1月21日
*@author       jiazhi
*@version      V1.0
*@package_name com.etc.HongRui.mybatis
************************/
package com.etc.HongRui.mybatis;

import java.util.List;
import com.etc.HongRui.entiry.Course;

public interface SearchMapper {
	public List<Course> search(String string);
	
}
