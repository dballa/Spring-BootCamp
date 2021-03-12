package model;

import java.util.ArrayList;
import java.util.List;

public class BarberShop {

    private String name;

    private String code;

    private String description;

    private List<Employee> employees;

    private List<Holiday> holidays = new ArrayList<>();

    private List<ShopService> services = new ArrayList<>();

    private List<WorkingDay> workingDays = new ArrayList<>();
    
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

	public List<Holiday> getHolidays() {
		return holidays;
	}

	public void setHolidays(List<Holiday> holidays) {
		this.holidays = holidays;
	}

	public List<ShopService> getServices() {
		return services;
	}

	public void setServices(List<ShopService> services) {
		this.services = services;
	}

	public List<WorkingDay> getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(List<WorkingDay> workingDays) {
		this.workingDays = workingDays;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}  

}