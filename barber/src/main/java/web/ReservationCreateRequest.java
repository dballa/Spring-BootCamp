package web;
	
	import java.time.LocalDateTime;

import model.EmployeeService;

	public class ReservationCreateRequest {
		
	    private String username;
	    
	    EmployeeService employeeService;
	    
	    private LocalDateTime startDate;
	    private LocalDateTime endDate;

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public EmployeeService getEmployeeService() {
			return employeeService;
		}

		public void setEmployeeService(EmployeeService employeeService) {
			this.employeeService = employeeService;
		}

		public LocalDateTime getStartDate() {
	        return startDate;
	    }

	    public void setStartDate(LocalDateTime startDate) {
	        this.startDate = startDate;
	    }

	    public LocalDateTime getEndDate() {
	        return endDate;
	    }

	    public void setEndDate(LocalDateTime endDate) {
	        this.endDate = endDate;
	    }

}
