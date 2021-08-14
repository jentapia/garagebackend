package ie.cct.gersgarage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookservices")
public class BookService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private int booking_id;
	private int service_id;
	
	
	
	
	public BookService(int booking_id, int service_id) {
		//super();
		this.booking_id = booking_id;
		this.service_id = service_id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	
	
	

}
