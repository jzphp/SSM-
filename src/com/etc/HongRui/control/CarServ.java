package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.User;
import com.etc.HongRui.entiry.shoplist;
import com.etc.HongRui.service.CarService;
import com.etc.HongRui.util.Log;

/**
 * Servlet implementation class CarServ
 */
@WebServlet("/CarServ")
public class CarServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 在添加购物车的时候要检测购物车里面有没有这个视频如果有这个视频则提示购物车里面存在，提示不用添加，购物车已经存在
		// 在添加购物车的时候要检测订单详情有没有购买记录，购买过就不需要购买

		// 由DeleServ调到CarServ只能在get方法里

		// ----该方法是显示购物车的记录
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {

			String uid = user.getUID();
			CarService service = new CarService();
			List<shoplist> list = null;
			try {
				list = service.getlist(uid);
				request.setAttribute("list", list);
				request.getRequestDispatcher("shop.jsp").forward(request, response);
			} catch (Exception e) {
				Log.logger.debug(e.getMessage());
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 显示用户购物车的详细信息
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {

			String uid = user.getUID();
			CarService service = new CarService();
			List<shoplist> list = null;

			try {
				list = service.getlist(uid);
				request.setAttribute("list", list);
				request.getRequestDispatcher("shop.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("login.jsp");
		}

		// 在添加购物车的时候要检测购物车里面有没有这个视频如果有这个视频则提示购物车里面存在，不用添加

	}
}
