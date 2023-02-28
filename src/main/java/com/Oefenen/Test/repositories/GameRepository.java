package com.Oefenen.Test.repositories;

import com.Oefenen.Test.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
