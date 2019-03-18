package com.po;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Topic {
	private String username;
	private String userId;
	private String title;
	private String content;
	private java.util.Date t;
	private String time;
	private String td;
	private String a;
	private String pic;
	private int commcount;
	private int scan;
	
    public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getScan() {
		return scan;
	}


	public void setScan(int scan) {
		this.scan = scan;
	}


	public int getCommcount() {
		return commcount;
	}


	public void setCommcount(int commcount) {
		this.commcount = commcount;
	}
	private static final String IA="img/member_center/nopic.jpg.png";
	public Topic(){
		
	}
	

	public String getPic() {
		return pic;
	}


	public void setPic(String pic) {
		this.pic = pic;
	}


	public String getA() {
		return a;
	}


	public void setA(String a) {
		this.a = a;
	}


	public static String getIA() {
		return IA;
	}


	public void addTopic(String username,String title,String content){
		this.setUsername(username);
		this.setContent(content);
		this.setTitle(title);
		this.setTime();
		this.setTd();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime() {
		this.t=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.time = format.format(this.t);
	}
	public String getTd() {
		return td;
	}
	public void setTd() {
		UUID uuid=UUID.randomUUID();
		this.td = uuid.toString();
	}
	public void setTd(String td){
		this.td=td;
	}
	public void setTime(String time) {
		// TODO Auto-generated method stub
		this.time=time;
	}
	

}
