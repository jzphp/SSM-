package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.List;

import com.etc.HongRui.dao.PlayDao;
import com.etc.HongRui.entiry.Video;
import com.etc.HongRui.util.Log;

public class PlayService {

	public List<Video> getvideo(String idString) throws SQLException {
		PlayDao dao=new PlayDao();
		List<Video> list=null;
		try {
			list=dao.getvideo(idString);
		} catch (Exception e) {
		e.printStackTrace();
		Log.logger.debug(e.getMessage());
		}finally{
			 dao.closeResource();
		 }
		return list;
	}

}
