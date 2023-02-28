package com.Oefenen.Test.controllers;

import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;


    @PostMapping("/addGame")
    public Game addGame(@RequestBody Game game){ return gameService.createGame(game); }

    @GetMapping("/game/{id}")
    public Game getGameById(@PathVariable int id){ return gameService.getGameById(id); }

    @PutMapping("/updateGame")
    public Game updateGame(@RequestBody Game game){ return gameService.updateGame(game); }

    @DeleteMapping("/game/{id}")
    public String deleteGameById(@PathVariable int id){ return gameService.deleteGameById(id); }
}
