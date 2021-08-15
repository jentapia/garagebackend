package ie.cct.gersgarage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.cct.gersgarage.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
	
	public Invoice save(Invoice invoice);
	
	public List<Invoice> findAll();
	
	public Optional<Invoice> findById(int id);

	public void deleteById(int id);

}
