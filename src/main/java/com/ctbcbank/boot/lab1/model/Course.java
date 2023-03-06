package com.ctbcbank.boot.lab1.model;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
	private String courseId; // 識別碼
	private String courseName; // 課程名稱
	private int coursePrice; // 價錢
	private String courseTeacher; // 授課老師
	private CourseCategory courseCategory;
	
	public Course(String courseName, int coursePrice, String courseTeacher,
			CourseCategory courseCategory) {
		super();
		this.courseId = UUID.randomUUID().toString();
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.courseTeacher = courseTeacher;
		this.courseCategory = courseCategory;
	}

	@Override
	public String toString() {
		return "Course {courseId=" + courseId + ", courseName=" + courseName + ", coursePrice=" + coursePrice
				+ ", courseTeacher=" + courseTeacher + ", courseCategory=" + courseCategory + "}";
	}
	
//	public Course(String courseName, int coursePrice, String courseTeacher) {
//		this.courseId = UUID.randomUUID().toString();
//		this.courseName = courseName;
//		this.coursePrice = coursePrice;
//		this.courseTeacher = courseTeacher;
//	}


}
