package com.Oefenen.Test.controllers;

import com.Oefenen.Test.models.Combination;
import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.services.CombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
@RestController
public class CombinationController {
    @Autowired
    private CombinationService combinationService;

    @GetMapping("/combinations")
    public List<Combination> getAllCombination(){ return combinationService.getAllCombinations(); }

    @PostMapping("/addCombinations")
    public Combination addCombination(@RequestBody Combination combinations){ return combinationService.createCombination(combinations); }

    @GetMapping("/combination/{id}")
    public Combination getCombinationById(@PathVariable int id){ return combinationService.getCombinationById(id); }

    @PutMapping("/updateCombinations")
    public Combination updateCombination(@RequestBody Combination combinations){ return combinationService.updateCombination(combinations); }

    @DeleteMapping("/deleteCombination/{id}")
    public String deleteCombinationById(@PathVariable int id){ return combinationService.deleteCombinationById(id); }
}
