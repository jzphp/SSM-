package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.Invatition;
import com.etc.HongRui.entiry.User;
import com.etc.HongRui.service.ViewCommentService;
import com.etc.HongRui.util.Log;

/**
 * Servlet implementation class WriteComServ
 */
@WebServlet("/WriteComServ")
public class WriteComServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteComServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String PID = request.getParameter("PID");
		User user = (User) request.getSession().getAttribute("user");
		ViewCommentService service = new ViewCommentService();
		Invatition invatition = null;
		try {
			invatition = service.getInvatition(PID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
		request.setAttribute("invatition", invatition);
		request.setAttribute("user", user);
		request.getRequestDispatcher("bbs/gentie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
