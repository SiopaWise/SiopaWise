package com.wise.siopa.dto;

public class SubCategory {
	private int subCategoryId;
	private String subCategoryName;
	private String image;
	private int deleteSubCategory;
	private Moderator moderator;
	private Category category;
	
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getDeleteSubCategory() {
		return deleteSubCategory;
	}
	public void setDeleteSubCategory(int deleteSubCategory) {
		this.deleteSubCategory = deleteSubCategory;
	}
	public Moderator getModerator() {
		return moderator;
	}
	public void setModerator(Moderator moderator) {
		this.moderator = moderator;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "SubCategory [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + ", image="
				+ image + ", deleteSubCategory=" + deleteSubCategory + ", moderator=" + moderator + ", category="
				+ category + "]";
	}
}
