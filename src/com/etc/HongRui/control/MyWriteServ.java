package com.etc.HongRui.control;
/**
 * bbs个人中心中我的帖子的控制器
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.Invatition;
import com.etc.HongRui.entiry.User;
import com.etc.HongRui.service.BbsService;
import com.etc.HongRui.service.PublishComment;
import com.etc.HongRui.util.Log;

/**
 * Servlet implementation class MyWriteServ
 */
@WebServlet("/MyWriteServ")
public class MyWriteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyWriteServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PublishComment service = new PublishComment();
		BbsService bbsService = new BbsService();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String p = request.getParameter("page") == null ? "1" : request.getParameter("page");
		int page = Integer.parseInt(p);
		// 存储当前页数据
		request.setAttribute("page", page);
		// 存储下一页
		request.setAttribute("next", page + 1);
		// 存储上一页
		request.setAttribute("up", page - 1);
		int count = 0;
		// 获取到总页数
		try {
			count = bbsService.getPage(10);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.setAttribute("pageall", count);
		
		
		
		
		User user = (User) request.getSession().getAttribute("user");
		List<Invatition> list = null;
		if (user!=null) {
			String UID = user.getUID();
			try {
				list = service.getInvatitions(UID,page,10);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}
			request.setAttribute("list",list);
			request.setAttribute("user", user);
			request.getRequestDispatcher("bbs/myWrite.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
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
