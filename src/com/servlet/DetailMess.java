package com.servlet;

import java.io.IOException;



import java.sql.SQLException;
import java.util.ArrayList;

import java.text.ParseException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EvaluateDao;
import com.dao.MessDao;
import com.dao.SortMess;
import com.po.Evaluate;
import com.po.Mess;
import com.po.User;
/**
 * Servlet implementation class DetailMess
 */
@WebServlet("/DetailMess")
public class DetailMess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Mess>messlist;
	ArrayList<Mess>scan_messlist;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailMess() {
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
		String username=(String)session.getAttribute("username");
		MessDao messdao=new MessDao();
		Mess detailMess=null;
		String md=(String)request.getParameter("md");
		Evaluate evaluate=null;
		int scan;
		try{
			detailMess=messdao.queryMess(md);
			messdao.alterScan(1, md);
			scan=messdao.queryScan(md);
			messlist=messdao.queryMess();
			if(messlist!=null&messlist.size()>0){
				SortMess.sortMessByTime(messlist,0,messlist.size()-1);
			}
			session.setAttribute("messlist", messlist);
			/*少了按浏览排序*/
			scan_messlist=messdao.queryMess();
			if(scan_messlist!=null&scan_messlist.size()>0){
				SortMess.sortMessByScan(scan_messlist,0,scan_messlist.size()-1);
			}
			session.setAttribute("scan_messlist", scan_messlist);
			
			application.setAttribute("scan"+md, scan);
			session.setAttribute("detailMess"+md, detailMess);
			session.setAttribute("evaluate"+md, evaluate);
			session.setAttribute("id", md);
			if(username==null)
				response.sendRedirect("article -nologin.jsp");
			else
				response.sendRedirect("article.jsp");
			/*跳转至具体展示用户分享的某一篇文章的页面*/
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ParseException e){
			e.printStackTrace();
		}
	}

}
