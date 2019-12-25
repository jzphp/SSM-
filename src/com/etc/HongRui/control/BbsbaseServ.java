package com.etc.HongRui.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.Peo;
import com.etc.HongRui.entiry.PeoTeacher;
import com.etc.HongRui.entiry.User;
import com.etc.HongRui.service.BbsService;
import com.etc.HongRui.util.Log;

/**
 * Servlet implementation class BbsbaseServ
 */
@WebServlet("/BbsbaseServ")
public class BbsbaseServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BbsbaseServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		User user = (User) request.getSession().getAttribute("user");

		BbsService service = new BbsService();
		if (user != null) {
			try {
				Peo peo = service.getPeo(user.getUID());
				request.setAttribute("peo", peo);
				PeoTeacher peoteacher = service.getPeoTeacher(user.getUID());
				request.setAttribute("peoteacher", peoteacher);		
				request.getRequestDispatcher("bbs/base.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		User user = (User) request.getSession().getAttribute("user");

		BbsService service = new BbsService();
		if (user != null) {
			try {
				Peo peo = service.getPeo(user.getUID());
				PeoTeacher peoteacher = service.getPeoTeacher(user.getUID());
				request.setAttribute("peo", peo);
				request.setAttribute("peoteacher", peoteacher);
				request.getRequestDispatcher("bbs/base.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
