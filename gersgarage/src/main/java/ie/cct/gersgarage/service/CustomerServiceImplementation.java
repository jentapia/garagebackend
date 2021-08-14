package ie.cct.gersgarage.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ie.cct.gersgarage.entity.Customer;
import ie.cct.gersgarage.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Customer> findAll() {
		
		return customerRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Customer> findAll(Pageable pageable) {
		
		return customerRepository.findAll(pageable);
	}

	
	@Override
	@Transactional
	public Customer save(Customer customer) {
		
		return customerRepository.save(customer);
	}

	
	@Override
	@Transactional(readOnly = true)
	public Customer findByEmail(String email) {
		Customer customer = customerRepository.findByEmail(email);
		
		return customer;
	}

	@Override
	@Transactional
	public void deleteByEmail(String email) {
		customerRepository.deleteByEmail(email);
		
	}
}
