/*************************
*@className    ViewComment.java
*@Date         2019年1月17日
*@author       jiazhi
*@version      V1.0
*@package_name com.etc.HongRui.dao
************************/
package com.etc.HongRui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.entiry.ViewComment;

public class ViewCommentDao extends BaseDao {
	/**
	 * 
	 * @param PID
	 * @return 评论的内容
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<ViewComment> getComment(String PID,int page , int row) throws ClassNotFoundException, SQLException{
		getConnect();
		int n1 =   (page - 1) * row;
		String sqlString = "select * from bbscomment where PID = ? order by CTime limit ? , ?";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, PID);
		ps.setInt(2, n1);
		ps.setInt(3, row);
		rsResultSet = ps.executeQuery();
		List<ViewComment> list = new ArrayList<ViewComment>();
		while (rsResultSet.next()) {
			ViewComment viewComment  = new ViewComment();
			viewComment.setPID(rsResultSet.getString("PID"));
			viewComment.setCID(rsResultSet.getString("CID"));
			viewComment.setUID(rsResultSet.getString("UID"));
			viewComment.setUsername("null");
			viewComment.setCText(rsResultSet.getString("CText"));
			viewComment.setCTime(rsResultSet.getString("CTime"));
			list.add(viewComment);
		}
		return list;
	}
	
	/**
	 * 
	 * @param viewComment
	 * @return 写评论的结果
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean writeComment(ViewComment viewComment) throws ClassNotFoundException, SQLException {
		getConnect();
		boolean flag = false;
		String sqlString ="insert into bbscomment value(?,?,?,?,?)";
		ps= connection.prepareStatement(sqlString);
		ps.setString(1, viewComment.getCID());
		ps.setString(2, viewComment.getPID());
		ps.setString(3, viewComment.getUID());
		ps.setString(4, viewComment.getCText());
		ps.setString(5, viewComment.getCTime());
		int result = ps.executeUpdate();
		if (result>0) {
			flag = true;
		}
		return flag;
	}
}
