package com.oraclejava.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclejava.model.AlreadyEntryExcption;
import com.oraclejava.model.Encryption;
import com.oraclejava.model.Member;
import com.oraclejava.model.MemberService;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/account/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MemberService service = new MemberService();
			Member member = new Member();
			
			
			final String algorithmName = "SHA-256";
			final String password = "p12345";
			
			Encryption e = new Encryption(algorithmName);
			byte[] bytes = e.toHashValue(request.getParameter("passwd"));
			String result = e.toEncryptedString(bytes);
			//System.out.println(result);
			
			member.setMemberid(request.getParameter("memberid"));
			member.setPasswd(result);
			member.setEmail(request.getParameter("email"));
			member.setUsertype("user");
			member.setActive("1");
			
			service.insertMember(member);
			
			response.sendRedirect(request.getContextPath() + "/account/login.jsp");
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}
}
