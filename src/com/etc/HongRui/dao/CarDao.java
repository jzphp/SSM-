 package com.etc.HongRui.dao;

 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.etc.HongRui.entiry.shoplist;
import com.etc.HongRui.util.GetID;;

/**
 * @author   gc
 *用于显示购物车的记录，以及删除购物车记录
 *由CarService 跳转
 *
 */
public class CarDao extends BaseDao {
	//得到list表---用于显示购物车的记录

	public List<shoplist> getlist(String uid) throws SQLException, ClassNotFoundException {
		
		// getCon();
		String sql = "SELECT s.`GID`,c.`CID`,c.`Ctype`,c.`Cname`,c.Cprice,c.`UID`,u.`Uclass`,t.Tname FROM shopcart s JOIN Course c ON c.`CID`=s.`CID`\r\n" + 
				"JOIN teacher t ON t.`UID`=c.UID \r\n" + 
				"JOIN user u ON u.UID=s.UID WHERE s.`UID`=?";		
		ps = connection.prepareStatement(sql);
		ps.setString(1, uid);
		rsResultSet = ps.executeQuery();
		List<shoplist> list = new ArrayList<shoplist>();
		while (rsResultSet.next()) {
			shoplist car = new shoplist();
			car.setGid(rsResultSet.getString("GID"));
			car.setCprice(rsResultSet.getFloat("Cprice"));
			car.setCtype(rsResultSet.getString("Ctype"));
			car.setUtype(rsResultSet.getString("Uclass"));
			car.setTname(rsResultSet.getString("Tname"));
			car.setCname(rsResultSet.getString("Cname"));
			list.add(car);
		}

		return list;
	}
	//删除单条数据
	public int dele(String str) throws SQLException {
		String sql = "delete from shopcart where GID = ?";
		ps = connection.prepareStatement(sql);
		ps.setString(1, str);
		int count = ps.executeUpdate();
		return count;
	}
	//删除多条数据
	//删除关于用户的购物车记录  ----在提交订单时使用
	public int delechoice(String strs) throws SQLException {
		String sql = "delete from shopcart where GID = ?";
		String[] strings = strs.split(",");
		int count = 0;
		for (int i = 0; i < strings.length; i++) {
			ps = connection.prepareStatement(sql);
			ps.setString(1, strings[i]);
			ps.executeUpdate();
			count++;
		}
		return count;
	}
	//添加购物车时，检测该用户的购物车是否存在此类视频，如果存在，返回true，否则返回false
	public boolean getRecord(String uid,String cid) throws SQLException {
		String sql="select * from shopcart where UID=? and CID=? " ;
		ps = connection.prepareStatement(sql);
		ps.setString(1, uid);
		ps.setString(2, cid);
		rsResultSet = ps.executeQuery();
		if(rsResultSet.next()) {
			return true;
		}else {
			return false;
		}
	}
	//添加购物车
	public boolean getAddCar(String uid,String cid) throws SQLException {
		String sql="insert into shopcart value(?,?,?)" ;
		ps = connection.prepareStatement(sql);
		ps.setString(1, GetID.getID());
		ps.setString(2, uid);
		ps.setString(3, cid);
		int rs = ps.executeUpdate();
		if(rs>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
