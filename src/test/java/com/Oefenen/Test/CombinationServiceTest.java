package com.Oefenen.Test;

import com.Oefenen.Test.mock.MockCombinationRepo;
import com.Oefenen.Test.models.*;
import com.Oefenen.Test.models.DTO.CombinationDTO;
import com.Oefenen.Test.models.DTO.HorseDTO;
import com.Oefenen.Test.models.DTO.RiderDTO;
import com.Oefenen.Test.services.CombinationService;
import com.Oefenen.Test.services.converters.CombinationConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Tag("UnitTest")
public class CombinationServiceTest {
    private CombinationService combinationService;
    private MockCombinationRepo mockCombinationRepo;
    List<Combination> combinationList;

    @BeforeEach
    void setup() {
        this.mockCombinationRepo = new MockCombinationRepo();
        this.combinationService = new CombinationService(mockCombinationRepo);

        combinationList = new ArrayList<>();

        //mock rider 1
        Rider rider1 = new Rider();

        rider1.setId(1);
        rider1.setFirstname("Henk");
        rider1.setLastname("Janssen");

        //mock horse 1
        Horse horse1 = new Horse();

        horse1.setId(1);
        horse1.setName("Horse 1");
        horse1.setAge(LocalDate.of(2024, 4, 4));

        //mock horse 2
        Horse horse2 = new Horse();

        horse2.setId(2);
        horse2.setName("Horse 2");
        horse2.setAge(LocalDate.of(2024, 4, 4));

        //mock enrollment 1
        Combination combination1 = new Combination();

        combination1.setId(1);
        combination1.setUserID(1);
        combination1.setHorse(horse1);
        combination1.setRider(rider1);

        combinationList.add(combination1);

        //mock enrollment 2
        Combination combination2 = new Combination();

        combination2.setId(2);
        combination2.setUserID(1);
        combination2.setHorse(horse2);
        combination2.setRider(rider1);

        combinationList.add(combination2);

        mockCombinationRepo.FillDatabase(combinationList);
    }

    @Test
    void getAllCombinationsTest(){
        //assign
        List<CombinationDTO> combinationList;

        //act
        combinationList = combinationService.getAllCombinations();

        //assert
        Assertions.assertEquals(1, combinationList.get(0).getId());
        Assertions.assertEquals(1, combinationList.get(0).getHorse().getId());
        Assertions.assertEquals(1, combinationList.get(0).getRider().getId());

        Assertions.assertEquals(2, combinationList.get(1).getId());
        Assertions.assertEquals(2, combinationList.get(1).getHorse().getId());
        Assertions.assertEquals(1, combinationList.get(1).getRider().getId());
    }

    @Test
    void createCombinationTest(){
        //assign
        //mock rider 1
        Rider rider1 = new Rider();

        rider1.setId(1);
        rider1.setFirstname("Henk");
        rider1.setLastname("Janssen");

        //mock horse 1
        Horse horse1 = new Horse();

        horse1.setId(1);
        horse1.setName("Horse 1");
        horse1.setAge(LocalDate.of(2024, 4, 4));

        //mock combination 1
        Combination combination1 = new Combination();

        combination1.setId(1);
        combination1.setHorse(horse1);
        combination1.setRider(rider1);


        //act
        boolean expected = combinationService.createCombination(combination1);

        //assert
        Assertions.assertEquals(expected, true);
    }

    @Test
    void getCombinationByIdTest(){
        //assign
        //mock rider 1
        Rider rider1 = new Rider();

        rider1.setId(1);
        rider1.setFirstname("Henk");
        rider1.setLastname("Janssen");

        //mock horse 1
        Horse horse1 = new Horse();

        horse1.setId(1);
        horse1.setName("Horse 1");
        horse1.setAge(LocalDate.of(2024, 4, 4));

        //mock combination 1
        Combination combination1 = new Combination();

        combination1.setId(1);
        combination1.setUserID(1);
        combination1.setHorse(horse1);
        combination1.setRider(rider1);


        //act
        CombinationDTO expected = combinationService.getCombinationById(combination1.getId());

        //assert
        Assertions.assertEquals(expected, combination1);
    }

    @Test
    void updateCombinationTest(){
        //assign
        //mock rider update
        Rider riderUpdate = new Rider();

        riderUpdate.setId(1);
        riderUpdate.setFirstname("Henk Update");
        riderUpdate.setLastname("Janssen");

        //mock horse update
        Horse horseUpdate = new Horse();

        horseUpdate.setId(1);
        horseUpdate.setName("Horse 1 update");
        horseUpdate.setAge(LocalDate.of(2024, 4, 4));

        //mock combination update
        Combination combinationUpdate = new Combination();

        combinationUpdate.setId(1);
        combinationUpdate.setHorse(horseUpdate);
        combinationUpdate.setRider(riderUpdate);

        //act
        boolean succes = combinationService.updateCombination(combinationUpdate);

        //assert
        Assertions.assertEquals(succes, true);
    }

    @Test
    void deleteCombinationTest(){
        //assign
        String outcome;

        //act
        outcome = combinationService.deleteCombinationById(1);

        //assert
        Assertions.assertEquals(outcome, "Combination got deleted");
    }
}
