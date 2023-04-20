package com.Oefenen.Test.services;

import com.Oefenen.Test.models.DTO.RiderDTO;
import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.models.Rider;
import com.Oefenen.Test.models.RiderConverter;
import com.Oefenen.Test.repositories.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiderService {
    private RiderRepository riderRepository;
    private RiderConverter riderConverter = new RiderConverter();

    @Autowired
    public RiderService(RiderRepository riderRepository){
        this.riderRepository = riderRepository;
    }

    public List<Rider> getAllRiders(){ return riderRepository.findAll();}

    public boolean createRider(RiderDTO riderDTO) {
        Rider rider = riderConverter.riderDTOToRider(riderDTO);
        rider = riderRepository.save(rider);
        if(rider != null){
            return true;
        }
        return false;
    }

    public RiderDTO getRiderById(int id) {
        Rider rider = riderRepository.findById(id).orElse(null);

        return riderConverter.riderToRiderDTO(rider);
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
