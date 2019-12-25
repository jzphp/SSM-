package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.dao.AdLDao;
import com.etc.HongRui.dao.BaseDao;
import com.etc.HongRui.entiry.Invatition;
import com.etc.HongRui.util.Log;

public class AdminLService extends BaseDao{

	public List<Invatition> getInvatition() throws SQLException {
		List<Invatition> list=new ArrayList<Invatition>();
		AdLDao dao=new AdLDao();
		try {
			list=dao.getInvatition();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public List<Invatition> getInvatition1(String ptheme) throws SQLException {
		AdLDao dao=new AdLDao();
		List<Invatition> list=new ArrayList<Invatition>();
		try {
			list=dao.getInvatition1(ptheme);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public List<Invatition> getInvatition2(String pID) throws SQLException {
		List<Invatition> list=new ArrayList<Invatition>();
		AdLDao dao=new AdLDao();
		try {
			list=dao.getInvatition2(pID);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public List<Invatition> getInvatition3(String ptheme, String pID) throws SQLException {
		List<Invatition> list=new ArrayList<Invatition>();
		AdLDao dao=new AdLDao();
		try {
			list=dao.getInvatition3(ptheme,pID);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			dao.closeResource();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public int Lundelete(String id) throws SQLException {
		AdLDao dao=new AdLDao();
		int count=0;
		count=dao.Lundelete(id);
		return count;
	}

	
}
