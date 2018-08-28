package eduardoppalardo.trip.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eduardoppalardo.trip.manager.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}