package ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query(value ="select * from product where category_id=?1", nativeQuery = true )
    List<Product> findAllById(Long category_id);
}
