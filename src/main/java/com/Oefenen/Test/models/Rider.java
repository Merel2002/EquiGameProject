package com.Oefenen.Test.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rider{
    @Id
    @GeneratedValue
    private int Id;
    private String firstname;
    private String lastname;

    public Rider(String _first, String _last){
        this.firstname = _first;
        this.lastname = _last;
    }

}
