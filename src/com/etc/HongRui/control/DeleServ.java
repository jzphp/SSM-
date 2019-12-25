package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.service.CarService;

/**
 * Servlet implementation class DeleServ
 */
@WebServlet("/DeleServ")
public class DeleServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String id = request.getParameter("id") ;
		 String typeString = request.getParameter("type") ;
		 CarService service=new CarService();
		 //根据传过来的参数进行删除
		 if(typeString.equals("deleone")) {//---删除一条记录
			 int idtrue = 0 ;
			  int count = service.dele(id) ;
			  if(count != 0){
				request.setAttribute("result", "成功删除" + count + "条信息！！id值为" + idtrue); 		 
				request.getRequestDispatcher("CarServ").forward(request,response);		  
		     }else{
			  request.setAttribute("result", "删除失败"  );
			  request.getRequestDispatcher("shop.jsp").forward(request,response);
		     }
		 }else{//--删除多条记录
			 String strs = request.getParameter("strs") ;
			 System.out.println(strs);
			 try {
				int count = service.delechoice(strs);
				if(count > 0){
					request.setAttribute("result", "成功删除" + count + "条数据！！！");
					 request.getRequestDispatcher("CarServ").forward(request, response);
				}else{
					request.setAttribute("result", "删除失败！！！"  );
					 request.getRequestDispatcher("shop.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
