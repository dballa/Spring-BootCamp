package academy.cabin;

import java.util.List;

public class Site {

	private Integer code;

	private String description;

	private String location;

	private List<Cabin> cabins;

	private List<Attribute> siteAttributes;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Cabin> getCabins() {
		return cabins;
	}

	public void setCabins(List<Cabin> cabins) {
		this.cabins = cabins;
	}

	public List<Attribute> getSiteAttributes() {
		return siteAttributes;
	}

	public void setSiteAttributes(List<Attribute> siteAttributes) {
		this.siteAttributes = siteAttributes;
	}

}
