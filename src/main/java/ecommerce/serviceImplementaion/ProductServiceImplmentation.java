package ecommerce.serviceImplementaion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.Product;
import ecommerce.repository.ProductRepository;
import ecommerce.service.ProductService;

@Service
public class ProductServiceImplmentation implements ProductService {
	
	@Autowired
	ProductRepository repository;

	@Override
	public List<Product> getAllProducts() {
		
		return repository.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		
		return repository.save(product);
	}

	@Override
	public void deleteproduct(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public Product findProductById(Long id) {
		
		return repository.findById(id).get();
	}

	@Override
	public List<Product> findAllById(Long id) {
		
		return repository.findAllById(id);
	}

	

	
    
	
}
