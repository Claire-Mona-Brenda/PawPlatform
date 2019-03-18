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
import com.dao.MessDao;
import com.dao.TopicDao;
import com.po.Comment;
import com.po.Mess;

/**
 * Servlet implementation class DetailCollection
 */
@WebServlet("/DetailCollection")
public class DetailCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Comment>commentlist;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailCollection() {
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
		TopicDao topicdao=new TopicDao();
		MessDao messdao=new MessDao();
		Mess detailCollect=null;
		String md=request.getParameter("md");
		try{
			detailCollect=messdao.queryMess(md);
			session.setAttribute("detailCollect", detailCollect);
			commentlist=topicdao.queryComment(md);
			session.setAttribute("commentlist"+md, commentlist);
			response.sendRedirect("collectarticle.jsp");/*转到具体某篇收藏的文章*/
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
