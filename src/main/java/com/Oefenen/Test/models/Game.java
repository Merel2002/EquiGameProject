package com.Oefenen.Test.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    public String name;

    @Column(name = "description")
    private String description;

    public Game(String _name, String _description) {
        this.setName(_name);
        this.setDescription(_description);
    }

    //private Organisation organisation;
    //private String type
    //private LocalDate date;

}
