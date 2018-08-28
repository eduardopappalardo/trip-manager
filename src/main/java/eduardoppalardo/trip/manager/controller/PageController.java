package eduardoppalardo.trip.manager.controller;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import eduardoppalardo.trip.manager.controller.dto.TripDto;
import eduardoppalardo.trip.manager.entity.Trip;

@Controller
public class PageController {

	@RequestMapping("/findTrips")
	public String findTrips() {
		return "findTrips";
	}

	@RequestMapping("/viewCart")
	public String viewCart(Model model, HttpSession httpSession) {
		HashSet<Trip> sessionsTrips = (HashSet<Trip>) httpSession.getAttribute(httpSession.getId());
		List<TripDto> trips = (sessionsTrips != null ? sessionsTrips : new HashSet<Trip>()).stream()
				.map(t -> TripDto.convert(t)).collect(Collectors.toList());
		model.addAttribute("trips", trips);
		return "viewCart";
	}
}