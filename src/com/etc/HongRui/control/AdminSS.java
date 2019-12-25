package com.etc.HongRui.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.Student;
import com.etc.HongRui.service.AdminService;
import com.etc.HongRui.util.Log;

@WebServlet("/AdminSS")
public class AdminSS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		// 处理乱码
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
	
		
		
	
/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username")==""?null:request.getParameter("username");
		String uid =request.getParameter("uid")==""?null:request.getParameter("uid");
		AdminService service  =  new AdminService();
		List<Student> list=null;
		try {
			if(username==null && uid==null) {
				list =service.getStudent();
				request.setAttribute("list",list);
				request.getRequestDispatcher("admin/student.jsp").forward(request, response);
			}else if(username!=null && uid==null) {
				list=service.getStudent1(username);
				request.setAttribute("list",list);
				request.getRequestDispatcher("admin/student.jsp").forward(request, response);
			}else if(username==null && uid!=null) {
				list=service.getStudent2( uid);
				request.setAttribute("list",list);
				request.getRequestDispatcher("admin/student.jsp").forward(request, response);
			}else if(username!=null && uid!=null) {
				list=service.getStudent3(username, uid);
				request.setAttribute("list",list);
				request.getRequestDispatcher("admin/student.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
		
	}

}