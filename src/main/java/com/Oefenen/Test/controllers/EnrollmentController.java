package com.Oefenen.Test.controllers;

import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/enrollments")
    public List<Enrollment> getAllEnrollments(){ return enrollmentService.getAllEnrollments(); }

    @PostMapping("/addEnrollment")
    public Enrollment addEnrollment(@RequestBody Enrollment enrollment){ return enrollmentService.createEnrollment(enrollment); }

    @GetMapping("/enrollment/{id}")
    public Enrollment getEnrollmentById(@PathVariable int id){ return enrollmentService.getEnrollmentById(id); }

    @PutMapping("/updateEnrollment")
    public Enrollment updateEnrollment(@RequestBody Enrollment enrollment){ return enrollmentService.updateEnrollment(enrollment); }

    @DeleteMapping("/deleteEnrollment/{id}")
    public String deleteEnrollmentById(@PathVariable int id){ return enrollmentService.deleteEnrollmentById(id); }
}
