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
 * Servlet implementation class AlterAvatar
 */
@WebServlet("/AlterAvatar")
public class AlterAvatar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterAvatar() {
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
		UserDao userdao=new UserDao();
		String avatar=new String(request.getParameter("avatar").getBytes("iso-8859-1"),"utf-8");
		avatar="images/"+avatar;
		String userId=(String)session.getAttribute("userId");
		User user=null;
		try{
			if(avatar.equals("images/")){
				response.sendRedirect("crowdfunding.center/make_head.jsp");
			}
			else{
				userdao.alterAvatar(avatar, userId);
				session.setAttribute("avatar", avatar);
			    user=userdao.queryUserInfo(userId);
			    session.setAttribute("userinfo", user);
			    response.sendRedirect("crowdfunding.center/my_info.jsp");
			}
			/*修改成功，转到用户个人界面*/
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
