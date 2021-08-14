package ie.cct.gersgarage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.cct.gersgarage.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	public User findByUsername(String username);

}
