package com.etc.HongRui.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.User;
import com.etc.HongRui.entiry.Video;
import com.etc.HongRui.service.PlayService;
import com.etc.HongRui.service.PpService;

/**
 * Servlet implementation class PlayServ
 */
@WebServlet("/PlayServ")
public class PlayServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//获取课程价格和id
		String typeString=request.getParameter("price");
		String idString=request.getParameter("id");//课程ID
		//PrintWriter outPrintWriter = response.getWriter() ;
		//获取用户ID
		User user=(User)request.getSession().getAttribute("user");
		if (user!=null) {
			String uidString=user.getUID();
			if(typeString.equals("0.0")) {
				PlayService service=new PlayService();
				List<Video> list=null;
				try {
					list = service.getvideo(idString);
					request.setAttribute("item", list);
					request.getRequestDispatcher("sd/list.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else { 
				//response.getWriter().append("*******请购买后在进行观看，谢谢合作。***********").append(request.getContextPath());
				PpService service=new PpService();
				boolean flag=false;
				flag=service.getorder(idString,uidString);
				if (flag==true) {
					PlayService service1=new PlayService();
					List<Video> list;
					try {
						list = service1.getvideo(idString);
						request.setAttribute("item", list);
						request.getRequestDispatcher("sd/list.jsp").forward(request, response);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					PrintWriter out=response.getWriter();
					out.print("<script>alert('请购买后观看');window.location.href='IndexServ';</script>");
				}
			}
		}else {
			PrintWriter out=response.getWriter();
			out.print("<script>alert('请登录后观看');window.location.href='login.jsp';</script>");
			response.sendRedirect("login.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
