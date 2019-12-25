package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.dao.IndexDao;
import com.etc.HongRui.entiry.Course;
import com.etc.HongRui.util.Log;

public class IndexService {

	
	 /*public List<List<Course>> getList() throws SQLException {
		 IndexDao dao =new IndexDao(); 
		 List<Course> list1=new ArrayList<Course>(); 
		 List<Course> list2=new ArrayList<Course>();
		 List<Course> list3=new ArrayList<Course>();
		 List<Course> list4=new ArrayList<Course>(); 
		 List<Course> list5=new ArrayList<Course>();
		 List<Course> list6=new ArrayList<Course>();
		 List<Course> list7=new ArrayList<Course>(); 
		 List<List<Course>>list =new ArrayList<List<Course>>(); 
		 try {
	 
			list.add(list1=dao.getList1()); 
			list.add(list2=dao.getList2());
			list.add(list3=dao.getList3()); 
			list.add(list4=dao.getList4());
			list.add(list5=dao.getList5());
			list.add(list6=dao.getList6());
			list.add(list7=dao.getList7()); 
		 } catch (Exception e) {
			 e.printStackTrace();
			Log.logger.debug(e.getMessage());
		 }finally { 
			 dao.closeResource(); 
		 }
		 return list;
	 }
	 */
	 public List<Course> getList1() throws SQLException { 
		 IndexDao dao =new IndexDao();
		  List<Course> list1=new ArrayList<Course>(); 
		 try {
			
			  list1=dao.getList1();
		} catch (Exception e) { 
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
			}finally {
				dao.closeResource(); 
				}
		 return list1;
		 }
	 public List<Course> getList2() throws SQLException { 
		 IndexDao dao =new IndexDao();
		  List<Course> list2=new ArrayList<Course>(); 
		 try {
			
			  list2=dao.getList2();
		} catch (Exception e) { 
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
			}finally {
				dao.closeResource(); 
				}
		 return list2;
		 }
	 public List<Course> getList3() throws SQLException { 
		 IndexDao dao =new IndexDao();
		  List<Course> list3=new ArrayList<Course>(); 
		 try {
			
			  list3=dao.getList3();
		} catch (Exception e) { 
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
			}finally {
				dao.closeResource(); 
				}
		 return list3;
		 }
	 public List<Course> getList4() throws SQLException { 
		 IndexDao dao =new IndexDao();
		  List<Course> list4=new ArrayList<Course>(); 
		 try {
			
			  list4=dao.getList4();
		} catch (Exception e) { 
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
			}finally {
				dao.closeResource(); 
				}
		 return list4;
		 }
	 public List<Course> getList5() throws SQLException { 
		 IndexDao dao =new IndexDao();
		  List<Course> list5=new ArrayList<Course>(); 
		 try {
			
			  list5=dao.getList5();
		} catch (Exception e) { 
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
			}finally {
				dao.closeResource(); 
				}
		 return list5;
		 }
	 public List<Course> getList6() throws SQLException { 
		 IndexDao dao =new IndexDao();
		  List<Course> list6=new ArrayList<Course>(); 
		 try {
			
			  list6=dao.getList6();
		} catch (Exception e) { 
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
			}finally {
				dao.closeResource(); 
				}
		 return list6;
		 }
	 public List<Course> getList7() throws SQLException { 
		 IndexDao dao =new IndexDao();
		  List<Course> list7=new ArrayList<Course>(); 
		 try {
			
			  list7=dao.getList7();
		} catch (Exception e) { 
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
			}finally {
				dao.closeResource(); 
				}
		 return list7;
		 }
	
}
