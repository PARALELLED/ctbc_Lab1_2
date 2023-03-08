package com.ctbc.boot.lab1.model;

import java.util.ArrayList;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor //無參建構子
@AllArgsConstructor //有參建構子
public class CourseCategory {
	// 無參/有參建構子 
//	public  CourseCategory(){
//		
//	}
//	CourseCategory(String categoryID , String categoryName ,String detail){
//		this.categoryID =categoryID;
//		this.categoryName = categoryName;
//		this.detail = detail;
//	}
	
	// 屬性
	private UUID categoryID; // 類別的識別碼
	private String categoryName; // 名稱
	private String detail; // 細節
	private ArrayList<Course> courseList; 
	
	// 建構子
	public CourseCategory(String categoryName, String detail) {
		this.categoryID = UUID.randomUUID(); // 改UUID
		this.categoryName = categoryName;
		this.detail = detail;
		this.courseList = courseList;
	}
	
	public void AddCourseToCategory(Course course){
		this.courseList = new ArrayList<>(); // ??
		this.courseList.add(course);
	}
	
	@Override
	public String toString() {
		return "CourseCategory {categoryID=[" + categoryID + "], categoryName=[" + categoryName + "], detail=[" + detail
				+ "]}";
	}
	
	
}