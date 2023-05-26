package com.Oefenen.Test.services;

import com.Oefenen.Test.models.DTO.GameDTO;
import com.Oefenen.Test.models.DTO.RiderDTO;
import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.models.Rider;
import com.Oefenen.Test.repositories.GameCustomRepository;
import com.Oefenen.Test.repositories.GameRepository;
import com.Oefenen.Test.services.converters.GameConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    final GameCustomRepository gameRepository;
    private GameConverter gameConverter = new GameConverter();
    @Autowired
    public GameService(GameCustomRepository gameRepository){ this.gameRepository = gameRepository; }

    public List<GameDTO> getAllGames(){
        Iterable<Game> games = gameRepository.findAllByOrderByDateAsc();
        List<GameDTO> gameDTOS = new ArrayList<>();

        for(Game game: games){
            gameDTOS.add(gameConverter.gameToGameDTO(game));
        }

        return gameDTOS;
    }
    public boolean createGame(GameDTO gameDTO) {
        Game game = gameConverter.gameDTOToGame(gameDTO);
        game = gameRepository.save(game);
        if(game != null){
            return true;
        }
        return false;
    }

    public GameDTO getGameById(int id) {
        Game game = gameRepository.findById(id).orElse(null);

        return gameConverter.gameToGameDTO(game);
    }

    public GameDTO getGameByName(String name) {
        Game game = gameRepository.findByName(name);

        return gameConverter.gameToGameDTO(game);
    }

    public boolean updateGame (GameDTO gameDTO)
    {
        Optional<Game> optionalGame = gameRepository.findById(gameDTO.getId());

        if(optionalGame.isPresent())
        {
            gameRepository.save(optionalGame.get());
            return true;
        }

        return false;
    }

    public String deleteGameById(int id){
        gameRepository.deleteById(id);
        return "Game got deleted.";
    }

}
