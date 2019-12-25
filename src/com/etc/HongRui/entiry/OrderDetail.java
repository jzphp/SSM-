package com.etc.HongRui.entiry;

public class OrderDetail extends Order {
	public String oid;//订单编号
	public String uid;//用户编号
	public String cid; //课程编号
	public String coursename;//课程名称
	public String otime; //订单时间
	public String ocomment; //订单评论
	public float omoney;//订单金额
	public int ostatus;//订单评论状态
	
	/**
	 * @return the coursename
	 */
	public String getCoursename() {
		return coursename;
	}
	/**
	 * @param coursename the coursename to set
	 */
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	/**
	 * @return the ostatus
	 */
	public int getOstatus() {
		return ostatus;
	}
	/**
	 * @param ostatus the ostatus to set
	 */
	public void setOstatus(int ostatus) {
		this.ostatus = ostatus;
	}
	/**
	 * @return the omoney
	 */
	public float getOmoney() {
		return omoney;
	}
	/**
	 * @param omoney the omoney to set
	 */
	public void setOmoney(float omoney) {
		this.omoney = omoney;
	}
	/**
	 * @return the oid
	 */
	public String getOid() {
		return oid;
	}
	/**
	 * @param oid the oid to set
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the cid
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * @param cid the cid to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * @return the otime
	 */
	public String getOtime() {
		return otime;
	}
	/**
	 * @param otime the otime to set
	 */
	public void setOtime(String otime) {
		this.otime = otime;
	}
	/**
	 * @return the ocomment
	 */
	public String getOcomment() {
		return ocomment;
	}
	/**
	 * @param ocomment the ocomment to set
	 */
	public void setOcomment(String ocomment) {
		this.ocomment = ocomment;
	}
	
}
