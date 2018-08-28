package eduardoppalardo.trip.manager;

import java.time.LocalDate;
import java.time.Month;

import javax.annotation.PostConstruct;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import eduardoppalardo.trip.manager.entity.Trip;
import eduardoppalardo.trip.manager.service.TripService;

/**
 * Usado durante desenvolvimento
 */
@Component
public class MassaDeDados {

	@Autowired
	private TripService tripService;

	@Value("${spring.datasource.url}")
	private String dataSourceUrl;

	@PostConstruct
	public void iniciar() {
		gerarMassaDados();
		abrirVisualizadorBanco();
	}

	private void abrirVisualizadorBanco() {
		System.setProperty("java.awt.headless", "false");
		DatabaseManagerSwing.main(new String[] { "--url", dataSourceUrl, "--user", "sa", "--password", "" });
	}

	private void gerarMassaDados() {
		Trip trip1 = new Trip();
		trip1.setDepartureDate(LocalDate.of(2018, Month.DECEMBER, 16));
		trip1.setReturnDate(LocalDate.of(2019, Month.JANUARY, 15));
		trip1.setOriginCity("São Paulo");
		trip1.setDestinyCity("Rome");

		tripService.save(trip1);

		Trip trip2 = new Trip();
		trip2.setDepartureDate(LocalDate.of(2018, Month.JULY, 1));
		trip2.setReturnDate(LocalDate.of(2019, Month.JULY, 30));
		trip2.setOriginCity("São Paulo");
		trip2.setDestinyCity("Paris");

		tripService.save(trip2);

		Trip trip3 = new Trip();
		trip3.setDepartureDate(LocalDate.of(2018, Month.JANUARY, 1));
		trip3.setReturnDate(LocalDate.of(2018, Month.JANUARY, 30));
		trip3.setOriginCity("Belo Horizonte");
		trip3.setDestinyCity("London");

		tripService.save(trip3);

		Trip trip4 = new Trip();
		trip4.setDepartureDate(LocalDate.of(2018, Month.NOVEMBER, 1));
		trip4.setReturnDate(LocalDate.of(2018, Month.NOVEMBER, 30));
		trip4.setOriginCity("Curitiba");
		trip4.setDestinyCity("Berlim");

		tripService.save(trip4);
	}
}