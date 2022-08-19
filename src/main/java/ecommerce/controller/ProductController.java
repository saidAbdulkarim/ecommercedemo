package ecommerce.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ecommerce.model.Category;
import ecommerce.model.Product;
import ecommerce.serviceImplementaion.CategoryServiceImplementation;
import ecommerce.serviceImplementaion.ProductServiceImplmentation;

@Controller
public class ProductController {
	
	public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/images";
	
	@Autowired
	ProductServiceImplmentation productServiceImplmentation;
	@Autowired
	CategoryServiceImplementation categoryServiceImplementation;

	@GetMapping("/admin/products")
	public String products(Model model) {
		model.addAttribute("products", productServiceImplmentation.getAllProducts());
		return "products";
	}
	@GetMapping("/admin/products/add")
	public String addProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categoryServiceImplementation.getAllCategories());
		return "productsAdd";
	}
	
	@PostMapping("/admin/products/add")
	public String saveProducts(@ModelAttribute("product") Product product,
			@RequestParam("productImage") MultipartFile file,
			@RequestParam("imgName") String imgName) throws IOException {
		
		String imageUUID;
		if(!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			
			Path fileNameAndPath = Paths.get(uploadDir ,imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		}
		else {
			imageUUID = imgName;
		}
		product.setImageName(imageUUID);
		productServiceImplmentation.addProduct(product);
		return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/product/delete/{id}")
	public String deleteCategory(@PathVariable Long id) {
		productServiceImplmentation.deleteproduct(id);
		return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/product/update/{id}")
	public String updateproduct(@PathVariable Long id, Model model) {
		Product product = productServiceImplmentation.findProductById(id);
		
		model.addAttribute("categories", categoryServiceImplementation.getAllCategories());
		model.addAttribute("product", product);
		return "updateProduct";
	}
}
