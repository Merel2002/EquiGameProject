package com.Oefenen.Test;

import com.Oefenen.Test.models.DTO.EnrollmentDTO;
import com.Oefenen.Test.models.DTO.GameDTO;
import com.Oefenen.Test.models.DTO.RiderDTO;
import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.models.Rider;
import com.Oefenen.Test.services.EnrollmentService;
import com.Oefenen.Test.mock.MockEnrollmentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentServiceTest {
    private EnrollmentService enrollmentService;
    private MockEnrollmentRepo mockEnrollmentRepo;
    List<Enrollment> enrollmentList;

    @BeforeEach
    void setup() {
        this.mockEnrollmentRepo = new MockEnrollmentRepo();
        this.enrollmentService = new EnrollmentService(mockEnrollmentRepo);

        enrollmentList = new ArrayList<>();

        //mock rider 1
        Rider rider1 = new Rider();

        rider1.setId(1);
        rider1.setFirstname("Henk");
        rider1.setLastname("Janssen");

        //mock rider 2
        Rider rider2 = new Rider();

        rider2.setId(2);
        rider2.setFirstname("Truus");
        rider2.setLastname("Janssen");

        //mock game 1
        Game game1 = new Game();

        game1.setId(1);
        game1.setName("Wedstrijd 1");
        game1.setDate(LocalDate.of(2024, 4, 4));
        game1.setLocation("Tilburg");
        game1.setDescription("Dit is een test wedstrijd");

        //mock enrollment 1
        Enrollment enrollment1 = new Enrollment();

        enrollment1.setId(1);
        enrollment1.setGame(game1);
        enrollment1.setRider(rider1);

        enrollmentList.add(enrollment1);

        //mock enrollment 2
        Enrollment enrollment2 = new Enrollment();

        enrollment2.setId(2);
        enrollment2.setGame(game1);
        enrollment2.setRider(rider2);

        enrollmentList.add(enrollment2);

        mockEnrollmentRepo.FillDatabase(enrollmentList);
    }

    @Test
    void getAllEnrollmentsTest(){
        //assign
        List<EnrollmentDTO> enrollmentList1;

        //act
        enrollmentList1 = enrollmentService.getAllEnrollments();

        //assert
        Assertions.assertEquals(1, enrollmentList1.get(0).getId());
        Assertions.assertEquals(1, enrollmentList1.get(0).getGame().getId());
        Assertions.assertEquals(1, enrollmentList1.get(0).getRider().getId());

        Assertions.assertEquals(2, enrollmentList1.get(1).getId());
        Assertions.assertEquals(1, enrollmentList1.get(1).getGame().getId());
        Assertions.assertEquals(2, enrollmentList1.get(1).getRider().getId());
    }

    @Test
    void createEnrollmentTest(){
        //assign
        //mock rider 1
        RiderDTO rider1 = new RiderDTO();

        rider1.setId(1);
        rider1.setFirstname("Henk");
        rider1.setLastname("Janssen");

        //mock game 1
        GameDTO game1 = new GameDTO();

        game1.setId(1);
        game1.setName("Wedstrijd 1");
        game1.setDate(LocalDate.of(2024, 4, 4));
        game1.setLocation("Tilburg");
        game1.setDescription("Dit is een test wedstrijd");

        //mock enrollment 1
        EnrollmentDTO enrollment1 = new EnrollmentDTO();

        enrollment1.setId(1);
        enrollment1.setGame(game1);
        enrollment1.setRider(rider1);

        boolean expected = true;
        //act
        boolean outcome = enrollmentService.createEnrollment(enrollment1);

        //assert
        Assertions.assertEquals(outcome, expected);
    }

    @Test
    void getEnrollmentByIdTest(){
        //assign
        //mock rider 1
        RiderDTO rider1 = new RiderDTO();

        rider1.setId(1);
        rider1.setFirstname("Henk");
        rider1.setLastname("Janssen");

        //mock game 1
        GameDTO game1 = new GameDTO();

        game1.setId(1);
        game1.setName("Wedstrijd 1");
        game1.setDate(LocalDate.of(2024, 4, 4));
        game1.setLocation("Tilburg");
        game1.setDescription("Dit is een test wedstrijd");

        //mock enrollment 1
        EnrollmentDTO enrollment1 = new EnrollmentDTO();

        enrollment1.setId(1);
        enrollment1.setGame(game1);
        enrollment1.setRider(rider1);


        //act
        EnrollmentDTO expected = enrollmentService.getEnrollmentById(enrollment1.getId());

        //assert
        Assertions.assertEquals(expected, enrollment1);
    }

    @Test
    void updateEnrollmentTest(){
        //assign
        //mock rider update
        RiderDTO riderUpdate = new RiderDTO();

        riderUpdate.setId(1);
        riderUpdate.setFirstname("Henk Update");
        riderUpdate.setLastname("Janssen");

        //mock game update
        GameDTO gameUpdate = new GameDTO();

        gameUpdate.setId(1);
        gameUpdate.setName("Wedstrijd 1 Update");
        gameUpdate.setDate(LocalDate.of(2024, 4, 4));
        gameUpdate.setLocation("Tilburg");
        gameUpdate.setDescription("Dit is een test wedstrijd");

        //mock enrollment update
        EnrollmentDTO enrollmentUpdate = new EnrollmentDTO();

        enrollmentUpdate.setId(1);
        enrollmentUpdate.setGame(gameUpdate);
        enrollmentUpdate.setRider(riderUpdate);

        boolean expected = true;

        //act
        boolean outcome = enrollmentService.updateEnrollment(enrollmentUpdate);

        //assert
        Assertions.assertEquals(outcome, expected);
    }

    @Test
    void deleteEnrollmentTest(){
        //assign
        String outcome;

        //act
        outcome = enrollmentService.deleteEnrollmentById(1);

        //assert
        Assertions.assertEquals(outcome, "Enrollment got deleted");
    }
}
