package com.etc.HongRui.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.etc.HongRui.entiry.User;

public class RegisterDao extends BaseDao{
	//学生用户注册
	public boolean register(User u) throws ClassNotFoundException, SQLException {
		int rs,rs2;
		ResultSet rs1;
		PreparedStatement ps1,ps2;
		getConnect();//连接数据库	
		String sql="SELECT MAX(UID) AS maxid FROM user";//查询数据库user表当前最大ID
		ps1=connection.prepareStatement(sql);//预编译
		rs1=ps1.executeQuery();//执行
		rs1.next();
		int mid=rs1.getInt("maxid");//转换成int型
		mid++;//自增
		String s="00"+String.valueOf(mid);//转换成字符串型
		String i=s.substring(s.length()-3);//从后截取3位
		String sqlstring="INSERT INTO user(UID,Username,Upwd,Uphone,Umail,Uclass)VALUES(?,?,?,?,?,?)";
		String sqlstring1="INSERT INTO student(UID)values(?)";
		ps=connection.prepareStatement(sqlstring);//预编译
		//处理占位符
		ps.setString(1, i);//自增后的UID
		ps.setString(2, u.getUsername());
		ps.setString(3, u.getUpwd());
		ps.setString(4, u.getUphone());
		ps.setString(5, u.getUmail());
		ps.setString(6, "0");//Uclass为学生
		ps2=connection.prepareStatement(sqlstring1);//预编译
		ps2.setString(1, i);//自增后的UID
		rs = ps.executeUpdate();//执行
		rs2 = ps2.executeUpdate();//执行
		boolean flag = false ;
		if(rs != 0 & rs2 != 0){
			flag = true ;
		}
		return flag ;		
	}
	
	//教师用户注册
	public boolean tregister(User u) throws ClassNotFoundException, SQLException{
		int rs,rs2;
		ResultSet rs1;
		PreparedStatement ps1,ps2;
		getConnect();//连接数据库	
		String sql="SELECT MAX(UID) AS maxid FROM user";//查询数据库user表当前最大ID
		ps1=connection.prepareStatement(sql);//预编译
		rs1=ps1.executeQuery();//执行
		rs1.next();
		int mid=rs1.getInt("maxid");//转换成int型
		mid++;//自增
		String s="00"+String.valueOf(mid);//转换成字符串型
		String i=s.substring(s.length()-3);//从后截取3位
		String sqlstring="INSERT INTO user(UID,Username,Upwd,Uphone,Umail,Uclass)VALUES(?,?,?,?,?,?)";
		String sqlstring1="INSERT INTO teacher(UID)values(?)";
		ps=connection.prepareStatement(sqlstring);//预编译
		//处理占位符
		ps.setString(1, i);//自增后的UID
		ps.setString(2, u.getUsername());
		ps.setString(3, u.getUpwd());
		ps.setString(4, u.getUphone());
		ps.setString(5, u.getUmail());
		ps.setString(6, "1");//Uclass为教师
		ps2=connection.prepareStatement(sqlstring1);//预编译
		ps2.setString(1, i);//自增后的UID
		rs = ps.executeUpdate();//执行
		rs2= ps2.executeUpdate();//执行
		boolean flag = false ;
		if(rs != 0 & rs2 != 0){
			flag = true ;
		}
		return flag ;		
	}
}
