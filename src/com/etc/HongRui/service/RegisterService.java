package com.etc.HongRui.service;

import java.sql.SQLException;

import com.etc.HongRui.dao.RegisterDao;
import com.etc.HongRui.entiry.User;
import com.etc.HongRui.util.Log;

public class RegisterService {
/**
 * 
 * @param user
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public boolean register(User user) throws ClassNotFoundException, SQLException {
		 RegisterDao dao = new RegisterDao();
		 boolean flag= dao.register(user) ;
		 try {
					
			} catch (Exception e) {
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}finally {
				dao.closeResource();
			}
		 return flag;	
	}
	/**
	 * 
	 * @param user
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean tregister(User user) throws ClassNotFoundException, SQLException {
		RegisterDao dao = new RegisterDao();
		boolean flag = dao.tregister(user);
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		} finally {
			dao.closeResource();
		}
		return flag;
	}

}
