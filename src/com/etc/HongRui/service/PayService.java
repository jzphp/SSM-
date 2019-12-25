package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.dao.PayDao;
import com.etc.HongRui.util.Log;

/**
 * @author   gc
 * 由PayServ跳转
 * 实现的是付款的功能---事务
 * 以及查询用户现有的账户余额，与想买的视频总价进行判断，查看用户是否可以购买
 */
public class PayService {
	public float getacconut(String uid,String type) throws SQLException {
		float account=0;
		PayDao dao=new PayDao();
		try {
			account=dao.getaccount(uid,type);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dao.closeResource();
		}
		return account;
		
	}
	public boolean shiwu(ArrayList<Float> monery,String type,String uid,List<String> cid,List<String> tid , List<String> time,List<String> gid) throws SQLException {
 		boolean flag=false;
		PayDao dao=new PayDao();
		try {
			dao.openTran();	
			//判断账户余额
		    dao.getUserAccount(monery, type, uid);
			dao.getTeacherAccount(tid,monery);
			dao.getPingTaiAccount(uid,cid,monery) ;
			dao.getOrderDetail(uid, cid,time);
			//还要清除购物车信息
			//传递的是购物车的id
			dao.delechoice(gid);		  
			dao.commitTran();
			flag = true ;
		} catch (ClassNotFoundException e) {
			Log.logger.debug(e.getMessage());
			e.printStackTrace();
			dao.rollTran();
		 }finally{
			dao.closeResource();	
		}
		return flag;
	}
}
