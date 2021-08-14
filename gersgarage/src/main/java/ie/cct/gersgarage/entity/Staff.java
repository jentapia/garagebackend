package ie.cct.gersgarage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, length=50)
	private String firstname;
	
	@Column(nullable=false, length=50)
	private String surname;
	
	@Column
	private String phone;
	
	private String address;
	
		
	public Staff(String name, String surname) {
		super();
		this.firstname = name;
		this.surname = surname;
	}
	
	public Staff(String name, String surname, String phone, String address) {
		super();
		this.firstname = name;
		this.surname = surname;
		this.phone = phone;
		this.address = address;
	}

	

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String name) {
		this.firstname = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
