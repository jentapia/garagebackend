package ie.cct.gersgarage.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String booking_type;
	private String booking_date;
	private String booking_status;
	private String comments;
	private int customer_id;
	private int vehicle_id;
	
	
//	  @ManyToOne(cascade = CascadeType.ALL)
//	  @JoinColumn(name = "customer_id", referencedColumnName = "id") 
//	  private Customer customer;
//	 	
//	  @ManyToOne(cascade = CascadeType.ALL)
//	  @JoinColumn(name = "vehicle_id", referencedColumnName = "id") 
//	  private Vehicle vehicle;
//	  
//	  @OneToOne(mappedBy = "booking") 
//	  private Invoice invoice;
	 
	
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	/*
	 * public Booking(String booking_type, String booking_date, String
	 * booking_status, String comments, Customer customer, Vehicle vehicle) {
	 * super(); this.booking_type = booking_type; this.booking_date = booking_date;
	 * this.booking_status = booking_status; this.comments = comments; this.customer
	 * = customer; this.vehicle = vehicle; }
	 */

	


	public Booking(String booking_type, String booking_date, String booking_status, String comments) {
		//super();
		this.booking_type = booking_type;
		this.booking_date = booking_date;
		this.booking_status = booking_status;
		this.comments = comments;
	}
	
	
	public Booking(String booking_type, String booking_date, String booking_status, String comments, int customer_id,
			int vehicle_id) {
		//super();
		this.booking_type = booking_type;
		this.booking_date = booking_date;
		this.booking_status = booking_status;
		this.comments = comments;
		this.customer_id = customer_id;
		this.vehicle_id = vehicle_id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBooking_type() {
		return booking_type;
	}


	public void setBooking_type(String booking_type) {
		this.booking_type = booking_type;
	}


	public String getBooking_date() {
		return booking_date;
	}


	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}


	public String getBooking_status() {
		return booking_status;
	}


	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}



	public int getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}



	public int getVehicle_id() {
		return vehicle_id;
	}



	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	
//
//	public Customer getCustomer() {
//		return customer;
//	}
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

//	public Vehicle getVehicle() {
//		return vehicle;
//	}
//	public void setVehicle(Vehicle vehicle) {
//		this.vehicle = vehicle;
//	}
//	public Invoice getInvoice() {
//		return invoice;
//	}
//	public void setInvoice(Invoice invoice) {
//		this.invoice = invoice;
//	}
	
	

}
