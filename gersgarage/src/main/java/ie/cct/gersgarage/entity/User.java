package ie.cct.gersgarage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, length=50, unique=true)
	private String username;
	
	@Column(nullable=false, length=8)
	private String password;
		
		
	
	
	public User(String username, String password) { 
		  super(); 
		  this.username = username; 
		  this.password = password; 
	}
	
	
	 


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
