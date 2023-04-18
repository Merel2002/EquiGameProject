package com.Oefenen.Test.models;

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
public class Enrollment {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Game game;

    @OneToOne
    private Rider rider;
    //@OneToOne
    //private Combination combination;

    public Enrollment(Game game, Rider rider){
        this.game = game;
        this.rider = rider;
    }

}
