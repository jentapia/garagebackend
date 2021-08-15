package ie.cct.gersgarage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ie.cct.gersgarage.util.JWTIssuer;
import ie.cct.gersgarage.exceptions.UnauthorizedException;
import ie.cct.gersgarage.entity.*;
import ie.cct.gersgarage.exceptions.BadRequestException;
import ie.cct.gersgarage.model.*;
import ie.cct.gersgarage.repository.*;
import ie.cct.gersgarage.service.CustomerService;

@RestController
@CrossOrigin("*")
public class GersgarageController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	//******************** LOGIN FUNCTIONS ************************
	// customer login		
	@GetMapping("/login")
	public Token login(
			@RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "password", required = true) String password) {

		Customer customer = customerService.findByEmail(email);
		Token tokenUser;
		
		if (customer == null) {	//checking if the user exists
			throw new BadRequestException("User does not exist");
		}
		
		if (customer.getEmail().contentEquals(email) && customer.getPassword().contentEquals(password)) { //checking if the credentials match
					//userOnLine.setUsername(username);
					//userOnLine.setPassword(password);
					
					tokenUser = new Token(JWTIssuer.createJWT(email, "gersgarage", email, 86400000)); //creating a token and setting it in a Token object 
					//return JWTIssuer.createJWT(username, "gersgarage", username, 86400000);
					return tokenUser;
		}
		
		throw new UnauthorizedException("Credentials do not match");
	}
	
	//Admin login
	@GetMapping("admin/login")
	public Token loginAdmin(
			@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "password", required = true) String password) {

		User user = userRepository.findByUsername(username);
		Token tokenUser;
		
		if (user == null) {	//checking if the user exists
			throw new BadRequestException("User does not exist");
		}
		
		if (user.getUsername().contentEquals(username) && user.getPassword().contentEquals(password)) { //checking if the credentials match
		
			tokenUser = new Token(JWTIssuer.createJWT(username, "gersgarage", username, 86400000)); //creating a token and setting it in a Token object 
			return tokenUser;
			}
		
		throw new UnauthorizedException("Credentials do not match");
	}
	
	
	//******************** CUSTOMER FUNCTIONS ************************
		
	//Register a new customer
	@PostMapping("/registeruser")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
		Customer fCustomer = customerService.findByEmail(customer.getEmail());
		
		if(fCustomer == null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
		}
		throw new BadRequestException("User already exists");
		//return ResponseEntity.badRequest().build();
	}
	
		
	//Find a customer
	@GetMapping("/{email}")
	public ResponseEntity<?> readCustomer(@PathVariable String email){
		Customer customer = customerService.findByEmail(email);
		
		if(customer == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(customer);
		
	}
	
	
	//Update a customer
	@PutMapping("/{email}")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customerDetails, @PathVariable(value = "email") String email){
		Customer customer = customerService.findByEmail(email);
		
		if(customer == null) {
			return ResponseEntity.notFound().build();
		}
		
		customer.setName(customerDetails.getName());;
		customer.setSurname(customerDetails.getSurname());
		customer.setEmail(customerDetails.getEmail());
		customer.setPassword(customerDetails.getPassword());
		customer.setMob_phone(customerDetails.getMob_phone());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
	}
	
	
	//Delete a customer
	@DeleteMapping("/{email}")
	public ResponseEntity<?> deleteCustomer (@PathVariable(value = "email") String email){
		Customer customer = customerService.findByEmail(email);
		
		if(customer == null) {
			return ResponseEntity.notFound().build();
		}
		
		customerService.deleteByEmail(email);
		return ResponseEntity.ok().build();
	}
	
	
	//Read all customers
	@GetMapping("/customers")
	public List<Customer> readAllCustomers(){
		
		List<Customer> customers = StreamSupport.stream(customerService.findAll()
				.spliterator(), false).collect(Collectors.toList());
		
		return customers;
	}
	
	
	//******************** BOOKING FUNCTIONS ************************
	//Read all bookings
	@GetMapping("/bookings")
	public List<Booking> readAllBookings(){
			
		List<Booking> bookings = StreamSupport.stream(bookingRepository.findAll()
				.spliterator(), false).collect(Collectors.toList());
			
		return bookings;
	}
		
	//Read a booking
	@GetMapping("/bookings/{id}")
	public ResponseEntity<?> readBooking(@PathVariable int id){
				
		Optional<Booking> booking = bookingRepository.findById(id);
		
		if(!booking.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(booking);
	}
	
	//Edit a booking
	@PutMapping("editbooking/{id}")
	public ResponseEntity<?> updateBooking(@RequestBody Booking bookingDetails, @PathVariable(value = "id") int id){
		Optional<Booking> booking = bookingRepository.findById(id);
				
		if(!booking.isPresent()) {
			return ResponseEntity.notFound().build();
		}
				
		booking.get().setBooking_status(bookingDetails.getBooking_status());
		booking.get().setBooking_type(bookingDetails.getBooking_type());
		booking.get().setBooking_date(bookingDetails.getBooking_date());
		booking.get().setComments(bookingDetails.getComments());
		booking.get().setCustomer_id(bookingDetails.getCustomer_id());
		booking.get().setVehicle_id(bookingDetails.getVehicle_id());
		
				
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingRepository.save(booking.get()));
	}
	
	//Register a new booking
	@PostMapping("/registerbooking")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<?> registerBooking(@RequestBody Booking booking) {

		return ResponseEntity.status(HttpStatus.CREATED).body(bookingRepository.save(booking));
			
	}
	
		
	//Register a new booking
	@PostMapping("/registerbooking2")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<?> registerBooking2(@RequestParam(name = "email") String email, @RequestParam(name = "lic_plate") String licplate, @RequestBody Booking booking) {

		Customer customer = customerService.findByEmail(email);
		
		if(customer == null) {
			return ResponseEntity.notFound().build();
		}
		
		Vehicle vehicle = vehicleRepository.findByLicplate(licplate);
		
				
		Booking book = bookingRepository.save(new Booking(booking.getBooking_type(), booking.getBooking_date(), booking.getBooking_status(), booking.getComments(), customer.getId(), vehicle.getId()));
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(book);
				
	}
	
	//Register a vehicle
	@PostMapping("/registervehicle")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<?> registerVehicle(@RequestParam(name = "email") String email, @RequestBody Vehicle vehicle) {
		Customer customer = customerService.findByEmail(email);
		
		Vehicle fvehicle = vehicleRepository.findByLicplate(vehicle.getLicplate());
		
		if(fvehicle == null) {
			Vehicle veh = vehicleRepository.save(new Vehicle(vehicle.getLicplate(), vehicle.getVehicle_type(), 
					vehicle.getVeh_make(),vehicle.getVeh_model(), vehicle.getVeh_year(), vehicle.getEngine(), customer.getId()));
			
			return ResponseEntity.status(HttpStatus.CREATED).body(veh);
		}
		
		else {
		
			return ResponseEntity.status(HttpStatus.FOUND).body(fvehicle);
					
		}
	}
	
	//******************** STAFF FUNCTIONS ************************
	//Create a staff member
	@PostMapping("/newstaff")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<?> newStaff(@RequestBody Staff staff) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(staffRepository.save(staff));
		
	}
	
	//Read all staff members
	@GetMapping("/stafflist")
	public List<Staff> readAllStaff(){
				
		List<Staff> staff = StreamSupport.stream(staffRepository.findAll()
				.spliterator(), false).collect(Collectors.toList());
				
		return staff;
	}
	
	//Read a staff member
	@GetMapping("/staff/{id}")
	public ResponseEntity<?> readStaff(@PathVariable int id){
					
		Optional<Staff> staff = staffRepository.findById(id);
			
		if(!staff.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(staff);
	}
	
	//Edit a staff member
	@PutMapping("editmember/{id}")
	public ResponseEntity<?> updateStaff(@RequestBody Staff staffDetails, @PathVariable(value = "id") int id){
		Optional<Staff> staff = staffRepository.findById(id);
				
		if(!staff.isPresent()) {
			return ResponseEntity.notFound().build();
		}
				
		staff.get().setFirstname(staffDetails.getFirstname());
		staff.get().setSurname(staffDetails.getSurname());
		staff.get().setAddress(staffDetails.getAddress());
		staff.get().setPhone(staffDetails.getPhone());
								
		return ResponseEntity.status(HttpStatus.CREATED).body(staffRepository.save(staff.get()));
	}

	//Delete a staff member
	@DeleteMapping("deletestaff/{id}")
	public ResponseEntity<?> deleteStaff (@PathVariable(value = "id") int id){
		Optional<Staff> staff = staffRepository.findById(id);
		
		if(!staff.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		staffRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
	//******************** ITEM FUNCTIONS ************************
	//Create a new item
	@PostMapping("/newitem")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<?> newItem(@RequestBody Item item) {
			
		return ResponseEntity.status(HttpStatus.CREATED).body(itemRepository.save(item));
			
	}
	
	//Read all items
	@GetMapping("/itemlist")
	public List<Item> readAllItems(){
				
		List<Item> items = StreamSupport.stream(itemRepository.findAll()
				.spliterator(), false).collect(Collectors.toList());
				
		return items;
	}
	
	//Edit an item
	@PutMapping("edititem/{id}")
	public ResponseEntity<?> updateItem(@RequestBody Item itemDetails, @PathVariable(value = "id") int id){
		Optional<Item> item = itemRepository.findById(id);
				
		if(!item.isPresent()) {
			return ResponseEntity.notFound().build();
		}
				
		item.get().setItem_name(itemDetails.getItem_name());
		item.get().setDescription(itemDetails.getDescription());
		item.get().setCost(itemDetails.getCost());
										
		return ResponseEntity.status(HttpStatus.CREATED).body(itemRepository.save(item.get()));
	}

	//Delete an item
	@DeleteMapping("deleteitem/{id}")
	public ResponseEntity<?> deleteItem (@PathVariable(value = "id") int id){
		Optional<Item> item = itemRepository.findById(id);
		
		
		if(!item.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		itemRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	//******************** SERVICE FUNCTIONS ************************
	//Create a new service
	@PostMapping("/newservice")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<?> newService(@RequestBody Service service) {
			
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceRepository.save(service));
			
	}
	
	//Read all services
	@GetMapping("/servicelist")
	public List<Service> readAllServices(){
		
		List<Service> services = StreamSupport.stream(serviceRepository.findAll()
				.spliterator(), false).collect(Collectors.toList());
				
		return services;
	}

	//Read a service by id
	@GetMapping("/service/{id}")
	public ResponseEntity<?> readServById(@PathVariable(value = "id") int id){
					
		Optional<Service> service = serviceRepository.findById(id);
		
		if(!service.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(service);
	}
	
	//Edit a service
	@PutMapping("editservice/{id}")
	public ResponseEntity<?> updateService(@RequestBody Service serviceDetails, @PathVariable(value = "id") int id){
		Optional<Service> service = serviceRepository.findById(id);
				
		if(!service.isPresent()) {
			return ResponseEntity.notFound().build();
		}
				
		service.get().setDescription(serviceDetails.getDescription());
		service.get().setName(serviceDetails.getName());
		service.get().setCost(serviceDetails.getCost());
						
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceRepository.save(service.get()));
	}

	//Delete a service
	@DeleteMapping("deleteservice/{id}")
	public ResponseEntity<?> deleteService (@PathVariable(value = "id") int id){
		Optional<Service> service = serviceRepository.findById(id);
		
		
		if(!service.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		serviceRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}	
	
	
	//******************** INVOICE FUNCTIONS ************************
	//Create a new invoice
	@PostMapping("/newinvoice")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<?> newInvoice(@RequestBody Invoice invoice) {
			
		return ResponseEntity.status(HttpStatus.CREATED).body(invoiceRepository.save(invoice));
			
	}
	
	//Read all invoices
	@GetMapping("/invoicelist")
	public List<Invoice> readAllInvoices(){
		
		List<Invoice> invoices = StreamSupport.stream(invoiceRepository.findAll()
				.spliterator(), false).collect(Collectors.toList());
				
		return invoices;
	}
	
	//Edit an invoice
	@PutMapping("editinvoice/{id}")
	public ResponseEntity<?> updateInvoice(@RequestBody Invoice invoiceDetails, @PathVariable(value = "id") int id){
		Optional<Invoice> invoice = invoiceRepository.findById(id);
				
		if(!invoice.isPresent()) {
			return ResponseEntity.notFound().build();
		}
				
		invoice.get().setInvoice_date(invoiceDetails.getInvoice_date());
		invoice.get().setTotal_due(invoiceDetails.getTotal_due());
		invoice.get().setBooking_id(invoiceDetails.getBooking_id());
		invoice.get().setCustomer_id(invoiceDetails.getCustomer_id());
		invoice.get().setDetails(invoiceDetails.getDetails());
		invoice.get().setVehicle_id(invoiceDetails.getVehicle_id());
		
						
		return ResponseEntity.status(HttpStatus.CREATED).body(invoiceRepository.save(invoice.get()));
	}

	//Delete an invoice
	@DeleteMapping("deleteinvoice/{id}")
	public ResponseEntity<?> deleteInvoice (@PathVariable(value = "id") int id){
		Optional<Invoice> invoice = invoiceRepository.findById(id);
		
		
		if(!invoice.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		invoiceRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
}
