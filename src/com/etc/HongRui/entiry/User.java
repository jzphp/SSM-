package com.etc.HongRui.entiry;

/*************************
*@className   User.java
*@Date        2019年1月9日
*@author      jiazhi
*@version     V1.0
*@description
*************************/


import java.util.Date;
/**
 * 
 * @author jiazhi
 *
 */
public class User {
	private String UID ;//用户ID
	private String Upwd;//用户密码
	private String Username;//用户名
	private String Uphone;//手机号码
	private String Umail;//邮箱
	private Date UcreateTime;//创建时间
	private String Uclass;//用户类别
	private int Uactivite;//是否激活
	private int Ubanned ;//是否封禁
	private Date UbanTime;//封禁时间
	private String UbanCouse;//封禁原因
	private String icon;//头像
	
	public String getUID() {
		return UID;
	}
	/**
	 * 
	 * @param uID
	 */
	public void setUID(String uID) {
		UID = uID;
	}
	/**
	 * 
	 * @return
	 */
	public String getUpwd() {
		return Upwd;
	}
	/**
	 * 
	 * @param upwd
	 */
	public void setUpwd(String upwd) {
		Upwd = upwd;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getUphone() {
		return Uphone;
	}
	public void setUphone(String uphone) {
		Uphone = uphone;
	}
	public String getUmail() {
		return Umail;
	}
	public void setUmail(String umail) {
		Umail = umail;
	}
	public Date getUcreateTime() {
		return UcreateTime;
	}
	public void setUcreateTime(Date ucreateTime) {
		UcreateTime = ucreateTime;
	}
	public String getUclass() {
		return Uclass;
	}
	public void setUclass(String uclass) {
		Uclass = uclass;
	}
	public int getUactivite() {
		return Uactivite;
	}
	public void setUactivite(int uactivite) {
		Uactivite = uactivite;
	}
	public int getUbanned() {
		return Ubanned;
	}
	public void setUbanned(int ubanned) {
		Ubanned = ubanned;
	}
	public Date getUbanTime() {
		return UbanTime;
	}
	public void setUbanTime(Date ubanTime) {
		UbanTime = ubanTime;
	}
	public String getUbanCouse() {
		return UbanCouse;
	}
	public void setUbanCouse(String ubanCouse) {
		UbanCouse = ubanCouse;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
}
