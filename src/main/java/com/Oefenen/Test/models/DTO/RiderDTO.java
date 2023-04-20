package com.Oefenen.Test.models.DTO;

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
public class RiderDTO {
    @Id
    @GeneratedValue
    private int Id;
    private String firstname;
    private String lastname;

    public RiderDTO(String _first, String _last){
        this.firstname = _first;
        this.lastname = _last;
    }

}
