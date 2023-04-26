package com.Oefenen.Test.unitTests;

import com.Oefenen.Test.mock.MockHorseRepo;
import com.Oefenen.Test.models.Horse;
import com.Oefenen.Test.services.HorseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class HorseServiceTest {
    private HorseService horseService;
    private MockHorseRepo mockHorseRepo;
    List<Horse> horseList;

    @BeforeEach
    void setup() {
        this.mockHorseRepo = new MockHorseRepo();
        this.horseService = new HorseService(mockHorseRepo);

        horseList = new ArrayList<>();

        //mock horse 1
        Horse horse1 = new Horse();

        horse1.setId(1);
        horse1.setName("Horse 1");
        horse1.setAge(LocalDate.of(2024, 4, 4));

        horseList.add(horse1);

        //mock horse 2
        Horse horse2 = new Horse();

        horse2.setId(2);
        horse2.setName("Horse 2");
        horse2.setAge(LocalDate.of(2024, 4, 4));

        horseList.add(horse2);

        mockHorseRepo.FillDatabase(horseList);
    }

    @Test
    void getAllHorsesTest(){
        //assign
        List<Horse> horseList1;

        //act
        horseList1 = horseService.getAllHorses();

        //assert
        Assertions.assertEquals(1, horseList1.get(0).getId());
        Assertions.assertEquals("Horse 1", horseList1.get(0).getName());
        Assertions.assertEquals(LocalDate.of(2024, 4, 4), horseList1.get(0).getAge());

        Assertions.assertEquals(2, horseList1.get(1).getId());
        Assertions.assertEquals("Horse 2", horseList1.get(1).getName());
        Assertions.assertEquals(LocalDate.of(2024, 4, 4), horseList1.get(0).getAge());
    }

    @Test
    void createHorseTest(){
        //assign
        Horse horse1 = new Horse();

        horse1.setId(1);
        horse1.setName("Horse 1");
        horse1.setAge(LocalDate.of(2024, 4, 4));

        //act
        Horse expected = horseService.createHorse(horse1);

        //assert
        Assertions.assertEquals(expected, horse1);
    }

    @Test
    void getHorseByIdTest(){
        //assign
        Horse horse1 = new Horse();

        horse1.setId(1);
        horse1.setName("Horse 1");
        horse1.setAge(LocalDate.of(2024, 4, 4));

        //act
        Horse expected = horseService.getHorseById(horse1.getId());

        //assert
        Assertions.assertEquals(expected, horse1);
    }

    @Test
    void updateHorseTest(){
        //assign
        Horse horseUpdate = new Horse();

        horseUpdate.setId(1);
        horseUpdate.setName("Wedstrijd 1 UPDATE");
        horseUpdate.setAge(LocalDate.of(2024, 4, 4));

        Horse horseOld = new Horse();

        horseOld.setId(1);
        horseOld.setName("Wedstrijd 1");
        horseOld.setAge(LocalDate.of(2024, 4, 4));

        //act
        horseUpdate = horseService.updateHorse(horseUpdate);

        //assert
        Assertions.assertNotEquals(horseUpdate, horseOld);
    }

    @Test
    void deleteHorseTest(){
        //assign
        String outcome;

        //act
        outcome = horseService.deleteHorseById(1);

        //assert
        Assertions.assertEquals(outcome, "Horse got deleted");
    }
}
