package com.Oefenen.Test.models.DTO;

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
public class GameDTO {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    private String description;

    @Column(name="date")
    private LocalDate date;

    @Column(name="location")
    private String location;

    public GameDTO(String _name, String _description, String _location, LocalDate _date) {
        this.setName(_name);
        this.setDescription(_description);
        this.setDate(_date);
        this.setLocation(_location);
    }


}

