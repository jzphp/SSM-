package com.etc.HongRui.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.Invatition;
import com.etc.HongRui.service.AdminLService;
import com.etc.HongRui.util.Log;
@WebServlet("/AdminL")
public class AdminL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {	

	}
		
	

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
	String ptheme = request.getParameter("ptheme")==""?null:request.getParameter("ptheme");
	String pID =request.getParameter("pID")==""?null:request.getParameter("pID");
	AdminLService service  =  new AdminLService();
	List<Invatition> list=null;
	try {
		if(ptheme==null && pID==null) {
			list =service.getInvatition();
			request.setAttribute("list",list);
			request.getRequestDispatcher("admin/luntan.jsp").forward(request, response);
		}else if(ptheme!=null && pID==null) {
			list=service.getInvatition1(ptheme);
			request.setAttribute("list",list);
			request.getRequestDispatcher("admin/luntan.jsp").forward(request, response);
		}else if(ptheme==null && pID!=null) {
			list=service.getInvatition2(pID);
			request.setAttribute("list",list);
			request.getRequestDispatcher("admin/luntan.jsp").forward(request, response);
		}else if(ptheme!=null && pID!=null) {
			list=service.getInvatition3(ptheme, pID);
			request.setAttribute("list",list);
			request.getRequestDispatcher("admin/luntan.jsp").forward(request, response);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		Log.logger.debug(e.getMessage());
	}
}

}