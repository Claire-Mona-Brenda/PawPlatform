package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SortTopic;
import com.dao.TopicDao;
import com.po.Comment;
import com.po.Topic;

/**
 * Servlet implementation class InitTopic
 */
@WebServlet("/InitTopic")
public class InitTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Topic>topiclist;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitTopic() {
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
		String userId=(String)session.getAttribute("userId");
		try{
			topiclist=topicdao.queryTopic();
			if(topiclist!=null&topiclist.size()>0){
				SortTopic.sortTopicByCommCount(topiclist, 0, topiclist.size()-1);
		    }
			session.setAttribute("topiclist", topiclist);
			if(userId==null){
				response.sendRedirect("topic.jsp");
			}
			else{
				response.sendRedirect("topic - login.jsp");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
