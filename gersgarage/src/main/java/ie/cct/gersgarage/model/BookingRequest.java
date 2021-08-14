package ie.cct.gersgarage.model;

import javax.persistence.Column;

public class BookingRequest {
	
	
	private String booking_type;
	private String booking_date;
	private String booking_status;
	private String comments;
	private String licplate;
	private String vehicle_type;
	private String veh_make;
	private String veh_model;
	private int veh_year;
	private String engine;
	private String email;
	
	public BookingRequest(String booking_type, String booking_date, String booking_status, String comments,
			String licplate, String vehicle_type, String veh_make, String veh_model, int veh_year, String engine,
			String email) {
		super();
		this.booking_type = booking_type;
		this.booking_date = booking_date;
		this.booking_status = booking_status;
		this.comments = comments;
		this.licplate = licplate;
		this.vehicle_type = vehicle_type;
		this.veh_make = veh_make;
		this.veh_model = veh_model;
		this.veh_year = veh_year;
		this.engine = engine;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
