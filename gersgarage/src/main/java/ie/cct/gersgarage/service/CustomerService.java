package ie.cct.gersgarage.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ie.cct.gersgarage.entity.Customer;

public interface CustomerService {
	
	public Iterable<Customer> findAll();
	
	public Page<Customer> findAll(Pageable pageable);
	
	public Customer findByEmail(String email);
	
	public Customer save(Customer customer);
	
	public void deleteByEmail(String email);
	
}
