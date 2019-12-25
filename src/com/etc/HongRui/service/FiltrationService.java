/*************************
*@className    Filtration.java
*@Date         2019年1月18日
*@author       jiazhi
*@version      V1.0
*@package_name com.etc.HongRui.service
************************/
package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.etc.HongRui.dao.FiltrationDao;
import com.etc.HongRui.util.Log;

public class FiltrationService {
	/**
	 * 
	 * @param str
	 * @return 不文明用户的替换的结果
	 * @throws SQLException
	 */
	public String Filtration(String str) throws SQLException {
		FiltrationDao dao = new FiltrationDao();
		ArrayList<String> list = null;
		try {
			list = dao.Filtration();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		for (String string : list) {
			str= str.replaceAll(string, "*");
		}
		return str;
	}
}
