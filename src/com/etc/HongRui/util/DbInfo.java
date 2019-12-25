package com.etc.HongRui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * 
 * @author jiazhi
 *
 */
public class DbInfo {
	//定义一个属性文件的实体
	private ConfigureDbInfo  configureDbInfo ;
   //单例模式的创建
	//定义一个静态属性
	private static DbInfo dbInfo ;
	//创建一个private的构造方法
	private DbInfo(){
		//创建属性文件的实体对象
		configureDbInfo = new ConfigureDbInfo() ;
		//调用获取资源的方法
		getProperties();
	}
	//创建一个静态方法，用来获取到静态属性对象
	public static DbInfo getInstance(){
		if(dbInfo == null){
			//当当前属性为空的时候需要创建实例
			dbInfo = new DbInfo() ;
		}
		return dbInfo ;
	}
	//创建一个获取属性文件信息的方法
	  public void getProperties(){
		  //定义一个字节流对象
		  FileInputStream fisFileInputStream = null;		  
		 try {
			//获取到属性文件的地址,通过反射原理来做
			String path =  DbInfo.class.getResource("/").toURI().getPath() + "db.properties" ;
			//创建一个文件对象
			File file = new File(path) ;
			//创建一个字节流对象
			try {
				fisFileInputStream = new FileInputStream(file) ;
			} catch (FileNotFoundException e) {
				Log.logger.debug(e.getMessage());
				e.printStackTrace();
			}
			//创建一个Properties对象
			Properties properties = new Properties() ;
			//加载properties文件
			try {
				properties.load(fisFileInputStream);
			} catch (IOException e) {
				Log.logger.debug(e.getMessage());
				e.printStackTrace();
			}
			//从属性文件中获取信息并且存储到configureDbInfo对象中
			  configureDbInfo.setDbdriver(properties.getProperty("dbdriver"));
			  configureDbInfo.setDbURL(properties.getProperty("dbURL"));
			  configureDbInfo.setPwd(properties.getProperty("pwd"));
			  configureDbInfo.setUname(properties.getProperty("uname"));
		} catch (URISyntaxException e) {
			 Log.logger.debug(e.getMessage());
			e.printStackTrace();
		} finally{
			if(fisFileInputStream != null){
				try {
					//关闭资源
					fisFileInputStream.close();
				} catch (IOException e) {
					Log.logger.debug(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		  
	  }
	  //获取ConfigureDbInfo对象的属性值
	  //获取dbdriver的值
	  public String getDbdriver(){
		  String dbdriver = null ;
		  if(configureDbInfo != null){
			  dbdriver = configureDbInfo.getDbdriver() ;
		  }
		  return dbdriver ;
	  }
	  //获取dbURL
	  public String getDbURL(){
		  String dbURL = null ;
		  if(configureDbInfo != null){
			  dbURL = configureDbInfo.getDbURL() ;
		  }
		  return dbURL ;
	  }
	  //获取uname 
	  public String getUname(){
		  String unameString = null  ;
		  if(configureDbInfo != null){
			  unameString = configureDbInfo.getUname() ;
		  }
			return unameString ;	  
	  }
	  //获取pwd
	  public String getpwd(){
		  String pwdString = null ;
		  if(configureDbInfo != null){
			  pwdString = configureDbInfo.getPwd() ;
		  }
		  return pwdString ;
	  }
	//创建属性文件的实体类
	class ConfigureDbInfo {
		private String dbdriver ; 
		private String dbURL ; 
		private String uname ;
		private String pwd ;
		public String getDbdriver() {
			return dbdriver;
		}
		public void setDbdriver(String dbdriver) {
			this.dbdriver = dbdriver;
		}
		public String getDbURL() {
			return dbURL;
		}
		public void setDbURL(String dbURL) {
			this.dbURL = dbURL;
		}
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		
	}
}
