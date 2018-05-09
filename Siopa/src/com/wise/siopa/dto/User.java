package com.wise.siopa.dto;

import java.util.Date;

public class User {
	private int userId;
	private String userName;
	private long userPhoneNumber;
	private String userEmailId;
	private String password;
	private int unsubscribe;
	private Date dateOfBirth;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(long userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUnsubscribe() {
		return unsubscribe;
	}
	public void setUnsubscribe(int unsubscribe) {
		this.unsubscribe = unsubscribe;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPhoneNumber=" + userPhoneNumber
				+ ", userEmailId=" + userEmailId + ", password=" + password + ", unsubscribe=" + unsubscribe + "]";
	}
	
	
	
}
