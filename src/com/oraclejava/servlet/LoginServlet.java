package com.oraclejava.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oraclejava.model.Encryption;
import com.oraclejava.model.Member;
import com.oraclejava.model.MemberDao;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("memberid");
		String passwd = request.getParameter("passwd");
		
		//HttpSession session1 = request.getSession();
		//session1.invalidate();
		
		final String algorithmName = "SHA-256";
		//final String password = "p12345";
		
		Encryption e = new Encryption(algorithmName);
		byte[] bytes = e.toHashValue(passwd);
		String result = e.toEncryptedString(bytes);
		//System.out.println(result);
		
		
		
		MemberDao dao = new MemberDao();
		
		//if(id.equals("oraclejava") && passwd.equals("1")) {
		if(dao.selectMemberByIdAndPassword(id, result) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", id);
			response.sendRedirect(request.getContextPath());
		}
		else {
			response.sendRedirect(request.getContextPath()+"/account/login.jsp");
		}		
	}
}
