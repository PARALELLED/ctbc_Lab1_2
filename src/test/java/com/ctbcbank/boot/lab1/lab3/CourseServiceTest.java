package com.ctbcbank.boot.lab1.lab3;

import java.util.ArrayList;

// Test 
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

// MockMvc
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;

// 
import com.ctbcbank.boot.lab1.model.Course;
import com.ctbcbank.boot.lab1.model.CourseCategory;
import com.ctbcbank.boot.lab1.service.CourseService;
import com.ctbcbank.boot.lab1.service.CourseServiceJDKImplement;

import net.bytebuddy.asm.Advice.This;



public class CourseServiceTest {
	
    private CourseServiceJDKImplement courseService;
    
    
	@BeforeEach
    public void setup() {
        this.courseService = new CourseServiceJDKImplement();
    }
	
	//private CourseService service;
	
	@Test
	@Order(1)
	// 查詢全部
    public void testGetAllCourses() {
		ArrayList<Course> courses = this.courseService.getAllCourses(); // 為什麼要this.
        System.out.println("1. testGetAllCourses \n" + courses.toString() + "\n");
        //Assertions.assertNotNull(courses); // expected: <null> but was: <[]>
        //Assertions.assertTrue(courses.isEmpty());
    }
	
	@Test
	@Order(2)
	// 新增
	public void testAddCourse() {
		String courseName = "Java";
		int coursePrice = 100;
		String courseTeacher = "Mark";
		CourseCategory coursecategory = new CourseCategory("Java", "Programming");
		
		Course course = this.courseService.addCourse(courseName, coursePrice, courseTeacher, coursecategory);
		
		System.out.println("2. testAddCourse \n" + course.toString() + "\n");
		System.out.println("courseMap = \n" + this.courseService.courseMap.toString());
		Assertions.assertNotNull(course);
		Assertions.assertEquals(courseName, course.getCourseName());
	}
	
	@Test
	public void testRemoveCourse() {
		Course course = this.courseService.addCourse("Java", 100, "Mark", (new CourseCategory("Java", "Programming")));
		System.out.println("3. testRemoveCourse \n刪除前" + this.courseService.courses.toString());

		boolean status = this.courseService.removeCourse("Java");
		System.out.println("是否刪除成功 : " + status);
		System.out.println("刪除後" + this.courseService.courses.toString() + "\n");;
		
	}
	
	@Test
	@Order(3)
	// 修改
	public void testUpdateCourse() {
		String courseName = "Java" ;
		String newName = "Spring Boot";
		int newPrice = 200;
		String newTeacher = "Brian";
		CourseCategory coursecategory = new CourseCategory("Java", "Programming");
		
		Course course = this.courseService.updateCourse(courseName,newName,newPrice, newTeacher, coursecategory);
		
		System.out.println("4. testUpdateCourse \n" + course.toString() + "\n");
		
	}
	
	
	
	
	public void testcourseMapget() {
		Course course = this.courseService.testcourseMapget("Java");
		System.out.println("test : " + course);
		
	}
	
	
	

}
