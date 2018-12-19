package com.chinasofti.moviesell.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String picPath="";
		HttpSession session=request.getSession();
		if(session.getAttribute("picPath")!=null){
			picPath=session.getAttribute("picPath").toString().trim();
		}else{
			
		}
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(this.getServletConfig(), request, response);

		smartUpload.setAllowedFilesList("jpg,JPG");
		
		try {
			smartUpload.upload();
			String[] lstUploadName=new String[12];
			
			//poster
			File uploadFile=smartUpload.getFiles().getFile(0);
			String fileName = smartUpload.getFiles().getFile(0).getFilePathName();
			lstUploadName[0]=fileName;
			String fileExt = uploadFile.getFileExt();
			fileName = "poster" + "." + fileExt;
			uploadFile.saveAs("/pic/pictures/"+picPath+"/" + fileName);
			
			//infoposter
			uploadFile=smartUpload.getFiles().getFile(1);
			fileName = smartUpload.getFiles().getFile(1).getFieldName();
			lstUploadName[1]=fileName;
			fileExt = uploadFile.getFileExt();
			fileName = "infoposter" + "." + fileExt;
			uploadFile.saveAs("/pic/pictures/"+picPath+"/" + fileName);
		 
			//info1
			for (int i = 1; i <=10; i++) {
					
				uploadFile=smartUpload.getFiles().getFile(i+1);
				fileName = smartUpload.getFiles().getFile(1+1).getFieldName();
				lstUploadName[i+1]=fileName;
				fileExt = uploadFile.getFileExt();
				fileName = "info"+i + "." + fileExt;
				uploadFile.saveAs("/pic/pictures/"+picPath+"/" + fileName);

			}
			  
			request.setAttribute("lstUploadName", lstUploadName);
			RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/admin/admin_addmoviepic.jsp?errorCode=0000");
			dispatcher.forward(request, response);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			sendPage(e.getMessage(), response);
		}
	}
	
 
	private void sendPage(final String errorMessage,final HttpServletResponse response) {
		int errorCode = Integer.parseInt(errorMessage.substring(errorMessage.length() - 6, errorMessage.length() - 2));
		try {
			response.sendRedirect("jsp/admin/admin_addmoviepic.jsp?errorCode=" + errorCode);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
