package com.Oefenen.Test.controllers;

import com.Oefenen.Test.models.Combination;
import com.Oefenen.Test.models.DTO.CombinationDTO;
import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.services.CombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CombinationController {
    @Autowired
    private CombinationService combinationService;

    @GetMapping("/combinations")
    public List<CombinationDTO> getAllCombination(){ return combinationService.getAllCombinations(); }

    @PostMapping("/addCombinations")
    public boolean addCombination(@RequestBody Combination combinations){ return combinationService.createCombination(combinations); }

    @GetMapping("/combination/{id}")
    public CombinationDTO getCombinationById(@PathVariable int id){ return combinationService.getCombinationById(id); }

    @GetMapping("/combinationsByUser/{userid}")
    public List<CombinationDTO> getCombinationsByUserId(@PathVariable int id){
        return combinationService.getCombinationByUserId(id);
    }

    @PutMapping("/updateCombinations")
    public boolean updateCombination(@RequestBody Combination combinations){ return combinationService.updateCombination(combinations); }

    @DeleteMapping("/deleteCombination/{id}")
    public String deleteCombinationById(@PathVariable int id){ return combinationService.deleteCombinationById(id); }
}
