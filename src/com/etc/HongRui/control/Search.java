/*************************
*@className    Search.java
*@Date         2019年1月21日
*@author       jiazhi
*@version      V1.0
*@package_name com.etc.HongRui.control
************************/
package com.etc.HongRui.control;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etc.HongRui.entiry.Course;
import com.etc.HongRui.service.SearchService;
import com.etc.HongRui.util.Log;


@Controller
public class Search {
	@RequestMapping("/search")
	public String search(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		String result="";
		List<Course> list = null;
		request.setCharacterEncoding("utf-8");
		String string=request.getParameter("serach");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		SearchService service  = (SearchService) applicationContext.getBean("service");
		try {
			list = service.getsearch(string);
			request.setAttribute("list", list);
			//request.getRequestDispatcher("detailsearch.jsp").forward(request, response);
			result = "detailsearch.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}
		return result;
	}
}
