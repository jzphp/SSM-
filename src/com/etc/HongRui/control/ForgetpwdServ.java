package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.User;
import com.etc.HongRui.service.LoginService;

/**
 * Servlet implementation class ForgetpwdServ
 */
@WebServlet("/ForgetpwdServ")
public class ForgetpwdServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetpwdServ() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String uphone = request.getParameter("uphone");
		String umail = request.getParameter("umail");
		
		LoginService service = new LoginService();
		
		try {
			User user = service.forgetpwd(username,uphone,umail) ;
			if(user != null){
				request.setAttribute("verify", user);
				request.getRequestDispatcher("setpassword.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("errorr.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {			 
			e.printStackTrace();
		}		
	}
}