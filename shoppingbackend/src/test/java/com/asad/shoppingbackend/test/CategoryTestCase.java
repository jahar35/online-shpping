package com.asad.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.asad.shoppingbackend.dao.CategoryDAO;
import com.asad.shoppingbackend.dto.Category;

public class CategoryTestCase {

	
	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.asad.shoppingbackend");
		context.refresh();
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		
	}
	@Test
	public void testAddCategory(){
		category=new Category();
		category.setName("Television");
		category.setDescription("Television Description");
		category.setImageURL("CAT_1.png");
		assertEquals("Successfully added the catevgory inside the table",true,categoryDAO.add(category));
				
	}
}
