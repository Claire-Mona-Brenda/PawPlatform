package com.po;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Comment {
	private String username;
	private String title;
	private String content;
	private java.util.Date t;
	private String time;
	private String cd;
	private String a;
	private String id;
	private int commcount;
	private String userId;
    private static final String IA="img/member_center/nopic.jpg.png";

    public Comment(){
	
    }
    
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCommcount() {
		return commcount;
	}

	public void setCommcount(int commcount) {
		this.commcount = commcount;
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
	public void setTime(String time){
		this.time=time;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}
	
	public void setCd() {
		UUID uuid=UUID.randomUUID();
		this.cd = uuid.toString();
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static String getIA() {
		return IA;
	}
    
}
