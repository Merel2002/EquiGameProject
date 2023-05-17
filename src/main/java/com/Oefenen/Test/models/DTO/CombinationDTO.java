package com.Oefenen.Test.models.DTO;

import com.Oefenen.Test.models.Horse;
import com.Oefenen.Test.models.Rider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CombinationDTO {
    @Id
    @GeneratedValue
    private int id;

    private int userID;

    @OneToOne
    private RiderDTO rider;
    @ManyToOne
    private HorseDTO horse;
}
