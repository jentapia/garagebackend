package ie.cct.gersgarage.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String availability;
	
	@Column
	private Date date;
	
	@Column
	private int staff_id;
	
	@Column
	private int booking_id;

	
		
	public Schedule(String availability, int staff_id, int booking_id) {
		super();
		this.availability = availability;
		this.staff_id = staff_id;
		this.booking_id = booking_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	
	
	
	

}
