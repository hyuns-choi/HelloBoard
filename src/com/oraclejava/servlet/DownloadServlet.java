package com.oraclejava.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclejava.model.BbsDao;
import com.oraclejava.model.BbsFile;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/bbs/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String no = request.getParameter("bbsfileno");
		BbsDao dao = new BbsDao();
		BbsFile bbsfile = dao.selectBbsFilesByFileNo(Integer.parseInt(no));
		
		dao.updateDownloadCount(Integer.parseInt(no));
		
		
		String file = "c:/upload/" + bbsfile.getSavedFileName();
		
		byte[] b = new byte[4096];
		FileInputStream fileInputStream = new FileInputStream(file);
		
		String mimetype = getServletContext().getMimeType(file);
		if(mimetype == null) {
			// 무조건 다운로드
			mimetype = "application/octet-stream";
		}
		
		response.setContentType(mimetype);
		
		// 한글파일명 인코딩
		String filename = URLEncoder.encode(bbsfile.getUserFileName(), "UTF-8");
		  response.setContentType(mimetype + "; charset=UTF-8");
		  
		  response.setHeader("Content-Disposition", 
		    "attachment; filename=" + filename);

		/*
		response.setHeader("Content-Disposition", 
				"attachment; filename=" + bbsfile.getUserFileName()
				);
				*/
		
		ServletOutputStream servletOutputStream = response.getOutputStream();
		
		int numRead = 0;
		while((numRead = fileInputStream.read(b, 0, b.length)) != -1){
			servletOutputStream.write(b, 0, numRead);
		}
		
		servletOutputStream.flush();
		servletOutputStream.close();
		fileInputStream.close();
	}

}
