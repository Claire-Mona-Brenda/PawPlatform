package com.servlet;

import java.io.IOException;



import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.po.User;

/**
 * Servlet implementation class LoignServlet
 */
@WebServlet("/LoignServlet")
public class LoignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoignServlet() {
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
		User user;
		HttpSession session=request.getSession();
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		String username=(String)session.getAttribute("username");
		UserDao userdao=new UserDao();
		try{
			user=userdao.queryUserInfo(userId);
			if(user==null)
				request.getRequestDispatcher("register.jsp").forward(request,response);/*账户不存在*/
			else{
				if((user.getId().equals(userId))&&(user.getPassword().equals(password))){
					user.setId(userId);
					user.setPassword(password);
					user.setUserName(username);
					if(userdao.queryAvatar(userId)==null||userdao.queryAvatar(userId).equals("")){
						user.setAvatar(User.getInitAvatar());
						userdao.alterAvatar(User.getInitAvatar(), userId);
					}
				    if(userdao.querySignature(userId)==null||userdao.querySignature(userId).equals("")){
						user.setSignature("坚持做一名认真负责的铲屎官。");
						userdao.alterSignature(userId, "坚持做一名认真负责的铲屎官。");
					}
					if(userdao.querySex(userId)==null||userdao.querySex(userId).equals("")){
						user.setSex("不告诉你");
						userdao.alterSex(userId, "不告诉你");
					}
					if(userdao.queryIntro(userId)==null||userdao.queryIntro(userId).equals("")){
						user.setIntro("家有萌萌的汪星人还是喵星人一只，你猜猜？");
						userdao.alterIntro(userId, "家有萌萌的汪星人还是喵星人一只，你猜猜？");
					}
					user=userdao.queryUserInfo(userId);
					session.setAttribute("userinfo", user);
					session.setAttribute("username", user.getUserName());
					session.setAttribute("password", user.getPassword());
					session.setAttribute("userId", userId);
					session.setAttribute("avatar", user.getAvatar());
					response.sendRedirect("index -login.jsp");/*登陆成功*/
				}
				else{
					response.sendRedirect("loginfailure.jsp");/*登录失败，密码或账号错误*/
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
