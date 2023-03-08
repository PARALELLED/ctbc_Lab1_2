package com.ctbc.boot.lab1.lab3;


//Test 
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Locale.Category;

import org.junit.jupiter.api.Test;

import com.ctbc.boot.lab1.model.CourseCategory;
import com.ctbc.boot.lab1.service.CourseCategoryService;
import com.ctbc.boot.lab1.service.CourseCategoryServiceJDKImplement;


//import static
import static org.assertj.core.api.Assertions.assertThat;

public class CourseCategoryTest {
	
	private CourseCategoryServiceJDKImplement categoryService;
	
	@BeforeEach
	public void setup() {
		this.categoryService = new CourseCategoryServiceJDKImplement(); // 要加上BeforeEach
	}
	
	//private CourseCategoryService service;
	@Test
	public void testGetAllCategory() {
		ArrayList<CourseCategory> categories = this.categoryService.getAllCategory();
		Assertions.assertNotNull(categories);
		Assertions.assertTrue(categories.isEmpty());
	}
	
	@Test
	public void testAddCategory() {
		String categoryName = "Programming";
		String detail = "Computer Technical";
		
		CourseCategory coursecategory = this.categoryService.addCategory(categoryName, detail);
		CourseCategory coursecategory2 = this.categoryService.addCategory("Web", "Angular");
		System.out.println(coursecategory.toString());
		System.out.println(coursecategory2.toString());
		
//		Assertions.assertNotNull(coursecategory);
//		Assertions.assertEquals(categoryName,coursecategory.getCategoryName());
		
		this.categoryService.categories.get(0).setCategoryID(null);
		System.out.println(coursecategory.toString());
		
		
		
	}
}