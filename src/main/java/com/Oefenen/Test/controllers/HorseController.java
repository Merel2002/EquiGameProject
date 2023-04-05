package com.Oefenen.Test.controllers;

import com.Oefenen.Test.models.Horse;
import com.Oefenen.Test.services.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class HorseController {
    @Autowired
    private HorseService horseService;

    @GetMapping("/horses")
    public List<Horse> getAllHorses(){ return horseService.getAllHorses(); }

    @PostMapping("/addHorse")
    public Horse addGame(@RequestBody Horse horse){ return horseService.createHorse(horse); }

    @GetMapping("/horse/{id}")
    public Horse getHorseById(@PathVariable int id){ return horseService.getHorseById(id); }

    @PutMapping("/updateHorse")
    public Horse updateHorse(@RequestBody Horse horse){ return horseService.updateHorse(horse); }

    @DeleteMapping("/horse/{id}")
    public String deleteHorseById(@PathVariable int id){ return horseService.deleteHorseById(id); }
}
