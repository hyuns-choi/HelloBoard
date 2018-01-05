package com.oraclejava.model;

import java.util.Date;

public class Member {
	private String memberid;
	private String passwd;
	private String email;
	private String usertype;
	private String active;
	private Date regdate;
	
	public Member() {}
	
	public Member(String memberid, String passwd, String email, String usertype, String active, Date regdate) {

		this.memberid = memberid;
		this.passwd = passwd;
		this.email = email;
		this.usertype = usertype;
		this.active = active;
		this.regdate = regdate;
	}

	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
