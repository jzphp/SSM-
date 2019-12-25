package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.User;
import com.etc.HongRui.service.CarService;
import com.etc.HongRui.service.OrderDetailService;

/**
 * Servlet implementation class addCarServ
 */
@WebServlet("/AddCarServ")
public class AddCarServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCarServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("model");
		String cid = request.getParameter("cid");
		System.out.println(type + "  " + cid);
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {

			String uid = user.getUID();
			// 在添加购物车的时候要检测购物车里面有没有这个视频如果有这个视频则提示购物车里面存在，提示不用添加，购物车已经存在
			// 在添加购物车的时候要检测订单详情有没有购买记录，购买过就不需要购买

			CarService service = new CarService();
			try {
				// 检测购物车有没有这条记录
				if (service.getRecord(uid, cid)) {
					// 购物车存在该条记录，跳转到shopexist.jsp，提示用户存在该条记录，不用添加购物车
					request.getRequestDispatcher("shopexist.jsp").forward(request, response);
				} else {
					// 购物车不存在这条记录，查看订单详情里面有没有这条记录
					OrderDetailService ser = new OrderDetailService();
					if (ser.getODetail(uid, cid)) {
						// 订单详情中存在，提示用户不需要购买
						request.getRequestDispatcher("ODetailexist.jsp").forward(request, response);
					} else {
						// 添加购物车
						if (service.getAddCar(uid, cid)) {
							// 添加购物车返回购物车界面--显示购物车的记录
							request.getRequestDispatcher("CarServ").forward(request, response);
						} else {
							// 添加购物车失败，返回
							request.getRequestDispatcher("AddCarError.jsp").forward(request, response);
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
		doGet(request, response);
	}

}
