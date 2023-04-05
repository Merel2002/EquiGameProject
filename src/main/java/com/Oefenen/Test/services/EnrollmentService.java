package com.Oefenen.Test.services;

import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {
    final private EnrollmentRepository enrollmentRepository;
    @Autowired
    public EnrollmentService(EnrollmentRepository _enrollmentRepository){ this.enrollmentRepository = _enrollmentRepository; }

    public Enrollment createEnrollment(Enrollment enrollment){
        enrollmentRepository.save(enrollment);
        return enrollment;
    }

    public List<Enrollment> getAllEnrollments(){ return enrollmentRepository.findAll(); }

    public Enrollment getEnrollmentById(int id){ return enrollmentRepository.findById(id).orElse(null); }

    public Enrollment updateEnrollment(Enrollment enrollment){
        Enrollment oldEnrollment;
        Optional<Enrollment> optionalEnrollment = enrollmentRepository.findById(enrollment.getId());

        if(optionalEnrollment.isPresent())
        {
            oldEnrollment = optionalEnrollment.get();
            oldEnrollment.setGame(enrollment.getGame());
            oldEnrollment.setRider(enrollment.getRider());
            //oldEnrollment.setCombination(enrollment.getCombination());
            enrollmentRepository.save(oldEnrollment);
        }
        else
        {
            return new Enrollment();
        }

        return oldEnrollment;
    }

    public String deleteEnrollmentById(int id){
        enrollmentRepository.deleteById(id);
        return "Enrollment got deleted";
    }
}
