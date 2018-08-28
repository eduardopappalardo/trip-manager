package eduardoppalardo.trip.manager.service;

import java.util.List;
import java.util.Optional;

import eduardoppalardo.trip.manager.entity.Trip;

public interface TripService {

	public Trip save(Trip trip);

	public List<Trip> findAll(Trip tripFilter);

	public Optional<Trip> findById(Integer id);

}