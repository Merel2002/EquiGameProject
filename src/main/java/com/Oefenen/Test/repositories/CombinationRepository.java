package com.Oefenen.Test.repositories;

import com.Oefenen.Test.models.Combination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombinationRepository extends JpaRepository<Combination, Integer> {
}
