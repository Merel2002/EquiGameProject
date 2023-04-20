package com.Oefenen.Test.controllers;

import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/enrollments")
    public List<Enrollment> getAllEnrollments(){ return enrollmentService.getAllEnrollments(); }

    @GetMapping("/enrollments/user/{id}")
    public List<Enrollment> getEnrollmentsByUserId(@PathVariable int id){
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        List<Enrollment> enrollmentsByUserId = new ArrayList<>();

        for(int i = 0; i < enrollments.size(); i++){
            if(enrollments.get(i).getRider().getId() == id){
                enrollmentsByUserId.add(enrollments.get(i));
            }
        }
        return enrollmentsByUserId;
    }

    @GetMapping("/enrollments/game/{id}")
    public List<Enrollment> getEnrollmentsByGameId(@PathVariable int id){
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        List<Enrollment> enrollmentsByGameId = new ArrayList<>();

        for(int i = 0; i < enrollments.size(); i++){
            if(enrollments.get(i).getGame().getId() == id){
                enrollmentsByGameId.add(enrollments.get(i));
            }
        }
        return enrollmentsByGameId;
    }

    @PostMapping("/addEnrollment")
    public Enrollment addEnrollment(@RequestBody Enrollment enrollment){ return enrollmentService.createEnrollment(enrollment); }

    @GetMapping("/enrollment/{id}")
    public Enrollment getEnrollmentById(@PathVariable int id){ return enrollmentService.getEnrollmentById(id); }

    @PutMapping("/updateEnrollment")
    public Enrollment updateEnrollment(@RequestBody Enrollment enrollment){ return enrollmentService.updateEnrollment(enrollment); }

    @DeleteMapping("/deleteEnrollment/{id}")
    public String deleteEnrollmentById(@PathVariable int id){ return enrollmentService.deleteEnrollmentById(id); }
}
