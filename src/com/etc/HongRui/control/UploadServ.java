package com.etc.HongRui.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HongRui.entiry.User;
import com.etc.HongRui.entiry.Video;
import com.etc.HongRui.service.UploadService;
import com.etc.HongRui.util.ConvertJSON;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUploadException;
import com.etc.HongRui.util.Log;
import com.etc.HongRui.util.GetID;

/**
 * Servlet implementation class uploadServ
 */
@WebServlet("/UploadServ")
public class UploadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			String UID = user.getUID();
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			UploadService service = new UploadService();
			String type = request.getParameter("type") == "" ? "0" : request.getParameter("type");
			String CCtype = request.getParameter("CCtype") == ""? "0" : request.getParameter("CCtype");
			String Ctype = request.getParameter("Ctype") == ""? "0" : request.getParameter("Ctype");
			ArrayList<String> list = null;
			if (type.equals("1")) {
				try {
					list = service.getFname(UID, list);
					if (list != null) {
						response.getWriter().append(ConvertJSON.convertList(list));
					} else {
						response.getWriter().append(null);
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.logger.debug(e.getMessage());
				}
			}
			if (type.equals("2")) {
				try {
					list = service.getSname(CCtype, UID, list);
					if (list != null) {
						response.getWriter().append(ConvertJSON.convertList(list));
					} else {
						response.getWriter().append(null);
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.logger.debug(e.getMessage());
				}
			}
			if (type.equals("3")) {
				try {
					list = service.getTname(CCtype, Ctype, UID, list);
					if (list != null) {
						response.getWriter().append(ConvertJSON.convertList(list));
					} else {
						response.getWriter().append(null);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.logger.debug(e.getMessage());
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		UploadService service = new UploadService();
		if (user != null) {
			String UID = user.getUID();
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			SmartUpload su = new SmartUpload();
			su.initialize(this.getServletConfig(), request, response);
			try {
				su.upload();
			} catch (SmartUploadException e) {
				Log.logger.debug(e.getMessage());
				e.printStackTrace();
			}
			
			String videoLength = su.getRequest().getParameter("videoLength");
			String Cname = su.getRequest().getParameter("Cname");
			String CID = null;
			String filepathString= null;
			String videoName =su.getRequest().getParameter("videoName");
			String viodeoID = GetID.getID();
			try {
				CID = service.getCID(Cname, UID);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Files files = su.getFiles();
			com.jspsmart.upload.File file = files.getFile(0);
			try {
				filepathString = basePath+"video/"+file.getFileName();
				file.saveAs("./video/"+file.getFileName());
			} catch (SmartUploadException e) {
				Log.logger.debug(e.getMessage());
				e.printStackTrace();
			}
			Video video = new Video();
			video.setCID(CID);
			video.setPath(filepathString);
			video.setVideoName(videoName);
			video.setVideoID(viodeoID);
			video.setVLength(videoLength);
			boolean flag = false;
			try {
				flag = service.upload(video);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (flag) {
				response.sendRedirect("BbsHomeServ");
				//request.getRequestDispatcher("BbsHomeServ").forward(request, response);
			}else {
				response.sendRedirect("bbs/upload.jsp");
			}
		}
	}

}
