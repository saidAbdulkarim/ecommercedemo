package ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ecommerce.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
   
	@Query(value="select name from category where name =?1", nativeQuery = true)
	public Category getCategoryByName(String name);
}
