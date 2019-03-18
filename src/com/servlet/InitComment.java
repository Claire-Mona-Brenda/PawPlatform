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
import com.dao.SortCommTime;
import com.dao.TopicDao;
import com.po.Comment;
import com.po.Topic;

/**
 * Servlet implementation class InitComment
 */
@WebServlet("/InitComment")
public class InitComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Comment>commentlist;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitComment() {
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
		String url=request.getParameter("url");
		String id=(String)session.getAttribute("id");
		try{
			int commcount=0;
			commentlist=topicdao.queryComment(id);
			if(commentlist!=null&&commentlist.size()>0){
			    SortCommTime.sort(commentlist, 0, commentlist.size()-1);
			}
			if(commentlist!=null){
				commcount=commentlist.size();
			}
			topicdao.alterCommCount(commcount, id);
			commcount=topicdao.queryCommCount(id);
			
			messdao.alterCommcount(commcount, id);
			session.setAttribute("commentlist"+id, commentlist);
			response.sendRedirect(url);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ParseException e){
			e.printStackTrace();
		}
	}

}
