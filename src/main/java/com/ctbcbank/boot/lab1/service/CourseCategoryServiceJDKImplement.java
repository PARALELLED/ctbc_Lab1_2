package com.ctbcbank.boot.lab1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ctbcbank.boot.lab1.model.CourseCategory;

public class CourseCategoryServiceJDKImplement implements CourseCategoryService{
	private Map<String, CourseCategory> categoryMap = new HashMap<>();
	
	public CourseCategoryServiceJDKImplement() {
		this.categoryMap = new HashMap<>();
	}

	@Override
	public ArrayList<CourseCategory> getAllCategory() {
		return categories;
	}

	@Override
	public CourseCategory addCategory(String categoryName, String detail) {
		CourseCategory category = new CourseCategory(categoryName, detail);
		categories.add(category);
		categoryMap.put(category.getCategoryName(), category);
		return category;
	}

	@Override
	public boolean removeCategory(String categoryID) {
		CourseCategory category = categoryMap.get(categoryID);
		if (category != null) {
			categories.remove(category);
			categoryMap.remove(categoryID);
		}
		return false;
	}

	@Override
	public CourseCategory updateCategory(String categoryID, String newName, String categoryName, String detail) {
		CourseCategory category = categoryMap.get(categoryID);
		if (category != null) {
			if (newName != null) {
				category.setCategoryName(categoryName);
				categoryMap.remove(categoryID); // 移除舊課程
				categoryMap.put(categoryID, category);
			}
			if (detail != null) { // 為什麼要用大寫的Integer??
				category.setDetail(detail);
			}
		}
		return category;
	}

	
	
	

}
