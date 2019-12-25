package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.HongRui.entiry.Order;
import com.etc.HongRui.entiry.User;
import com.etc.HongRui.service.PayService;
import com.etc.HongRui.util.Log;

/**
 * Servlet implementation class PayServ
 */
@WebServlet("/PayServ")
public class PayServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServ() {
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
		// TODO Auto-generated method stub
		//由order.jsp 页面，点击付款   信息提交的这
		
		PayService service=new PayService();
		HttpSession session=request.getSession();
		List<Order>  ods=(List<Order>) session.getAttribute("orderlist");//在checkOutServ 接收
		User user=(User)request.getSession().getAttribute("user");
		String uid=user.getUID();
		float total = 0;
		float account=0;
		String type=null;
		boolean flag=false;
		//for (循环变量类型 循环变量名称 : 要被遍历的对象)  循环体  for(OrderDetail od: ods)
		for(Order od: ods) {
			type=od.getType();
			total+=od.getCprice();
		}
		//由于涉及多条记录，所以使用list进行传参
		List<String> cid=(List<String>) ods.stream().map(Order::getCid).collect(Collectors.toList());
		List<String> tid=(List<String>) ods.stream().map(Order::getTid).collect(Collectors.toList());
		List<String> time=(List<String>) ods.stream().map(Order::getDeta).collect(Collectors.toList());
		ArrayList<Float> price=(ArrayList<Float>)ods.stream().map(Order::getCprice).collect(Collectors.toList());
		List<String> gid=(List<String>) ods.stream().map(Order::getGid).collect(Collectors.toList());
		request.getSession().setAttribute("cid", cid);
		//先判断账户余额
		try {
			account=service.getacconut(uid, type);
			account=account-total;
			if(account<0) {
				request.getRequestDispatcher("shoperror.jsp").forward(request, response);
			}else {
				try {
					flag=service.shiwu(price,type,uid, cid, tid , time,gid);
					if(flag) {
						//订单详情在OrderDetailServ进行处理
						//付款成功后，跳转到OrderDetailServ对订单详情进行显示
						response.sendRedirect("OrderDetailServ");
					}else {
						//付款没成功，调到购物车界面重新购买
						request.getRequestDispatcher("shop.jsp").forward(request, response);
					}
				} catch (SQLException e) {
					Log.logger.debug(e.getMessage());
					e.printStackTrace();
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
