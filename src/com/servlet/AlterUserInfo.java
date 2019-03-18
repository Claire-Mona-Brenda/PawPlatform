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
 * Servlet implementation class AlterUserInfo
 */
@WebServlet("/AlterUserInfo")
public class AlterUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterUserInfo() {
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
		HttpSession session=request.getSession();
		String username=new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8");
		String sex=new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");
		String sig=new String(request.getParameter("sig").getBytes("iso-8859-1"),"utf-8");
		String intro=new String(request.getParameter("intro").getBytes("iso-8859-1"),"utf-8");
		
		User user=(User)session.getAttribute("userinfo");
		String userId=(String)session.getAttribute("userId");
		UserDao userdao=new UserDao();
		try{
			if(username.length()>50){
				session.setAttribute("alteruserinfo-warn", "输入的用户昵称过长");
				response.sendRedirect("crowdfunding.center/my_info2-warn.jsp");
			}
			if(username.isEmpty()==false){
				userdao.alterUsername(userId, username);
				session.setAttribute("username", username);
			}
			if(sex.isEmpty()==false){
				userdao.alterSex(userId, sex);
			}
			if(sig.isEmpty()==false){
				userdao.alterSignature(userId, sig);
			}
			if(intro.isEmpty()==false){
				userdao.alterIntro(userId, intro);
			}
			user=userdao.queryUserInfo(userId);
			session.setAttribute("userinfo", user);
			response.sendRedirect("crowdfunding.center/my_info.jsp");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
	}

}
