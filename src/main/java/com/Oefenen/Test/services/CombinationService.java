package com.Oefenen.Test.services;

import com.Oefenen.Test.models.Combination;
import com.Oefenen.Test.models.DTO.CombinationDTO;
import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.repositories.CombinationCustomRepository;
import com.Oefenen.Test.repositories.CombinationRepository;
import com.Oefenen.Test.services.converters.CombinationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CombinationService {
    final private CombinationCustomRepository combinationRepository;
    private CombinationConverter combinationConverter;
    @Autowired
    public CombinationService(CombinationCustomRepository _combinationRepository){
        this.combinationRepository = _combinationRepository;
        this.combinationConverter = new CombinationConverter();
    }

    public boolean createCombination(Combination combination){
        combinationRepository.save(combination);
        return true;
    }

    public List<CombinationDTO> getAllCombinations(){
        List<CombinationDTO> combinationDTOS = new ArrayList<>();
        List<Combination> combinations = combinationRepository.findAll();

        for(Combination combination: combinations){
            combinationDTOS.add(combinationConverter.combinationToCombinationDTO(combination));
        }

        return combinationDTOS;
    }

    public CombinationDTO getCombinationById(int id){
        Combination combination = combinationRepository.findById(id).orElse(null);
        return combinationConverter.combinationToCombinationDTO(combination);
    }

    public List<CombinationDTO> getCombinationByUserId(int id){
        List<Combination> combinations = combinationRepository.findAllByUserID(id);
        List<CombinationDTO> combinationDTOS = new ArrayList<>();

        for(Combination combination : combinations){
            combinationDTOS.add(combinationConverter.combinationToCombinationDTO(combination));
        }

        return combinationDTOS;
    }

    public boolean updateCombination(Combination combination){
        boolean succes = false;
        Combination oldCombination;
        Optional<Combination> optionalCombination = combinationRepository.findById(combination.getId());

        if(optionalCombination.isPresent())
        {
            oldCombination = optionalCombination.get();

            combinationRepository.save(oldCombination);
            succes = true;
        }

        return succes;
    }

    public String deleteCombinationById(int id){
        combinationRepository.deleteById(id);
        return "Combination got deleted";
    }
}
