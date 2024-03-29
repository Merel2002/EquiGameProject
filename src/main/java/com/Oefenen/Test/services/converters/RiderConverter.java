package com.Oefenen.Test.services.converters;


import com.Oefenen.Test.models.DTO.CreateRiderDTO;
import com.Oefenen.Test.models.DTO.RiderDTO;
import com.Oefenen.Test.models.Rider;

public class RiderConverter {
    public RiderDTO riderToRiderDTO(Rider rider){
        RiderDTO riderDTO = new RiderDTO();
        riderDTO.setId(rider.getId());
        riderDTO.setFirstname(rider.getFirstname());
        riderDTO.setLastname(rider.getLastname());

        return riderDTO;
    }

    public Rider riderDTOToRider(RiderDTO riderDTO){
        Rider rider = new Rider();
        rider.setId(riderDTO.getId());
        rider.setFirstname(riderDTO.getFirstname());
        rider.setLastname(riderDTO.getLastname());

        return rider;
    }

    public Rider createRiderDTOTORider(CreateRiderDTO riderDTO){
        Rider rider = new Rider();
        rider.setFirstname(riderDTO.getFirstname());
        rider.setLastname(riderDTO.getLastname());

        return rider;
    }
}
