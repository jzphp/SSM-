package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class BbspwdServ
 */
@WebServlet("/BbspwdServ")
public class BbspwdServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbspwdServ() {
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
		User user = (User) request.getSession().getAttribute("user");
		String uid = user.getUID();
		String upwd = request.getParameter("upwd");
		User u = new User();
		u.setUID(uid);
		u.setUpwd(upwd);
		BbsService service = new BbsService();
		try {
			boolean flag = service.Bbspwd(u) ;
			if(flag){
				request.getRequestDispatcher("bbs/okPwd.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("bbs/errorPwd.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {			 
			e.printStackTrace();
		}		
	}
}

