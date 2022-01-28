package com.itwillbs.domain;

import java.sql.Timestamp;

public class MemberDTO {
	// 데이터를 담아서 전달
	// 은익된 멤버변수에 set메서드를 통해서 값을 저장하고 
	//       전달하면 get메서들 통해서 값을 가져와서 사용
	
	//멤버변수
	private String id;
	private String pass;
	private String name;
	private Timestamp date;
	
	//메서드 set() get()  alt shift s => r
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
	
	
	
}
