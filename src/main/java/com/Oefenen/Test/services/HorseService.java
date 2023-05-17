package com.Oefenen.Test.services;

import com.Oefenen.Test.models.DTO.HorseDTO;
import com.Oefenen.Test.models.Horse;
import com.Oefenen.Test.repositories.HorseCustomRepository;
import com.Oefenen.Test.repositories.HorseRepository;
import com.Oefenen.Test.services.converters.HorseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HorseService{
    final private HorseCustomRepository horseRepository;
    private HorseConverter horseConverter;

    @Autowired
    public HorseService(HorseCustomRepository _horseRepository){
        this.horseRepository = _horseRepository;
        this.horseConverter = new HorseConverter();
    }


    public boolean createHorse(HorseDTO horseDTO){
        Horse horse = horseConverter.horseDTOToHorse(horseDTO);
        horseRepository.save(horse);
        return true;
    }

    public List<HorseDTO> getAllHorses(){
        List<Horse> horses = horseRepository.findAll();
        List<HorseDTO> DTOhorses = new ArrayList<>();

        for(Horse horse : horses){
            DTOhorses.add(horseConverter.horseToHorseDTO(horse));
        }

        return DTOhorses;
    }

    public HorseDTO getHorseById(int id){
        Horse horse = horseRepository.findById(id).orElse(null);
        HorseDTO horseDTO = horseConverter.horseToHorseDTO(horse);

        return horseDTO;
    }

    public HorseDTO getHorseByName(String name){
        Horse horse = horseRepository.findByName(name);
        HorseDTO horseDTO = horseConverter.horseToHorseDTO(horse);

        return horseDTO;
    }


    public boolean updateHorse(HorseDTO horse){
        Optional<Horse> optionalHorse = horseRepository.findById(horse.getId());
        boolean succes = false;

        if(optionalHorse.isPresent())
        {
            horseRepository.save(optionalHorse.get());
            succes = true;
        }

        return succes;
    }

    public String deleteHorseById(int id){
        horseRepository.deleteById(id);
        return "Horse got deleted";
    }
}
