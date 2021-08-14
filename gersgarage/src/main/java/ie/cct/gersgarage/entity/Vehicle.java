package ie.cct.gersgarage.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, unique=true)
	private String licplate;
	
	@Column
	private String vehicle_type;
	
	@Column
	private String veh_make;
	
	@Column
	private String veh_model;
	
	@Column
	private int veh_year;
	
	@Column
	private String engine;
	
	@Column
	private int customer_id;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "customer_id", referencedColumnName = "id")
//	private Customer customer;
//	
//	@OneToMany(mappedBy = "vehicle")
//	private List<Invoice> invoice;
//	
//	@OneToMany(mappedBy = "vehicle")
//	private List<Booking> booking;
	
	
		
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle(String licplate, String vehicle_type, String veh_make, String veh_model, int veh_year,
			String engine, int customer_id) {
		//super();
		this.licplate = licplate;
		this.vehicle_type = vehicle_type;
		this.veh_make = veh_make;
		this.veh_model = veh_model;
		this.veh_year = veh_year;
		this.engine = engine;
		this.customer_id = customer_id;
	}
	
	

	public Vehicle(String licplate, String vehicle_type, String veh_make, String veh_model, int veh_year,
			String engine) {
		//super();
		this.licplate = licplate;
		this.vehicle_type = vehicle_type;
		this.veh_make = veh_make;
		this.veh_model = veh_model;
		this.veh_year = veh_year;
		this.engine = engine;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLicplate() {
		return licplate;
	}
	
	public void setLicplate(String licplate) {
		this.licplate = licplate;
	}
	
	public String getVehicle_type() {
		return vehicle_type;
	}
	
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	
	public String getVeh_make() {
		return veh_make;
	}
	
	public void setVeh_make(String veh_make) {
		this.veh_make = veh_make;
	}
	
	public String getVeh_model() {
		return veh_model;
	}
	
	public void setVeh_model(String veh_model) {
		this.veh_model = veh_model;
	}
	
	public int getVeh_year() {
		return veh_year;
	}
	
	public void setVeh_year(int veh_year) {
		this.veh_year = veh_year;
	}
	
	public String getEngine() {
		return engine;
	}
	
	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	public List<Booking> getBooking() {
//		return booking;
//	}
//
//	public void setBooking(List<Booking> booking) {
//		this.booking = booking;
//	}
//
//	public List<Invoice> getInvoice() {
//		return invoice;
//	}
//
//	public void setInvoice(List<Invoice> invoice) {
//		this.invoice = invoice;
//	}
	
	
}
