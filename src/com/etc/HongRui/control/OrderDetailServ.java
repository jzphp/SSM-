package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.OrderDetail;
import com.etc.HongRui.entiry.User;
import com.etc.HongRui.service.OrderDetailService;
import com.etc.HongRui.util.Log;

/**
 * Servlet implementation class OrderDetail
 */
@WebServlet("/OrderDetailServ")
public class OrderDetailServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("user");
		String uid=user.getUID();
		List<OrderDetail> listod=null;
		OrderDetailService service=new OrderDetailService();
		 List<String> cid=(List<String>)request.getSession().getAttribute("cid");
		try {
			listod =service.getlist(uid,cid);
			request.setAttribute("listod", listod);
			request.getRequestDispatcher("orderdetail.jsp").forward(request, response);
		} catch (SQLException e) {

			Log.logger.error(e.getMessage());
			e.printStackTrace();
		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//读取订单编号
		//显示订单详情--由于需要读取订单编号，所以还需要重新读取数据库中订单详情表
		User user=(User)request.getSession().getAttribute("user");
		String uid=user.getUID();
		List<OrderDetail> listod=null;
		OrderDetailService service=new OrderDetailService();
		 List<String> cid=(List<String>)request.getSession().getAttribute("cid");
		try {
			listod =service.getlist(uid,cid);
			request.setAttribute("listod", listod);
			request.getRequestDispatcher("orderdetail.jsp").forward(request, response);
		} catch (SQLException e) {

			Log.logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

}
