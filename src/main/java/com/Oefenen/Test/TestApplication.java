package com.Oefenen.Test;

import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.models.Rider;
import com.Oefenen.Test.repositories.EnrollmentRepository;
import com.Oefenen.Test.repositories.GameRepository;
import com.Oefenen.Test.repositories.RiderRepository;
import com.Oefenen.Test.services.EnrollmentService;
import com.Oefenen.Test.services.GameService;
import com.Oefenen.Test.services.RiderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class TestApplication{

	public GameService gameService;
	public RiderService riderService;
	public EnrollmentService enrollmentService;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Bean
	CommandLineRunner run(GameRepository gameRepository, RiderRepository riderRepository, EnrollmentRepository enrollmentRepository){
		return args -> {
			Game game = new Game("Game1", "Test game", "locatie 1", LocalDate.of(2024, 9, 9));
			Rider rider = new Rider("rider", "horse");
			gameRepository.save(game);
			riderRepository.save(rider);
			enrollmentRepository.save(new Enrollment(game, rider));
		};
	}

}
