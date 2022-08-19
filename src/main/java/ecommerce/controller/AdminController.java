package ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.model.Category;
import ecommerce.repository.CategoryRepository;
import ecommerce.serviceImplementaion.CategoryServiceImplementation;

@Controller
public class AdminController {

	@Autowired
	CategoryServiceImplementation serviceImplementation;

	@GetMapping("/admin")
	public String adminHome() {
		return "adminHome";
	}

	@GetMapping("/admin/categories")
	public String manageCategories(Model model) {
		model.addAttribute("categories", serviceImplementation.getAllCategories());
		return "categories";
	}

	@GetMapping("/admin/categories/add")
	public String AddCategories(Model model) {
		model.addAttribute("category", new Category());

		return "categoriesAdd";
	}

	@PostMapping("/admin/categories/add")
	public String saveCategories(@ModelAttribute("category") Category category) {
		serviceImplementation.addCategory(category);

		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCategory(@PathVariable int id) {
		serviceImplementation.deleteCategory(id);
		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/update/{id}")
	public String updateCategory(@PathVariable int id, Model model) {
		Category category = serviceImplementation.findCategoryById(id);
		model.addAttribute("category", category);
		return "updateCategory";
	}
}
