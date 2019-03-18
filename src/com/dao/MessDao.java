package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.db.DBUtil;
import com.po.Mess;
public class MessDao {
	public MessDao(){
		
	}
	public ArrayList<Mess> queryMess()throws SQLException{/*查询所有文章*/
		Connection conn=DBUtil.getConnection();
		String sql="select * from messlist";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		Mess mess=null;
		ArrayList<Mess> messlist=new ArrayList();
		while(rs.next()){
			mess=new Mess();
			mess.setContent(rs.getString("content"));
			mess.setMd(rs.getString("md"));
			mess.setPic(rs.getString("pic"));
			mess.setTime(rs.getString("time"));
			mess.setTitle(rs.getString("title"));
			mess.setWriter(rs.getString("writer"));
			mess.setScan(rs.getInt("scan"));
			mess.setFavor(rs.getInt("favor"));
			mess.setNouse(rs.getInt("nouse"));
			mess.setCommcount(rs.getInt("commcount"));
			mess.setCollcount(rs.getInt("collcount"));
			messlist.add(mess);
		}
		return messlist;
	}
	
	public void addMess(String writer,String content,String pic,String title)throws SQLException{/*发表文章*/
		Connection conn=DBUtil.getConnection();
		Mess mess=new Mess();
		mess.setMd();
		String sql="Insert into messlist(writer,content,md,pic,time,title,scan,favor,nouse,commcount,collcount) Value(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, writer);
		pstmt.setString(2, content);
		pstmt.setString(3, mess.getMd());
		pstmt.setString(4, pic);
		mess.setTime();
		pstmt.setString(5, mess.getTime());
		pstmt.setString(6, title);
		pstmt.setInt(7, 0);
		pstmt.setInt(8, 0);
		pstmt.setInt(9, 0);
		pstmt.setInt(10, 0);
		pstmt.setInt(11, 0);
		pstmt.executeUpdate();
	}
	
	public void addMess(String writer,String content,String title)throws SQLException{/*发表文章*/
		Connection conn=DBUtil.getConnection();
		Mess mess=new Mess();
		mess.setMd();
		String sql="Insert into messlist(writer,content,md,time,title,scan,favor,nouse,collcount) Value(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, writer);
		pstmt.setString(2, content);
		pstmt.setString(3, mess.getMd());
		mess.setTime();
		pstmt.setString(4, mess.getTime());
		pstmt.setString(5, title);
		pstmt.setInt(6, 0);
		pstmt.setInt(7, 0);
		pstmt.setInt(8, 0);
		pstmt.setInt(9, 0);
		pstmt.setInt(10, 0);
		pstmt.executeUpdate();
	}
	
	public Mess queryMess(String md)throws SQLException{/*查询具体某一篇文章*/
		Mess mess=null;
		Connection conn=DBUtil.getConnection();
		String sql="select md,content,pic,time,title,writer,scan,favor,nouse,commcount,collcount from messlist where md=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, md);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			mess=new Mess();
			mess.setMd(rs.getString("md"));
			mess.setContent(rs.getString("content"));
			mess.setPic(rs.getString("pic"));
			mess.setTime(rs.getString("time"));
			mess.setTitle(rs.getString("title"));
			mess.setWriter(rs.getString("writer"));
			mess.setScan(rs.getInt("scan"));
			mess.setFavor(rs.getInt("favor"));
			mess.setNouse(rs.getInt("nouse"));
			mess.setCommcount(rs.getInt("commcount"));
			mess.setCollcount(rs.getInt("collcount"));
		}
		return mess;
	}
	
	public int queryScan(String md)throws SQLException{/*查询浏览数量*/
		int scan=0;
		Connection conn=DBUtil.getConnection();
		String sql="select scan from messlist where md=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, md);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			scan=rs.getInt("scan");
		}
		return scan;
	}
	public int queryCollCount(String md)throws SQLException{/*查询浏览数量*/
		int collcount=0;
		Connection conn=DBUtil.getConnection();
		String sql="select collcount from messlist where md=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, md);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			collcount=rs.getInt("collcount");
		}
		return collcount;
	}
	public void alterCollCount(int collcount,String md)throws SQLException{/*修改浏览数*/
		Connection conn=DBUtil.getConnection();
		String sql="Update messlist set collcount=? where md=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, collcount);
		pstmt.setString(2, md);
		pstmt.executeUpdate();
	}
	
	public int queryFavor(String md)throws SQLException{/*查询喜欢文章的用户数*/
		int favor=0;
		Connection conn=DBUtil.getConnection();
		String sql="select favor from messlist where md=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, md);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			favor=rs.getInt("favor");
		}
		return favor;
	}
	public int queryNouse(String md)throws SQLException{/*查询不喜欢文章的用户数*/
		int nouse=0;
		Connection conn=DBUtil.getConnection();
		String sql="select nouse from messlist where md=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, md);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			nouse=rs.getInt("nouse");
		}
		return nouse;
	}
	
	public void alterScan(int scan,String md)throws SQLException{/*修改浏览数*/
		Connection conn=DBUtil.getConnection();
		MessDao messdao=new MessDao();
		int old_scan=messdao.queryScan(md);
		String sql="Update messlist set scan=? where md=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, old_scan+scan);
		pstmt.setString(2, md);
		pstmt.executeUpdate();
	}
	public void alterCommcount(int commcount,String md)throws SQLException{/*修改评论数*/
		Connection conn=DBUtil.getConnection();
		String sql="Update messlist set commcount=? where md=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, commcount);
		pstmt.setString(2, md);
		pstmt.executeUpdate();
	}
	
	public void alterFavor(int favor,String md)throws SQLException{/*修改喜欢数*/
		Connection conn=DBUtil.getConnection();
		MessDao messdao=new MessDao();
		int old_favor=messdao.queryFavor(md);
		String sql="Update messlist set favor=? where md=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, old_favor+favor);
		pstmt.setString(2, md);
		pstmt.executeUpdate();
	}
	public void alterNouse(int nouse,String md)throws SQLException{/*修改不喜欢数*/
		Connection conn=DBUtil.getConnection();
		MessDao messdao=new MessDao();
		int old_nouse=messdao.queryNouse(md);
		String sql="Update messlist set nouse=? where md=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, old_nouse+nouse);
		pstmt.setString(2, md);
		pstmt.executeUpdate();
	}
	public static void main(String[] args) throws SQLException, java.text.ParseException{
		MessDao messdao=new MessDao();
		String username,title,time,td,content;
		Mess mess,t1;
		ArrayList<Mess>ml=new ArrayList<Mess>();
		ml=messdao.queryMess();
		if(ml!=null&ml.size()>0){
		SortMess.sortMessByTime(ml,0,ml.size()-1);
		}
		for(int i=0;i<ml.size();i++){
			mess=ml.get(i);
			System.out.println(mess.getTime());
			System.out.println();
		}
	}

}
