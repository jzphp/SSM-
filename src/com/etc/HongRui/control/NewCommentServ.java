package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.service.FiltrationService;
import com.etc.HongRui.service.PublishComment;
import com.etc.HongRui.util.Log;
/**
 * Servlet implementation class NewCommentServ
 */
@WebServlet("/NewCommentServ")
public class NewCommentServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCommentServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String themeString = request.getParameter("theme").trim();
		String contextString = request.getParameter("context").trim();
		FiltrationService service = new FiltrationService();
		
		try {
			themeString = service.Filtration(themeString);
			contextString = service.Filtration(contextString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
		String useridString = request.getParameter("UserID");

		PublishComment publishComment = new PublishComment();

		try {
			boolean flag = publishComment.Publish(publishComment.getThemeInfo(themeString,contextString,useridString));
			if (flag) {
				response.sendRedirect("BbsMainServ") ;
			}else {
				request.getRequestDispatcher("write.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}

	}

}
