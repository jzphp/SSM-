package com.etc.HongRui.dao;

import java.sql.SQLException;


import com.etc.HongRui.entiry.administration;
import com.etc.HongRui.entiry.Student;
import com.etc.HongRui.entiry.Teacher;
import com.etc.HongRui.entiry.User;

/**
 * 
 * @author judge
 *
 */
public class LoginDao extends BaseDao{
	/**
	 * 
	 * @param username
	 * @param pwd
	 * @return 用户的实体信息
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public User login(String username,String pwd) throws ClassNotFoundException, SQLException {
		getConnect();
		String sqlstring="SELECT * FROM  user WHERE Username = ? AND Upwd = ?";
		ps=connection.prepareStatement(sqlstring);
		ps.setString(1, username);
		ps.setString(2, pwd);
		rsResultSet = ps.executeQuery() ;
		User user = null;//千万不要new实例化
		if(rsResultSet.next()){
			user = new User();
			user.setUID(rsResultSet.getString("UID"));
			user.setUsername(rsResultSet.getString("Username"));
			user.setUmail(rsResultSet.getString("Umail"));
			user.setUphone(rsResultSet.getString("Uphone"));
			user.setUcreateTime(rsResultSet.getDate("UcreateTime"));
			user.setUclass(rsResultSet.getString("Uclass"));
			user.setUactivite(rsResultSet.getInt("Uactivite"));
			user.setUbanned(rsResultSet.getInt("ubanned"));
			user.setUbanTime(rsResultSet.getDate("UbanTime"));
			user.setUbanCouse(rsResultSet.getString("UbanCouse"));
			user.setUpwd(rsResultSet.getString("Upwd"));
		}
		return user;
	}
	
	/**
	 * 
	 * @param a
	 * @return 后台管理员登录的验证结果
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean loginAD(administration a) throws ClassNotFoundException, SQLException {
		getConnect();
		String sqlstring="SELECT * FROM administration WHERE adname=? AND PASSWORD =?";
		ps=connection.prepareStatement(sqlstring);
		ps.setString(1, a.getAdname());
		ps.setString(2, a.getPassword());
		rsResultSet = ps.executeQuery() ;
		boolean flag = false ;
		if(rsResultSet.next()){
			flag = true ;
		}
		return flag ;
	}
	/**
	 * 
	 * @param UID
	 * @return 学生的具体的信息
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @author jiazhi
	 */
	public Student getStudentDetail(String UID) throws ClassNotFoundException, SQLException {
		Student student = null;
		getConnect();
		
		String sqlstring = "SELECT * FROM student WHERE UID= ? ";
		ps=connection.prepareStatement(sqlstring);
		ps.setString(1, UID.toString());
		rsResultSet = ps.executeQuery() ;
		while (rsResultSet.next()) {
			student = new Student();
			student.setSname(rsResultSet.getString("Sname"));
			student.setSage(rsResultSet.getString("Sage"));
			student.setSsex(rsResultSet.getString("Ssex"));
			student.setSvip(rsResultSet.getString("Svip"));
			student.setSstart(rsResultSet.getString("Sstart"));
			student.setSstop(rsResultSet.getString("Sstop"));
		}
		return student;
	}
	/**
	 * @author jiazhi
	 * @param UID
	 * @return 教师的具体信息
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Teacher getTeacherDetail(String UID) throws ClassNotFoundException, SQLException {
		Teacher teacher = null;
		getConnect();
		String sqlstring = "SELECT * FROM teacher WHERE UID= ? ";
		ps=connection.prepareStatement(sqlstring);
		ps.setString(1, UID.toString());
		rsResultSet = ps.executeQuery() ;
		while (rsResultSet.next()) {
			teacher = new Teacher();
			teacher.setTname(rsResultSet.getString("Tname"));
			teacher.setTsex(rsResultSet.getString("Tsex"));
			teacher.setTage(rsResultSet.getString("Tage"));
			teacher.setTbackground(rsResultSet.getString("Tbackground"));
			teacher.setTcourse(rsResultSet.getString("Tcourse"));
			teacher.setTmonery(rsResultSet.getString("Tmonery"));
		}
		return teacher;
	}
	/**
	 * @author jiazhi
	 * @param UID
	 * @return 获取用户类型
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String getUserClass(String UID) throws ClassNotFoundException, SQLException {
		String UClass = null;
		getConnect();
		String sqlString = "select UClass from user where UID = ? ";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, UID);
		rsResultSet = ps.executeQuery();
		while (rsResultSet.next()) {
			UClass =rsResultSet.getString("UClass");
		}
		return UClass;
	}
	public User forgetpwd(String username,String uphone,String umail) throws ClassNotFoundException, SQLException {
		getConnect();//连接数据库	
		String sqlstring="SELECT * FROM user WHERE Username=? AND Uphone=? AND Umail=? ";
		ps=connection.prepareStatement(sqlstring);//预编译
		//处理占位符
		ps.setString(1, username);
		ps.setString(2, uphone);
		ps.setString(3, umail);
		rsResultSet = ps.executeQuery();
		User user = null;
		if(rsResultSet.next()){
			user = new User();
			user.setUsername(rsResultSet.getString("username"));
			user.setUphone(rsResultSet.getString("Uphone"));
			user.setUmail(rsResultSet.getString("Umail"));		
		}
		return user ;		
	}

	public boolean setpwd(User u) throws ClassNotFoundException, SQLException {
		getConnect();//连接数据库	
		String sqlstring="update user set Upwd=? where Username=?";
		ps=connection.prepareStatement(sqlstring);//预编译
		//处理占位符
		ps.setString(1, u.getUpwd());
		ps.setString(2, u.getUsername());
		int rs = ps.executeUpdate();
		boolean flag = false ;
		if(rs!=0){
			return true;
		}
		return flag ;	
	}
}
