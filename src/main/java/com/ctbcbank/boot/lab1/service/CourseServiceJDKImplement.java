package com.ctbcbank.boot.lab1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ctbcbank.boot.lab1.model.Course;
import com.ctbcbank.boot.lab1.model.CourseCategory;

public class CourseServiceJDKImplement implements CourseService {
	private Map<String,Course> courseMap;
	
	// 建構子?? // 應該要在哪邊初始化才對??
	public CourseServiceJDKImplement() {
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
		courseMap.put(course.getCourseName(), course);
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
	public Course updateCourse(String courseId, String newName, Integer newPrice, String newTeacher,CourseCategory coursecategory) {
		Course course = courseMap.get(courseId);
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

}
