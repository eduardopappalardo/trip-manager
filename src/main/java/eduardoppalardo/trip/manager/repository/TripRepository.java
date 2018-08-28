package eduardoppalardo.trip.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eduardoppalardo.trip.manager.entity.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer> {

	@Query("FROM Trip t WHERE (:#{#tripParam.departureDate} IS NULL OR t.departureDate = :#{#tripParam.departureDate})"
			+ " AND (:#{#tripParam.returnDate} IS NULL OR t.returnDate = :#{#tripParam.returnDate})"
			+ " AND (:#{#tripParam.originCity} IS NULL OR UPPER(t.originCity) LIKE CONCAT(CONCAT('%', UPPER(:#{#tripParam.originCity})), '%'))"
			+ " AND (:#{#tripParam.destinyCity} IS NULL OR UPPER(t.destinyCity) LIKE CONCAT(CONCAT('%', UPPER(:#{#tripParam.destinyCity})), '%'))")
	List<Trip> findAll(@Param("tripParam") Trip tripFilter);

}