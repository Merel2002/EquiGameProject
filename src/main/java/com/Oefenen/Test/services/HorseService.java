package com.Oefenen.Test.services;

import com.Oefenen.Test.models.Horse;
import com.Oefenen.Test.repositories.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorseService{
    final private HorseRepository horseRepository;

    @Autowired
    public HorseService(HorseRepository _horseRepository){ this.horseRepository = _horseRepository; }


    public Horse createHorse(Horse horse){
        horseRepository.save(horse);
        return horse;
    }

    public List<Horse> getAllHorses(){ return horseRepository.findAll(); }

    public Horse getHorseById(int id){ return horseRepository.findById(id).orElse(null); }

    public Horse updateHorse(Horse horse){
        Horse oldHorse;
        Optional<Horse> optionalHorse = horseRepository.findById(horse.getId());

        if(optionalHorse.isPresent())
        {
            oldHorse = optionalHorse.get();
            horseRepository.save(oldHorse);
        }
        else
        {
            return new Horse();
        }

        return oldHorse;
    }

    public String deleteHorseById(int id){
        horseRepository.deleteById(id);
        return "Horse got deleted";
    }
}
