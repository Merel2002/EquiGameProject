package com.Oefenen.Test.controllers;

import com.Oefenen.Test.models.DTO.EnrollmentDTO;
import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.services.EnrollmentService;
import com.Oefenen.Test.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;
    @Autowired
    private ValidationService validationService;

    @GetMapping("/enrollments")
    public ResponseEntity<List<EnrollmentDTO>> getAllEnrollments(){
        List<EnrollmentDTO> enrollmentDTOS = enrollmentService.getAllEnrollments();
        return ResponseEntity.ok(enrollmentDTOS);
    }

    @GetMapping("/enrollments/user/{id}")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByRiderId(@PathVariable int id){
        List<EnrollmentDTO> enrollmentDTOS = enrollmentService.getAllEnrollmentsByRiderId(id);
        return ResponseEntity.ok(enrollmentDTOS);
    }

    @GetMapping("/enrollments/game/{id}")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByGameId(@PathVariable int id){
        List<EnrollmentDTO> enrollmentDTOS = enrollmentService.getAllEnrollmentsByGameId(id);
        return ResponseEntity.ok(enrollmentDTOS);
    }

    @PostMapping("/addEnrollment")
    public boolean addEnrollment(@RequestBody EnrollmentDTO enrollmentDTO){
        boolean valid1 = false;
        boolean valid2 = false;

        valid1 = validationService.riderValidator(enrollmentDTO.getRider());
        valid2 = validationService.gameValidator(enrollmentDTO.getGame());

        boolean valid = false;
        if(valid1 && valid2){
            valid = enrollmentService.createEnrollment(enrollmentDTO);
        }

        return valid;
    }

    @GetMapping("/enrollment/{id}")
    public EnrollmentDTO getEnrollmentById(@PathVariable int id){
        boolean valid = false;
        valid = validationService.intValidator(id, 0);

        if(valid){
            return enrollmentService.getEnrollmentById(id);
        }

        return null;
    }

    @PutMapping("/updateEnrollment")
    public boolean updateEnrollment(@RequestBody EnrollmentDTO enrollmentDTO){
        boolean valid1 = false;
        boolean valid2 = false;
        boolean valid3 = false;

        valid1 = validationService.riderValidator(enrollmentDTO.getRider());
        valid2 = validationService.gameValidator(enrollmentDTO.getGame());
        valid3 = validationService.intValidator(enrollmentDTO.getId(), 0);

        boolean valid = false;
        if(valid1 && valid2 && valid3){
            valid = enrollmentService.updateEnrollment(enrollmentDTO);
        }

        return valid;
    }

    @DeleteMapping("/deleteEnrollment/{id}")
    public String deleteEnrollmentById(@PathVariable int id){
        boolean valid = false;
        valid = validationService.intValidator(id, 0);

        if(valid){
            return enrollmentService.deleteEnrollmentById(id);
        }

        return "Enrollment not deleted.";
    }
}
