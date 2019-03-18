package com.servlet;

import java.io.IOException;
import java.text.ParseException;
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
import com.dao.SortMess;
import com.po.Collection;
import com.po.Mess;

/**
 * Servlet implementation class DeleteCollection
 */
@WebServlet("/DeleteCollection")
public class DeleteCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Collection>collectlist;
	ArrayList<Mess>messlist;
	ArrayList<Mess>recomm_messlist;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCollection() {
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
		MessDao messdao=new MessDao();
		String userId=(String)session.getAttribute("userId");
		String md=request.getParameter("md");
		int collcount;
		try{
			collectdao.deleteCollection(userId, md);
			collectlist=collectdao.queryCollection(userId);
			session.setAttribute("collectlist", collectlist);
			
			collcount=collectdao.countCollection(md);
			messdao.alterCollCount(collcount, md);
			
			messlist=messdao.queryMess();
			if(messlist!=null&messlist.size()>0){
				SortMess.sortMessByTime(messlist,0,messlist.size()-1);
			}
			session.setAttribute("messlist", messlist);
			
			recomm_messlist=messdao.queryMess();
			if(recomm_messlist!=null&recomm_messlist.size()>0){
				SortMess.sortMessByLike(recomm_messlist,0,recomm_messlist.size()-1);
			}
			session.setAttribute("recomm_messlist", recomm_messlist);
			
			response.sendRedirect("crowdfunding.center/outbox.jsp");/*跳转至用户收藏文章的个人界面*/
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ParseException e){
			e.printStackTrace();
		}
	}

}
