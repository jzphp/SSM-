package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.List;

import com.etc.HongRui.dao.CheckDao;
import com.etc.HongRui.entiry.Order;
import com.etc.HongRui.util.Log;

public class CheckOutService {

//	得到列表
	public List<Order> getlist(String str,String uid) throws SQLException {
		CheckDao dao=new CheckDao();
		List<Order> list = null ;
		 try{
			 dao.getConnect();
			 list=dao.getlist(str,uid);
		 }catch(Exception e){
			 Log.logger.debug(e.getMessage());
			 e.printStackTrace();
		 }finally{
			 dao.closeResource();		 }
		return list;
	}
}
