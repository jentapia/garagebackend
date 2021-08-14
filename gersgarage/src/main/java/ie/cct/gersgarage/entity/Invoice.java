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
@Table(name = "invoices")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int total_due;
	
	private String invoice_date;
	
	private String details;
	
	private int booking_id;
	
	private int customer_id;
	
	private int vehicle_id;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "customer_id", referencedColumnName = "id")
//	private Customer customer;
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "vehicle_id", referencedColumnName = "id")
//	private Vehicle vehicle;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "booking_id", referencedColumnName = "id")
//	private Booking booking;
	

	
	
		
	public Invoice(int total_due, String invoice_date, String details, int booking_id) {
		//super();
		this.total_due = total_due;
		this.invoice_date = invoice_date;
		this.details = details;
		this.booking_id = booking_id;
	}

	
	public Invoice(int total_due, String invoice_date, String details, int booking_id, int customer_id, int vehicle_id) {
	super();
	this.total_due = total_due;
	this.invoice_date = invoice_date;
	this.details = details;
	this.booking_id = booking_id;
	this.customer_id = customer_id;
	this.vehicle_id = vehicle_id;
}



	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInvoice_date() {
		return invoice_date;
	}
	
	public void setInvoice_date(String invoice_date) {
		this.invoice_date = invoice_date;
	}
	
	public int getTotal_due() {
		return total_due;
	}
	
	public void setTotal_due(int total_due) {
		this.total_due = total_due;
	}

	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
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

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
		
		

}
