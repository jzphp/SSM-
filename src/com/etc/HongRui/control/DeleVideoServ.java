package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.service.DeleService;

/**
 * Servlet implementation class ShaChu
 */
@WebServlet("/DeleVideoServ")
public class DeleVideoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleVideoServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoID = request.getParameter("id").toString();
		String type = request.getParameter("type");
		String str = request.getParameter("strs");
		DeleService service = new DeleService();
	
		if (type.equals("deleone")) {// 删除一条信息
			int count = service.dele(videoID);
			if (count != 0) {
				request.setAttribute("result", "成功删除" + count + "条信息！！id值为" + videoID);
				request.getRequestDispatcher("ShowVideoServ").forward(request, response);
			} else {
				request.setAttribute("result", "删除失败！");
				request.getRequestDispatcher("admin/video-del.jsp").forward(request, response);
			}
		} else {// 删除多条信息
			System.out.println(str);
			int count = 0;
			try {
				count = service.delechoice(str);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (count > 0) {
				request.setAttribute("result", "成功删除" + count + "条数据！");
				request.getRequestDispatcher("ShowVideoServ").forward(request, response);
			} else {
				request.setAttribute("result", "删除失败！");
				request.getRequestDispatcher("admin/video-del.jsp").forward(request, response);
			}
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
