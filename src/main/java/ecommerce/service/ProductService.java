package ecommerce.service;

import java.util.List;

import ecommerce.model.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	public Product addProduct(Product product);
	public void deleteproduct(Long id);
	public Product findProductById(Long id);
	public List<Product> findAllById(Long id);
	
}
