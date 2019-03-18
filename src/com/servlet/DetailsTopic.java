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

import com.dao.MessDao;
import com.dao.SortTopic;
import com.dao.TopicDao;
import com.po.Evaluate;
import com.po.Mess;
import com.po.Topic;

/**
 * Servlet implementation class DetailsTopic
 */
@WebServlet("/DetailsTopic")
public class DetailsTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Topic>topiclist;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsTopic() {
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
		String userId=(String)session.getAttribute("userId");
		TopicDao topicdao=new TopicDao();
		Topic detailTopic=null;
		String td=(String)request.getParameter("td");
		int scan;
		try{
			detailTopic=topicdao.queryTopic(td);
			topicdao.alterTopicScan(1, td);
			scan=topicdao.queryTopicScan(td);
			
			topiclist=topicdao.queryTopic();
			if(topiclist!=null&topiclist.size()>0){
				SortTopic.sortTopicByCommCount(topiclist, 0, topiclist.size()-1);
				}
			
			session.setAttribute("topiclist", topiclist);
			application.setAttribute("topiclist", topiclist);
			application.setAttribute("scan"+td, scan);
			session.setAttribute("detailTopic"+td, detailTopic);
			session.setAttribute("id", td);
			if(userId==null)
				response.sendRedirect("topic -details.jsp");
			else
				response.sendRedirect("topic -details -login.jsp");
			/*跳转至具体展示用户分享的某一篇文章的页面*/
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
