package com.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.DBUtil;

import java.sql.Connection;
import java.util.ArrayList;

import com.po.User;
public class UserDao {
	public UserDao(){
		
	}
	/*对用户所有信息的操作*/
	public User queryUserInfo(String id)throws SQLException{//查询用户
		User user=null;
		Connection conn=DBUtil.getConnection();
		String sql="select * from userlist where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			user=new User();
			user.setId(rs.getString("id"));
			user.setUserName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setAvatar(rs.getString("avatar"));
			user.setSignature(rs.getString("signature"));
			user.setIntro(rs.getString("intro"));
			user.setSex(rs.getString("sex"));
		}
		return user;
	}
	public ArrayList<String> queryId()throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="select id from userlist";
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		ArrayList<String>ids=new ArrayList<String>();
		while(rs.next()){
			ids.add(rs.getString("id"));
		}
		return ids;
	}
	public void addUser(String username,String password,String id)throws SQLException{//添加用户
		Connection conn=DBUtil.getConnection();
		String avatar=User.getInitAvatar();
		String sql="Insert into userlist(id,username,password,avatar) Value(?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, username);
		pstmt.setString(3, password);
		pstmt.setString(4, avatar);
		pstmt.executeUpdate();
	}
	
	
	public void alterAvatar(String avatar,String id)throws SQLException{//修改用户头像
		Connection conn=DBUtil.getConnection();
		String sql="Update userlist set avatar=? where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, avatar);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
	}
	public String queryAvatar(String id)throws SQLException{//查询用户头像信息
		Connection conn=DBUtil.getConnection();
		String avatar=null;
		String sql="select avatar from userlist where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			avatar=rs.getString("avatar");
		}
		return avatar;
	}
	
	public void alterPassword(String password,String id)throws SQLException{//修改密码
		Connection conn=DBUtil.getConnection();
		String sql="Update userlist set password=? where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
	}
	public String queryPassword(String id)throws SQLException{//查询用户密码
		Connection conn=DBUtil.getConnection();
		String password=null;
		String sql="select password from userlist where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			password=rs.getString("password");
		}
		return password;
	}
	

	public String querySignature(String id)throws SQLException{//查询用户的个性签名
		String signature=null;
		Connection conn=DBUtil.getConnection();
		String sql="select signature from userlist where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			signature=rs.getString("signature");
		}
		return signature;
	}
	public void alterSignature(String id,String sig)throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="Update userlist set signature=? where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, sig);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
	}
	
	public void alterUsername(String id,String username)throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="Update userlist set username=? where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
	}
	public String queryUsername(String id)throws SQLException{//查询用户的个性签名
		String username=null;
		Connection conn=DBUtil.getConnection();
		String sql="select username from userlist where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			username=rs.getString("username");
		}
		return username;
	}
	
	public void alterSex(String id,String sex)throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="Update userlist set sex=? where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, sex);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
	}
	public String querySex(String id)throws SQLException{//查询用户的性别
		String sex=null;
		Connection conn=DBUtil.getConnection();
		String sql="select sex from userlist where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			sex=rs.getString("sex");
		}
		return sex;
	}
	
	public void alterIntro(String id,String intro)throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="Update userlist set intro=? where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, intro);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
	}
	public String queryIntro(String id)throws SQLException{//查询用户的个性签名
		String intro=null;
		Connection conn=DBUtil.getConnection();
		String sql="select intro from userlist where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			intro=rs.getString("intro");
		}
		return intro;
	}
	/*public static void main(String[] args){
		UserDao ud=new UserDao();
		User user;
		String id="13978374553";
		String a,u,si,i,sex,p;
		try{
				ud.alterIntro(id, "吃完热风");
				ud.alterPassword("wadcewfer", id);
				ud.alterSex(id, "啊晚饭我认为啊");
				ud.alterSignature(id, "成为热俄文啊v");
				ud.alterIntro(id, "吃完rare额范围抢冲锋枪");
				ud.alterUsername(id,"船袜的消费");
				user=ud.queryUserInfo(id);
				i=user.getIntro();
				p=user.getPassword();
				sex=user.getSex();
			System.out.print(i);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}*/

}
