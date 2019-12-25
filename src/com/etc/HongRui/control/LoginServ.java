package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.User;
import com.etc.HongRui.service.LoginService;
import com.etc.HongRui.util.Log;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
//如果不存在@WebServlet("/LoginServ")则需要在web.xml进行配置
/*
 * <servlet>
 * <servlet-name>loginServ</servlet-name>
 *   <servlet-class>com.etc.HongRui.control.LoginServ</servlet-class>
 *  </servlet>
 *  <servlet-mapping>
 *     <servlet-name>loginServ</servlet-name>
 *     <url-pattern>/LoginServ</url-pattern>
 *  </servlet-mapping>
 * */
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
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
		//处理乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//从页面中获取到需要的参数信息
		String username=request.getParameter("username");
		String pwd=request.getParameter("upwd");
		//需要创建user对象
		//创建一个逻辑层的对象
		LoginService service =new LoginService();
		try {
			
			User user= service.login(username,pwd) ;
			if(user!=null){
			//将用户对象存储到session
			   request.getSession().setAttribute("user", user);
			   String model = request.getParameter("model")=="" ? "index":request.getParameter("model");
			   //将登录成功的信息添加到Cookie中
			   //创建一个Cookie对象
			   Cookie cookie =  new Cookie("mycookie", user.getUsername() + "," + user.getUpwd()) ;
			   //设置自动登录的时间
			   cookie.setMaxAge(180);
			   //在浏览器端添加cookie对象
			   response.addCookie(cookie);
			   request.getRequestDispatcher("MainServ?model="+model).forward(request, response);
			}else{
			   request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.error(e.getMessage());
			
		} catch (SQLException e){
			 
			e.printStackTrace();
		}
		
		
	}

}
