package ie.cct.gersgarage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.cct.gersgarage.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer>{
	
	public Service save(Service service);
	
	public List<Service> findAll();
	
	public Optional<Service> findById(int id);

}
