package com.Oefenen.Test;

import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Autowired
	private GameRepository gameRepository;

	@Override
	public void run(String... args) throws Exception {
		this.gameRepository.save(new Game("Roosberg", "Wedstrijd op 12-03-2029", "Bavel", LocalDate.of(2024, 4, 4)));
		this.gameRepository.save(new Game("Bavel", "Wedstrijd op 14-03-2029", "Breda", LocalDate.of(2024, 4, 4)));
	}
}
