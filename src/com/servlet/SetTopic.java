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
import com.po.Topic;
import com.po.User;
/**
 * Servlet implementation class SetTopic
 */
@WebServlet("/SetTopic")
public class SetTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Topic>topiclist;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetTopic() {
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
		ServletContext application=this.getServletContext();
		TopicDao topicdao=new TopicDao();
		String pic=request.getParameter("pic");
		pic="images/"+pic;
		String content,title,username,userId;
		username=(String)session.getAttribute("username");
		userId=(String)session.getAttribute("userId");
		
		title=new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8");
		content=new String(request.getParameter("content").getBytes("iso-8859-1"),"utf-8");
		if(title.trim().equals("")||pic.equals("images/")){
			session.setAttribute("settopic-warn","标题和图片都不能为空");
			response.sendRedirect("publish -topic.jsp");/*回到发表讨论页面，提示用户添加标题*/
		}
		else{
			try{
				topicdao.setTopic(title, content, username, pic, userId);
				topiclist=topicdao.queryTopic();
				if(topiclist!=null&topiclist.size()>0){
					SortTopic.sortTopicByCommCount(topiclist, 0, topiclist.size()-1);
			    }
				session.setAttribute("topiclist", topiclist);
				application.setAttribute("topiclist", topiclist);
				response.sendRedirect("topic - login.jsp");/*回到讨论区*/
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		
	}

}
