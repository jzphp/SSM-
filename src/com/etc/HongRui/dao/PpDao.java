/**
 * 
 */
package com.etc.HongRui.dao;

import java.sql.SQLException;

/**
 * @author LS
 *
 * PpDao.java 查询订单表中是否由此课程，此用户的购买信息。

 */
public class PpDao extends BaseDao{

	public boolean getorder(String idString,String uidString) throws ClassNotFoundException, SQLException {
		getConnect();
		String sqlString="SELECT OID FROM orderdetail WHERE UID= ? AND CID= ?";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, uidString);
		ps.setString(2, idString);
		rsResultSet=ps.executeQuery();
		boolean flag=false;
		while(rsResultSet.next()) {
			flag=true;
		}
		return flag;
	}
}
