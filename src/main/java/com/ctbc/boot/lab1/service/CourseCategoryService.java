package com.ctbc.boot.lab1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.ctbc.boot.lab1.model.CourseCategory;


public interface CourseCategoryService {
	public static ArrayList<CourseCategory> categories = new ArrayList<CourseCategory>();
	public static Map<UUID, CourseCategory> categoryMap = new HashMap<>();
	
	// 列出所有的課程
    ArrayList<CourseCategory> getAllCategory();
    // 依照屬性新增課程,並且傳回課程??
    CourseCategory addCategory(String categoryName, String detail);
    // 依照鍵值刪除課程
    CourseCategory removeCategory(UUID categoryID,CourseCategory coursecategory);
    // 依照鍵值與新的值修改,並且傳回修改後的課程
    CourseCategory updateCategory(String categoryID,String newName, String categoryName, String detail);
}