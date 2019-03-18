package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.po.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<String>ids;
	UserDao userdao=new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String username=new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8");
		String password=request.getParameter("password");
		String userId=request.getParameter("userId");
		HttpSession session=request.getSession();
		User user=new User();
		Pattern pattern1=Pattern.compile("^1[3|4|5|8][0-9]\\d{8}");
		Matcher match1=pattern1.matcher(userId);
		boolean judg_uid=match1.matches();
		Pattern pattern2=Pattern.compile("^[0-9a-zA-Z]{6}");
		Matcher match2=pattern2.matcher(password);
		boolean judg_pw=match2.matches();
		try{
			ids=userdao.queryId();
			for(int i=0;i<ids.size();i++){
				if((userId.equals(ids.get(i)))){
					response.sendRedirect("register-already.jsp");
					return;/*用户名重复，注册失败*/
					
				}
			}
			if(userId==null||userId.trim().equals("")||password.trim().equals("")||
					password==null||username.trim().equals("")||username==null||
					judg_uid==false||judg_pw==false||username.length()>50){
				
				if(username.length()>50){
					session.setAttribute("warn5", "用户昵称过长");
				}
				if(userId==null||userId.trim().equals("")||password.trim().equals("")||
						password==null||username.trim().equals("")||username==null){
					session.setAttribute("warn1", "三栏信息都不能为空");
				}
				if(judg_uid==false){
					session.setAttribute("warn2", "手机号输入不正确");
				}
				if(judg_pw==false){
					session.setAttribute("warn3", "密码输入不正确");
				}
				response.sendRedirect("register-warn.jsp");
				return;
			}
			else{
				userdao.addUser(username, password, userId);
				user.setId(userId);
				user.setPassword(password);
				user.setUserName(username);
				session.setAttribute("userinfo", user);
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("userId", userId);
				response.sendRedirect("login.jsp");
				return;
				/*注册成功*/
			
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
