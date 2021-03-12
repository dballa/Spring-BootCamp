package model;

import java.util.ArrayList;
import java.util.List;

public class ReservationRegister {
	
	private String id;
    private String businessDate;
    
    private List<TimeSlot> timeSlots = new ArrayList<>();
 

    public List<TimeSlot> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(List<TimeSlot> timeSlots) {
		this.timeSlots = timeSlots;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }


}
