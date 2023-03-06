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



public class CourseServiceTest {
	
    private CourseServiceJDKImplement courseService;
    
    
	@BeforeEach
    public void setup() {
        this.courseService = new CourseServiceJDKImplement();
    }
	
	//private CourseService service;
	@Test
	@Order(1)
    public void testGetAllCourses() {
        ArrayList<Course> courses = this.courseService.getAllCourses(); // 為什麼要this.
        System.out.println("1. testGetAllCourses \n" + courses.toString());
        Assertions.assertNotNull(courses); // expected: <null> but was: <[]>
        Assertions.assertTrue(courses.isEmpty());
    }
	
	@Test
	@Order(2)
	public void testAddCourse() {
		String courseName = "Java";
		int coursePrice = 100;
		String courseTeacher = "Mark";
		CourseCategory coursecategory = new CourseCategory("Java", "Programming");
		
		Course course = this.courseService.addCourse(courseName, coursePrice, courseTeacher, coursecategory);
		
		System.out.println("2. testAddCourse \n" + course.toString());
		System.out.println("courseMap = \n" + this.courseService.courseMap.toString());
		Assertions.assertNotNull(course);
		Assertions.assertEquals(courseName, course.getCourseName());
	}
	
	@Test
	@Order(3)
	public void testUpdateCourse() {
		
		
		String courseName = "Java" ;
		String newName = "Spring Boot";
		int newPrice = 200;
		String newTeacher = "Brian";
		CourseCategory coursecategory = new CourseCategory("Java", "Programming");
		
		Course course = this.courseService.updateCourse(courseName,newName,newPrice, newTeacher, coursecategory);
		
		System.out.println("3. testUpdateCourse \n" + course.toString());
		
	}
	
	
	public void testcourseMapget() {
		Course course = this.courseService.testcourseMapget("Java");
		System.out.println("test : " + course);
		
	}
	
	
	

}
