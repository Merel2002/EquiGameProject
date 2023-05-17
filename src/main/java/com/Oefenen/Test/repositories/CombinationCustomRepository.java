package com.Oefenen.Test.repositories;

import com.Oefenen.Test.models.Combination;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CombinationCustomRepository extends CombinationRepository{
    List<Combination> findAllByUserID(int id);
}
