/*************************
*@className    FiltrationDao.java
*@Date         2019年1月18日
*@author       jiazhi
*@version      V1.0
*@package_name com.etc.HongRui.dao
************************/
package com.etc.HongRui.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public class FiltrationDao extends BaseDao{
	/**
	 * 
	 * @return 不文明用语的结果查询集合
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<String> Filtration() throws ClassNotFoundException, SQLException {
		getConnect();
		String sqlString = "select * from filtration";
		ps = connection.prepareStatement(sqlString);
		rsResultSet = ps.executeQuery();
		ArrayList<String> list = new ArrayList<String>();
		while (rsResultSet.next()) {
			list.add(rsResultSet.getString(1));
		}
		return list;
	}
}
