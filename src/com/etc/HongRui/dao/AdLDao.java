package com.etc.HongRui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.entiry.Invatition;

public class AdLDao extends BaseDao{

	public List<Invatition> getInvatition() throws ClassNotFoundException, SQLException {
		getConnect(); 
System.out.println();
		String sqlString="SELECT  *FROM  invatition";
		ps=connection.prepareStatement(sqlString);
		rsResultSet=ps.executeQuery();
		List<Invatition> list=new ArrayList<Invatition>();
		while(rsResultSet.next()) {
			Invatition Invatition=new Invatition();
			Invatition.setPID(rsResultSet.getString("PID"));
			Invatition.setPtheme(rsResultSet.getString("Ptheme"));
			Invatition.setPcontext(rsResultSet.getString("Pcontext"));
			Invatition.setPtime(rsResultSet.getString("Ptime"));
			list.add(Invatition);
		}
		
		return list;
	}

	public List<Invatition> getInvatition1(String ptheme) throws ClassNotFoundException, SQLException {
		getConnect(); 
		String sqlString="SELECT  * FROM  invatition WHERE Ptheme= ? ";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, ptheme);	
		rsResultSet=ps.executeQuery();
		List<Invatition> list=new ArrayList<Invatition>();
		while(rsResultSet.next()) {
			Invatition Invatition=new Invatition();
			Invatition.setPID(rsResultSet.getString("PID"));
			Invatition.setPtheme(rsResultSet.getString("Ptheme"));
			Invatition.setPcontext(rsResultSet.getString("Pcontext"));
			Invatition.setPtime(rsResultSet.getString("Ptime"));
			list.add(Invatition);
		}
		
		return list;
	}

	public List<Invatition> getInvatition2(String pID) throws ClassNotFoundException, SQLException {
		getConnect(); 		
		String sqlString=" SELECT  * FROM  invatition WHERE PID= ? ";
		ps=connection.prepareStatement(sqlString);		
		ps.setString(1, pID);
		rsResultSet=ps.executeQuery();
		List<Invatition> list=new ArrayList<Invatition>();
		while(rsResultSet.next()) {
			Invatition Invatition=new Invatition();
			Invatition.setPID(rsResultSet.getString("PID"));
			Invatition.setPtheme(rsResultSet.getString("Ptheme"));
			Invatition.setPcontext(rsResultSet.getString("Pcontext"));
			Invatition.setPtime(rsResultSet.getString("Ptime"));
			list.add(Invatition);
		}
		
		return list;
	}

	public List<Invatition> getInvatition3(String ptheme, String pID) throws ClassNotFoundException, SQLException {
		getConnect(); 
		System.out.println(ptheme);
		System.out.println(pID);
		String sqlString="SELECT  *FROM  invatition WHERE Ptheme= ? AND PID= ?";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, ptheme);
		ps.setString(2, pID);
		rsResultSet=ps.executeQuery();
		List<Invatition> list=new ArrayList<Invatition>();
		while(rsResultSet.next()) {
			Invatition Invatition=new Invatition();
			Invatition.setPID(rsResultSet.getString("PID"));
			Invatition.setPtheme(rsResultSet.getString("Ptheme"));
			Invatition.setPcontext(rsResultSet.getString("Pcontext"));
			Invatition.setPtime(rsResultSet.getString("Ptime"));
			list.add(Invatition);
		}
		
		return list;
	}

	public int Lundelete(String id) throws SQLException  {
		int count=0;
		try {
			getConnect();
			String sql="DELETE FROM invatition WHERE PID=?" ;
			ps=connection.prepareStatement(sql);
			ps.setString(1, id);
			count=ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return count;
	}

	
}
