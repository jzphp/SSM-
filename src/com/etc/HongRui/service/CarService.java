package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.List;

import com.etc.HongRui.dao.CarDao;
import com.etc.HongRui.entiry.shoplist;
import com.etc.HongRui.util.Log;

public class CarService {
	//	得到列表
	public List<shoplist> getlist(String uid) throws SQLException {
		CarDao dao = new CarDao() ;
		List<shoplist> list = null ;
		 try{
			 dao.getConnect();
			 list=dao.getlist(uid);
		 }catch(Exception e){
			 Log.logger.debug(e.getMessage());
			 e.printStackTrace();
		 }finally{
			 dao.closeResource();		 }
		return list;
	}
	//删除单挑数据
	public int dele(String  idtrue) {
		 CarDao dao = new CarDao() ;
		 int count = 0 ;
		 try{
			  dao.getConnect();;
			  count = dao.dele(idtrue) ; 
		 }catch(Exception e){
			 Log.logger.debug(e.getMessage());
			 e.printStackTrace();
		 }finally{
			 try {
				dao.closeResource();
			} catch (SQLException e) {
			 
				e.printStackTrace();
			}
		 }
		
		return count;
	}
	//删除多条数据
	public int delechoice(String strs) throws SQLException {
		CarDao dao = new CarDao() ;
		int count = 0 ;
		 try{
			 dao.getConnect();
			count = dao.delechoice(strs)  ;
		 }catch(Exception e){
			 Log.logger.debug(e.getMessage());
			 e.printStackTrace();
		 }finally{
			 dao.closeResource();	
		 }
		return count;
	}
	//在添加购物车时，检测数据库关于该用户有没有该课程，如果存在，返回true，否则返回false
	public boolean getRecord(String uid,String cid) throws SQLException {
		boolean flag=false;
		CarDao dao =new CarDao();
		try {
			dao.getConnect();
			if(dao.getRecord(uid,cid)) {
				flag= true;
			}else {
				flag= false;
			}
		} catch (ClassNotFoundException e) {
			dao.closeResource();
			e.printStackTrace();
		}
		return flag;
		
		
	}
	//添加购物车---添加成功返回TRUE， 添加失败返回FALSE
	public boolean getAddCar(String uid,String cid) throws SQLException {
		boolean flag=false;
		CarDao dao =new CarDao();
		try {
			dao.getConnect();
			if(dao.getAddCar(uid,cid)) {
				flag= true;
			}else {
				flag= false;
			}
		} catch (ClassNotFoundException e) {
			dao.closeResource();
			e.printStackTrace();
		}
		return flag;
	}
	
	
	

}
