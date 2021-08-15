package ie.cct.gersgarage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.cct.gersgarage.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	public Item save(Item item);
	
	public List<Item> findAll();
	
	public Optional<Item> findById(int id);

	public void deleteById(int id);

}
