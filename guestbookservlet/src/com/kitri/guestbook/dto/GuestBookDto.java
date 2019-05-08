package com.kitri.guestbook.dto;

import java.sql.Date;

public class GuestBookDto {
	private int seq;
	private String name;
	private String subject;
	private String content;
	private String logtime;
	
	public GuestBookDto() {
		super();
	}
	public GuestBookDto(int seq, String name, String subject, String content, String logtime) {
		super();
		this.seq = seq;
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.logtime = logtime;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	
	@Override
	public String toString() {
		return "GuestaBookDto [seq=" + seq + ", name=" + name + ", subject=" + subject + ", content=" + content
				+ ", logtime=" + logtime + "]";
	}
}