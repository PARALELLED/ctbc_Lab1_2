package com.ctbc.boot.lab1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.ctbc.boot.lab1.model.Course;
import com.ctbc.boot.lab1.model.CourseCategory;
import com.ctbc.boot.lab1.service.CourseCategoryServiceJDKImplement.CategoryIdNotFound;


public class CourseServiceJDKImplement implements CourseService {
	public ArrayList<Course> courses;
	public Map<UUID, Course> courseMap;

	// 建構子?? // 應該要在哪邊初始化才對??
	public CourseServiceJDKImplement() {
		this.courses = new ArrayList<>();
		this.courseMap = new HashMap<>();
	}

	// 查詢全部
	@Override
	public ArrayList<Course> getAllCourses() {
//		Course course2 = new Course("Java",100,"Mark",(new CourseCategory("Java", "Programming")));
//		courses.add(course2);
//		courseMap.put("Java", course2);
		return courses;
	}

	// 新增
	@Override
	public Course addCourse(String courseName, int coursePrice, String courseTeacher, CourseCategory coursecategory)
			throws CourseNameDuplicate {
		for (Course c : courses) {
			if (c.getCourseName().contains(courseName)) {
				System.out.println("courseName重複");
				throw new CourseNameDuplicate("CourseName already exist: " + courseName);
			}
		}
		// String categoryName = coursecategory.getCategoryName();

		Course course = new Course(courseName, coursePrice, courseTeacher, coursecategory);
		coursecategory.AddCourseToCategory(course); // 
		System.out.println("coursecategory : " + coursecategory.getCourseList().toString());
		
		courses.add(course);
		courseMap.put(course.getCourseId(), course); // ex : "Java", course類別
		return course;

		// String categoryName = coursecategory.getCategoryName();

//			Course course = new Course(courseName, coursePrice, courseTeacher,coursecategory);
//			courses.add(course);
//			courseMap.put(course.getCourseName(), course); // ex : "Java", course類別

	}

	// 刪除
	@Override
	public Course removeCourse(UUID courseId, Course course) {
//		Course course2 = new Course("Java",100,"Mark",(new CourseCategory("Java", "Programming")));
//		courses.add(course2);
//		courseMap.put("Java", course2);

//		Course course = courseMap.get(courseId);
//		System.out.println(course.toString());

		// course.setCourseId(null);

		if (courseMap.containsKey(courseId) && course.getCourseId() == courseId) {
			courses.remove(course);
			courseMap.remove(course.getCourseId());
		}
		return course;
	}

	// 修改
	@Override
	public Course updateCourse(UUID courseId, String newName, Integer newPrice, String newTeacher,
			CourseCategory coursecategory) {
//		Course course2 = new Course("Java",100,"Mark",(new CourseCategory("Java", "Programming")));
//		courses.add(course2);
//		courseMap.put("Java", course2);

//		Course course = courseMap.get(courseName); // 拿出一堂課程類別
//		System.out.println("course : " + course);
//		UUID courseId = course.getCourseId(); // 拿到該類別的ID

		// System.out.println("courseId : " + courseId + "[使用course.setCourseId(null)模擬Id為null的錯誤]");

//		System.out.println("courseId1 : " + courseId + " [改掉courseI，測試UUID錯誤時修改傳回為空]");
//		course.setCourseId(UUID.randomUUID()); // 2.2.2.4
//		System.out.println("courseId2 : " + courseMap.get(courseName).getCourseId());

		for (Course c : courses) {
			// System.out.println("c : " + c.toString());
			if (c.getCourseId().equals(courseId)) {
				// System.out.println(c.toString());

				if (courseId != null) {
					if (c != null) {
						if (newName != null) {
							c.setCourseName(newName);
							courseMap.remove(courseId); // 移除舊課程
							courseMap.put(courseId, c);
						}
						if (newPrice != null) { // 為什麼要用大寫的Integer??
							c.setCoursePrice(newPrice);
						}
						if (newTeacher != null) {
							c.setCourseTeacher(newTeacher);
						}
					}
					return c;
				}
			} else {
				return null;
			}

		}
		return null;
	}

	// Exception
	public class CourseNameDuplicate extends Exception {
		public CourseNameDuplicate(String message) {
			super(message);
		}
	}

	@Override
	public Course testcourseMapget(String courseName) {
		Course course = new Course("Java", 100, "Mark", (new CourseCategory("Java", "Programming")));
		courseMap.put(course.getCourseId(), course);
		Course course2 = courseMap.get(courseName); // 拿出一堂課程類別
		return course2;
	}

}
