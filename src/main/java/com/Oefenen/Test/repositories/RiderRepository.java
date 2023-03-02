package com.Oefenen.Test.repositories;

import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.models.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RiderRepository extends JpaRepository<Rider, Integer> {

}
