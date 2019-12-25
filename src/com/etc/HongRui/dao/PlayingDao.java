package com.etc.HongRui.dao;

import java.sql.SQLException;

/**
 * @author LS
 *
 * SearchDao.java 
 * 根据视频id查询数据库中存在的视频对应的路径
 */
public class PlayingDao extends BaseDao {

	public String getpath(String stridString) throws ClassNotFoundException, SQLException {

		getConnect();
		String sqlString="select path from video where videoID = ?";
		
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, stridString);
		rsResultSet=ps.executeQuery();
		String  paString=null;
		while(rsResultSet.next()) {
			paString=rsResultSet.getString("path");
		}
		return paString;
	}

}
