package com.Oefenen.Test.repositories;

import com.Oefenen.Test.models.Game;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameCustomRepository extends GameRepository{
    Game findByName(String name);
}
