package com.ctbcbank.boot.lab1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ctbcbank.boot.lab1.model.Course;
import com.ctbcbank.boot.lab1.model.CourseCategory;

public class CourseServiceJDKImplement implements CourseService {
	public ArrayList<Course> courses;
	public Map<String,Course> courseMap;
	
	// 建構子?? // 應該要在哪邊初始化才對??
	public CourseServiceJDKImplement() {
		this.courses = new ArrayList<>();
		this.courseMap = new HashMap<>();
	}
	
	@Override
	public ArrayList<Course> getAllCourses() {
		return courses;
	}

	@Override
	public Course addCourse(String courseName, int coursePrice, String courseTeacher,CourseCategory coursecategory) {
		Course course = new Course(courseName, coursePrice, courseTeacher,coursecategory);
		courses.add(course);
		courseMap.put(course.getCourseName(), course); // ex : "Java", course類別
		return course;
	}

	@Override
	public boolean removeCourse(String courseId) {
		Course course = courseMap.get(courseId);
		if (course != null) {
			courses.remove(course);
			courseMap.remove(courseId);
		}
		return false;
	}

	@Override
	public Course updateCourse(String courseName, String newName, Integer newPrice, String newTeacher,CourseCategory coursecategory) {
		Course course2 = new Course("Java",100,"Mark",(new CourseCategory("Java", "Programming")));
		courseMap.put("Java", course2);
		
		Course course = courseMap.get(courseName); // 拿出一堂課程類別
		String courseId = course.getCourseId(); // 拿到該類別的ID
		if (course != null) {
			if (newName != null) {
				course.setCourseName(newName);
				courseMap.remove(courseId); // 移除舊課程
				courseMap.put(courseId, course);
			}
			if (newPrice != null) { // 為什麼要用大寫的Integer??
				course.setCoursePrice(newPrice);
			}
			if (newTeacher != null) {
				course.setCourseTeacher(newTeacher);
			}
		}
		return course;

	}

	@Override
	public Course testcourseMapget(String courseName) {
		Course course = new Course("Java",100,"Mark",(new CourseCategory("Java", "Programming")));
		courseMap.put("Java", course);
		Course course2 = courseMap.get(courseName); // 拿出一堂課程類別
		return course2;
	}

}
