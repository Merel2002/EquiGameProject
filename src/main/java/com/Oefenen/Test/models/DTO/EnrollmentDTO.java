package com.Oefenen.Test.models.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EnrollmentDTO {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private GameDTO game;

    @OneToOne
    private RiderDTO rider;
    //@OneToOne
    //private Combination combination;

    public EnrollmentDTO(GameDTO game, RiderDTO rider){
        this.game = game;
        this.rider = rider;
    }

}
