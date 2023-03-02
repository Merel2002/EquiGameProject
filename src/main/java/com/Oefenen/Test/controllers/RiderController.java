package com.Oefenen.Test.controllers;

import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.models.Rider;
import com.Oefenen.Test.services.GameService;
import com.Oefenen.Test.services.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RiderController {
    @Autowired
    private RiderService riderService;

    @GetMapping("/riders")
    public List<Rider> getAllRiders(){ return riderService.getAllRiders(); }

    @PostMapping("/addRider")
    public Rider addRider(@RequestBody Rider rider){ return riderService.createRider(rider); }

    @GetMapping("/rider/{id}")
    public Rider getRiderById(@PathVariable int id){ return riderService.getRiderById(id); }

    @PutMapping("/updateRider")
    public Rider updateRider(@RequestBody Rider rider){ return riderService.updateRider(rider); }

    @DeleteMapping("/rider/{id}")
    public String deleteRiderById(@PathVariable int id){ return riderService.deleteRiderById(id); }
}
