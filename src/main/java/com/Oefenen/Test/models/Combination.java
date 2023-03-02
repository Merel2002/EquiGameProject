package com.Oefenen.Test.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Combination {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Rider rider;
    @ManyToOne
    private Horse horse;
}
