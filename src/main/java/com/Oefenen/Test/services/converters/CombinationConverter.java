package com.Oefenen.Test.services.converters;

import com.Oefenen.Test.models.Combination;
import com.Oefenen.Test.models.DTO.CombinationDTO;
import com.Oefenen.Test.models.DTO.EnrollmentDTO;
import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.models.Rider;

public class CombinationConverter {

    private RiderConverter riderConverter = new RiderConverter();
    private HorseConverter horseConverter = new HorseConverter();

    public CombinationDTO combinationToCombinationDTO(Combination combination){
        CombinationDTO combinationDTO = new CombinationDTO();
        combinationDTO.setId(combination.getId());
        combinationDTO.setHorse(horseConverter.horseToHorseDTO(combination.getHorse()));
        combinationDTO.setRider(riderConverter.riderToRiderDTO(combination.getRider()));
        combinationDTO.setUserID(combinationDTO.getUserID());

        return combinationDTO;
    }

    public Combination combinationDTOToCombination(CombinationDTO combinationDTO){
        Combination combination = new Combination();
        combination.setId(combination.getId());
        combination.setRider(riderConverter.riderDTOToRider(combinationDTO.getRider()));
        combination.setHorse(horseConverter.horseDTOToHorse(combinationDTO.getHorse()));
        combination.setUserID(combinationDTO.getUserID());

        return combination;
    }
}
