package com.etc.HongRui.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.User;
import com.etc.HongRui.service.BbsService;

/**
 * Servlet implementation class BbsDeleteServ
 */
@WebServlet("/BbsDeleteServ")
public class BbsDeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BbsDeleteServ() {
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
		String type = request.getParameter("type") == "" ? "0" : request.getParameter("type");
		String PID = request.getParameter("type") == "" ? "0" : request.getParameter("PID");
		String OID = request.getParameter("type") == "" ? "0" : request.getParameter("OID");
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			BbsService service = new BbsService();
			String UID = user.getUID();
			boolean flag =false;
			if (type.equals("mywrite")) {
				try {
					flag = service.deleMyWrite(PID, UID);
					if (flag) {
						request.getRequestDispatcher("MyWriteServ").forward(request, response);
					}else {
						PrintWriter out=response.getWriter();
						out.print("<script>alert('删除失败');window.location.href='login.jsp';</script>");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (type.equals("myorder")) {
				try {
					flag = service.deleMyOrder(OID, UID);
					if (flag) {
						request.getRequestDispatcher("MyOrderServ").forward(request, response);
					}else {
						PrintWriter out=response.getWriter();
						out.print("<script>alert('删除失败');window.location.href='login.jsp';</script>");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			response.sendRedirect("login.jsp");
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
