package ie.cct.gersgarage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.cct.gersgarage.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
	
	public Vehicle save(Vehicle vehicle);
	
	public Vehicle findByLicplate(String licplate);

	public void deleteById(int id);

}
