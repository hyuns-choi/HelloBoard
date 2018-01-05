package com.oraclejava.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oraclejava.model.Bbs;
import com.oraclejava.model.BbsDao;
import com.oraclejava.model.BbsFile;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/bbs/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null){
			response.sendRedirect(request.getContextPath() + "/account/login.jsp");
			return;
		}
		
		String no = request.getParameter("bbsno");
		BbsDao dao = new BbsDao();
		Bbs bbs = dao.selectBbsByBbsNo(Integer.parseInt(no));
		
		dao.updateReadCount(Integer.parseInt(no));
		
		List<BbsFile> files = dao.selectBbsFilesByBbsNo(bbs.getBbsno());
		
		request.setAttribute("bbs", bbs);
		request.setAttribute("files", files);
		
		getServletContext().getRequestDispatcher("/bbs/detail.jsp").forward(request, response);
		
		// 페이지이동
		//getServletContext().getRequestDispatcher("/bbs/writeform.jsp").forward(request, response);
	}
}
