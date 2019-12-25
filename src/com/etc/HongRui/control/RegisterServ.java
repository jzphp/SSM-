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
 * Servlet implementation class RegisterServ
 */
@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServ() {
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
		//��������
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//��ҳ���л�ȡ����Ҫ�Ĳ�����Ϣ
		String username=request.getParameter("username");
		String upwd=request.getParameter("upwd");
		//String upwd1=request.getParameter("upwd1");
		String uphone=request.getParameter("uphone");
		String umail=request.getParameter("umail");
		//��Ҫ����user����
		User user =new User();
		//����ȡ�������ݴ洢��������
		user.setUsername(username);
		user.setUpwd(upwd);
		user.setUphone(uphone);
		user.setUmail(umail);
		
		//����һ���߼���Ķ���
		RegisterService service =new RegisterService();
		
		try {
			boolean flag = service.register(user) ;
			if(flag){
				//ҳ����ת
				request.getRequestDispatcher("login.jsp").forward(request, response);
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
