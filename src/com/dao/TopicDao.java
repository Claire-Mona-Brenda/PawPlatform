package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.mail.internet.ParseException;

import com.db.DBUtil;
import com.po.Comment;
import com.po.Topic;
public class TopicDao {
	public TopicDao(){
		
	}
	//话题类
	public ArrayList<Topic> queryTopic()throws SQLException{/*查询所有用户发表的话题*/
		Connection conn=DBUtil.getConnection();
		String sql="select * from topiclist";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ArrayList<Topic>topiclist=new ArrayList();
		Topic topic=null;
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			topic=new Topic();
			topic.setContent(rs.getString("content"));
			topic.setTd(rs.getString("td"));
			topic.setTime(rs.getString("time"));
			topic.setTitle(rs.getString("title"));
			topic.setUsername(rs.getString("username"));
			topic.setPic(rs.getString("pic"));
			topic.setCommcount(rs.getInt("commcount"));
			topic.setUserId(rs.getString("ud"));
			topic.setScan(rs.getInt("scan"));
			topiclist.add(topic);
		}
		return topiclist;
	}
	
	public Topic queryTopic(String userId,String td)throws SQLException{/*查询具体某一篇话题*/
		Connection conn=DBUtil.getConnection();
		String sql="select content,time,title,pic,td,username,commcount,scan from topiclist where ud=? and td=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, td);
		Topic topic=new Topic();
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			topic.setContent(rs.getString("content"));
			topic.setTd(rs.getString("td"));
			topic.setTime(rs.getString("time"));
			topic.setTitle(rs.getString("title"));
			topic.setUsername(rs.getString("username"));
			topic.setPic(rs.getString("pic"));
			topic.setCommcount(rs.getInt("commcount"));
			topic.setScan(rs.getInt("scan"));
		}
		return topic;
	}
	
	public Topic queryTopic(String td)throws SQLException{/*查询具体某一篇话题*/
		Connection conn=DBUtil.getConnection();
		String sql="select content,time,title,pic,td,username,commcount,scan from topiclist where td=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, td);
		Topic topic=new Topic();
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			topic.setContent(rs.getString("content"));
			topic.setTd(rs.getString("td"));
			topic.setTime(rs.getString("time"));
			topic.setTitle(rs.getString("title"));
			topic.setUsername(rs.getString("username"));
			topic.setPic(rs.getString("pic"));
			topic.setCommcount(rs.getInt("commcount"));
			topic.setScan(rs.getInt("scan"));
		}
		return topic;
	}
	/*发表一篇话题*/
	public void setTopic(String title,String content,String username,String pic,String userId)throws SQLException{
		Connection conn=DBUtil.getConnection();
		Topic topic=new Topic();
		topic.setTd();
		String sql="Insert into topiclist(title,content,username,td,time,pic,commcount,ud,scan) Value(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, username);
		pstmt.setString(4, topic.getTd());
		topic.setTime();
		pstmt.setString(5, topic.getTime());
		pstmt.setString(6, pic);
		pstmt.setInt(7, 0);
		pstmt.setString(8, userId);
		pstmt.setInt(9, 0);
		pstmt.executeUpdate();
	}
	/*发表一篇话题，无图*/
	public void setTopic(String title,String content,String username,String userId)throws SQLException{
		Connection conn=DBUtil.getConnection();
		Topic topic=new Topic();
		topic.setTd();
		String sql="Insert into topiclist(title,content,username,td,time,commcount,ud,scan) Value(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, username);
		pstmt.setString(4, topic.getTd());
		topic.setTime();
		pstmt.setString(5, topic.getTime());
		pstmt.setInt(6, 0);
		pstmt.setString(7, userId);
		pstmt.setInt(8, 0);
		pstmt.executeUpdate();
	}
	
	public int queryTopicScan(String td)throws SQLException{/*查询话题浏览数量*/
		int scan=0;
		Connection conn=DBUtil.getConnection();
		String sql="select scan from topiclist where td=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, td);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			scan=rs.getInt("scan");
		}
		return scan;
	}
	public void alterTopicScan(int scan,String td)throws SQLException{/*修改话题浏览数*/
		Connection conn=DBUtil.getConnection();
		TopicDao topicdao=new TopicDao();
		int old_scan=topicdao.queryTopicScan(td);
		String sql="Update topiclist set scan=? where td=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, old_scan+scan);
		pstmt.setString(2, td);
		pstmt.executeUpdate();
	}
	
	
	
	//评论类
	public ArrayList<Comment> queryComment(String id)throws SQLException{/*查询具体某一篇文章（话题）中所有用户的评论*/
		Connection conn=DBUtil.getConnection();
		String sql="select username,cd,avatar,content,time from commentlist where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ArrayList<Comment>commentlist=new ArrayList<Comment>();
		Comment comm=null;
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			comm=new Comment();
			comm.setContent(rs.getString("content"));
			comm.setCd(rs.getString("cd"));
			comm.setTime(rs.getString("time"));
			comm.setUsername(rs.getString("username"));
			comm.setA(rs.getString("avatar"));
			comm.setId(id);
			commentlist.add(comm);
		}
		return commentlist;
	}
	public ArrayList<Comment> queryComment()throws SQLException{/*查询文章（话题）中所有用户的评论*/
		Connection conn=DBUtil.getConnection();
		String sql="select * from commentlist";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ArrayList<Comment>commentlist=new ArrayList<Comment>();
		Comment comm=null;
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			comm=new Comment();
			comm.setContent(rs.getString("content"));
			comm.setCd(rs.getString("cd"));
			comm.setTime(rs.getString("time"));
			comm.setUsername(rs.getString("username"));
			comm.setA(rs.getString("avatar"));
			comm.setId(rs.getString("id"));
			comm.setCommcount(rs.getInt("commcount"));
			commentlist.add(comm);
		}
		return commentlist;
	}
	
	public int queryCommCount(String id)throws SQLException{/*查询具体某一篇文章（话题）中所有用户的评论数量*/
		Connection conn=DBUtil.getConnection();
		String sql="select commcount from commentlist where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		int commcount=0;
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			commcount=rs.getInt("commcount");
		}
		return commcount;
	}
	
	public void alterCommCount(int commcount,String id)throws SQLException{/*修改具体文章（话题）评论数*/
		Connection conn=DBUtil.getConnection();
		String sql="update commentlist set commcount=? where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, commcount);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
	}
	
	public void alterTopiclistCommCount(int commcount,String td)throws SQLException{/*修改某一篇话题中评论数*/
		Connection conn=DBUtil.getConnection();
		String sql="update topiclist set commcount=? where td=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, commcount);
		pstmt.setString(2, td);
		pstmt.executeUpdate();
	}
	
	/*在具体某一篇文章（话题）下用户进行评论*/
	public void addComment(String content,String username,String avatar,String id,String userId)throws SQLException{
		Connection conn=DBUtil.getConnection();
		Comment comm=new Comment();
		comm.setCd();
		String cd=comm.getCd();
		String sql="Insert into commentlist(content,username,cd,time,avatar,id,ud) Value(?,?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, content);
		pstmt.setString(2, username);
		pstmt.setString(3,cd);
		comm.setTime();
		pstmt.setString(4, comm.getTime());
		pstmt.setString(5, avatar);
		pstmt.setString(6, id);
		pstmt.setString(7, userId);
		pstmt.executeUpdate();
	}
 
	
	public static void main(String[] args) throws SQLException, java.text.ParseException{
		TopicDao tdao=new TopicDao();
		String username,title,time,td,content;
		Topic t1;
		ArrayList<Topic>tl=new ArrayList<Topic>();
		tl=tdao.queryTopic();
		if(tl!=null&tl.size()>0){
		SortTopic.sortTopicByCommCount(tl, 0, tl.size()-1);
		}
		
		tdao.alterCommCount(6541, "ku");
		System.out.println(tdao.queryCommCount("ku"));
	}
}
