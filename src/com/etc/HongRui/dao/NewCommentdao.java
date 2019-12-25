package com.etc.HongRui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.entiry.Invatition;

/*************************
*@className   NewCommentdao.java
*@Date        2019年1月10日
*@author      jiazhi
*@version     V1.0
*@description
*************************/

public class NewCommentdao extends BaseDao {
/**
 * 
 * @param newComment 主题的实体信息
 * @return 发表新帖的结果true  或 false
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public boolean write(Invatition newComment) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		getConnect();
		String sqlString = "insert into invatition value(?,?,?,?,?)";
		ps = connection.prepareStatement(sqlString);
		ps.setString(1, newComment.getPID());
		ps.setString(2, newComment.getUID());
		ps.setString(3, newComment.getPtheme());
		ps.setString(4, newComment.getPcontext());
		ps.setString(5, newComment.getPtime());
		int a  = ps.executeUpdate();
		boolean flag = false;
		if (a>0) {
			flag = true;
		}
		return flag;
	}
	/**
	 * 
	 * @param UID
	 * @return 根据UID查询的主题结果
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Invatition> showInvatitions(String UID,int page , int row) throws SQLException, ClassNotFoundException {
		getConnect();
		int n1 =   (page - 1) * row;
		List<Invatition> list = new ArrayList<Invatition>();
		String sqlString  = "select * from invatition where uid = ? limit ? , ?";
		ps = connection.prepareStatement(sqlString);
		ps.setString(1, UID);
		ps.setInt(2, n1);
		ps.setInt(3, row);
		rsResultSet = ps.executeQuery();
		while (rsResultSet.next()) {
			Invatition invatition = new Invatition();
			invatition.setPID(rsResultSet.getString("PID"));
			invatition.setPtheme(rsResultSet.getString("Ptheme"));
			invatition.setPtime(rsResultSet.getString("Ptime"));
			invatition.setPcontext(rsResultSet.getString("Pcontext"));
			list.add(invatition);
		}
		return list;
	}
	
}
