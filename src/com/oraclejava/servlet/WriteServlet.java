package com.oraclejava.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.oraclejava.model.Bbs;
import com.oraclejava.model.BbsDao;
import com.oraclejava.model.BbsFile;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/bbs/write")
@MultipartConfig(
		fileSizeThreshold = 5_242_880, //5MB
		maxFileSize = 20_971_520L,	// 20mb
		maxRequestSize = 41_943_040L
)

public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null){
			response.sendRedirect(request.getContextPath() + "/account/login.jsp");
			return;
		}

		// 페이지이동
		getServletContext().getRequestDispatcher("/bbs/writeform.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part part = request.getPart("attach");
		
		// 파일 업로드
		
		String originalname = this.getFileName(part);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String now = formatter.format(date);
		String savedfilename = now + "_" + originalname;
		
		File file = new File("c:/upload/" + savedfilename);
		try(InputStream is = part.getInputStream()){
			Files.copy(is, file.toPath());
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Bbs bbs = new Bbs();
		bbs.setTitle(request.getParameter("title"));
		bbs.setUploader(request.getParameter("uploader"));
		bbs.setContent(request.getParameter("content"));
		
		BbsDao dao = new BbsDao();
		dao.insertBbs(bbs);
				

		BbsFile bbsFile = new BbsFile();
		bbsFile.setSavedFileName(savedfilename);
		bbsFile.setUserFileName(originalname);
		bbsFile.setBbsNo(bbs.getBbsno());
		dao.insertBbsFile(bbsFile);
		
		
		response.sendRedirect(request.getContextPath() + "/bbs/list");
	}

	private String getFileName(Part part) {
		// TODO Auto-generated method stub
		String name = null;
		for(String dispotion : part.getHeader("Content-Disposition").split(";")) {
			if(dispotion.trim().startsWith("filename")) {
				name = dispotion.substring(dispotion.indexOf('=')+1)
						.replace("\"", "").trim();
				name = name.substring(name.lastIndexOf("\\")+1);
			}				
		}
		return name;
	}

}
