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
 * Servlet implementation class BbsOrderComServ
 */
@WebServlet("/BbsOrderComServ")
public class BbsOrderComServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbsOrderComServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("user");
		String OID = request.getParameter("OID");
		if (user!=null) {
			request.setAttribute("user", user);
			request.setAttribute("oid", OID);
			request.getRequestDispatcher("bbs/myPendding.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("user");
		String OID = request.getParameter("oid");
		String context = request.getParameter("content");
		if (user!=null) {
			String UID = user.getUID();
			boolean flag = false;
			BbsService service = new BbsService();
			try {
				flag = service.orderCommen(context, OID, UID);
				if (flag) {
					request.getRequestDispatcher("MyOrderServ").forward(request, response);
				}else {
					PrintWriter out=response.getWriter();
					out.print("<script>alert('评价失败');window.location.href='login.jsp';</script>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
