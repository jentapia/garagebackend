package ie.cct.gersgarage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.cct.gersgarage.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

	public Customer findByEmail(String email);
	
	public void deleteByEmail(String email);
}
