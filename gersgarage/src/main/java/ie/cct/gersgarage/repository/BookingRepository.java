package ie.cct.gersgarage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.cct.gersgarage.entity.Booking;



@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	public Booking save(Booking booking);
	
	public List<Booking> findAll();
	
	public Optional<Booking> findById(int id);
	
	public void deleteById(int id);

}
