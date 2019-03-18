package com.po;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Collection {
	private String title;
	private String userId;
	private String time;
	private String writer;
	private java.util.Date t;
	private String md;
	
	Mess mess=new Mess();
	public Collection(){
		
	}
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTime() {
		return time;
	}
	public void setTime() {
		this.t=new Date();
		SimpleDateFormat  format=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.time=format.format(this.t);
	}
	public void setTime(String time){
		this.time=time;
	}
	public String getMd() {
		return md;
	}
	public void setMd(String md){
		this.md=md;
	}

	
	

}
