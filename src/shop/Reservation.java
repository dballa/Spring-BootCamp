package shop;

import java.time.LocalDateTime;
import java.util.List;

public class Reservation {


    private LocalDateTime startTime;

    private User client;

    private List<EmployeeService> employeeServices;

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public List<EmployeeService> getEmployeeServices() {
		return employeeServices;
	}

	public void setEmployeeServices(List<EmployeeService> employeeServices) {
		this.employeeServices = employeeServices;
	}
    
    

}
