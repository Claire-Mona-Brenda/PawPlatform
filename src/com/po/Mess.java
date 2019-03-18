package com.po;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Mess {
	private String writer;
	private String title;
	private java.util.Date t;
	private String time;
	private String content;
	private String pic;
	private static final String PIC="images/t5.jpg";
	private String md;
	private int scan;
	private int favor;
	private int nouse;
	private int commcount;
	private int collcount;
	public Mess(){
		
	}
	
	public int getCollcount() {
		return collcount;
	}

	public void setCollcount(int collcount) {
		this.collcount = collcount;
	}

	public int getCommcount() {
		return commcount;
	}

	public void setCommcount(int commcount) {
		this.commcount = commcount;
	}

	public int getFavor() {
		return favor;
	}

	public void setFavor(int favor) {
		this.favor = favor;
	}

	public int getNouse() {
		return nouse;
	}

	public void setNouse(int nouse) {
		this.nouse = nouse;
	}

	public int getScan() {
		return scan;
	}

	public void setScan(int scan) {
		this.scan = scan;
	}

	public String getPIC(){
		return PIC;
	}
	public void addmess_p(String writer,String title,String content,String pic){
		this.setWriter(writer);
		this.setTitle(title);
		this.setContent(content);
		this.setPic(pic);
		this.setTime();
		this.setMd();
	}
	public void addmess(String writer,String title,String content){
		this.setWriter(writer);
		this.setTitle(title);
		this.setContent(content);
		this.setTime();
		this.setMd();
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getMd() {
		return md;
	}
	public void setMd() {
		UUID uuid=UUID.randomUUID();
		this.md=uuid.toString();
	}
	public void setMd(String md){
		this.md=md;
	}
	

}
