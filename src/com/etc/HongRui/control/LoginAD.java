package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.administration;
import com.etc.HongRui.service.LoginService;


@WebServlet("/LoginAD")
public class LoginAD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAD() {
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
		       //��������
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				//��ҳ���л�ȡ����Ҫ�Ĳ�����Ϣ
				String user=request.getParameter("nick");
				String pwd=request.getParameter("password");
				
				//��Ҫ����administration����
				administration a =new administration();
				//����ȡ�������ݴ洢��������
				a.setAdname(user);
				a.setPassword(pwd);
				//����һ���߼���Ķ���
				LoginService service =new LoginService();
				
				try {
					boolean flag = service.loginAD(a) ;
					if(flag){
						//ҳ����ת
						request.getRequestDispatcher("admin/main.jsp").forward(request, response);
					}else{
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					 
					e.printStackTrace();
				}
				
				
			
	}

}
