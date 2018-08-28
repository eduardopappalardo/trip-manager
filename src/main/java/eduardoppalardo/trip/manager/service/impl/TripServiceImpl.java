package eduardoppalardo.trip.manager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduardoppalardo.trip.manager.entity.Trip;
import eduardoppalardo.trip.manager.repository.TripRepository;
import eduardoppalardo.trip.manager.service.TripService;
import eduardoppalardo.trip.manager.validation.Validator;

@Service
public class TripServiceImpl implements TripService {

	@Autowired
	private TripRepository tripRepository;

	@Autowired
	private Validator validator;

	@Override
	public Trip save(Trip trip) {
		validator.validate(trip);
		return tripRepository.save(trip);
	}

	@Override
	public List<Trip> findAll(Trip tripFilter) {
		return tripRepository.findAll(tripFilter != null ? tripFilter : new Trip());
	}

	@Override
	public Optional<Trip> findById(Integer id) {
		return tripRepository.findById(id);
	}
}