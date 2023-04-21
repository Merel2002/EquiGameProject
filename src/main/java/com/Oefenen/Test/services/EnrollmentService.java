package com.Oefenen.Test.services;

import com.Oefenen.Test.models.DTO.EnrollmentDTO;
import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.repositories.EnrollmentRepository;
import com.Oefenen.Test.services.converters.EnrollmentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {
    final private EnrollmentRepository enrollmentRepository;
    private EnrollmentConverter enrollmentConverter = new EnrollmentConverter();
    @Autowired
    public EnrollmentService(EnrollmentRepository _enrollmentRepository){ this.enrollmentRepository = _enrollmentRepository; }

    public boolean createEnrollment(EnrollmentDTO enrollmentDTO){
        Enrollment enrollment = enrollmentConverter.enrollmentDTOToEnrollment(enrollmentDTO);
        enrollment = enrollmentRepository.save(enrollment);

        return true;
    }

    public List<EnrollmentDTO> getAllEnrollments(){
        Iterable<Enrollment> enrollments = enrollmentRepository.findAll();
        List<EnrollmentDTO> enrollmentDTOS = new ArrayList<>();

        for(Enrollment enrollment : enrollments){
            EnrollmentDTO enrollmentDTO = enrollmentConverter.enrollmentToEnrollmentDTO(enrollment);
            enrollmentDTOS.add(enrollmentDTO);
        }

        return enrollmentDTOS;
    }

    public EnrollmentDTO getEnrollmentById(int id){
        Enrollment enrollment = enrollmentRepository.findById(id).orElse(null);

        return enrollmentConverter.enrollmentToEnrollmentDTO(enrollment);
    }

    public boolean updateEnrollment(EnrollmentDTO enrollmentDTO){
        Optional<Enrollment> optionalEnrollment = enrollmentRepository.findById(enrollmentDTO.getId());

        if(optionalEnrollment.isPresent())
        {
            enrollmentRepository.save(optionalEnrollment.get());
            return true;
        }

        return false;
    }

    public String deleteEnrollmentById(int id){
        enrollmentRepository.deleteById(id);
        return "Enrollment got deleted";
    }
}
