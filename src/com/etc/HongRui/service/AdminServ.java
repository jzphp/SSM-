package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.dao.AdmDao;
import com.etc.HongRui.dao.BaseDao;
import com.etc.HongRui.entiry.Teacher;
import com.etc.HongRui.util.Log;

public class AdminServ extends BaseDao {
	

	/**
	 * @param i
	 * @return
	 * @throws SQLException 
	 */
	
	public List<Teacher> getTeacher() throws SQLException {
		List<Teacher> list=new ArrayList<Teacher>();
		AdmDao dao=new AdmDao();
		try {
			list=dao.getTeacher();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public List<Teacher> getTeacher1(String username) throws SQLException {
		List<Teacher> list=new ArrayList<Teacher>();
		AdmDao dao=new AdmDao();
		try {
			list=dao.getTeacher1(username);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
		finally {
			dao.closeResource();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public List<Teacher> getTeacher2(String uid) throws SQLException {
		List<Teacher> list=new ArrayList<Teacher>();
		AdmDao dao=new AdmDao();
		try {
			list=dao.getTeacher2(uid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
		finally {
			dao.closeResource();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public List<Teacher> getTeacher3(String username, String uid) throws SQLException {
		List<Teacher> list=new ArrayList<Teacher>();
		AdmDao dao=new AdmDao();
		try {
			list=dao.getTeacher3(username,uid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
		finally {
			dao.closeResource();
		}
		// TODO Auto-generated method stub
		return list;
	}
	
	public Teacher showTeacher(String id) throws SQLException {
		AdmDao dao=new AdmDao();
		Teacher teacher= null;
		try {
			teacher=dao.showTeacher(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.closeResource();
		}
		return teacher;
	}
	
}

