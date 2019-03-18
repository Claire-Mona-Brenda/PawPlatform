package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.po.User;

/**
 * Servlet implementation class RetrievePasswordServlet
 */
@WebServlet("/RetrievePasswordServlet")
public class RetrievePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrievePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		HttpSession session=request.getSession();
		UserDao userdao=new UserDao();
		User user=null;
		try{
			user=userdao.queryUserInfo(userId);
			if(user==null){
				response.sendRedirect("register.jsp");/*该用户不存在*/
			}
			else{
				session.setAttribute("password", user.getPassword());
				response.sendRedirect("getpassword-success.jsp");/*找回密码页面*/
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
