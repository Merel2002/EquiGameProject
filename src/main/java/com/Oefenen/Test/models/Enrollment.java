package com.Oefenen.Test.models;

import jakarta.persistence.*;
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
    @ManyToOne
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
