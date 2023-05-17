package com.Oefenen.Test.services.converters;

import com.Oefenen.Test.models.DTO.HorseDTO;
import com.Oefenen.Test.models.DTO.RiderDTO;
import com.Oefenen.Test.models.Horse;
import com.Oefenen.Test.models.Rider;

public class HorseConverter {
    public HorseDTO horseToHorseDTO(Horse horse){
        HorseDTO horseDTO = new HorseDTO();
        horseDTO.setId(horse.getId());
        horseDTO.setName(horse.getName());
        horseDTO.setAge(horse.getAge());

        return horseDTO;
    }

    public Horse horseDTOToHorse(HorseDTO horseDTO){
        Horse horse = new Horse();
        horse.setId(horseDTO.getId());
        horse.setName(horseDTO.getName());
        horse.setAge(horseDTO.getAge());

        return horse;
    }
}
