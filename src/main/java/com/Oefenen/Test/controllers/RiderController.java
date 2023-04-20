package com.Oefenen.Test.controllers;

import com.Oefenen.Test.models.DTO.RiderDTO;
import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.models.Rider;
import com.Oefenen.Test.services.GameService;
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
    public List<Rider> getAllRiders(){ return riderService.getAllRiders(); }

    @PostMapping("/addRider")
    public ResponseEntity<RiderDTO> addRider(@RequestBody RiderDTO riderDTO){
        boolean valid = false;
        valid = validationService.stringValidator(riderDTO.getFirstname(), 1, 30);
        valid = validationService.stringValidator(riderDTO.getLastname(), 1, 50);

        if(valid){
            valid = riderService.createRider(riderDTO);
        }

        if(valid){
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
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
    public Rider updateRider(@RequestBody Rider rider){ return riderService.updateRider(rider); }

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
