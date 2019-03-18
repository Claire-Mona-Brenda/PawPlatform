package com.servlet;

import java.io.IOException;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

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
 * Servlet implementation class EDetailMess
 */
@WebServlet("/EDetailMess")
public class EDetailMess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Mess> messlist;
	ArrayList<Mess> recomm_messlist;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EDetailMess() {
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
		EvaluateDao evadao=new EvaluateDao();
		Evaluate eva;
		String userId=(String)session.getAttribute("userId");
		String md=request.getParameter("md");
		String url=request.getParameter("url");
		String value=request.getParameter("value");
		int nouse,favor;
		try{
			if(userId==null){
				response.sendRedirect("login.jsp");
			}
			else{
				eva=evadao.queryEvaluation(md,userId);
				String emd=eva.getMd();
				String euserId=eva.getUserId();
				if(emd==null&&euserId==null){
					evadao.InitEvaluation(md,userId);
					eva=evadao.queryEvaluation(md,userId);
				}
				if(value.equals("nouse")){
					favor=eva.getFavor();
					nouse=eva.getNouse();
					if(favor==0&&nouse==0){
						evadao.alterNouse(md,userId);
						messdao.alterNouse(1, md);
					}
				}
				if(value.equals("favor")){
					favor=eva.getFavor();
					nouse=eva.getNouse();
					if(favor==0&&nouse==0){
						evadao.alterFavor(md,userId);
						messdao.alterFavor(1, md);
					}
				}
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
				
				response.sendRedirect(url);/*跳转至具体展示用户分享的某一篇文章的未登录页面*/
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
