package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.Invatition;
import com.etc.HongRui.entiry.User;
import com.etc.HongRui.service.BbsService;
import com.etc.HongRui.util.Log;

/**
 * Servlet implementation class BbsSeacherServ
 */
@WebServlet("/BbsSeacherServ")
public class BbsSeacherServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BbsSeacherServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		BbsService service = new BbsService();
		User user = (User) request.getSession().getAttribute("user");
		String p = request.getParameter("page") == null ? "1" : request.getParameter("page");
		int page = Integer.parseInt(p);
		// 存储当前页数据
		request.setAttribute("page", page);
		// 存储下一页
		request.setAttribute("next", page + 1);
		// 存储上一页
		request.setAttribute("up", page - 1);
		int count = 0;
		// 获取到总页数
		try {
			count = service.getPage(10);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.setAttribute("pageall", count);
		if (user != null) {
			String search = request.getParameter("search");
			List<Invatition> list = null;
			try {
				list = service.search(search,page,10);
				try {
					if (list!=null) {
						list = service.cUtUname(list);
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.logger.debug(e.getMessage());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}
			request.setAttribute("list", list);
			request.setAttribute("user", user);
			request.getRequestDispatcher("bbs/search.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
