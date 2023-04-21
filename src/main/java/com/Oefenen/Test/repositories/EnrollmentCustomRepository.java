package com.Oefenen.Test.repositories;

import com.Oefenen.Test.models.DTO.EnrollmentDTO;
import com.Oefenen.Test.models.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentCustomRepository extends EnrollmentRepository{
    List<Enrollment> findAllByGame_Id(int id);
    List<Enrollment> findAllByRider_Id(int id);
}
