package com.etc.HongRui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.entiry.Student;

public class AdminDao extends BaseDao{
	public List<Student> getStudent() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		getConnect(); 
		String sqlString="SELECT student.`UID`,Sname,Uphone FROM user JOIN student ON user.`UID`=student.`UID`";
		ps=connection.prepareStatement(sqlString);
		rsResultSet=ps.executeQuery();
		List<Student> list=new ArrayList<Student>();
		while(rsResultSet.next()) {
			Student student=new Student();
			student.setUID(rsResultSet.getString("UID"));
			student.setSname(rsResultSet.getString("Sname"));
			student.setUphone(rsResultSet.getString("Uphone"));
			list.add(student);
		}
		
		return list;
	}

	public List<Student> getStudent1(String username) throws ClassNotFoundException, SQLException {
		getConnect(); 
		String sqlString="SELECT student.`UID`,Sname,Uphone FROM user JOIN student ON user.`UID`=student.`UID` WHERE Sname=?";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, username);		
		rsResultSet=ps.executeQuery();
		List<Student> list=new ArrayList<Student>();
		while(rsResultSet.next()) {
			Student student=new Student();
			student.setUID(rsResultSet.getString("UID"));
			student.setSname(rsResultSet.getString("Sname"));
			student.setUphone(rsResultSet.getString("Uphone"));
			list.add(student);
		}
		
		return list;
	}

	public List<Student> getStudent2(String uid) throws ClassNotFoundException, SQLException {
		getConnect(); 
		String sqlString="SELECT student.`UID`,Sname,Uphone FROM user JOIN student ON user.`UID`=student.`UID` where student.`UID`= ?";
		ps=connection.prepareStatement(sqlString);		
		ps.setString(1, uid);
		rsResultSet=ps.executeQuery();
		List<Student> list=new ArrayList<Student>();
		while(rsResultSet.next()) {
			Student student=new Student();
			student.setUID(rsResultSet.getString("UID"));
			student.setSname(rsResultSet.getString("Sname"));
			student.setUphone(rsResultSet.getString("Uphone"));
			list.add(student);
		}
		
		return list;
	}

	public List<Student> getStudent3(String username, String uid) throws ClassNotFoundException, SQLException {
		getConnect(); 
		String sqlString="SELECT student.`UID`,Sname,Uphone FROM user JOIN student ON user.`UID`=student.`UID` WHERE Sname=? AND student.`UID`=?";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, username);
		ps.setString(2, uid);
		rsResultSet=ps.executeQuery();
		List<Student> list=new ArrayList<Student>();
		while(rsResultSet.next()) {
			Student student=new Student();
			student.setUID(rsResultSet.getString("UID"));
			student.setSname(rsResultSet.getString("Sname"));
			student.setUphone(rsResultSet.getString("Uphone"));
			list.add(student);
		}
		
		return list;
	}

	public Student showStudent(String id) throws ClassNotFoundException, SQLException {
		getConnect(); 
		String sqlString="SELECT student.`UID`,Sname,Ssex,Sage,Svip,Saccount,Sstart,Sstop,Uphone FROM user JOIN student ON user.`UID`=student.`UID` WHERE  student.`UID`= ?  ";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, id);
		rsResultSet=ps.executeQuery();
		Student student = new Student();
		while(rsResultSet.next()) {
			student.setUID(rsResultSet.getString("UID"));
			student.setSname(rsResultSet.getString("Sname"));
			student.setUphone(rsResultSet.getString("Uphone"));
			student.setSage(rsResultSet.getString("Sage"));
			student.setSsex(rsResultSet.getString("Ssex"));
			student.setSstart(rsResultSet.getString("Sstart"));
			student.setSstop(rsResultSet.getString("Sstop"));
			student.setSvip(rsResultSet.getString("Svip"));
			student.setSaccount(rsResultSet.getString("Saccount"));
			
		}
		return student;
	}
	
}