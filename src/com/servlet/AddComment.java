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
import com.dao.SortMess;
import com.dao.SortTopic;
import com.dao.TopicDao;
import com.po.Comment;
import com.po.Mess;
import com.po.Topic;
import com.po.User;

/**
 * Servlet implementation class AddComment
 */
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Comment> commentlist;
	ArrayList<Mess> messlist;
	ArrayList<Topic>topiclist;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComment() {
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
		String username=(String)session.getAttribute("username");
		String userId=(String)session.getAttribute("userId");
		String url=(String)session.getAttribute("url");
		if(userId==null){
			response.sendRedirect("login.jsp");
		}
		else{
			String avatar=(String)session.getAttribute("avatar");
			String id=(String)session.getAttribute("id");
			String content=new String(request.getParameter("content").getBytes("iso-8859-1"),"utf-8");
			if(content==null||content.trim().equals("")){
				session.setAttribute("contwarn", "内容为空");
				response.sendRedirect(url);
			}
			else{
			try{
				topicdao.addComment(content, username, avatar, id, userId);
				commentlist=topicdao.queryComment(id);
				SortCommTime.sort(commentlist, 0, commentlist.size()-1);/*评论排序*/
				
				int commcount=commentlist.size();
				topicdao.alterCommCount(commcount, id);/*commentlist修改commcount*/
				topicdao.alterTopiclistCommCount(commcount, id);/*topiclist修改commcount*/
				messdao.alterCommcount(commcount, id);/*messlist修改commcount*/
				
				messlist=messdao.queryMess();
				if(messlist!=null&messlist.size()>0){
					SortMess.sortMessByTime(messlist,0,messlist.size()-1);
				}
				topiclist=topicdao.queryTopic();
				if(topiclist!=null&topiclist.size()>0){
					SortTopic.sortTopicByCommCount(topiclist, 0, topiclist.size()-1);
					}
				
				
				session.setAttribute("commentlist"+id, commentlist);
				session.setAttribute("messlist", messlist);
				session.setAttribute("topiclist", topiclist);
				session.setAttribute("url", null);
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
		
		
	}

}
