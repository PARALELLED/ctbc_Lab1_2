package com.ctbc.boot.lab1.service;

// 2.2.1

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.ctbc.boot.lab1.model.CourseCategory;

public class CourseCategoryServiceJDKImplement implements CourseCategoryService {
	private Map<UUID, CourseCategory> categoryMap = new HashMap<>();
	
	public CourseCategoryServiceJDKImplement() {
		this.categoryMap = new HashMap<>();
	}
	
	

	@Override
	public ArrayList<CourseCategory> getAllCategory() {
		return categories;
	}

	// 2.1.1.2
	@Override
	public CourseCategory addCategory(String categoryName, String detail) {
		CourseCategory category = new CourseCategory(categoryName, detail);
		categories.add(category);
		categoryMap.put(category.getCategoryID(), category);
		return category;
	}

	@Override
	public CourseCategory removeCategory(UUID categoryID,CourseCategory coursecategory) {
		CourseCategory category = categoryMap.get(categoryID);
		if (category != null) {
			categories.remove(category);
			categoryMap.remove(categoryID);
		}
		return category;
	}

	@Override
	public CourseCategory updateCategory(String categoryID, String newName, String categoryName, String detail) {
		CourseCategory category = categoryMap.get(categoryID);
		if (category != null) {
			if (newName != null) {
				category.setCategoryName(categoryName);
				categoryMap.remove(categoryID); // 移除舊課程
				categoryMap.put(category.getCategoryID(), category);
			}
			if (detail != null) { // 為什麼要用大寫的Integer??
				category.setDetail(detail);
			}
		}
		return category;
	}

	// Exception
	public class CategoryIdNotFound extends Exception {
		public CategoryIdNotFound(String message) {
			super(message);
		}
	}

	public CourseCategory getCategoryById(String categoryId) throws CategoryIdNotFound {
		CourseCategory category = categoryMap.get(categoryId);
		if (category == null) {
			throw new CategoryIdNotFound("Category ID not found: " + categoryId);
		}
		return category;
	}
}
