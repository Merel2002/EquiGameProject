package com.Oefenen.Test.services.converters;

import com.Oefenen.Test.models.DTO.EnrollmentDTO;
import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.models.Rider;

public class EnrollmentConverter {
    private GameConverter gameConverter = new GameConverter();
    private RiderConverter riderConverter = new RiderConverter();
    public EnrollmentDTO enrollmentToEnrollmentDTO(Enrollment enrollment){
        EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
        enrollmentDTO.setId(enrollment.getId());
        enrollmentDTO.setGame(gameConverter.gameToGameDTO(enrollment.getGame()));
        enrollmentDTO.setRider(riderConverter.riderToRiderDTO(enrollment.getRider()));

        return enrollmentDTO;
    }

    public Enrollment enrollmentDTOToEnrollment(EnrollmentDTO enrollmentDTO){
        Enrollment enrollment = new Enrollment();
        enrollment.setId(enrollmentDTO.getId());
        enrollment.setGame(gameConverter.gameDTOToGame(enrollmentDTO.getGame()));
        enrollment.setRider(riderConverter.riderDTOToRider(enrollmentDTO.getRider()));

        return enrollment;
    }
}
