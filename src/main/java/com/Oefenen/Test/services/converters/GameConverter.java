package com.Oefenen.Test.services.converters;

import com.Oefenen.Test.models.DTO.CreateRiderDTO;
import com.Oefenen.Test.models.DTO.GameDTO;
import com.Oefenen.Test.models.DTO.RiderDTO;
import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.models.Rider;

public class GameConverter {
    public GameDTO gameToGameDTO(Game game){
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(game.getId());
        gameDTO.setName(game.getName());
        gameDTO.setDescription(game.getDescription());
        gameDTO.setDate(game.getDate());
        gameDTO.setLocation(game.getLocation());

        return gameDTO;
    }

    public Game gameDTOToGame(GameDTO gameDTO){
        Game game = new Game();
        game.setId(gameDTO.getId());
        game.setName(gameDTO.getName());
        game.setDescription(gameDTO.getDescription());
        game.setDate(gameDTO.getDate());
        game.setLocation(gameDTO.getLocation());

        return game;
    }

}
