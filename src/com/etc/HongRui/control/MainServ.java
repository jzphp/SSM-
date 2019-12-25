package com.etc.HongRui.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.User;


/**
 * Servlet implementation class MainServ
 */
@WebServlet("/MainServ")
public class MainServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String model = request.getParameter("model")== "" ? "index" :request.getParameter("model");
		User user =(User)request.getSession().getAttribute("user");
		request.setAttribute("model", model);
		request.setAttribute("user", user);
		if(user==null) {
			if(model.equals("detail")) {
				request.getRequestDispatcher("IndexServ").forward(request, response) ;
			}else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else{
			if(model.equals("bbs")) {
				request.getRequestDispatcher("BbsMainServ").forward(request, response);
			}else if(model.equals("detail")) {
				request.getRequestDispatcher("IndexServ").forward(request, response) ;
			}else if(model.equals("car")) {
				request.getRequestDispatcher("CarServ").forward(request, response);
			}
			else {
				response.sendRedirect("IndexServ");
				
			}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String model = request.getParameter("model")== "" ? "index" :request.getParameter("model");
		User user =(User)request.getSession().getAttribute("user");
		request.setAttribute("model", model);
		request.setAttribute("user", user);
		if(user==null) {
			if(model.equals("detail")) {
				request.getRequestDispatcher("IndexServ").forward(request, response) ;
			}else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else{
			if(model.equals("bbs")) {
				request.getRequestDispatcher("BbsMainServ").forward(request, response);
			}else if(model.equals("car")) {
				request.getRequestDispatcher("CarServ").forward(request, response);
			}
			else {
				response.sendRedirect("IndexServ");
				
			}
		}
	}
}
