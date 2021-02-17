package academy.cabin;

import java.util.List;

public class Cabin {

	private Integer cabinNumber;

	private Integer numberOfFloors;

	private Integer numberOfKitchens;

	private Integer numberOfBathrooms;

	private Integer numberOfBedrooms;

	private Integer maxCapacity;

	private Double price;

	private Site site;

	private List<Attribute> cabinAttributes;

	private List<Booking> bookings;

	public Integer getCabinNumber() {
		return cabinNumber;
	}

	public void setCabinNumber(Integer cabinNumber) {
		this.cabinNumber = cabinNumber;
	}

	public Integer getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(Integer numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public Integer getNumberOfKitchens() {
		return numberOfKitchens;
	}

	public void setNumberOfKitchens(Integer numberOfKitchens) {
		this.numberOfKitchens = numberOfKitchens;
	}

	public Integer getNumberOfBathrooms() {
		return numberOfBathrooms;
	}

	public void setNumberOfBathrooms(Integer numberOfBathrooms) {
		this.numberOfBathrooms = numberOfBathrooms;
	}

	public Integer getNumberOfBedrooms() {
		return numberOfBedrooms;
	}

	public void setNumberOfBedrooms(Integer numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public List<Attribute> getCabinAttributes() {
		return cabinAttributes;
	}

	public void setCabinAttributes(List<Attribute> cabinAttributes) {
		this.cabinAttributes = cabinAttributes;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}
