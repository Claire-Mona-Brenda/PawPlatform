package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.db.DBUtil;
import com.po.Evaluate;
public class EvaluateDao {
	public EvaluateDao(){
		
	}
	public Evaluate queryEvaluation(String md,String userId)throws SQLException{
		Evaluate eva=new Evaluate();
		Connection conn=DBUtil.getConnection();
		String sql="select * from evaluatelist where md=? and ud=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, md);
		pstmt.setString(2, userId);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			eva.setFavor(rs.getInt("favor"));
			eva.setNouse(rs.getInt("nouse"));
			eva.setMd(rs.getString("md"));
			eva.setUserId(rs.getString("ud"));
		}
		return eva;
	}
	
	public ArrayList<Evaluate> queryEvaluation()throws SQLException{
		Evaluate eva;
		ArrayList<Evaluate> evalist=new ArrayList<Evaluate>();
		Connection conn=DBUtil.getConnection();
		String sql="select * from evaluatelist";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			eva=new Evaluate();
			eva.setFavor(rs.getInt("favor"));
			eva.setNouse(rs.getInt("nouse"));
			eva.setMd(rs.getString("md"));
			eva.setUserId(rs.getString("ud"));
			evalist.add(eva);
		}
		return evalist;
	}
	
	public void InitEvaluation(String md,String userId)throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="Insert into evaluatelist(ud,md,favor,nouse) Value(?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, md);
		pstmt.setInt(3, 0);
		pstmt.setInt(4, 0);
		pstmt.executeUpdate();
	}
	
	public void alterFavor(String md,String userId)throws SQLException{
		Connection conn=DBUtil.getConnection();
		EvaluateDao ed=new EvaluateDao();
		Evaluate e;
		e=ed.queryEvaluation(md,userId);
		int favor=e.getFavor();
		if(favor==0){
			String sql="update evaluatelist set favor=? where md=? and ud=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setString(2, md);
			pstmt.setString(3, userId);
			pstmt.executeUpdate();
		}	
	}
	public void alterNouse(String md,String userId)throws SQLException{
		Connection conn=DBUtil.getConnection();
		EvaluateDao ed=new EvaluateDao();
		Evaluate e;
		e=ed.queryEvaluation(md,userId);
		int nouse=e.getNouse();
		if(nouse==0){
			String sql="update evaluatelist set nouse=? where md=? and ud=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setString(2, md);
			pstmt.setString(3, userId);
			pstmt.executeUpdate();
		}
		
	}
	public static void main(String[] args){
		MessDao messdao=new MessDao();
		EvaluateDao evadao=new EvaluateDao();
		ArrayList<Evaluate>m=new ArrayList<Evaluate>();
		Evaluate eva;
		String userId="wdrrx";
		String md="axwderx";
		String value="nouse";
		int nouse,favor;
		try{
			
			eva=evadao.queryEvaluation(md, userId);
			System.out.println(m.size());
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}
	

}
