package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.Video;
import com.etc.HongRui.service.DeleService;

/**
 * Servlet implementation class DeleServ
 */
@WebServlet("/ShowVideoServ")
public class ShowVideoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowVideoServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String vid = request.getParameter("id") == ""? null :request.getParameter("id");
		String vname = request.getParameter("name") == ""? null :request.getParameter("name");
		
		List<Video> list = null;

		DeleService service = new DeleService();

		try {
			if(vid == null && vname == null) {
				list = service.getlist();
				request.setAttribute("list", list);
				request.getRequestDispatcher("admin/video-del.jsp").forward(request, response);
			}else if(vid != null && vname == null) {
				list = service.getlist1(vid);
				request.setAttribute("list", list);
				request.getRequestDispatcher("admin/video-del.jsp").forward(request, response);
			}else if(vid == null && vname != null) {
				list = service.getlist2(vname);
				request.setAttribute("list", list);
				request.getRequestDispatcher("admin/video-del.jsp").forward(request, response);
			}else if(vid != null && vname != null) {
				list = service.getlist3(vid , vname);
				request.setAttribute("list", list);
				request.getRequestDispatcher("admin/video-del.jsp").forward(request, response);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
