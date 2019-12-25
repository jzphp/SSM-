package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.Teacher;
import com.etc.HongRui.service.AdminServ;

/**
 * Servlet implementation class ShowTeacherDetail
 */
@WebServlet("/ShowTeacherDetail")
public class ShowTeacherDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTeacherDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String id =request.getParameter("id");
		AdminServ service=new AdminServ();
		Teacher teacher=null;
		try {
			teacher=service.showTeacher(id);
			request.getSession().setAttribute("teacher", teacher);
			request.getRequestDispatcher("admin/teacher-info.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
