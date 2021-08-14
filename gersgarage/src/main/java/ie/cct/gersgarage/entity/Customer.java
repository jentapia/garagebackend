package ie.cct.gersgarage.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, length=50, unique=true)
	private String email;
	
	@Column(nullable=false, length=8)
	private String password;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 50)
	private String surname;
	
	@Column(length = 15)
	private String mob_phone;
	
//	@OneToMany(mappedBy = "customer")
//	private List<Vehicle> vehicle;
//	
//	@OneToMany(mappedBy = "customer")
//	private List<Invoice> invoice;
	
//	@OneToMany(mappedBy = "customer")
//	private List<Booking> booking;
	
	
	
	/*
	 * public Customer(String email, String password, String name, String surname,
	 * String mob_phone, List<Vehicle> vehicle, List<Invoice> invoice) { super();
	 * this.email = email; this.password = password; this.name = name; this.surname
	 * = surname; this.mob_phone = mob_phone; this.vehicle = vehicle; this.invoice =
	 * invoice;
	 * 
	 * }
	 */
	
	
	
	


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Customer(String email, String password, String name, String surname, String mob_phone) {
		//super();
		
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.mob_phone = mob_phone;
	}
	
	



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMob_phone() {
		return mob_phone;
	}

	public void setMob_phone(String mob_phone) {
		this.mob_phone = mob_phone;
	}

//	public List<Vehicle> getVehicle() {
//		return vehicle;
//	}
//
//	public void setVehicle(List<Vehicle> vehicle) {
//		this.vehicle = vehicle;
//	}
//
//	public List<Invoice> getInvoice() {
//		return invoice;
//	}
//
//	public void setInvoice(List<Invoice> invoice) {
//		this.invoice = invoice;
//	}

//	public List<Booking> getBooking() {
//		return booking;
//	}
//
//	public void setBooking(List<Booking> booking) {
//		this.booking = booking;
//	}

}
