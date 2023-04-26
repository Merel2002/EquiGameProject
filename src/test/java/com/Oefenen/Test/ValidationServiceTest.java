package com.Oefenen.Test;

import com.Oefenen.Test.models.DTO.GameDTO;
import com.Oefenen.Test.models.DTO.RiderDTO;
import com.Oefenen.Test.services.ValidationService;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class ValidationServiceTest {
    @Autowired
    private ValidationService validationService;


    @Test
    void stringValidatorValidTest(){
        //assign
        String input = "Test";
        int min = 0;
        int max = 5;

        //act
        boolean succes = validationService.stringValidator(input, min, max);

        //assert
        Assertions.assertEquals(succes, true);
    }
    @Test
    void stringValidatorNotValidTest(){
        //assign
        String input = "Test";
        int min = 0;
        int max = 3;

        //act
        boolean succes = validationService.stringValidator(input, min, max);

        //assert
        Assertions.assertEquals(succes, false);
    }
    @Test
    void intBetweenValidatorValidTest(){
        //assign
        int input = 3;
        int min = 0;
        int max = 5;

        //act
        boolean succes = validationService.intBetweenValidator(input, min, max);

        //assert
        Assertions.assertEquals(succes, true);
    }
    @Test
    void intBetweenValidatorNotValidTest(){
        //assign
        int input = 5;
        int min = 0;
        int max = 3;

        //act
        boolean succes = validationService.intBetweenValidator(input, min, max);

        //assert
        Assertions.assertEquals(succes, false);
    }

    @Test
    void intValidatorValidTest(){
        //assign
        int input = 2;
        int min = 0;

        //act
        boolean succes = validationService.intValidator(input, min);

        //assert
        Assertions.assertEquals(succes, true);
    }

    @Test
    void intValidatorNotValidTest(){
        //assign
        int input = 2;
        int min = 3;

        //act
        boolean succes = validationService.intValidator(input, min);

        //assert
        Assertions.assertEquals(succes, false);
    }

    @Test
    void dateValidatorValidTest(){
        //assign
        LocalDate date = LocalDate.of(2034, 02, 02);

        //act
        boolean succes = validationService.dateValidator(date);

        //assert
        Assertions.assertEquals(succes, true);
    }

    @Test
    void dateValidatorNotValidTest(){
        //assign
        LocalDate date = LocalDate.of(2019, 02, 02);

        //act
        boolean succes = validationService.dateValidator(date);

        //assert
        Assertions.assertEquals(succes, false);
    }

    @Test
    void riderValidatorValidTest(){
        //assign
        RiderDTO rider = new RiderDTO();
        rider.setId(1);
        rider.setFirstname("Henk");
        rider.setLastname("Jan");

        //act
        boolean succes = validationService.riderValidator(rider);

        //assert
        Assertions.assertEquals(succes, true);
    }
    @Test
    void riderValidatorNotValidTest(){
        //assign
        RiderDTO rider = new RiderDTO();
        rider.setId(1);
        rider.setFirstname("HenkyHenkiHenkeHenkeHenkeHenkeH");
        rider.setLastname("Jan");

        //act
        boolean succes = validationService.riderValidator(rider);

        //assert
        Assertions.assertEquals(succes, false);
    }

    @Test
    void gameValidatorValidTest(){
        //assign
        GameDTO game = new GameDTO();
        game.setId(1);
        game.setLocation("Bavel");
        game.setDate(LocalDate.of(2080, 9, 9));
        game.setDescription("Dit is een wedstrijd");
        game.setName("Springwedstrijd");

        //act
        boolean succes = validationService.gameValidator(game);

        //assert
        Assertions.assertEquals(succes, true);
    }

    @Test
    void gameValidatorNotValidTest(){
        //assign
        GameDTO game = new GameDTO();
        game.setId(0);
        game.setLocation("Bavel");
        game.setDate(LocalDate.of(2080, 9, 9));
        game.setDescription("Dit is een wedstrijd");
        game.setName("Springwedstrijd");

        //act
        boolean succes = validationService.gameValidator(game);

        //assert
        Assertions.assertEquals(succes, false);
    }
}
