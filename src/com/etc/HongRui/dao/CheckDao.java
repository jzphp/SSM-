package com.etc.HongRui.dao;
/**
 * @author   gc
 *根据购物车点击的提交，得到选中的商品oid查找，所以显示查到的记录
 *由CheckOutService跳转
 */
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.etc.HongRui.entiry.Order;

public class CheckDao  extends BaseDao {
public List<Order> getlist(String strs,String uid) throws SQLException, ClassNotFoundException {
	//---提交订单时，处理oid连接起来的strs
	//获取当前时间
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	String date = df.format(new Date());
	List<Order> list = new ArrayList<Order>();
	String sql1 = "SELECT s.`GID`,u.`Username`,c.`CID`,c.`Ctype`,c.`Cname`,c.Cprice,c.`UID`,u.`Uclass`,t.Tname FROM shopcart s \r\n" + 
			"JOIN Course c ON c.`CID`=s.`CID`\r\n" + 
			"JOIN teacher t ON t.`UID`=c.UID\r\n" + 
			"JOIN user u ON u.UID=s.UID WHERE s.`UID`=? AND s.`GID`=?";	
	String[] strings = strs.split("-");
	for(int i=0;i<strings.length;i++) {
		ps = connection.prepareStatement(sql1);
		ps.setString(1, uid);
		ps.setString(2, strings[i]);
		rsResultSet = ps.executeQuery();
		while (rsResultSet.next()) {
			Order car = new Order();
			car.setType(rsResultSet.getString("Uclass"));
			car.setCprice(rsResultSet.getFloat("Cprice"));
			car.setCtype(rsResultSet.getString("Ctype"));
			car.setTname(rsResultSet.getString("Tname"));
			car.setUname(rsResultSet.getString("Username"));
			car.setDeta(date);
			car.setCname(rsResultSet.getString("Cname"));
			car.setTid(rsResultSet.getString("UID"));
			car.setCid(rsResultSet.getString("CID"));
			car.setGid(rsResultSet.getString("GID"));
			list.add(car);
		}
	}
		return list;
	}

}
