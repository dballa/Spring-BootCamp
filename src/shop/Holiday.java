package shop;


import java.time.LocalTime;

public class Holiday  {

    private String day;

    private boolean isFullDay;

    private LocalTime startTime;

    private LocalTime endTime;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public boolean isFullDay() {
		return isFullDay;
	}

	public void setFullDay(boolean isFullDay) {
		this.isFullDay = isFullDay;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

    
}
