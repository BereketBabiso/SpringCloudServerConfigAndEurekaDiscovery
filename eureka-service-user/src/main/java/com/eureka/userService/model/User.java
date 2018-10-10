package com.eureka.userService.model;

import java.util.Objects;

public class User {
	private String userName;
	private String acctNumber;
	
	public User() {
		
	}
	
	public User(String userName, String acctNumber) {
		this();
		this.userName = userName;
		this.acctNumber = acctNumber;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAcctNumber() {
		return acctNumber;
	}
	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(this.getClass()!=obj.getClass()) return false;
		User u = (User) obj;
		return this.acctNumber.equalsIgnoreCase(u.getAcctNumber());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.userName,this.acctNumber);
	}

}
