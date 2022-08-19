package ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
