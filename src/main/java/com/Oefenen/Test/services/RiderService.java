package com.Oefenen.Test.services;

import com.Oefenen.Test.models.DTO.CreateRiderDTO;
import com.Oefenen.Test.models.DTO.RiderDTO;
import com.Oefenen.Test.models.Rider;
import com.Oefenen.Test.services.converters.RiderConverter;
import com.Oefenen.Test.repositories.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    //gets all the riders and turns them into dto's
    public List<RiderDTO> getAllRiders(){
        Iterable<Rider> riders = riderRepository.findAll();
        List<RiderDTO> riderDTOS = new ArrayList<>();

        for(Rider rider: riders){
            riderDTOS.add(riderConverter.riderToRiderDTO(rider));
        }

        return riderDTOS;
    }

    public boolean createRider(CreateRiderDTO riderDTO) {
        Rider rider = riderConverter.createRiderDTOTORider(riderDTO);
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

    public boolean updateRider (RiderDTO riderDTO)
    {
        RiderDTO oldRider;
        Optional<Rider> optionalRider = riderRepository.findById(riderDTO.getId());

        if(optionalRider.isPresent())
        {
            oldRider = riderConverter.riderToRiderDTO(optionalRider.get());

            riderRepository.save(optionalRider.get());
            return true;
        }

        return false;
    }

    public String deleteRiderById(int id){ riderRepository.deleteById(id); return "Rider got deleted."; }

}
