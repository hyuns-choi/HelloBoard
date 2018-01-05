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

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/bbs/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")==null) {
			response.sendRedirect(request.getContextPath() + "/account/login.jsp");
			return;
		}
		
		BbsDao dao = new BbsDao();
		List<Bbs> list = dao.selectBbs();
		
		// 다음 페이지에만 유효한 세션값설정
		request.setAttribute("bbslist", list);
		// 페이지이동
		getServletContext().getRequestDispatcher("/bbs/list.jsp").forward(request, response);
			
	}

	
}
