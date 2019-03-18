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

import com.dao.CollectDao;
import com.po.Collection;

/**
 * Servlet implementation class InitCollection
 */
@WebServlet("/InitCollection")
public class InitCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Collection>collectlist;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitCollection() {
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
		CollectDao collectdao=new CollectDao();
		String url=(String)request.getParameter("url");
		String userId=(String)session.getAttribute("userId");
		try{
			collectlist=collectdao.queryCollection(userId);
			session.setAttribute("collectlist", collectlist);
			request.getRequestDispatcher(url).forward(request, response);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
