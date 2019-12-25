package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.Student;
import com.etc.HongRui.entiry.Teacher;
import com.etc.HongRui.entiry.User;
import com.etc.HongRui.service.BbsService;
import com.etc.HongRui.util.Log;

/**
 * Servlet implementation class BbsHomeServ
 */
@WebServlet("/BbsHomeServ")
public class BbsHomeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbsHomeServ() {
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
		User user=(User)request.getSession().getAttribute("user");
		String uclass=null;
		BbsService service  =  new BbsService();
		try {
			uclass = service.getUClass(user.getUID().toString());
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Log.logger.debug(e1.getMessage());
		}
		Student student = null;
		Teacher teacher = null;
		try {
			if (uclass.equals("0")) {
				student = service.getStudent(user.getUID().toString());
				request.setAttribute("student", student);
			}
			if (uclass.equals("1")) {
				teacher = service.getTeacher(user.getUID().toString());
				request.setAttribute("teacher", teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
		request.setAttribute("uclass", uclass);
		request.getRequestDispatcher("bbs/base.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
