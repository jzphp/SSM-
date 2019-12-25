package com.etc.HongRui.entiry;

public class Order extends shoplist {
	public String deta;//订单产生的日期
	public String uname;//购买者的名字
	public String oid;//
	public String type;//用户的类型
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDeta() {
		return deta;
	}
	public void setDeta(String deta) {
		this.deta = deta;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	
	
	

	

}
