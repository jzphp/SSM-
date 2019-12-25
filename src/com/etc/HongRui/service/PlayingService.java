package com.etc.HongRui.service;

import java.sql.SQLException;

import com.etc.HongRui.dao.PlayingDao;
import com.etc.HongRui.util.Log;

public class PlayingService {

	public String getpath(String stridString) throws SQLException {
		PlayingDao dao=new PlayingDao();
		String pathString=null;
	
		try {
			pathString= dao.getpath(stridString);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally{
			 dao.closeResource();
		 }
		return pathString;
	}

}
