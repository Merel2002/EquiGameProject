package com.Oefenen.Test.services;

import com.Oefenen.Test.models.Combination;
import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.repositories.CombinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CombinationService {
    final private CombinationRepository combinationRepository;
    @Autowired
    public CombinationService(CombinationRepository _combinationRepository){ this.combinationRepository = _combinationRepository; }

    public Combination createCombination(Combination combination){
        combinationRepository.save(combination);
        return combination;
    }

    public List<Combination> getAllCombinations(){ return combinationRepository.findAll(); }

    public Combination getCombinationById(int id){ return combinationRepository.findById(id).orElse(null); }

    public Combination updateCombination(Combination combination){
        Combination oldCombination;
        Optional<Combination> optionalCombination = combinationRepository.findById(combination.getId());

        if(optionalCombination.isPresent())
        {
            oldCombination = optionalCombination.get();

            combinationRepository.save(oldCombination);
        }
        else
        {
            return new Combination();
        }

        return oldCombination;
    }

    public String deleteCombinationById(int id){
        combinationRepository.deleteById(id);
        return "Combination got deleted";
    }
}
