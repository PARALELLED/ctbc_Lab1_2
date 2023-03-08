package com.ctbc.boot.lab1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ctbc.boot.lab1.model.Course;
import com.ctbc.boot.lab1.model.CourseCategory;
import com.ctbc.boot.lab1.service.CourseServiceJDKImplement.CourseNameDuplicate;



@Service
public interface CourseService {
	public static ArrayList<Course> courses = new ArrayList<Course>();
    public static Map<UUID, Course> courseMap = new HashMap<>(); // UUID, Course
    
    /*
    建構子??
    CourseService() {
        courses = new ArrayList<>();
        courseMap = new HashMap<>();
    }
    */
    // 列出所有的課程
    ArrayList<Course> getAllCourses();
    // 依照屬性新增課程,並且傳回課程??
    Course addCourse(String courseName, int coursePrice, String courseTeacher, CourseCategory coursecategory) throws CourseNameDuplicate;
    // 依照鍵值刪除課程
    Course removeCourse(UUID courseId,Course course);
    // 依照鍵值與新的值修改,並且傳回修改後的課程
    Course updateCourse(UUID courseId,String newName, Integer newPrice, String newTeacher,CourseCategory coursecategory);
    Course testcourseMapget(String courseName);
    
}