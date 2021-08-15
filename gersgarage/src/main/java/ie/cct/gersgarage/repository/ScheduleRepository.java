package ie.cct.gersgarage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.cct.gersgarage.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
	
	public Schedule save(Schedule schedule);
	
	public List<Schedule> findAll();
	
	public Optional<Schedule> findById(int id);

	public void deleteById(int id);

}
