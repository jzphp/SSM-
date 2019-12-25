package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.etc.HongRui.dao.AdminDao;
import com.etc.HongRui.dao.BaseDao;
import com.etc.HongRui.entiry.Student;
import com.etc.HongRui.util.Log;

public class AdminService extends BaseDao {
	public List<Student> getStudent() throws SQLException {
		List<Student> list=new ArrayList<Student>();
		AdminDao dao=new AdminDao();
		try {
			list=dao.getStudent();
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
	
	public List<Student> getStudent1(String username) throws SQLException {
		List<Student> list=new ArrayList<Student>();
		AdminDao dao=new AdminDao();
		try {
			list=dao.getStudent1(username);
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

	public List<Student> getStudent2(String uid) throws SQLException {
		List<Student> list=new ArrayList<Student>();
		AdminDao dao=new AdminDao();
		try {
			list=dao.getStudent2(uid);
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

	public List<Student> getStudent3(String username, String uid) throws SQLException {
		List<Student> list=new ArrayList<Student>();
		AdminDao dao=new AdminDao();
		try {
			list=dao.getStudent3(username,uid);
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


	public Student showStudent(String id) throws SQLException {
		AdminDao dao=new AdminDao();
		Student student= null;
		try {
			student=dao.showStudent(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.closeResource();
		}
		return student;
	}
}
	

	/**
	 * @param i
	 * @return
	 * @throws SQLException 
	 */