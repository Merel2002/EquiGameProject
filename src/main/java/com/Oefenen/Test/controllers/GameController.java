package com.Oefenen.Test.controllers;

import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class GameController {
    @Autowired
    private GameService gameService;

    //om te testen
    @GetMapping("/games")
    public List<Game> getAllGames(){ return gameService.getAllGames(); }

    @PostMapping("/addGame")
    public Game addGame(@RequestBody Game game){ return gameService.createGame(game); }

    @GetMapping("/game/{id}")
    public Game getGameById(@PathVariable int id){ return gameService.getGameById(id); }

    @PutMapping("/updateGame")
    public Game updateGame(@RequestBody Game game){ return gameService.updateGame(game); }

    @DeleteMapping("/deleteGame/{id}")
    public String deleteGameById(@PathVariable int id){ return gameService.deleteGameById(id); }
}
