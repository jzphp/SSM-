package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.service.AdminLService;

/**
 * Servlet implementation class LunDelete
 */
@WebServlet("/LunDelete")
public class LunDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LunDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		AdminLService service = new AdminLService();
		System.out.println(id + "  " + type);
		if (type.equals("deleone")) {
			int count = 0;
			try {
				count = service.Lundelete(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (count != 0) {
				request.setAttribute("delete", "成功删除" + count + "条信息！！id值为" + id);
				request.getRequestDispatcher("admin/luntan.jsp").forward(request, response);
			} else {
				request.getAttribute("删除失败！！");
				request.getRequestDispatcher("admin/luntan.jsp").forward(request, response);
			}

		}
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
