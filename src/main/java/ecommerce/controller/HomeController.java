package ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ecommerce.model.Product;
import ecommerce.serviceImplementaion.CategoryServiceImplementation;
import ecommerce.serviceImplementaion.ProductServiceImplmentation;
import ecommerce.util.Cart;

@Controller
public class HomeController {

	
	@Autowired
	CategoryServiceImplementation categoryServiceImplementation;
	@Autowired
	ProductServiceImplmentation productServiceImplmentation;
	
	@GetMapping({"/" , "/home"})
	public String HomePage(Model model) {
		
		model.addAttribute("cartCount", Cart.cart.size());
		return "index";
	}
	
	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("categories", categoryServiceImplementation.getAllCategories());
		model.addAttribute("products", productServiceImplmentation.getAllProducts());
		return "shop";
	}
	
	@GetMapping("/shop/category/{id}")
	public String shop(Model model, @PathVariable Long id) {
		model.addAttribute("categories", categoryServiceImplementation.getAllCategories());
		model.addAttribute("products", productServiceImplmentation.findAllById(id));
		return "shop";
	}
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(@PathVariable Long id, Model model) {
		
		model.addAttribute("product", productServiceImplmentation.findProductById(id));
		return "viewProduct";
	}
	
}
