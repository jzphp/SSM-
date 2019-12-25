/**
 * 
 */
package com.etc.HongRui.service;

import com.etc.HongRui.dao.PpDao;
import com.etc.HongRui.util.Log;

/**
 * @author LS
 *
 * PpService.java 验证订单里是否有此人买了此课程

 */
public class PpService {

	public boolean getorder(String idString,String uidString) {
		PpDao dao=new PpDao();
		boolean flag=false;
				try {
					flag=dao.getorder(idString,uidString);
				} catch (Exception e) {
					e.printStackTrace();
					Log.logger.debug(e.getMessage());
				}
		return flag;
	}

}
