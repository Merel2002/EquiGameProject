package com.Oefenen.Test.controllers;

import com.Oefenen.Test.models.DTO.CreateRiderDTO;
import com.Oefenen.Test.models.DTO.RiderDTO;
import com.Oefenen.Test.services.RiderService;
import com.Oefenen.Test.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RiderController {
    @Autowired
    private RiderService riderService;
    @Autowired
    private ValidationService validationService;

    @GetMapping("/riders")
    public ResponseEntity<List<RiderDTO>> getAllRiders(){
        List<RiderDTO> riderDTOS = riderService.getAllRiders();
        return ResponseEntity.ok(riderDTOS);
    }

    @PostMapping("/addRider")
    public boolean addRider(@RequestBody CreateRiderDTO riderDTO){
        boolean valid1 = false;
        boolean valid2 = false;
        valid1 = validationService.stringValidator(riderDTO.getFirstname(), 1, 30);
        valid2 = validationService.stringValidator(riderDTO.getLastname(), 1, 50);

        boolean valid = false;
        if(valid1 && valid2){
            valid = riderService.createRider(riderDTO);
        }

        return valid;
    }

    @GetMapping("/rider/{id}")
    public RiderDTO getRiderById(@PathVariable int id){
        boolean valid = false;
        valid = validationService.intValidator(id, 0);

        if(valid){
            return riderService.getRiderById(id);
        }
        return null;
    }

    @PutMapping("/updateRider")
    public boolean updateRider(@RequestBody RiderDTO riderDTO){
        boolean valid1 = false;
        boolean valid2 = false;
        boolean valid3 = false;
        valid1 = validationService.intValidator(riderDTO.getId(), 0);
        valid2 = validationService.stringValidator(riderDTO.getFirstname(), 1, 30);
        valid3 = validationService.stringValidator(riderDTO.getLastname(), 1, 50);

        boolean valid = false;
        if(valid1 && valid2 && valid3){
            valid = riderService.updateRider(riderDTO);
        }

        return valid;
    }

    @DeleteMapping("/deleteRider/{id}")
    public String deleteRiderById(@PathVariable int id){
        boolean valid = false;
        valid = validationService.intValidator(id, 0);

        if(valid){
            return riderService.deleteRiderById(id);
        }
        return "Rider didn't got deleted.";
    }
}
