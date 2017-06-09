package com.asad.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.asad.shoppingbackend.dao.CategoryDAO;
import com.asad.shoppingbackend.dto.Category;
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories=new ArrayList();;
	
	static{
		Category category=new Category();
		//adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("Television Description");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		//adding second category
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Mobile Description");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
		//adding third category
				category=new Category();
				category.setId(3);
				category.setName("Laptop");
				category.setDescription("Laptop Description");
				category.setImageURL("CAT_3.png");
				categories.add(category);
	
	}
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
