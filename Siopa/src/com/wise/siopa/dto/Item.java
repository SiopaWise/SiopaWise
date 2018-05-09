package com.wise.siopa.dto;

import java.util.Date;

public class Item {
	private int itemId;
	private String description;
	private int oldMonths;
	private int maxPrice;
	private int minPrice;
	private String sold;
	private Moderator moderator;
	private SubCategory subcategory;
	private User user;
	private String locality;
	private String city;
	private String state;
	private Date date;
	private String image;
	private String country;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getOldMonths() {
		return oldMonths;
	}
	public void setOldMonths(int oldMonths) {
		this.oldMonths = oldMonths;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public String getSold() {
		return sold;
	}
	public void setSold(String sold) {
		this.sold = sold;
	}
	public Moderator getModerator() {
		return moderator;
	}
	public void setModerator(Moderator moderator) {
		this.moderator = moderator;
	}
	public SubCategory getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(SubCategory subcategory) {
		this.subcategory = subcategory;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", description=" + description + ", oldMonths=" + oldMonths + ", maxPrice="
				+ maxPrice + ", minPrice=" + minPrice + ", sold=" + sold + ", moderator=" + moderator + ", subcategory="
				+ subcategory + ", user=" + user + ", locality=" + locality + ", city=" + city + ", state=" + state
				+ ", date=" + date + ", image=" + image + ", country=" + country + "]";
	}
	
}
