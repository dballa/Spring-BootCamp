package shop;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BarberShop {

    private String name;

    private String code;

    private BigInteger longitude;

    private BigInteger latitude;

    private String description;

    private List<Employee> employees;

    private List<Product> products;

    private List<Holiday> holidays = new ArrayList<>();

    private List<Service> services = new ArrayList<>();

    private List<WorkingDays> workingDays = new ArrayList<>();
    
    private User owner;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigInteger getLongitude() {
		return longitude;
	}

	public void setLongitude(BigInteger longitude) {
		this.longitude = longitude;
	}

	public BigInteger getLatitude() {
		return latitude;
	}

	public void setLatitude(BigInteger latitude) {
		this.latitude = latitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Holiday> getHolidays() {
		return holidays;
	}

	public void setHolidays(List<Holiday> holidays) {
		this.holidays = holidays;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<WorkingDays> getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(List<WorkingDays> workingDays) {
		this.workingDays = workingDays;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
    

}
