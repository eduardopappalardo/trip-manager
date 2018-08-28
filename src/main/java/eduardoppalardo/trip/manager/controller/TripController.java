package eduardoppalardo.trip.manager.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eduardoppalardo.trip.manager.controller.dto.TripDto;
import eduardoppalardo.trip.manager.entity.Trip;
import eduardoppalardo.trip.manager.service.TripService;

@RestController
@RequestMapping("/Trip")
public class TripController {

	@Autowired
	private TripService tripService;

	@GetMapping
	public ResponseEntity<?> findAll(
			@RequestParam("departureDate") @DateTimeFormat(iso = ISO.DATE) LocalDate departureDate,
			@RequestParam("returnDate") @DateTimeFormat(iso = ISO.DATE) LocalDate returnDate,
			@RequestParam("originCity") String originCity, @RequestParam("destinyCity") String destinyCity) {
		try {
			Trip tripFilter = new Trip();
			tripFilter.setDepartureDate(departureDate);
			tripFilter.setReturnDate(returnDate);
			tripFilter.setOriginCity(originCity);
			tripFilter.setDestinyCity(destinyCity);

			List<TripDto> trips = tripService.findAll(tripFilter).stream().map(t -> TripDto.convert(t))
					.collect(Collectors.toList());
			return new ResponseEntity<>(trips, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}