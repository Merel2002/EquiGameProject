package com.Oefenen.Test.repositories;

import com.Oefenen.Test.models.Rider;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderCustomRepository extends RiderRepository {
    Rider findByFirstname(String name);
}
