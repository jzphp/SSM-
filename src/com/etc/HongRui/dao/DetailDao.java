package com.etc.HongRui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.entiry.Course;

/**
 * @author LS
 *
 * SearchDao.java 
 * 根据主页面传递的ctype类别查询数据库list显示课程信息
 * 将免费和收费的视频区分开来 显示，使用了两个数据库查询语句，用了两个函数
 */
public class DetailDao extends BaseDao{
	//获取课程详情
	/**
	 * @param ctype
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Course> getcourse(String ctype) throws SQLException, ClassNotFoundException {
		getConnect();
		String sqlString="select CID,Cname,Cintroduce,Cprice from Course where Ctype= ? and Cbase='1'";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, ctype);
		rsResultSet=ps.executeQuery();
		List<Course> list =new ArrayList<Course>();
		while(rsResultSet.next()) {
			Course course=new Course();
			course.setCid(rsResultSet.getString("cid"));
			course.setCname(rsResultSet.getString("cname"));
			course.setCprice(rsResultSet.getFloat("cprice"));
			course.setCintroduce(rsResultSet.getString("cintroduce"));
			list.add(course);
		}
		return list;
	}

	/**
	 * @param ctype
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Course> getcourse1(String ctype) throws SQLException, ClassNotFoundException {
		getConnect();
		String sqlString="select CID,Cname,Cintroduce,Cprice from Course where Ctype= ? and Cbase='0'";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, ctype);
		rsResultSet=ps.executeQuery();
		List<Course> list =new ArrayList<Course>();
		while(rsResultSet.next()) {
			Course course=new Course();
			course.setCid(rsResultSet.getString("cid"));
			course.setCname(rsResultSet.getString("cname"));
			course.setCprice(rsResultSet.getFloat("cprice"));
			course.setCintroduce(rsResultSet.getString("cintroduce"));
			list.add(course);
	}
		return list;
	}

//列表显示所有该课程
	/*public List<Course> getcourse(int page, int row,String ctype) throws SQLException {
		 	int n =   (page - 1) * row;
			String sql = "select Cname,Cprice,Cintroduce from Course  where Ctype= ? and Cbase='1' limit ? , ?";		
			ps = connection.prepareStatement(sql);
			ps.setInt(1, n);
			ps.setInt(2, 1);
			ps.setString(3, ctype);
			rsResultSet = ps.executeQuery();
			List<Course> list = new ArrayList<Course>();
			while (rsResultSet.next()) {
				Course course = new Course();
				course.setCname(rsResultSet.getString("Cname"));
				course.setCprice(rsResultSet.getFloat("cprice"));
				course.setCintroduce(rsResultSet.getString("cintroduce"));
				list.add(course);
			}
		return list;
	}
	public int getPage(int i,String ctype) throws ClassNotFoundException, SQLException {
		 getConnect();
		 String sql = "select count(*) from Course where Ctype = ? " ;
		 ps = connection.prepareStatement(sql) ;
		 rsResultSet = ps.executeQuery() ;
		 int no = 0 ;
		 if(rsResultSet.next()){
			no = rsResultSet.getInt(1) ;
		 }
		 int count = 0 ;
		 if( no % i == 0){
			 count = no / i ;
		 }else{
			 count = no / i + 1;
		 }
		return count;
	}
	*/
	
}
