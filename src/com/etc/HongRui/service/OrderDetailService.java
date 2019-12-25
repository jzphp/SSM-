package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.List;

import com.etc.HongRui.dao.ODDao;
import com.etc.HongRui.entiry.OrderDetail;
import com.etc.HongRui.util.Log;

public class OrderDetailService {
	public List<OrderDetail> getlist(String uid, List<String> cid) throws SQLException {
	List<OrderDetail> list =null;
	ODDao dao=new ODDao();
	try {
		list=dao.getlist(uid,cid);
	} catch (ClassNotFoundException | SQLException e) {
		Log.logger.debug(e.getMessage());
		e.printStackTrace();
	}finally {
		dao.closeResource();
	}
		return list;
	}
	//查看订单详情中有没有关于该课程的记录，返回true，否则返回false
	public boolean getODetail(String uid,String cid) {
		ODDao dao=new ODDao();
	    boolean flge=dao.getODetail(uid,cid);
		return flge;
		
	}
}
