package model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private User user;

    private BarberShop barberShop;

    private List<EmployeeService> employeeServices;

    private List<Holiday> holidays = new ArrayList<>();

    private List<WorkingDay> workingDays = new ArrayList<>();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BarberShop getBarberShop() {
		return barberShop;
	}

	public void setBarberShop(BarberShop barberShop) {
		this.barberShop = barberShop;
	}

	public List<EmployeeService> getEmployeeServices() {
		return employeeServices;
	}

	public void setEmployeeServices(List<EmployeeService> employeeServices) {
		this.employeeServices = employeeServices;
	}

	public List<Holiday> getHolidays() {
		return holidays;
	}

	public void setHolidays(List<Holiday> holidays) {
		this.holidays = holidays;
	}

	public List<WorkingDay> getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(List<WorkingDay> workingDays) {
		this.workingDays = workingDays;
	}


    
}