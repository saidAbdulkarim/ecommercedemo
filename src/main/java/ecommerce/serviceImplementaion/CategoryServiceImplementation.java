package ecommerce.serviceImplementaion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.Category;
import ecommerce.repository.CategoryRepository;
import ecommerce.service.CategoryService;

@Service
public class CategoryServiceImplementation implements CategoryService {
	@Autowired
	CategoryRepository repository;

	@Override
	public List<Category> getAllCategories() {

		return repository.findAll();
	}

	@Override
	public void addCategory(Category category) {
		repository.save(category);

	}

	@Override
	public void deleteCategory(int id) {
		repository.deleteById(id);

	}

	@Override
	public Category findCategoryById(int id) {
		 return repository.findById(id).get();
		
	}

}
