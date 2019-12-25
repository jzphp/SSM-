package com.etc.HongRui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.entiry.OrderDetail;
/**
 * @author   gc
 * 查询订单详情表，将符合条件的完成订单进行显示
 *
 */
public class ODDao extends BaseDao {
	public List<OrderDetail> getlist(String uid,List<String> cid) throws SQLException, ClassNotFoundException {
		getConnect();
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		for(int i=0;i<cid.size();i++) {
			String sql1 = "SELECT  DISTINCT o.`OID`,o.`UID`,o.`Otime`,c.`Cname`,o.`CID`,t.`Tname`,c.`Cprice`,c.`Ctype`,u.`Username` FROM orderdetail o \r\n" + 
					"JOIN user u ON u.`UID`=o.`UID`\r\n" + 
					"JOIN Course c ON c.`CID`=o.`CID`\r\n" + 
					"JOIN teacher t ON c.`UID`=t.`UID`\r\n" + 
					"WHERE o.`UID`=? AND o.`CID`=?";		
			ps = connection.prepareStatement(sql1);
			ps.setString(1, uid);
			ps.setString(2, cid.get(i));
			rsResultSet = ps.executeQuery();
			while (rsResultSet.next()) {
				OrderDetail car = new OrderDetail();
				car.setCprice(rsResultSet.getFloat("Cprice"));
				car.setCtype(rsResultSet.getString("Ctype"));
				car.setTname(rsResultSet.getString("Tname"));
				car.setUname(rsResultSet.getString("Username"));
				car.setOid(rsResultSet.getString("Oid"));
				car.setCname(rsResultSet.getString("Cname"));
				car.setDeta(rsResultSet.getString("Otime"));
				list.add(car);
			}
		}

		return list;
	}
	//查看订单详情中有没有该记录，如果存在，返回true，否则返回false
	public boolean getODetail(String uid,String cid) {
		boolean flag=false;
		try {
			getConnect();
			String sql="select * from orderdetail where UID=? and CID=? ";
			ps = connection.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, cid);
			rsResultSet = ps.executeQuery();
			if(rsResultSet.next()) {
				flag= true;
			}else {
				flag= false;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
}
