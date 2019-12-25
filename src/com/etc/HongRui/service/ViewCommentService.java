/*************************
*@className    ViewCommentService.java
*@Date         2019年1月17日
*@author       jiazhi
*@version      V1.0
*@package_name com.etc.HongRui.service
************************/
package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.List;

import com.etc.HongRui.dao.BbsDao;
import com.etc.HongRui.dao.LoginDao;
import com.etc.HongRui.dao.ViewCommentDao;
import com.etc.HongRui.entiry.Invatition;
import com.etc.HongRui.entiry.Student;
import com.etc.HongRui.entiry.Teacher;
import com.etc.HongRui.entiry.ViewComment;

public class ViewCommentService {
	/**
	 * 
	 * @param PID
	 * @return 评论的集合
	 * @throws SQLException
	 */
	public List<ViewComment> getComments(String PID,int page , int row) throws SQLException {
		ViewCommentDao dao = new ViewCommentDao();
		List<ViewComment> list= null;
		try {
			list = dao.getComment(PID,page , row);
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
	 * @param PID
	 * @return 主题的信息
	 * @throws SQLException
	 */
	public Invatition getInvatition(String PID) throws SQLException {
		Invatition invatition = null;
		BbsDao dao = new BbsDao();
		try {
			invatition = dao.getInvatition(PID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.closeResource();
		}
		return invatition;
	}
	/**
	 * @return 设置viewComment中的username值
	 * @param 评论集合
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<ViewComment> setUsername(List<ViewComment> list) throws SQLException{
		String UID = null;
		LoginDao dao = new LoginDao();
		try {
			dao.getConnect();
			BbsService service = new BbsService();
			for (ViewComment viewComment : list) {
				UID = viewComment.getUID();
				String uclass = dao.getUserClass(UID);
				if (uclass.equals("0")) {
					Student student = service.getStudent(UID);
					viewComment.setUsername(student.getSname());
				}
				if (uclass.equals("1")) {
					Teacher teacher = service.getTeacher(UID);
					viewComment.setUsername(teacher.getTname());
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.closeResource();
		}
		
		return list;
	}
	
	/***
	 * 
	 * @param viewComment
	 * @return 发表评论的结果
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean writeComment(ViewComment viewComment) throws ClassNotFoundException, SQLException {
		ViewCommentDao dao = new ViewCommentDao();
		boolean flag = false;
		dao.getConnect();
		try {
			dao.writeComment(viewComment);
			flag = true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.closeResource();
		}
		return flag;
	}
}
