package ecommerce.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ecommerce.model.Category;

public interface CategoryService {

	public List<Category> getAllCategories();

	public void addCategory(Category category);

	public void deleteCategory(int id);
	
	public Category findCategoryById(int id);
}
