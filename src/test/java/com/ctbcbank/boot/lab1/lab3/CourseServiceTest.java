package com.ctbcbank.boot.lab1.lab3;



import java.util.ArrayList;

// Test 
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
	
	
	private CourseService service;
	@Test
    public void testGetAllCourses() {
        ArrayList<Course> courses = this.courseService.getAllCourses();
        Assertions.assertNotNull(courses); // expected: <null> but was: <[]>
        Assertions.assertTrue(courses.isEmpty());
    }
	
	@Test
	public void testAddCourse() {
		String courseName = "Java";
		int coursePrice = 100;
		String courseTeacher = "Mark";
		CourseCategory coursecategory = new CourseCategory("Java", "Programming");
		
		Course course = this.courseService.addCourse(courseName, coursePrice, courseTeacher, coursecategory);
		System.out.println(course.toString());
		Assertions.assertNotNull(course);
		Assertions.assertEquals(courseName, course.getCourseName());
		
		
	}
	
	
	

}
