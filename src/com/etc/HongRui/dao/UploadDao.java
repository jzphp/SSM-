/*************************
*@className    uoloadDao.java
*@Date         2019年1月14日
*@author       jiazhi
*@version      V1.0
*@package_name com.etc.HongRui.dao
************************/
package com.etc.HongRui.dao;


import java.sql.SQLException;
import java.util.ArrayList;

import com.etc.HongRui.entiry.Video;

public class UploadDao extends BaseDao {
	/**
	 * 
	 * @param UID 用户的UID
	 * @return 课程一级分类名称集合
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<String> GetFname(String UID) throws ClassNotFoundException, SQLException {
		getConnect();
		String sqlString = "SELECT DISTINCT CCtype FROM Course where UID=?";
		ps = connection.prepareStatement(sqlString);
		ps.setString(1, UID);
		rsResultSet = ps.executeQuery();
		ArrayList<String> list=new ArrayList<String>();
		while (rsResultSet.next()) {
			list.add(rsResultSet.getString("CCtype").toString());
		}
		return list;
	}
/**
 * 
 * @param CCtype
 * @param UID
 * @return 课程二级分类名称集合
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public ArrayList<String> GetSname(String CCtype,String UID) throws ClassNotFoundException, SQLException {
		getConnect();
		String sqlString = "SELECT DISTINCT Ctype FROM Course where CCtype= ? and UID=? ";
		ps = connection.prepareStatement(sqlString);
		ps.setString(1, CCtype);
		ps.setString(2, UID);
		rsResultSet = ps.executeQuery();
		ArrayList<String> list=new ArrayList<String>();
		while (rsResultSet.next()) {
			list.add(rsResultSet.getString("Ctype"));
		}
		return list;
	}
/**
 * 
 * @param CCtype
 * @param Ctype
 * @param UID
 * @return 课程三级分类名称集合
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public ArrayList<String> GetTname(String CCtype,String Ctype,String UID) throws ClassNotFoundException, SQLException {
		getConnect();
		String sqlString = "SELECT DISTINCT Cname FROM Course where CCtype=? && Ctype = ? && UID=?";
		ps = connection.prepareStatement(sqlString);
		ps.setString(1, CCtype);
		ps.setString(2, Ctype);
		ps.setString(3, UID);
		rsResultSet = ps.executeQuery();
		ArrayList<String> list=new ArrayList<String>();
		while (rsResultSet.next()) {
			list.add(rsResultSet.getString("Cname"));
		}
		return list;
	}
	/**
	 * 
	 * @param Cname
	 * @param UID
	 * @return 课程CID编号
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String getCID(String Cname,String UID) throws ClassNotFoundException, SQLException {
		getConnect();
		String CID=null;
		String sqlString = "SELECT CID FROM Course WHERE UID =? && Cname=?";
		ps = connection.prepareStatement(sqlString);
		ps.setString(1, UID);
		ps.setString(2, Cname);
		rsResultSet = ps.executeQuery();
		while (rsResultSet.next()) {
			CID = rsResultSet.getString("CID");
		}
		return CID;
	}
/**
 * 
 * @param video
 * @return 上传的结果
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public boolean Upload(Video video) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		getConnect();
		boolean flag = false;
		String sqlString = "insert into video value(?,?,?,?,?)";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, video.getVideoID());
		ps.setString(2, video.getCID());
		ps.setString(3, video.getVLength());
		ps.setString(4, video.getPath());
		ps.setString(5, video.getVideoName());
		int result = ps.executeUpdate();
		if(result>0) {
			flag = true;
		}
		return flag;
	}

}
