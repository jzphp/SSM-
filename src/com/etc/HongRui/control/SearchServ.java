package com.etc.HongRui.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.Course;
import com.etc.HongRui.service.SearchService;
import com.etc.HongRui.util.Log;

/**
 * Servlet implementation class SearchServ
 */
@WebServlet("/SearchServ")
public class SearchServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//接收页面传来的字符
		request.setCharacterEncoding("utf-8");
		String string=request.getParameter("serach");
		//实例化逻辑层调用getsearch方法
		SearchService service=new SearchService();
		try {
			List<Course> list = service.getsearch(string);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("detailsearch.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
		
	}

}
