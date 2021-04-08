package dto;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;


public class UserToCreateDto {
	
	private int id;
	
	@NotBlank(message="First name is mandatory")
	private String firstName;
	
	@NotBlank(message="Last name is mandatory")
	private String lastName;
	
	@NotBlank(message="Birthdate is mandatory")
	private LocalDate birthdate;
	
	@NotBlank(message="Username is mandatory")
	private String username;
	
	@NotBlank(message="Password is mandatory")
	private String password;
	
	private boolean enabled;
	@NotBlank(message="Role is mandatory")

	private long userRegistration;
	
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserToCreateDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthdate="
				+ birthdate + ", username=" + username + ", password=" + password + ", enabled=" + enabled + ", role="
				+ role + "]";
	}

}
