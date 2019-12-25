package com.etc.HongRui.service;

import java.sql.SQLException;

import com.etc.HongRui.dao.LoginDao;
import com.etc.HongRui.entiry.User;
import com.etc.HongRui.entiry.administration;
import com.etc.HongRui.util.Log;


public class LoginService {
/**
 * 
 * @param username
 * @param pwd
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public User login(String username,String pwd) throws ClassNotFoundException, SQLException {

		 LoginDao dao = new LoginDao() ;
		 User user = null;
		 try {
			 user = dao.login(username,pwd) ;
			
			} catch (Exception e) {
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}finally {
				dao.closeResource();
			}
		 
		 return user;	
	}

	public  void check() throws ClassNotFoundException, SQLException {
		LoginDao dao=new LoginDao();

		dao.openTran();
		try {
			dao.commitTran();
		} catch (Exception e) {
			Log.logger.debug(e.getMessage());
			dao.rollTran();
		}finally {
			dao.closeResource();
		}
	}
	public boolean loginAD(administration a) throws ClassNotFoundException, SQLException {
		 LoginDao dao = new LoginDao() ;
		 boolean flag= dao.loginAD(a) ;
		 try {
			
			} catch (Exception e) {
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}finally {
				dao.closeResource();
			}
		 
		 return flag;	
	}
	public User forgetpwd(String username,String uphone,String umail) throws ClassNotFoundException, SQLException {
		LoginDao dao = new LoginDao();
		User user = null;
		 try {
			 user = dao.forgetpwd(username,uphone,umail);
				
			} catch (Exception e) {
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}finally {
				dao.closeResource();
			}
		 return user;	
	}

	public boolean setpwd(User user) throws ClassNotFoundException, SQLException {
		LoginDao dao = new LoginDao();
		boolean flag = dao.setpwd(user);
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
