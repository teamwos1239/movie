package com.chinasofti.moviesell.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UpdatePicServlet
 */
public class UpdatePicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePicServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		

		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(this.getServletConfig(), request, response);
		smartUpload.setAllowedFilesList("jpg,JPG");
		try {
			smartUpload.upload();
		} catch (SecurityException e) {

			request.setAttribute("errorCode","1105" );
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/admin_updatemoviepic.jsp");
			dispatcher.forward(request, response);
			
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Request req = smartUpload.getRequest();
		// 新的文件的名字
		String picName = req.getParameter("picName").toString();
		// 文件的目录名
		String picDir = "";

		if (req.getParameter("picDir") != null) {
			picDir = req.getParameter("picDir").toString();
		}
		
		
		
		
		File uploadPic = smartUpload.getFiles().getFile(0);
		String pic =picName + "." + uploadPic.getFileExt();
		
		
		String savepath="pic/pictures/" + picDir + "/" + pic;

		String proPath=request.getServletContext().getRealPath("");
		java.io.File fileDir = new java.io.File(proPath+"/pic/pictures/" + picDir);
		if(fileDir.isDirectory()){
			
		}else{
			fileDir.mkdir();
		}
		
		
		try {
			uploadPic.saveAs(savepath);
			
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			request.setAttribute("errorCode","1010" );
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/admin_updatemoviepic.jsp");
			dispatcher.forward(request, response);
			
		}
		int mno=Integer.parseInt(req.getParameter("mno").toString());
		request.setAttribute("errorCode", "0000");
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/admin_updatemoviepic.jsp?mpicpath="+picDir+"&&mno="+mno);
		dispatcher.forward(request, response);
		

	}

}
