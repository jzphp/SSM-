package com.etc.HongRui.control;

import java.io.IOException;
//import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.Course;
import com.etc.HongRui.entiry.User;
import com.etc.HongRui.service.DetailService;
import com.etc.HongRui.util.Log;

/**
 * Servlet implementation class DetailServ
 */

@WebServlet("/DetailServ")
public class DetailServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String ctype = request.getParameter("type");
		User user = (User) request.getSession().getAttribute("user");
		//if (user != null) {

			// 创建一个逻辑层的对象
			DetailService service = new DetailService();
			/*
			 * String ctype = null; try { ctype = service.getctype(re, ctype); } catch
			 * (SQLException e1) { // TODO Auto-generated catch block e1.printStackTrace();
			 * Logger.getLogger(Log.class).debug(e1.getMessage()); } List<Course> list =
			 * service.getcourse(ctype);
			 */
			try {
				List<Course> list = service.getcourse(ctype);
				request.setAttribute("list", list);
				request.setAttribute("user", user);
				List<Course> list1 = service.getcourse1(ctype);
				request.setAttribute("list1", list1);
				request.setAttribute("user", user);
				request.getRequestDispatcher("detail.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}
//		}else {
//			String model = "detail";
//			request.setAttribute("model", model);
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//		}

		// 使用三目表达式来表示，当当前页面为第一次打开的时候，因为没有当前页面传递，所以赋值为1，否则赋值为获取的页码
		/*
		 * String p = request.getParameter("page") == null ? "1" : request
		 * .getParameter("page"); int page = Integer.parseInt(p); // 存储当前页数据
		 * request.setAttribute("page", page); // 存储下一页 request.setAttribute("next",
		 * page + 1); // 存储上一页 request.setAttribute("up", page - 1); int count = 0; //
		 * 获取到总页数 try { count = service.getPage(1,ctype); } catch (SQLException e) {
		 * 
		 * e.printStackTrace(); } request.setAttribute("page", count); // 获取页面传递过来的参数
		 * 
		 * try { List<Course> list = service.details(page,5,ctype); //
		 * 将从服务器中获取的数据进行存储,第一个参数表示的是自己任意起的名称,第二个参数表示的是存储到第一个参数的数据
		 * request.setAttribute("list", list);
		 * request.getRequestDispatcher("detail.jsp").forward(request, response);
		 * 
		 * } catch (SQLException e) { Logger.getLogger(Log.class).debug(e.getMessage());
		 * e.printStackTrace(); }
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
