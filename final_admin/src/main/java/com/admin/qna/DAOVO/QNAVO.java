package com.admin.qna.DAOVO;

import java.util.Date;

public class QNAVO {
	private int num;
	private String name;
	private String email;
	private String text;
	private Date regidate;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	public QNAVO(int num, String name, String email, String text, Date regidate) {
		super();
		this.num = num;
		this.name = name;
		this.email = email;
		this.text = text;
		this.regidate = regidate;
	}
	@Override
	public String toString() {
		return "QNAVO [num=" + num + ", name=" + name + ", email=" + email + ", text=" + text + ", regidate=" + regidate
				+ "]";
	}
	public QNAVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
