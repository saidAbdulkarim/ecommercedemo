package ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ecommerce.model.Product;
import ecommerce.serviceImplementaion.ProductServiceImplmentation;
import ecommerce.util.Cart;

@Controller
public class CartController {
    
	
	
	@Autowired
	ProductServiceImplmentation productServiceImplmentation;
	
	@GetMapping("/addToCart/{id}")
	public String addtocart(@PathVariable Long id) {
		Cart.cart.add(productServiceImplmentation.findProductById(id));
		return "redirect:/shop";
	}
	@GetMapping("/cart")
	public String cart(Model model) {
		
		model.addAttribute("cartCount", Cart.cart.size());
		model.addAttribute("total", Cart.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cart", Cart.cart);
		return "cart";
	}
	
	
	
	@GetMapping("/checkout")
	public String checkout() {
		return"checkout";
	}
	
	@GetMapping("cart/removeItem/{index}")
	public String removeItem(@PathVariable int index) {
		Cart.cart.remove(index);
		return "redirect:/cart";
	}
}
