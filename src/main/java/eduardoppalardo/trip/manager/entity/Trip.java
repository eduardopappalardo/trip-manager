package eduardoppalardo.trip.manager.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Trip extends AbstractPersistable<Integer> {

	@NotNull
	@Column(nullable = false)
	private LocalDate departureDate;

	@NotNull
	@Column(nullable = false)
	private LocalDate returnDate;

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	private String originCity;

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	private String destinyCity;

	public Trip() {
	}

	public Trip(Integer id) {
		super.setId(id);
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public String getOriginCity() {
		return originCity;
	}

	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}

	public String getDestinyCity() {
		return destinyCity;
	}

	public void setDestinyCity(String destinyCity) {
		this.destinyCity = destinyCity;
	}
}