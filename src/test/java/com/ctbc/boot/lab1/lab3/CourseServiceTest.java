package com.ctbc.boot.lab1.lab3;

import java.util.ArrayList;
import java.util.UUID;

import javax.sound.midi.Soundbank;

//Test 
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.from;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

//MockMvc
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;

//
import com.ctbc.boot.lab1.model.Course;
import com.ctbc.boot.lab1.model.CourseCategory;
import com.ctbc.boot.lab1.service.CourseService;
import com.ctbc.boot.lab1.service.CourseServiceJDKImplement;
import com.ctbc.boot.lab1.service.CourseServiceJDKImplement.CourseNameDuplicate;

import net.bytebuddy.asm.Advice.This;

public class CourseServiceTest {

	private CourseServiceJDKImplement courseService;

	@BeforeEach
	public void setup() {
		this.courseService = new CourseServiceJDKImplement();
	}

	// private CourseService service;
	
	// 查詢全部
	//@Test
	@Order(1) 
	public void testGetAllCourses() {
		ArrayList<Course> courses = this.courseService.getAllCourses(); // 為什麼要this.
		System.out.println("\n1. testGetAllCourses (3.1 服務生成時可以取出所有的但是是為空)");
		System.out.println(courses.toString() + "\n");
		Assertions.assertNotNull(courses); // expected: <null> but was: <[]>
		Assertions.assertTrue(courses.isEmpty());
		//Assertions.fail("錯誤");
		
	}
	
	// 新增
	//@Test
	@Order(2)	
	public void testAddCourse() throws CourseNameDuplicate {
		System.out.println("\n2. testAddCourse");
		String courseName = "Java";
		int coursePrice = 100;
		String courseTeacher = "Mark";
		CourseCategory coursecategory = new CourseCategory("Java", "Programming");
		
		
		//3.3 測試加入多筆之後比較內容
		Course course = this.courseService.addCourse(courseName, coursePrice, courseTeacher, coursecategory);
		//---------------------------------------------------------------------------------------		
		System.out.println("加入1筆");
		System.out.println("courses = \n" + course.toString());
		System.out.println("\ncourseMap = \n" + this.courseService.courseMap.toString());
		Assertions.assertNotNull(course);
		Assertions.assertEquals(courseName, course.getCourseName());
		Assertions.assertEquals(this.courseService.courses.size(), 1);
		//---------------------------------------------------------------------------------------
		Course course3 = this.courseService.addCourse("Spring", 300, "Kevin", (new CourseCategory("Java", "Programming")));
		Assertions.assertEquals(this.courseService.courses.size(), 2);
		

//		 5.1 課程名稱重複的例外
//		Course course = this.courseService.addCourse(courseName, coursePrice, courseTeacher, coursecategory);
//		Course course2 = this.courseService.addCourse(courseName, coursePrice, courseTeacher, coursecategory); // , (new CourseCategory("Web", "Angular"))
//		System.out.println(course.toString());
//		System.out.println(course2.toString());
		
	}

	
	// 刪除
	@Test
	public void testRemoveCourse() throws CourseNameDuplicate {
		System.out.println("\n3. testRemoveCourse");
		CourseCategory courseCategory = new CourseCategory("Java", "Programming");
		Course course2 = this.courseService.addCourse("Java", 100, "Mark", courseCategory);
		Course course3 = this.courseService.addCourse("Spring", 300, "Kevin", (new CourseCategory("Java", "Programming")));
		
		//this.courseService.courses.get(0).setCourseId(null); // 3.5 測試UUID不存在時刪除沒有影響
		int couseSize = this.courseService.courses.size();
		System.out.println("刪除前串列大小 : " + Integer.toString(couseSize));
		System.out.println(this.courseService.courses.toString());
		Assertions.assertEquals(couseSize, 2);

		Course status = this.courseService.removeCourse(course2.getCourseId(),course2);
		int couseSize2 = this.courseService.courses.size();
		System.out.println("刪除項 : " + status);
		System.out.println("刪除後串列大小 : " + Integer.toString(couseSize2));
		System.out.println(this.courseService.courses.toString() + "\n");
		Assertions.assertEquals(couseSize2, 1);
	}

	//@Test
	@Order(3)
	// 修改
	public void testUpdateCourse() throws CourseNameDuplicate {
		System.out.println("4. testUpdateCourse");
		System.out.println("修改前");
		Course course2 = this.courseService.addCourse("Java", 100, "Mark", (new CourseCategory("Java", "Programming")));
		// System.out.println("courseId : [" +
		// this.courseService.courses.get(0).getCourseId() + "]");

		String courseName = "C++"; // "Java"
		String newName = "Spring Boot";
		int newPrice = 200;
		String newTeacher = "Brian";
		CourseCategory coursecategory = new CourseCategory("Java", "Programming");
		//Course course = new Course(newName, newPrice, newTeacher, coursecategory);
		                                    //Course updateCourse(String courseId,String newName, Integer newPrice, String newTeacher,CourseCategory coursecategory);
		for (Course c : this.courseService.courses) {
			//System.out.println("c : " + c.toString());
			if (c.getCourseName().equals(courseName)) {
				System.out.println("c : " + c.toString());
				Course course = this.courseService.updateCourse(c.getCourseId(),newName,newPrice,newTeacher,coursecategory);
				System.out.println("修改後");
				System.out.println(course.toString());
			} else {
				System.out.println((String) null + " [UUID錯誤，修改傳回為空]");
			}
		}
		
		
		
		
//		if (course == null) {
//			System.out.println((String) null + " [查無courseId，return null]");
//		} else {
//			System.out.println("\n修改後");
//			System.out.println(course.toString() + "\n");
//		}

	}

	public void testcourseMapget() {
		Course course = this.courseService.testcourseMapget("Java");
		System.out.println("test : " + course);

	}

}