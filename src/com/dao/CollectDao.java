package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.db.DBUtil;
import com.po.Collection;
import com.po.Mess;

public class CollectDao {
	public CollectDao(){
		
	}
	public ArrayList<Collection> queryCollection(String userId)throws SQLException{//查询用户所有收藏文章
		ArrayList<Collection> collectlist=new ArrayList();
		Collection collection=null;
		Connection conn=DBUtil.getConnection();
		String sql="select title,md,writer,time from collectlist where ud=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			collection=new Collection();
			collection.setTitle(rs.getString("title"));
			collection.setTime(rs.getString("time"));
			collection.setMd(rs.getString("md"));
			collection.setWriter(rs.getString("writer"));
			collectlist.add(collection);
		}
		return collectlist;
	}
	
	public Collection queryCollection(String userId,String md)throws SQLException{//查询用户收藏的某一篇文章
		Collection collection=new Collection();
		Connection conn=DBUtil.getConnection();
		String sql="select title,time,writer,md from collectlist where ud=? and md=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, md);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			collection.setTitle(rs.getString("title"));
			collection.setTime(rs.getString("time"));
			collection.setMd(rs.getString("md"));
			collection.setWriter(rs.getString("writer"));
			
		}
		return collection;
	}
	
	public int countCollection(String md)throws SQLException{/*查询某一篇文章收藏数量*/
		int count=0;
		Connection conn=DBUtil.getConnection();
		String sql="select ud from collectlist where md=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, md);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			count++;
		}
		return count;
	}
	
	
	/*增加用户收藏文章*/
	public void addCollection(String userId,String title,String md,String writer)throws SQLException{
		Connection conn=DBUtil.getConnection();
		Collection collection=new Collection();
		String sql="Insert into collectlist(ud,title,md,writer,time) Value(?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, title);
		pstmt.setString(3, md);
		pstmt.setString(4, writer);
		collection.setTime();
		String time=collection.getTime();
		pstmt.setString(5,time);
		pstmt.executeUpdate();
	}
	
	/*删除用户收藏文章*/
	public void deleteCollection(String userId,String md)throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="delete from collectlist where ud=? and md=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, md);
		pstmt.executeUpdate();
	}
	
	/*查询用户收藏具体某一篇文章详情内容*/
	public Mess queryDCollection(String md)throws SQLException{
		Mess mess=null;
		Connection conn=DBUtil.getConnection();
		String sql="select title,writer,time,content,pic,md from messlist where md=?";
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
		}
		return mess;
	}
	
}
