package ie.cct.gersgarage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "services")
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, length=50)
	private String name;
	
	@Column
	private String description;
	
	@Column
	private float cost;
	
	
	
	public Service(String serv_name, String description, float cost) {
		super();
		this.name = serv_name;
		this.description = description;
		this.cost = cost;
	}
	
	

	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String serv_name) {
		this.name = serv_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	

	
		
}
