package com.etc.HongRui.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.etc.HongRui.entiry.Course;
import com.etc.HongRui.service.IndexService;
import com.etc.HongRui.util.Log;

/**
 * Servlet implementation class IndexServ
 */
@WebServlet("/IndexServ")
public class IndexServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		//创建一个逻辑层对象
		IndexService service=new IndexService();
		/*
		 *根据页面上对应的类型传递到DAO层的sql语句查询将传递回来的list显示到页面上 
		 */
		try {
			 List<Course> list1 =service.getList1(); 
			 request.setAttribute("item", list1);
			 List<Course> list2 =service.getList2(); 
			 request.setAttribute("ll", list2);
			 List<Course> list3 =service.getList3(); 
			 request.setAttribute("lll", list3);
			 List<Course> list4 =service.getList4(); 
			 request.setAttribute("llll", list4);
			 List<Course> list5 =service.getList5(); 
			 request.setAttribute("lllll", list5);
			 List<Course> list6 =service.getList6(); 
			 request.setAttribute("llllll", list6);
			 List<Course> list7 =service.getList7(); 
			 request.setAttribute("items", list7);
			 request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//创建一个逻辑层对象
		IndexService service=new IndexService();
		/*
		 *根据页面上对应的类型传递到DAO层的sql语句查询将传递回来的list显示到页面上 
		 */
		try {
			 List<Course> list1 =service.getList1(); 
			 request.setAttribute("item", list1);
			 List<Course> list2 =service.getList2(); 
			 request.setAttribute("ll", list2);
			 List<Course> list3 =service.getList3(); 
			 request.setAttribute("lll", list3);
			 List<Course> list4 =service.getList4(); 
			 request.setAttribute("llll", list4);
			 List<Course> list5 =service.getList5(); 
			 request.setAttribute("lllll", list5);
			 List<Course> list6 =service.getList6(); 
			 request.setAttribute("llllll", list6);
			 List<Course> list7 =service.getList7(); 
			 request.setAttribute("items", list7);
			 request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
	}

}
