package com.etc.HongRui.control;

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
import com.etc.HongRui.entiry.ViewComment;
import com.etc.HongRui.service.BbsService;
import com.etc.HongRui.service.FiltrationService;
import com.etc.HongRui.service.ViewCommentService;
import com.etc.HongRui.util.GetID;
import com.etc.HongRui.util.Log;
import com.etc.HongRui.util.getDate;

/**
 * Servlet implementation class ViewCommentServ
 */
@WebServlet("/ViewCommentServ")
public class ViewCommentServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewCommentServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		// TODO Auto-generated method stub
		String PID = request.getParameter("PID");
		ViewCommentService service = new ViewCommentService();
		User user = (User) request.getSession().getAttribute("user");
		Invatition invatition = null;
		List<ViewComment> list = null;
		try {
			list = service.getComments(PID, page, 10);
			invatition = service.getInvatition(PID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}

		try {
			list = service.setUsername(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
		request.setAttribute("list", list);
		request.setAttribute("user", user);
		request.getSession().setAttribute("invatition", invatition);
		request.setAttribute("invatition", invatition);
		request.getRequestDispatcher("bbs/CommentView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Invatition invatition = (Invatition) request.getSession().getAttribute("invatition");
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			request.setAttribute("user", user);
			String PID = invatition.getPID();
			String CID = GetID.getID();
			String UID = user.getUID();
			String CText = null;
			String CTime = null;
			ViewCommentService service = new ViewCommentService();
			CText = request.getParameter("context").trim();
			FiltrationService service2 = new FiltrationService();
			try {
				CText = service2.Filtration(CText);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}
			CTime = getDate.GetDate();
			ViewComment viewComment = new ViewComment();
			viewComment.setPID(PID);
			viewComment.setCID(CID);
			viewComment.setUID(UID);
			viewComment.setCText(CText);
			viewComment.setCTime(CTime);
			boolean flag = false;
			try {
				flag = service.writeComment(viewComment);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}
			if (flag) {
				response.sendRedirect("ViewCommentServ?PID=" + PID);
			} else {
				request.getRequestDispatcher("bbs/gentie.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
