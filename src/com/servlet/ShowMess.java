package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MessDao;
import com.dao.SortMess;
import com.po.Mess;
import com.po.User;

/**
 * Servlet implementation class ShowMess
 */
@WebServlet("/ShowMess")
public class ShowMess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Mess>messlist;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMess() {
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
		String userId=(String)session.getAttribute("userId");
		MessDao messdao=new MessDao();
		try{
			messlist=messdao.queryMess();
			if(messlist!=null&messlist.size()>0){
				SortMess.sortMessByTime(messlist,0,messlist.size()-1);
			}
			session.setAttribute("messlist", messlist);
			
			if(userId==null)
				response.sendRedirect("finding.jsp");
			else
				response.sendRedirect("finding -login.jsp");/*跳转至展示所有用户分享文章的页面*/
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		
	}

}
