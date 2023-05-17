package com.Oefenen.Test.controllers;

import com.Oefenen.Test.models.DTO.HorseDTO;
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
    public List<HorseDTO> getAllHorses(){ return horseService.getAllHorses(); }

    @PostMapping("/addHorse")
    public boolean addHorse(@RequestBody HorseDTO horse){
        return horseService.createHorse(horse);
    }

    @GetMapping("/horse/{id}")
    public HorseDTO getHorseById(@PathVariable int id){ return horseService.getHorseById(id); }

    @GetMapping("/horseName/{name}")
    public HorseDTO getHorseByName(@PathVariable String name){ return horseService.getHorseByName(name); }

    @PutMapping("/updateHorse")
    public boolean updateHorse(@RequestBody HorseDTO horse){
        return horseService.updateHorse(horse);
    }

    @DeleteMapping("/deleteHorse/{id}")
    public String deleteHorseById(@PathVariable int id){ return horseService.deleteHorseById(id); }
}
