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
 * Servlet implementation class UpdatebaseServ
 */
@WebServlet("/UpdatebaseServ")
public class UpdatebaseServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatebaseServ() {
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
		String type = request.getParameter("type");
		String uid = request.getParameter("uid");
		BbsService service = new BbsService();
		if (type.equals("0")) {			
			String username=request.getParameter("username");
			String uphone=request.getParameter("uphone");
			String umail=request.getParameter("umail");
			String sname=request.getParameter("sname");
			String ssex=request.getParameter("ssex");
			String sage=request.getParameter("sage");
			User user = new User();
			user.setUID(uid);
			user.setUsername(username);
			user.setUphone(uphone);
			user.setUmail(umail);
			Student student = new Student();
			student.setSname(sname);
			student.setSsex(ssex);
			student.setSage(sage);			
			try {
				boolean flag = service.updateStudent(user,student) ;
				if(flag){
					request.getRequestDispatcher("BbsbaseServ").forward(request, response);
				}else{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.logger.error(e.getMessage());
			} catch (SQLException e) {			 
				e.printStackTrace();
			}		
		}else if (type.equals("1")) {
			String tusername=request.getParameter("tusername");			
			String tuphone=request.getParameter("tuphone");			
			String tumail=request.getParameter("tumail");
			String tname=request.getParameter("tname");
			String tsex=request.getParameter("tsex");
			String tage=request.getParameter("tage");
			User tuser = new User();
			tuser.setUID(uid);
			tuser.setUsername(tusername);
			tuser.setUphone(tuphone);
			tuser.setUmail(tumail);
			Teacher teacher = new Teacher();
			teacher.setTname(tname);
			teacher.setTsex(tsex);
			teacher.setTage(tage);			
			try {
				boolean flag = service.updateTeacher(tuser,teacher) ;
				if(flag){							
					request.getRequestDispatcher("BbsbaseServ").forward(request, response);
				}else{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.logger.error(e.getMessage());
			} catch (SQLException e) {			 
				e.printStackTrace();
			}		
		}
	}
}		

