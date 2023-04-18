package com.Oefenen.Test.services;

import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    final GameRepository gameRepository;
    @Autowired
    public GameService(GameRepository gameRepository){ this.gameRepository = gameRepository; }

    public List<Game> getAllGames(){ return gameRepository.findAll(); }
    public Game createGame(Game game) { return gameRepository.save(game); }

    public Game getGameById(int id)
    {
        return gameRepository.findById(id).orElse(null);
    }

    public Game updateGame (Game game)
    {
        Game oldGame;
        Optional<Game> optionalGame = gameRepository.findById(game.getId());

        if(optionalGame.isPresent())
        {
            oldGame = optionalGame.get();
            oldGame.setName(game.getName());
            oldGame.setDescription(game.getDescription());
            oldGame.setDate(game.getDate());
            oldGame.setLocation(game.getLocation());
            gameRepository.save(oldGame);
        }
        else
        {
            return new Game();
        }

        return oldGame;
    }

    public String deleteGameById(int id){ gameRepository.deleteById(id); return "Game got deleted."; }

}
