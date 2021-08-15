package ie.cct.gersgarage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.cct.gersgarage.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{
	
	public Staff save(Staff staff);
	
	public List<Staff> findAll();
	
	public Optional<Staff> findById(int id);

	public void deleteById(int id);

}
