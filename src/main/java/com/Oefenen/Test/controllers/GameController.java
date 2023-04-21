package com.Oefenen.Test.controllers;

import com.Oefenen.Test.models.DTO.GameDTO;

import com.Oefenen.Test.services.GameService;
import com.Oefenen.Test.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private ValidationService validationService;

    @GetMapping("/games")
    public ResponseEntity<List<GameDTO>> getAllGames(){
        List<GameDTO> gameDTOS = gameService.getAllGames();
        return ResponseEntity.ok(gameDTOS);
    }

    @PostMapping("/addGame")
    public boolean addGame(@RequestBody GameDTO gameDTO){
        boolean valid[] = {false, false, false, false};

        valid[0] = validationService.stringValidator(gameDTO.getName(), 0, 50);
        valid[1] = validationService.stringValidator(gameDTO.getDescription(), 0, 500);
        valid[2] = validationService.dateValidator(gameDTO.getDate());
        valid[3] = validationService.stringValidator(gameDTO.getLocation(), 0, 20);

        boolean validator = false;
        if(valid[0] && valid[1] && valid[2] && valid[3]){
            validator = gameService.createGame(gameDTO);
        }
        return validator;
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<GameDTO> getGameById(@PathVariable int id){
        boolean valid = false;
        valid = validationService.intValidator(id, 0);

        if(valid){
            GameDTO gamedto = gameService.getGameById(id);
            return ResponseEntity.ok(gamedto);
        }
        return null;
    }

    @GetMapping("/game/{name}")
    public ResponseEntity<GameDTO> getGameByName(@PathVariable String name){
        boolean valid = false;
        valid = validationService.stringValidator(name, 0, 50);

        if(valid){
            GameDTO gamedto = gameService.getGameByName(name);
            return ResponseEntity.ok(gamedto);
        }
        return null;
    }

    @PutMapping("/updateGame")
    public boolean updateGame(@RequestBody GameDTO gameDTO){
        boolean valid[] = {false, false, false, false, false};

        valid[0] = validationService.stringValidator(gameDTO.getName(), 0, 50);
        valid[1] = validationService.stringValidator(gameDTO.getDescription(), 0, 500);
        valid[2] = validationService.dateValidator(gameDTO.getDate());
        valid[3] = validationService.stringValidator(gameDTO.getLocation(), 0, 20);
        valid[4] = validationService.intValidator(gameDTO.getId(), 0);

        boolean validator = false;
        if(valid[0] && valid[1] && valid[2] && valid[3] && valid[4]){
            validator = gameService.updateGame(gameDTO);
        }

        return validator;
    }

    @DeleteMapping("/deleteGame/{id}")
    public String deleteGameById(@PathVariable int id){
        boolean valid = false;
        valid = validationService.intValidator(id, 0);

        if(valid){
            return gameService.deleteGameById(id);
        }
        return "Rider didn't got deleted.";
    }
}
