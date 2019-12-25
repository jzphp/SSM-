/*************************
*@className    BbsDao.java
*@Date         2019年1月12日
*@author       jiazhi
*@version      V1.0
*@package_name com.etc.HongRui.dao
************************/
package com.etc.HongRui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.entiry.Invatition;
import com.etc.HongRui.entiry.OrderDetail;
import com.etc.HongRui.entiry.Peo;
import com.etc.HongRui.entiry.PeoTeacher;
import com.etc.HongRui.entiry.Student;
import com.etc.HongRui.entiry.Teacher;
import com.etc.HongRui.entiry.User;


public class BbsDao extends BaseDao{
	/**
	 * 
	 * @param page
	 * @param row
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Invatition> getInvatition(int page , int row) throws SQLException, ClassNotFoundException {
		getConnect();
		int n1 =   (page - 1) * row;
		String sql = "select * from invatition ORDER BY Ptime DESC limit ? , ?";		
		ps = connection.prepareStatement(sql);
		ps.setInt(1, n1);
		ps.setInt(2, row);
		rsResultSet = ps.executeQuery();
		List<Invatition> list = new ArrayList<Invatition>();
		while (rsResultSet.next()) {
			Invatition invatition = new Invatition();
			invatition.setPID(rsResultSet.getString("PID"));
			invatition.setUID(rsResultSet.getString("UID"));
			invatition.setPtheme(rsResultSet.getString("Ptheme"));
			invatition.setPcontext(rsResultSet.getString("Pcontext"));
			invatition.setPtime(rsResultSet.getString("Ptime"));
			invatition.setUsername("null");
			list.add(invatition);
		}
		
		return list;
	}

	/**
	 * @param i
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int getPage(int i) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		getConnect();
		String sql = "select count(*) from invatition " ;
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
	/**
	 * 
	 * @param PID
	 * @return 返回主题的内容
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Invatition getInvatition(String PID) throws ClassNotFoundException, SQLException {
		getConnect();
		String sqlString = "select * from invatition where PID = ?";
		ps= connection.prepareStatement(sqlString);
		ps.setString(1, PID);
		rsResultSet = ps.executeQuery();
		Invatition invatition = new Invatition();
		while (rsResultSet.next()) {
			invatition.setPID(rsResultSet.getString("PID"));
			invatition.setUID(rsResultSet.getString("UID"));
			invatition.setUsername("null");
			invatition.setPcontext(rsResultSet.getString("Pcontext"));
			invatition.setPtheme(rsResultSet.getString("Ptheme"));
			invatition.setPtime(rsResultSet.getString("Ptime"));
		}
		return invatition;
	}
	/**
	 * 
	 * @param string 搜索内容
	 * @return 搜索结果的集合
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Invatition> Search(String string,int page , int row) throws SQLException, ClassNotFoundException {
		getConnect();
		int n1 =   (page - 1) * row;
		String sqlString = "select * from invatition where Ptheme like '%"+string+"%'limit ? , ?";
		ps= connection.prepareStatement(sqlString);
		ps.setInt(1, n1);
		ps.setInt(2, row);
		rsResultSet = ps.executeQuery();
		List<Invatition> list = new ArrayList<Invatition>();
		while (rsResultSet.next()) {
			Invatition invatition = new Invatition();
			invatition.setUID(rsResultSet.getString("UID"));
			invatition.setPID(rsResultSet.getString("PID"));
			invatition.setPtheme(rsResultSet.getString("Ptheme"));
			invatition.setPtime(rsResultSet.getString("Ptime"));
			invatition.setPcontext(rsResultSet.getString("Pcontext"));
			invatition.setUsername(null);
			list.add(invatition);
		}
		return list;
		
	}
	/**
	 * 
	 * @param UID
	 * @return 订单历史记录
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public List<OrderDetail> getOrders(String UID,int page , int row) throws SQLException, ClassNotFoundException {
		getConnect();
		int n1 =   (page - 1) * row;
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		String sqlString = "select * from orderdetail where UID = ? limit ? , ?";
		ps= connection.prepareStatement(sqlString);
		ps.setString(1, UID);
		ps.setInt(2, n1);
		ps.setInt(3, row);
		rsResultSet = ps.executeQuery();
		while (rsResultSet.next()) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOid(rsResultSet.getString("OID"));
			orderDetail.setUid(rsResultSet.getString("UID"));
			orderDetail.setCid(rsResultSet.getString("CID"));
			orderDetail.setOtime(rsResultSet.getString("Otime"));
			orderDetail.setOcomment(rsResultSet.getString("OComment"));
			orderDetail.setOmoney(rsResultSet.getFloat("Omoney"));
			orderDetail.setOstatus(rsResultSet.getInt("Otatus"));
			list.add(orderDetail);
		}
		return list;
	}

	/**
	 * @param cID
	 * @return 返回课程名字
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public String getCname(String cID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		getConnect();
		String cnameString=null;
		String sqlString = "select Cname from Course where CID = ?";
		ps  = connection.prepareStatement(sqlString);
		ps.setString(1, cID);
		rsResultSet = ps.executeQuery();
		while (rsResultSet.next()) {
			cnameString= rsResultSet.getString("Cname");
		}
		return cnameString;
	}
	
	/**
	 * 
	 * @param PID
	 * @param UID
	 * @return 删除帖子的结果
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean delMyWrite(String PID,String UID) throws SQLException, ClassNotFoundException {
		getConnect();
		String string = "delete  from  bbscomment where PID='"+PID+"'";
		String sqlString = "delete from invatition where PID = '"+PID+"' and UID = '"+UID+"'";
		ps=connection.prepareStatement(string);
		ps.executeUpdate();
		ps = connection.prepareStatement(sqlString);
		int a = ps.executeUpdate();
		boolean flag=false;
		if (a>0) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 
	 * @param OID
	 * @param UID
	 * @return 删除订单的结果
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean delMyOrder(String OID,String UID) throws ClassNotFoundException, SQLException {
		getConnect();
		String sqlString = "delete from orderdetail where OID = ? and UID = ?";
		ps = connection.prepareStatement(sqlString);
		ps.setString(1, OID);
		ps.setString(2, UID);
		int a = ps.executeUpdate();
		boolean flag=false;
		if (a>0) {
			flag = true;
		}
		return flag;
	}

/**
 * 
 * @param context
 * @param oID
 * @param uID
 * @return 返回评论的结果
 * @throws SQLException
 * @throws ClassNotFoundException
 */
	public boolean orderCommen(String context, String oID, String uID) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		getConnect();
		String sqlString = "UPDATE orderdetail SET OComment ='"+context+"'WHERE  UID='"+uID+"' AND OID="+Integer.parseInt(oID);
		String sqlString1 = "UPDATE orderdetail SET OTatus=1 WHERE UID='"+uID+"' AND OID="+Integer.parseInt(oID);
		ps = connection.prepareStatement(sqlString);
		int a = ps.executeUpdate();
		ps = connection.prepareStatement(sqlString1);
	    a = ps.executeUpdate();
		boolean flag = false;
		if (a>0) {
			flag = true;
		}
		return flag;
	}
	public boolean updateStudent(User user, Student student) throws ClassNotFoundException, SQLException {
		getConnect();//连接数据库	
		String sqlstring="update user set Uphone=? , Umail=? where UID=?";
		ps=connection.prepareStatement(sqlstring);//预编译
		//处理占位符
		ps.setString(1, user.getUphone());
		ps.setString(2, user.getUmail());
		ps.setString(3, user.getUID());
		int rs = ps.executeUpdate();
		String sqlstring1="update student set Sname=? , Ssex=? , Sage=? where UID=?";
		ps=connection.prepareStatement(sqlstring1);//预编译
		ps.setString(1, student.getSname());
		ps.setString(2, student.getSsex());
		ps.setString(3, student.getSage());
		ps.setString(4, user.getUID());
		int rs1 = ps.executeUpdate();
		boolean flag = false ;
		if(rs!=0 & rs1!=0){
			return true;
		}
		return flag ;	
	}
	
	public boolean updateTeacher(User tuser, Teacher teacher) throws ClassNotFoundException, SQLException {
		getConnect();//连接数据库	
		String sqlstring="update user set Uphone=? , Umail=? where UID=?";
		ps=connection.prepareStatement(sqlstring);//预编译
		//处理占位符
		ps.setString(1, tuser.getUphone());
		ps.setString(2, tuser.getUmail());
		ps.setString(3, tuser.getUID());
		int rs = ps.executeUpdate();
		String sqlstring1="update teacher set Tname=? , Tsex=? , Tage=? where UID=?";
		ps=connection.prepareStatement(sqlstring1);//预编译
		ps.setString(1, teacher.getTname());
		ps.setString(2, teacher.getTsex());
		ps.setString(3, teacher.getTage());
		ps.setString(4, tuser.getUID());
		int rs1 = ps.executeUpdate();
		boolean flag = false ;
		if(rs!=0 & rs1!=0){
			return true;
		}
		return flag ;	
	}



	public Peo getPeo(String uid) throws ClassNotFoundException, SQLException {
		getConnect();//连接数据库	
		String sqlstring="SELECT user.UID,Username,Sname,Ssex,Sage,Uphone,Umail FROM user JOIN student ON user.UID=student.UID WHERE user.UID=?";
		ps=connection.prepareStatement(sqlstring);//预编译
		//处理占位符
		ps.setString(1, uid);
		rsResultSet = ps.executeQuery();
		Peo peo = null;
		if(rsResultSet.next()){
			peo = new Peo();
			peo.setUid(rsResultSet.getString("uid"));
			peo.setUsername(rsResultSet.getString("username"));
			peo.setUphone(rsResultSet.getString("uphone"));
			peo.setUmail(rsResultSet.getString("umail"));
			peo.setSname(rsResultSet.getString("sname"));
			peo.setSsex(rsResultSet.getString("ssex"));
			peo.setSage(rsResultSet.getString("sage"));
		}
		return peo ;		
	}

	public PeoTeacher getPeoTeacher(String uid) throws ClassNotFoundException, SQLException {
		getConnect();//连接数据库	
		String sqlstring="SELECT user.UID,Username,Tname,Tage,Tsex,Uphone,Umail FROM user JOIN teacher ON user.UID=teacher.UID WHERE user.UID=?";
		ps=connection.prepareStatement(sqlstring);//预编译
		//处理占位符
		ps.setString(1, uid);
		rsResultSet = ps.executeQuery();
		PeoTeacher peoteacher = null;
		if(rsResultSet.next()){
			peoteacher = new PeoTeacher();
			peoteacher.setUid(rsResultSet.getString("uid"));
			peoteacher.setUsername(rsResultSet.getString("username"));
			peoteacher.setUphone(rsResultSet.getString("uphone"));
			peoteacher.setUmail(rsResultSet.getString("umail"));
			peoteacher.setTname(rsResultSet.getString("Tname"));
			peoteacher.setTsex(rsResultSet.getString("Tsex"));
			peoteacher.setTage(rsResultSet.getString("Tage"));
		}
		return peoteacher ;		
	}

	public boolean Bbspwd(User u) throws ClassNotFoundException, SQLException {
		getConnect();//连接数据库	
		String sqlstring="update user set Upwd=? where UID=?";
		ps=connection.prepareStatement(sqlstring);//预编译
		//处理占位符
		ps.setString(1, u.getUpwd());
		ps.setString(2, u.getUID());
		int rs = ps.executeUpdate();
		boolean flag = false ;
		if(rs!=0){
			return true;
		}
		return flag ;	
	}
	
}
