package com.Oefenen.Test.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue
    private int id;
    public String name;
    //private String describtion;
    //private Organisation organisation;
    //private String type
    //private String type;
    //private LocalDate date;

}
