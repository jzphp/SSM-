package com.etc.HongRui.entiry;

public class shoplist {
	public String gid;//购物车编号
    public String videoname;//视频名字
    public String ctype;//判断课程的类型
    public String utype;//用户类别
	public String cname;//课程名称
	public String tname;//订单产生的时间
    public float cprice;//课程价格
    public String tid;//教师ID
    public String cid;//课程ID
	   public String getUtype() {
			return utype;
		}
		public void setUtype(String utype) {
			this.utype = utype;
		}
    public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getVideoname() {
		return videoname;
	}
	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public float getCprice() {
		return cprice;
	}
	public void setCprice(float cprice) {
		this.cprice = cprice;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	

}
