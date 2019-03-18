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

import com.dao.EvaluateDao;
import com.dao.MessDao;
import com.dao.SortMess;
import com.po.Mess;
import com.po.User;

/**
 * Servlet implementation class ShareMess
 */
@WebServlet("/ShareMess")
public class ShareMess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Mess>messlist;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareMess() {
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
		MessDao messdao=new MessDao();
		
		
		String writer=(String)session.getAttribute("username");
		String userId=(String)session.getAttribute("userId");
		if(userId==null){
			response.sendRedirect("login.jsp");
		}/*未登录前不能发表文章*/
		String content=new String(request.getParameter("content").getBytes("iso-8859-1"),"utf-8");
		String title=new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8");
		String pic=new String(request.getParameter("pic").getBytes("iso-8859-1"),"utf-8");
		pic="images/"+pic;
		if(content.trim().equals("")||pic.trim().equals("images/")||title.trim().equals("")){
			session.setAttribute("sharemess-warn","发表的文章的内容、图片、标题都不能为空");
			response.sendRedirect("publish.jsp");/*发表的文章的内容、图片、标题都不能为空*/
		}
		else{
			try{
				if(pic.equals("images/")){
					messdao.addMess(writer, content, title);
				}
				else{
					messdao.addMess(writer, content, pic, title);
				}
				messlist=messdao.queryMess();
				if(messlist!=null&messlist.size()>0){
					SortMess.sortMessByTime(messlist,0,messlist.size()-1);
				}
				session.setAttribute("messlist", messlist);
				
				response.sendRedirect("finding -login.jsp");/*跳转至已登录首页*/
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
