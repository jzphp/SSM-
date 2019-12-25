package com.etc.HongRui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author   gc
 * 由PayServ跳转
 * 实现的是付款的功能---事务
 * 付款包括
 * 1.用户账户的减少（要判断用户的类别）
 * 2.教师账号的增加
 * 3.平台账户的增加
 * 4.生成订单详情
 * 5.购物车记录的删除
 * 以及查询用户现有的账户余额，与想买的视频总价进行判断，查看用户是否可以购买
 */
public class PayDao extends BaseDao {
	
	public float getaccount(String uid,String type) throws SQLException, ClassNotFoundException {
		float account=0;
		getConnect();
		if(type.equals("1")) {
			String sql="select Taccount from teacher where UID=?";
			ps=connection.prepareStatement(sql);//预编译
			ps.setString(1, uid);
			rsResultSet = ps.executeQuery() ;
			while(rsResultSet.next()) {
				account=rsResultSet.getFloat("Taccount");//获取到Taccount的值 ---结果只有1列
			}
		}else {
			String sql1="select Saccount from student where UID=?";
			ps=connection.prepareStatement(sql1);//预编译
			ps.setString(1, uid);
			rsResultSet = ps.executeQuery() ;
			while(rsResultSet.next()) {
				account=rsResultSet.getFloat("Saccount");//取到值			
			}
		}
		return account;
		
	}
	
	
	
	
	//购买者账户的变化
	public void getUserAccount(ArrayList<Float> monery,String type,String uid) throws SQLException, ClassNotFoundException {
		//用户账户的减少---使用存储过程
		int rs=0;
		boolean flag=false;
		String account;
		float rmb = 0;	
		for(int i=0;i<monery.size();i++) {
			//读取数据库获取用户账户的余额
			if(type.equals("1")) {//说明是教师用户，所以要去教师表里面进行操作
				account="select Taccount from teacher where UID=?";
				ps=connection.prepareStatement(account);//预编译
				ps.setString(1, uid);
				rsResultSet = ps.executeQuery() ;
				while(rsResultSet.next()) {
					rmb=rsResultSet.getFloat("Taccount");//获取到Taccount的值 ---结果只有1列
				}
				rmb=rmb-monery.get(i);	
				String sql2;
				sql2="update teacher set Taccount =? where UID=?";
				ps=connection.prepareStatement(sql2);
				ps.setFloat(1, rmb);
				ps.setString(2, uid);
				rs= ps.executeUpdate();
				if(rs>0){
					flag=true;
				}
				if(!flag) {
					break;
				}
				
			}else {
				account="select Saccount from student where UID=?";
				ps=connection.prepareStatement(account);//预编译
				ps.setString(1, uid);
				rsResultSet = ps.executeQuery() ;
				
				while(rsResultSet.next()) {
					rmb=rsResultSet.getFloat("Saccount");//取到值			
				}
				//--------------------------
				rmb=rmb-monery.get(i);	
				String sql2;
				sql2="update  student set Saccount=? where UID=?";
				ps=connection.prepareStatement(sql2);
				ps.setFloat(1, rmb);
				ps.setString(2, uid);
				rs= ps.executeUpdate();
				if(rs>0){
					flag=true;
				}
				if(!flag) {
					break;
				}
				
			}
		}
	}
	//讲师账户的变化
	public void getTeacherAccount(List<String> tid,ArrayList<Float> monery) throws SQLException, ClassNotFoundException {
		//教师账户增加
		int rs=0;
		boolean flag=false;
		float rmb = 0;
		for(int i=0;i<tid.size();i++) {
			//首先获取数据库中的账户的值
			String account="select Taccount from teacher where UID=?";
			ps=connection.prepareStatement(account);//预编译
			ps.setString(1, tid.get(i));
			rsResultSet = ps.executeQuery() ;
			
			while(rsResultSet.next()) {
				rmb=rsResultSet.getFloat("Taccount");
			}//--------------------------
			rmb=(float) (rmb+monery.get(i)*0.5);	
			String sql2;
			sql2="update teacher set Taccount =? where UID=?";		
			ps=connection.prepareStatement(sql2);
			ps.setFloat(1,rmb);
			ps.setString(2,tid.get(i));
			rs = ps.executeUpdate() ;
			if(rs>0){
				flag=true;
			}
			if(!flag) {
				break;
			}
		}
		
	}
	//平台账户的增加
	public void getPingTaiAccount(String uid, List<String> cid,ArrayList<Float> monery) throws SQLException, ClassNotFoundException {
		int rs=0;
		boolean flag=false;
		float rmb=0;
		for(int i=0;i<cid.size();i++) {
			//首先获取平台数据库中的账户的值
			String account="select PTaccount from pingtaiaccount";
			ps=connection.prepareStatement(account);//预编译
			rsResultSet = ps.executeQuery() ;
			while(rsResultSet.next()) {
				 rmb=rsResultSet.getFloat("PTaccount");
			}
			rmb=(float) (rmb+monery.get(i)*0.5);	
			String sql2;
			sql2="insert into pingtaiaccount values(?,?,?)";
			ps=connection.prepareStatement(sql2);
			ps.setString(1,uid);
			ps.setString(2, cid.get(i));
			ps.setFloat(3,rmb);
			rs = ps.executeUpdate() ;
			if(rs>0){
				flag=true;
			}
			if(!flag) {
				break;
			}
		}
		
    }
	
	//生成订单详情
	public void getOrderDetail(String uid, List<String> cid,List<String> time) throws SQLException, ClassNotFoundException {
		//getConnect();
		String sql;
		boolean flag=false;
		for(int i=0;i<cid.size();i++) {
			sql="insert into orderdetail(UID,CID,Otime) values(?,?,?)";
			ps=connection.prepareStatement(sql);
			ps.setString(1,uid);
			ps.setString(2, cid.get(i));
			ps.setString(3, time.get(i));
			int rs = ps.executeUpdate();
			if(rs>0){
				flag=true;
			}
			if(!flag) {
				break;
			}
		}
	}
	//清除购物车信息
	public void delechoice(List<String> oid) throws SQLException, ClassNotFoundException {
		//需要循环删除
		String sql=null;
		for(int i=0;i<oid.size();i++) {
			sql = "delete from shopcart where GID = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1,oid.get(i));
			ps.executeUpdate();
		}
	}
}
