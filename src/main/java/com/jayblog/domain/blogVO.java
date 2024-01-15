package com.jayblog.domain;

public class blogVO {
	private Integer bno;
	private String title;
	private Object content;
	private String date;
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "blogVO [bno=" + bno + ", title=" + title + ", content=" + content + ", date=" + date + "]";
	}
	

}
