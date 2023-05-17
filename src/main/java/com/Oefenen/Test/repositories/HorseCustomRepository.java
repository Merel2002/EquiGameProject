package com.Oefenen.Test.repositories;

import com.Oefenen.Test.models.Horse;
import org.springframework.stereotype.Repository;

@Repository
public interface HorseCustomRepository extends HorseRepository{
    Horse findByName(String name);
}
