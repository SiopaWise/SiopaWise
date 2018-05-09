package com.wise.siopa.dto;

public class Moderator {
	private int moderatorId;
	private String moderatorName;
	private String password;
	private String moderatorEmailId;
	private long moderatorPhoneNumber;
	@Override
	public String toString() {
		return "Moderator [moderatorId=" + moderatorId + ", moderatorName=" + moderatorName + ", password=" + password
				+ ", moderatorEmailId=" + moderatorEmailId + ", moderatorPhoneNumber=" + moderatorPhoneNumber + "]";
	}
	public int getModeratorId() {
		return moderatorId;
	}
	public void setModeratorId(int moderatorId) {
		this.moderatorId = moderatorId;
	}
	public String getModeratorName() {
		return moderatorName;
	}
	public void setModeratorName(String moderatorName) {
		this.moderatorName = moderatorName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getModeratorEmailId() {
		return moderatorEmailId;
	}
	public void setModeratorEmailId(String moderatorEmailId) {
		this.moderatorEmailId = moderatorEmailId;
	}
	public long getModeratorPhoneNumber() {
		return moderatorPhoneNumber;
	}
	public void setModeratorPhoneNumber(long moderatorPhoneNumber) {
		this.moderatorPhoneNumber = moderatorPhoneNumber;
	}
	
}
