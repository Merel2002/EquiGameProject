package com.Oefenen.Test.models.DTO;

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
public class HorseDTO {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private LocalDate age;

    public HorseDTO(String _name, LocalDate _age){
        this.name = _name;
        this.age = _age;
    }
}
