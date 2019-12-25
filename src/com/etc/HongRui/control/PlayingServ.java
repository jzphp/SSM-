package com.etc.HongRui.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlayingServ
 */
@WebServlet("/PlayingServ")
public class PlayingServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayingServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path=request.getParameter("type");
		request.setAttribute("path", path);
		request.getRequestDispatcher("sd/play.jsp").forward(request, response);
		
		/*PlayingService service=new PlayingService();
		try {
			pathString=service.getpath(stridString);
			request.setAttribute("path", pathString);
			request.getRequestDispatcher("sd/main.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
