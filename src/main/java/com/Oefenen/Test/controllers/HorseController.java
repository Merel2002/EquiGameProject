package com.Oefenen.Test.controllers;

import com.Oefenen.Test.models.DTO.HorseDTO;
import com.Oefenen.Test.models.Horse;
import com.Oefenen.Test.services.HorseService;
import com.Oefenen.Test.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/adminAPI")
public class HorseController {
    @Autowired
    private HorseService horseService;

    @Autowired
    private ValidationService validationService;

    @GetMapping("/horses")
    public List<HorseDTO> getAllHorses(){ return horseService.getAllHorses(); }

    @PostMapping("/horses")
    public boolean addHorse(@RequestBody HorseDTO horse){
        boolean valid1 = false;
        boolean valid2 = false;

        valid1 = validationService.stringValidator(horse.getName(), 1, 50);
        valid2 = validationService.dateOfBirthValidator(horse.getAge());

        if(valid1 && valid2){
            return horseService.createHorse(horse);
        }

        return false;
    }

    @GetMapping("/horses/id/{id}")
    public HorseDTO getHorseById(@PathVariable int id){ return horseService.getHorseById(id); }

    @GetMapping("/horses/name/{name}")
    public HorseDTO getHorseByName(@PathVariable String name){ return horseService.getHorseByName(name); }

    @PutMapping("/horses")
    public boolean updateHorse(@RequestBody HorseDTO horse){
        return horseService.updateHorse(horse);
    }

    @DeleteMapping("/horses/{id}")
    public String deleteHorseById(@PathVariable int id){ return horseService.deleteHorseById(id); }
}
