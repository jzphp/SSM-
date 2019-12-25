/*************************
*@className    BbsService.java
*@Date         2019年1月12日
*@author       jiazhi
*@version      V1.0
*@package_name com.etc.HongRui.service
************************/
package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.List;
import com.etc.HongRui.util.Log;
import com.etc.HongRui.dao.BbsDao;
import com.etc.HongRui.dao.LoginDao;
import com.etc.HongRui.entiry.Invatition;
import com.etc.HongRui.entiry.OrderDetail;
import com.etc.HongRui.entiry.Student;
import com.etc.HongRui.entiry.Teacher;
import com.etc.HongRui.entiry.User;
import com.etc.HongRui.entiry.Peo;
import com.etc.HongRui.entiry.PeoTeacher;

public class BbsService {
	/**
	 * 
	 * @param page
	 * @param row
	 * @return 数据库查询的结果的集合
	 * @throws SQLException
	 */
	
	public List<Invatition> getInvatition(int page , int row) throws SQLException {
		BbsDao bbsDao = new BbsDao() ;
		List<Invatition> list = null ;
		try{
			 bbsDao.getConnect();
			 list = bbsDao.getInvatition(page , row) ;
		}catch(Exception e){
			 Log.logger.debug(e.getMessage());
			 e.printStackTrace();
		}finally{
			 bbsDao.closeResource();
		}
		return list;
	}

	/**
	 * @param i
	 * @return 分的页数
	 * @throws SQLException 
	 */
	public int getPage(int i) throws SQLException {
		BbsDao dao = new BbsDao() ;
		int count = 0 ;
		 try{
			count = dao.getPage(i) ;
		 }catch(Exception e){
			 e.printStackTrace();
			 Log.logger.debug(e.getMessage());
		 }finally{
			dao.closeResource();
		 }
		return count;
	}
	/**
	 * 
	 * @param UID
	 * @return 返回学生信息
	 * @throws SQLException
	 */
	public Student getStudent(String UID) throws SQLException {
		Student student = null;
		LoginDao dao = new LoginDao();
		try {
			student = dao.getStudentDetail(UID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		return student;
	}
	/**
	 * 
	 * @param UID
	 * @return 返回教师信息
	 * @throws SQLException
	 */
	public Teacher getTeacher(String UID) throws SQLException {
		Teacher teacher = null;
		LoginDao dao = new LoginDao();
		try {
			teacher = dao.getTeacherDetail(UID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		return teacher;
	}
	/**
	 * 
	 * @param list
	 * @return 把列表中的UID转成姓名
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Invatition> cUtUname(List<Invatition> list) throws SQLException, ClassNotFoundException {
		LoginDao dao = new LoginDao();
		for (Invatition In : list) {
			String UID  = In.getUID();
			String uclass = dao.getUserClass(UID);
			if (uclass.equals("0")) {
				Student student = getStudent(UID);
				In.setUsername(student.getSname());
			}
			if (uclass.equals("1")) {
				Teacher teacher = getTeacher(UID);
				In.setUsername(teacher.getTname());
			}
		}
		return list;
	}
	
	/**
	 * 
	 * @param UID
	 * @return 获取用户类别
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String getUClass(String UID) throws ClassNotFoundException, SQLException {
		String uclass=null;
		LoginDao dao = new LoginDao();
		uclass = dao.getUserClass(UID);
		return uclass;
	}
	
	/**
	 * 
	 * @param Str
	 * @return 搜索的结果
	 * @throws SQLException
	 */
	public List<Invatition> search(String Str,int page , int row) throws SQLException {
		BbsDao dao = new BbsDao();
		List<Invatition> list = null;
		try {
			list = dao.Search(Str,page , row);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		return list;
		
	}
	/**
	 * 
	 * @param UID 
	 * @return 返回订单历史记录
	 * @throws SQLException
	 */
	public List<OrderDetail> getOrders(String UID,int page , int row) throws SQLException {
		BbsDao dao = new BbsDao();
		List<OrderDetail> list = null;
		try {
			list = dao.getOrders(UID,page , row);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.closeResource();
		}
		return list;
	}
	/**
	 * 
	 * @param list
	 * @return 设置课程名
	 * @throws SQLException
	 */
	public List<OrderDetail> cidToCourseName(List<OrderDetail> list) throws SQLException {
		BbsDao dao = new BbsDao();
		String cnameString = null;
		String CID = null;
		for (OrderDetail orderDetail : list) {
			CID = orderDetail.getCid();
			try {
				cnameString = dao.getCname(CID);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dao.closeResource();
			}
			orderDetail.setCoursename(cnameString);
		}
		
		return list;
	}
	
	/**
	 * 
	 * @param PID
	 * @param UID
	 * @return 删除帖子的结果
	 * @throws SQLException
	 */
	public boolean deleMyWrite(String PID,String UID) throws SQLException {
		BbsDao dao  = new BbsDao();
		boolean flag= false;
		try {
			flag = dao.delMyWrite(PID, UID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.closeResource();
		}
		return flag;
	}
	
	/***
	 * 
	 * @param OID
	 * @param UID
	 * @return 删除订单的结果
	 * @throws SQLException
	 */
	public boolean deleMyOrder(String OID,String UID) throws SQLException {
		BbsDao dao = new BbsDao();
		boolean flag= false;
		try {
			flag=dao.delMyOrder(OID, UID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.closeResource();
		}
		return flag;
	}
	
	/**
	 * 
	 * @param context
	 * @param OID
	 * @param UID
	 * @return 订单评价结果
	 * @throws SQLException
	 */
	public boolean orderCommen(String context,String OID,String UID) throws SQLException {
		BbsDao dao = new BbsDao();
		boolean flag = false;
		try {
			flag = dao.orderCommen(context,OID,UID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.closeResource();
		}
		return flag;
	}
	
	public boolean updateStudent(User user, Student student) throws ClassNotFoundException, SQLException {
		BbsDao dao = new BbsDao();
		boolean flag = false;
		try {
			flag= dao.updateStudent(user,student);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		return flag;	
	}
	
	public boolean updateTeacher(User tuser, Teacher teacher) throws ClassNotFoundException,SQLException {
		BbsDao dao = new BbsDao();
		boolean flag = false;
		try {
			flag= dao.updateTeacher(tuser,teacher);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		return flag;	
	}

	public Peo getPeo(String uid) throws SQLException {
		BbsDao dao = new BbsDao() ;
		Peo peo = null;
		try {
			peo=dao.getPeo(uid);
		}catch(Exception e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		return peo;
	}

	public PeoTeacher getPeoTeacher(String uid) throws SQLException {
		BbsDao dao = new BbsDao() ;
		PeoTeacher peoteacher = null;
		try {
			peoteacher=dao.getPeoTeacher(uid);
		}catch(Exception e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		return peoteacher;
	}

	public boolean Bbspwd(User u) throws ClassNotFoundException, SQLException {
		BbsDao dao = new BbsDao();
		boolean flag = dao.Bbspwd(u);
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		return flag;	
	}
	
}
