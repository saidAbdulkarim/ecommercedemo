package ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ecommerce.model.Role;
import ecommerce.model.User;
import ecommerce.repository.RoleRepository;
import ecommerce.repository.UserRepository;
import ecommerce.util.Cart;

@Controller
public class LoginController {
  
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	UserRepository repository;
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/login")
	public String login() {
		Cart.cart.clear();
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerSend(@ModelAttribute("user") User user, HttpServletRequest request)throws ServletException {
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.findById(2).get());
		user.setRoles(roles);
		repository.save(user);
		request.login(user.getEmail(), password);
		return "redirect:/";
	}
}
