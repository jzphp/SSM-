package com.etc.HongRui.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.etc.HongRui.util.DbInfo;

public class BaseDao {
	
	public Connection connection;
	public PreparedStatement ps;
	public ResultSet rsResultSet ;
	public Statement st;
	DbInfo dbInfo ;

	public void getConnect() throws ClassNotFoundException, SQLException {
		//实例在需要的时候创建，因为DbInfo对象是用来获取信息的，所以在此处获取之前创建即可
		dbInfo = DbInfo.getInstance() ;
		//添加驱动
		Class.forName(dbInfo.getDbdriver()) ;
		//连接数据库
		connection = DriverManager.getConnection(dbInfo.getDbURL(), dbInfo.getUname(), dbInfo.getpwd()) ;
	}
	public void closeResource()
			throws SQLException {
		if(connection!=null)
			connection.close();
		if(ps!=null)
			ps.close();
		if(rsResultSet!=null)
			rsResultSet.close();
		if(st!=null)
			st.close();
		
	}
	
	public void openTran() throws ClassNotFoundException, SQLException {
		if(connection==null) {
			getConnect();
		}
		connection.setAutoCommit(false);
	}
	
	public void commitTran() throws SQLException {
		connection.commit();
	}
	
	public void rollTran() throws SQLException {
		connection.rollback();
	}
	public void closeTran() throws SQLException {
		connection.setAutoCommit(true);
	}

}
