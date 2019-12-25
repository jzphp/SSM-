package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.List;

import com.etc.HongRui.dao.NewCommentdao;
import com.etc.HongRui.entiry.Invatition;
import com.etc.HongRui.util.GetID;
import com.etc.HongRui.util.Log;
import com.etc.HongRui.util.getDate;

/*************************
*@className   PublishComment.java
*@Date        2019年1月10日
*@author      jiazhi
*@version     V1.0
*@description
*************************/

public class PublishComment {
	
/**
 * 
 * @param newComment
 * @return 发表的结果
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public boolean Publish(Invatition newComment) throws SQLException{
		// TODO Auto-generated method stub
		NewCommentdao dao = new NewCommentdao();
		boolean flag = false;
		try {
			flag = dao.write(newComment);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		return flag;
	}
/**
 * 
 * @param themeString
 * @param contextString
 * @param useridString
 * @return 生成的新帖的实体
 */
	public Invatition getThemeInfo(String themeString, String contextString, String useridString) {
		// TODO Auto-generated method stub
		Invatition newComment = new Invatition();
		
		String pidString = GetID.getID();
		String createDateString = getDate.GetDate();
		
		newComment.setUID(useridString);
		newComment.setPID(pidString);
		newComment.setPtheme(themeString);
		newComment.setPcontext(contextString);
		newComment.setPtime(createDateString);
		return newComment;
	}
	
	/**
	 * 
	 * @param UID
	 * @return 获取主题的结果的集合
	 * @throws SQLException
	 */
	
	public List<Invatition> getInvatitions(String UID,int page , int row) throws SQLException {
		List<Invatition> list = null;
		NewCommentdao dao = new NewCommentdao();
		try {
			list = dao.showInvatitions(UID,page , row);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.closeResource();
		}
		return list ;
	}

}
