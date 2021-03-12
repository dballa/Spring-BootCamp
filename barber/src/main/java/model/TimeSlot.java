package model;

import java.time.LocalDateTime;
import java.util.List;

	public class TimeSlot {
		
	    private LocalDateTime startTime;
	    private LocalDateTime endTime;
	    
	    private List<Reservation> reservations;

	    public LocalDateTime getStartTime() {
			return startTime;
		}

		public void setStartTime(LocalDateTime startTime) {
			this.startTime = startTime;
		}

		public LocalDateTime getEndTime() {
			return endTime;
		}

		public void setEndTime(LocalDateTime endTime) {
			this.endTime = endTime;
		}

		public List<Reservation> getReservations() {
	        return reservations;
	    }

	    public void setReservations(List<Reservation> reservations) {
	        this.reservations = reservations;
	    }
	}
