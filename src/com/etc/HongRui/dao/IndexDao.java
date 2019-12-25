package com.etc.HongRui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.entiry.Course;
/**
 * @author LS
 *
 * SearchDao.java 
 * 根据大类别显示小类别，list显示
 */
public class  IndexDao extends BaseDao{

	
	/**
	 * 
	 * @return  大列表
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	/*
	 * public List<Course>getList() throws SQLException, ClassNotFoundException{
	 * getConnect(); String sqlString="SELECT DISTINCT CCtype FROM Course";
	 * ps=connection.prepareStatement(sqlString); rsResultSet=ps.executeQuery();
	 * List<Course> list=new ArrayList<Course>(); while (rsResultSet.next()) {
	 * Course customer =new Course();
	 * customer.setCctype(rsResultSet.getString("cctype")); list.add(customer); }
	 * return list;
	 * 
	 * }
	 */

	public List<Course> getList1() throws SQLException, ClassNotFoundException {
		getConnect();
		String sqlString ="SELECT DISTINCT Ctype FROM Course WHERE CCtype='前端开发'";
		ps=connection.prepareStatement(sqlString);
		rsResultSet=ps.executeQuery();
		List<Course> list1=new ArrayList<Course>();
		while  (rsResultSet.next()){
			Course course1=new Course();
			course1.setCtype(rsResultSet.getString("ctype"));
			list1.add(course1);
		}
		return list1;
	}
	
	public List<Course> getList2() throws SQLException, ClassNotFoundException {
		getConnect();
		String sqlString ="SELECT DISTINCT Ctype FROM Course WHERE CCtype='后端开发'";
		ps=connection.prepareStatement(sqlString);
		rsResultSet=ps.executeQuery();
		List<Course> list2=new ArrayList<Course>();
		while  (rsResultSet.next()){
			Course course2=new Course();
			course2.setCtype(rsResultSet.getString("ctype"));
			list2.add(course2);
		}
		return list2;
	}
	public List<Course> getList3() throws SQLException, ClassNotFoundException {
		getConnect();
		String sqlString ="SELECT DISTINCT Ctype FROM Course WHERE CCtype='移动开发'";
		ps=connection.prepareStatement(sqlString);
		rsResultSet=ps.executeQuery();
		List<Course> list3=new ArrayList<Course>();
		while  (rsResultSet.next()){
			Course course3=new Course();
			course3.setCtype(rsResultSet.getString("ctype"));
			list3.add(course3);
		}
		return list3;
	}
	public List<Course> getList4() throws SQLException, ClassNotFoundException {
		getConnect();
		String sqlString ="SELECT DISTINCT Ctype FROM Course WHERE CCtype='人工智能'";
		ps=connection.prepareStatement(sqlString);
		rsResultSet=ps.executeQuery();
		List<Course> list4=new ArrayList<Course>();
		while  (rsResultSet.next()){
			Course course4=new Course();
			course4.setCtype(rsResultSet.getString("ctype"));
			list4.add(course4);
		}
		return list4;
	}
	public List<Course> getList5() throws SQLException, ClassNotFoundException {
		getConnect();
		String sqlString ="SELECT DISTINCT Ctype FROM Course WHERE CCtype='物联网'";
		ps=connection.prepareStatement(sqlString);
		rsResultSet=ps.executeQuery();
		List<Course> list5=new ArrayList<Course>();
		while  (rsResultSet.next()){
			Course course5=new Course();
			course5.setCtype(rsResultSet.getString("ctype"));
			list5.add(course5);
		}
		return list5;
	}
	public List<Course> getList6() throws SQLException, ClassNotFoundException {
		getConnect();
		String sqlString ="SELECT DISTINCT Ctype FROM Course WHERE CCtype='设计产品测试'";
		ps=connection.prepareStatement(sqlString);
		rsResultSet=ps.executeQuery();
		List<Course> list6=new ArrayList<Course>();
		while  (rsResultSet.next()){
			Course course6=new Course();
			course6.setCtype(rsResultSet.getString("ctype"));
			list6.add(course6);
		}
		return list6;
	}
	public List<Course> getList7() throws SQLException, ClassNotFoundException {
		getConnect();
		String sqlString ="SELECT DISTINCT Ctype FROM Course WHERE CCtype='云计算大数据'";
		ps=connection.prepareStatement(sqlString);
		rsResultSet=ps.executeQuery();
		List<Course> list7=new ArrayList<Course>();
		while  (rsResultSet.next()){
			Course course7=new Course();
			course7.setCtype(rsResultSet.getString("ctype"));
			list7.add(course7);
		}
		return list7;
	}

}
