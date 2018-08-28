package eduardoppalardo.trip.manager.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Embeddable
public class UserAddress {

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	private String street;

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	private String city;

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	private String state;

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	private String country;

	@NotBlank
	@Size(max = 50)
	@Column(nullable = false, length = 50)
	private String zipCode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}