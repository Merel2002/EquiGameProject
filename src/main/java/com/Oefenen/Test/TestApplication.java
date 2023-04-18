package com.Oefenen.Test;

import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.models.Rider;
import com.Oefenen.Test.services.EnrollmentService;
import com.Oefenen.Test.services.GameService;
import com.Oefenen.Test.services.RiderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

	public GameService gameService;
	public RiderService riderService;
	public EnrollmentService enrollmentService;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Game game = new Game("Game1", "Testg game", "locatie 1", LocalDate.of(2019, 9, 9));
		Rider rider = new Rider("rider", "horse");
		gameService.createGame(game);
		riderService.createRider(rider);
		enrollmentService.createEnrollment(new Enrollment(game, rider));
	}
}
