package com.wise.siopa.dto;

public class Category {
	private int categoryId;
	private String categoryName;
	private String logo;
	private Moderator moderator;
	private int deleteCategory;
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", logo=" + logo
				+ ", moderator=" + moderator + ", deleteCategory=" + deleteCategory + "]";
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Moderator getModerator() {
		return moderator;
	}
	public void setModerator(Moderator moderator) {
		this.moderator = moderator;
	}
	public int getDeleteCategory() {
		return deleteCategory;
	}
	public void setDeleteCategory(int deleteCategory) {
		this.deleteCategory = deleteCategory;
	}
}
