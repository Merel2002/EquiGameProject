package com.Oefenen.Test.services;

import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.models.Rider;
import com.Oefenen.Test.repositories.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiderService {
    @Autowired
    private RiderRepository riderRepository;

    public List<Rider> getAllRiders(){ return riderRepository.findAll();}

    public Rider createRider(Rider rider) { return riderRepository.save(rider); }

    public Rider getRiderById(int id)
    {
        return riderRepository.findById(id).orElse(null);
    }

    public Rider updateRider (Rider rider)
    {
        Rider oldRider;
        Optional<Rider> optionalRider = riderRepository.findById(rider.getId());

        if(optionalRider.isPresent())
        {
            oldRider = optionalRider.get();
            oldRider.setFirstname(rider.getFirstname());
            oldRider.setLastname(rider.getLastname());

            riderRepository.save(oldRider);
        }
        else
        {
            return new Rider();
        }

        return oldRider;
    }

    public String deleteRiderById(int id){ riderRepository.deleteById(id); return "Rider got deleted."; }

}
