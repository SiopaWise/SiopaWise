package com.wise.siopa.dto;

public class Interest {
	private Item item;
	private User user;
	private int bidAmount;
	@Override
	public String toString() {
		return "Interest [item=" + item + ", user=" + user + ", bidAmount=" + bidAmount + "]";
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}
}
