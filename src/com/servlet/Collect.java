package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.text.ParseException;

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
 * Servlet implementation class Collect
 */
@WebServlet("/Collect")
public class Collect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Collection>collectlist;
	ArrayList<Mess>messlist;
	ArrayList<Mess>recomm_messlist;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Collect() {
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
		String md=(String)request.getParameter("md");
		String url=(String)request.getParameter("url");
		String userId=(String)session.getAttribute("userId");
		String title=new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8");
		String writer=new String(request.getParameter("writer").getBytes("iso-8859-1"),"utf-8");
		Collection collection;
		int collcount;
		try{
			if(userId==null){
				collcount=collectdao.countCollection(md);
				messdao.alterCollCount(collcount, md);
				messlist=messdao.queryMess();
				session.setAttribute("messlist", messlist);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				/*Î´µÇÂ¼»Øµ½µÇÂ¼Ò³Ãæ*/
			}
			else{
				collection=collectdao.queryCollection(userId, md);
				collcount=collectdao.countCollection(md);
				if(collection.getUserId()==null&&collection.getMd()==null){
					collectdao.addCollection(userId, title, md, writer);
					collcount=collectdao.countCollection(md);
				}
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
				
				collectlist=collectdao.queryCollection(userId);
				session.setAttribute("collectlist", collectlist);
				
				request.getRequestDispatcher(url).forward(request, response);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ParseException e){
			e.printStackTrace();
		}
	}

}
