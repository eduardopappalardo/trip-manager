package eduardoppalardo.trip.manager.controller;

import java.util.HashSet;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eduardoppalardo.trip.manager.entity.Trip;
import eduardoppalardo.trip.manager.service.TripService;

@RestController
@RequestMapping("/Cart")
public class CartController {

	@Autowired
	private TripService tripService;

	@PutMapping
	public ResponseEntity<?> addToCart(@RequestBody Integer tripId, HttpSession session) {
		try {
			Optional<Trip> trip = tripService.findById(tripId);
			HashSet<Trip> sessionsTrips = (HashSet<Trip>) session.getAttribute(session.getId());

			if (sessionsTrips == null) {
				sessionsTrips = new HashSet<>();
				sessionsTrips.add(trip.get());
				session.setAttribute(session.getId(), sessionsTrips);
			} else {
				sessionsTrips.add(trip.get());
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping
	public ResponseEntity<?> removeTrip(@RequestBody Integer tripId, HttpSession session) {
		HashSet<Trip> sessionsTrips = (HashSet<Trip>) session.getAttribute(session.getId());

		if (sessionsTrips != null) {
			sessionsTrips.remove(new Trip(tripId));
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}