package com.oraclejava.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oraclejava.model.Member;
import com.oraclejava.model.MemberDao;

/**
 * Servlet implementation class GetMembers
 */
@WebServlet("/GetMembers")
public class GetMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMembers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("application/json;charset=utf-8");
		
		Gson gson = new Gson();
		
		/*
		Member member1 = new Member("fox1", "1111", "fox@naver.com", "user", "1", new Date());
		
		Member member2 = new Member("fox2", "1222", "fox2@naver.com", "user", "1", new Date());
		
		List<Member> userList = new ArrayList<>();
		userList.add(member1);
		userList.add(member2);
		
		try (PrintWriter out = response.getWriter()){
			out.print(gson.toJson(userList));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		*/
		
		MemberDao dao = new MemberDao();
		List<Member> userList = dao.selectMembers();
		
		try (PrintWriter out = response.getWriter()){
			out.print(gson.toJson(userList));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
