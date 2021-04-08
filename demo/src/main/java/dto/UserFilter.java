package dto;

public class UserFilter {
	
	private String firstName;
	private String lastName;
	private Integer age;
	private String sortBy;
	private String order;
	
	
	public UserFilter(String firstName, String lastName, Integer age, String sortBy, String order) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sortBy = sortBy;
		this.order = order;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "UserFilter [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", sortBy=" + sortBy
				+ ", order=" + order + "]";
	}
	
	

}
