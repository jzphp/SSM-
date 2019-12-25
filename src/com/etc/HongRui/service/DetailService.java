package com.etc.HongRui.service;

//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.dao.DetailDao;
import com.etc.HongRui.entiry.Course;
import com.etc.HongRui.util.Log;

public class DetailService {
	
	/*public String getctype(String []re,String ctype) throws SQLException {
		DetailDao dao = new DetailDao() ;
		 try {
			try{
				 dao.getConnect();
				ctype = dao.getctype(re,ctype) ;
			 }catch(Exception e){
				 e.printStackTrace();
				 Logger.getLogger(Log.class).debug(e.getMessage());
			 }finally{
				 dao.closeResource();
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
		return ctype;
	}
	*/
	/*public List<Course> details(int page , int row,String ctype) throws SQLException {
		DetailDao dao = new DetailDao() ;
		List<Course> list = null ;
		 try{
			 dao.getConnect();
			list = dao.getcourse(page, row,ctype) ;
		 }catch(Exception e){
			 e.printStackTrace();
			Log.logger.debug(e.getMessage());
		 }finally{
			 dao.closeResource();
		 }
		return list;
	}
	public int getPage(int i,String ctype) throws SQLException {
		DetailDao dao = new DetailDao() ;
		int count = 0 ;
		 try{
			count = dao.getPage(i,ctype) ;
		 }catch(Exception e){
			 e.printStackTrace();
			 Log.logger.debug(e.getMessage());
		 }finally{
			dao.closeResource();
		 }
		return count;
	}
	*/

	/**
	 * @param ctype
	 * @return
	 */
	public List<Course> getcourse(String ctype) {
		DetailDao dao=new DetailDao();
		List<Course> list=new ArrayList<Course>();
		try {
			list=dao.getcourse(ctype);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
		return list;
	}

	public List<Course> getcourse1(String ctype) {
		DetailDao dao=new DetailDao();
		List<Course> list=new ArrayList<Course>();
		try {
			list=dao.getcourse1(ctype);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
		return list;
	}
}
