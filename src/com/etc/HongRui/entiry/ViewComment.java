/*************************
*@className    Comment.java
*@Date         2019年1月12日
*@author       jiazhi
*@version      V1.0
*@package_name com.etc.HongRui.entiry
************************/
package com.etc.HongRui.entiry;


public class ViewComment {
     private String CID;  //序号
     private String PID;   //帖子id
     private String UID;   //用户id
     private String Username;
     private String CText;  //评论内容
     private String CTime;  //评论时间
     
	/**
	 * @return the username
	 */
	public String getUsername() {
		return Username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		Username = username;
	}
	/**
	 * @return the cID
	 */
	public String getCID() {
		return CID;
	}
	/**
	 * @param cID the cID to set
	 */
	public void setCID(String cID) {
		CID = cID;
	}
	/**
	 * @return the pID
	 */
	public String getPID() {
		return PID;
	}
	/**
	 * @param pID the pID to set
	 */
	public void setPID(String pID) {
		PID = pID;
	}
	/**
	 * @return the uID
	 */
	public String getUID() {
		return UID;
	}
	/**
	 * @param uID the uID to set
	 */
	public void setUID(String uID) {
		UID = uID;
	}
	/**
	 * @return the cText
	 */
	public String getCText() {
		return CText;
	}
	/**
	 * @param cText the cText to set
	 */
	public void setCText(String cText) {
		CText = cText;
	}
	/**
	 * @return the cTime
	 */
	public String getCTime() {
		return CTime;
	}
	/**
	 * @param cTime the cTime to set
	 */
	public void setCTime(String cTime) {
		CTime = cTime;
	}
     
}
