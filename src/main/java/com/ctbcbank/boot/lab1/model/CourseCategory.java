package com.ctbcbank.boot.lab1.model;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseCategory {
	
	CourseCategory(){
		
	}
	
	private String categoryID; // 類別的識別碼
	private String categoryName; // 名稱
	private String detail; // 細節
	
	// 建構子
	public CourseCategory(String categoryName, String detail) {
		this.categoryID = UUID.randomUUID().toString();
		this.categoryName = categoryName;
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "CourseCategory {categoryID=[" + categoryID + "], categoryName=[" + categoryName + "], detail=[" + detail
				+ "]}";
	}
	
	
}
