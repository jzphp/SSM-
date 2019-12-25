package com.etc.HongRui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.entiry.Teacher;

public class AdmDao extends BaseDao{
/***
 * 
 * @return 
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public List<Teacher> getTeacher() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		getConnect(); 
		String sqlString="SELECT teacher.`UID`,Tname,Uphone FROM user JOIN teacher ON user.`UID`=teacher.`UID`";
		ps=connection.prepareStatement(sqlString);
		rsResultSet=ps.executeQuery();
		List<Teacher> list=new ArrayList<Teacher>();
		while(rsResultSet.next()) {
			Teacher teacher=new Teacher();
			teacher.setUID(rsResultSet.getString("UID"));
			teacher.setTname(rsResultSet.getString("Tname"));
			teacher.setUphone(rsResultSet.getString("Uphone"));
			list.add(teacher);
		}
		
		return list;
	}
/**
 * 
 * @param username
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public List<Teacher> getTeacher1(String username) throws ClassNotFoundException, SQLException {
		getConnect(); 
		String sqlString="SELECT teacher.`UID`,Tname,Uphone FROM user JOIN teacher ON user.`UID`=teacher.`UID` where Tname= ?";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, username);
		rsResultSet=ps.executeQuery();
		List<Teacher> list=new ArrayList<Teacher>();
		while(rsResultSet.next()) {
			Teacher teacher=new Teacher();
			teacher.setUID(rsResultSet.getString("UID"));
			teacher.setTname(rsResultSet.getString("Tname"));
			teacher.setUphone(rsResultSet.getString("Uphone"));
			list.add(teacher);
		}
		
		return list;
	}
/**
 * 
 * @param uid
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public List<Teacher> getTeacher2(String uid) throws ClassNotFoundException, SQLException {
		getConnect(); 
		String sqlString="SELECT teacher.`UID`,Tname,Uphone FROM user JOIN teacher ON user.`UID`=teacher.`UID` where teacher.UID= ?";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, uid);
		rsResultSet=ps.executeQuery();
		List<Teacher> list=new ArrayList<Teacher>();
		while(rsResultSet.next()) {
			Teacher teacher=new Teacher();
			teacher.setUID(rsResultSet.getString("UID"));
			teacher.setTname(rsResultSet.getString("Tname"));
			teacher.setUphone(rsResultSet.getString("Uphone"));
			list.add(teacher);
		}
		
		return list;
	}
/**
 * 
 * @param username
 * @param uid
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public List<Teacher> getTeacher3(String username, String uid) throws ClassNotFoundException, SQLException {
		getConnect(); 
		String sqlString="SELECT teacher.`UID`,Tname,Uphone FROM user JOIN teacher ON user.`UID`=teacher.`UID` where Tname=? and teacher.UID=?";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, username);
		ps.setString(2, uid);
		rsResultSet=ps.executeQuery();
		List<Teacher> list=new ArrayList<Teacher>();
		while(rsResultSet.next()) {
			Teacher teacher=new Teacher();
			teacher.setUID(rsResultSet.getString("UID"));
			teacher.setTname(rsResultSet.getString("Tname"));
			teacher.setUphone(rsResultSet.getString("Uphone"));
			list.add(teacher);
		}
		
		return list;
	}
	
	/**
	 * @param i
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Teacher showTeacher(String id) throws ClassNotFoundException, SQLException {
		getConnect(); 
		String sqlString="SELECT teacher.`UID`,Tname,Tsex,Tage,Taccount,Tbackground,Tcourse,Tmonery,Uphone FROM user JOIN teacher ON user.`UID`=teacher.`UID` WHERE  teacher.`UID`= ?  ";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, id);
		rsResultSet=ps.executeQuery();
		Teacher teacher = new Teacher();
		while(rsResultSet.next()) {
			teacher.setUID(rsResultSet.getString("UID"));
			teacher.setTname(rsResultSet.getString("Tname"));
			teacher.setUphone(rsResultSet.getString("Uphone"));
			teacher.setTage(rsResultSet.getString("Tage"));
			teacher.setTsex(rsResultSet.getString("Tsex"));
			teacher.setTbackground(rsResultSet.getString("Tbackground"));
			teacher.setTcourse(rsResultSet.getString("Tcourse"));
			teacher.setTmonery(rsResultSet.getString("Tmonery"));
			teacher.setTcourse(rsResultSet.getString("Tcourse"));
			
		}
		return teacher;
	}
	
}
