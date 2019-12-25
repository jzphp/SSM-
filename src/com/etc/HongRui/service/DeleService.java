package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.dao.VideoDao;
import com.etc.HongRui.entiry.Video;
import com.etc.HongRui.util.Log;

public class DeleService {
	//获取视频列表信息
	public List<Video> getlist() throws SQLException {
		VideoDao dao = new VideoDao();
		List<Video> list = null;
		try {
			dao.getConnect();
			list = dao.getlist();
		}catch(Exception e) {
			Log.logger.debug(e.getMessage());
			e.printStackTrace();
		}finally {
			dao.closeResource();
		}
		return list;
	}
	
	public List<Video> getlist1(String vid) throws SQLException {
		VideoDao dao = new VideoDao();
		List<Video> list = new ArrayList<Video>();
		try {
			list = dao.getlist1(vid);
		}catch(Exception e) {
			Log.logger.debug(e.getMessage());
			e.printStackTrace();
		}finally {
			dao.closeResource();
		}
		return list;
	}

	public List<Video> getlist2(String vname) throws SQLException {
		VideoDao dao = new VideoDao();
		List<Video> list = new ArrayList<Video>();
		try {
			list = dao.getlist2(vname);
		}catch (Exception e) {
			Log.logger.debug(e.getMessage());
			e.printStackTrace();
		}finally {
			dao.closeResource();
		}
		return list;
	}

	public List<Video> getlist3(String vid , String vname) throws SQLException {
		VideoDao dao = new VideoDao();
		List<Video> list = new ArrayList<Video>();
		try {
			list = dao.getlist3(vid , vname);
		}catch(Exception e){
			Log.logger.debug(e.getMessage());
			e.printStackTrace();
		}finally {
			dao.closeResource();
		}
		return list;
	} 

	public int dele(String Vid) {
		VideoDao dao = new VideoDao();
		int count = 0;
		try {
			dao.getConnect();
			count = dao.dele(Vid);
		}catch(Exception e) {
			Log.logger.debug(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				dao.closeResource();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public int delechoice(String str) throws SQLException {
		VideoDao dao = new VideoDao() ;
		int count = 0 ;
		 try{
			 dao.getConnect();
			count = dao.delechoice(str)  ;
		 }catch(Exception e){
			 Log.logger.debug(e.getMessage());
			 e.printStackTrace();
		 }finally{
			 dao.closeResource();	
		 }
		return count;
	}









	






	
	


}  