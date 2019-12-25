/*************************
*@className    UploadService.java
*@Date         2019年1月14日
*@author       jiazhi
*@version      V1.0
*@package_name com.etc.HongRui.service
************************/
package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.etc.HongRui.dao.UploadDao;
import com.etc.HongRui.entiry.Video;
import com.etc.HongRui.util.Log;

public class UploadService {
	/**
	 * 
	 * @param UID
	 * @param list
	 * @return 获取课程分类一级名称的集合
	 * @throws SQLException
	 */
	public ArrayList<String> getFname(String UID,ArrayList<String> list) throws SQLException {
		UploadDao dao = new UploadDao();
		try {
			list = dao.GetFname(UID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		return list;
	}
	/**
	 * 
	 * @param CCtype
	 * @param UID
	 * @param list
	 * @return 获取课程分类二级名称的集合
	 * @throws SQLException
	 */
	public ArrayList<String> getSname(String CCtype,String UID,ArrayList<String> list) throws SQLException {
		UploadDao dao = new UploadDao();
		try {
			list = dao.GetSname(CCtype,UID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		return list;
	}
	/**
	 * 
	 * @param CCtype
	 * @param Ctype
	 * @param UID
	 * @param list
	 * @return 获取课程分类三级名称的集合
	 * @throws SQLException
	 */
	public ArrayList<String> getTname(String CCtype,String Ctype,String UID,ArrayList<String> list) throws SQLException {
		UploadDao dao = new UploadDao();
		try {
			list = dao.GetTname(CCtype,Ctype,UID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		return list;
	}
	/**
	 * 
	 * @param Cname
	 * @param UID
	 * @return 获取课程CID
	 * @throws SQLException
	 */
	public String getCID(String Cname,String UID) throws SQLException {
		String CID = null;
		UploadDao dao = new UploadDao();
		try {
			CID = dao.getCID(Cname, UID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		return CID;
	}
/**
 * 
 * @param video
 * @return 上传的结果
 * @throws SQLException
 */
	public boolean upload(Video video) throws SQLException {
		// TODO Auto-generated method stub
		UploadDao dao = new UploadDao();
		boolean flag = false;
		try {
			flag = dao.Upload(video);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		return flag;
		
	}
}
