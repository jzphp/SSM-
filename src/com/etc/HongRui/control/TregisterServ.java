package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.User;
import com.etc.HongRui.service.RegisterService;

/**
 * Servlet implementation class TregisterServ
 */
@WebServlet("/TregisterServ")
public class TregisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TregisterServ() {
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
		//处理乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取页面信息
		String username = request.getParameter("username");
		String upwd = request.getParameter("upwd");
		String uphone = request.getParameter("uphone");
		String umail = request.getParameter("umail");
		//
		User user = new User();
		user.setUsername(username);
		user.setUpwd(upwd);
		user.setUphone(uphone);
		user.setUmail(umail);
		
		RegisterService service = new RegisterService();
		
		try {
			boolean flag = service.tregister(user) ;
			if(flag){
				//ҳ����ת
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("errorr.jsp").forward(request, response);
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();			
		} catch(SQLException e) {
			e.printStackTrace();			
		}		
	}
}
