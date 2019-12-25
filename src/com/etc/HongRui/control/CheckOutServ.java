package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.Order;
import com.etc.HongRui.entiry.User;
import com.etc.HongRui.service.CheckOutService;
import com.etc.HongRui.util.Log;

/**
 * Servlet implementation class CheckOutServ
 */
@WebServlet("/CheckOutServ")
public class CheckOutServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CheckOutServ-------doget");
		//---提交订单时，根据传过来的参数进行选择---传过来的是购物车的oid连接的String
		//----由shop.jsp点击提交过来，
		User user=(User)request.getSession().getAttribute("user");
		
		String uid=user.getUID();		
		String b=request.getParameter("b");
		  CheckOutService service=new CheckOutService(); 
		  List<Order> orderlist =null;
		  try { 
			  orderlist=service.getlist(b,uid);
			  request.getSession().setAttribute("orderlist", orderlist);
			  //将选中的记录在order.jsp显示
			  request.getRequestDispatcher("order.jsp").forward(request, response); 
		  } catch(SQLException e) {
			  Log.logger.debug(e.getMessage());
			  e.printStackTrace();
		  }
		 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("check---dopost");
	}

}
