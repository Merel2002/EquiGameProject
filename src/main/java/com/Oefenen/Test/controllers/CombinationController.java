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
@RequestMapping("/adminAPI")
public class CombinationController {
    @Autowired
    private CombinationService combinationService;

    @GetMapping("/combinations")
    public List<CombinationDTO> getAllCombination(){ return combinationService.getAllCombinations(); }

    @PostMapping("/combinations")
    public boolean addCombination(@RequestBody Combination combinations){ return combinationService.createCombination(combinations); }

    @GetMapping("/combinations/id/{id}")
    public CombinationDTO getCombinationById(@PathVariable int id){ return combinationService.getCombinationById(id); }

    @GetMapping("/combinations/user/{id}")
    public List<CombinationDTO> getCombinationsByUserId(@PathVariable int id){
        return combinationService.getCombinationByUserId(id);
    }

    @PutMapping("/combinations")
    public boolean updateCombination(@RequestBody Combination combinations){ return combinationService.updateCombination(combinations); }

    @DeleteMapping("/combinations/{id}")
    public String deleteCombinationById(@PathVariable int id){ return combinationService.deleteCombinationById(id); }
}
