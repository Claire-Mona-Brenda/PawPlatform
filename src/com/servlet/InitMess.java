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
import com.dao.TopicDao;
import com.po.Collection;
import com.po.Mess;
import com.po.User;

/**
 * Servlet implementation class InitMess
 */
@WebServlet("/InitMess")
public class InitMess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Mess>messlist;
	ArrayList<Mess>recomm_messlist;
	ArrayList<Mess>scan_messlist;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitMess() {
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
		String url=request.getParameter("url");
		MessDao messdao=new MessDao();
		
		try{
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
			
			scan_messlist=messdao.queryMess();
			if(scan_messlist!=null&scan_messlist.size()>0){
				SortMess.sortMessByScan(scan_messlist,0,scan_messlist.size()-1);
			}
			session.setAttribute("scan_messlist", scan_messlist);/*��������������� */
			
			response.sendRedirect(url);/*��ת��չʾ�����û��������µ�ҳ��*/
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ParseException e){
			e.printStackTrace();
		}
	}

}
