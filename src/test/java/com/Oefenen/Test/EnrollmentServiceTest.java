package com.Oefenen.Test;

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
        List<Enrollment> enrollmentList1;

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
        Rider rider1 = new Rider();

        rider1.setId(1);
        rider1.setFirstname("Henk");
        rider1.setLastname("Janssen");

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

        //act
        Enrollment expected = enrollmentService.createEnrollment(enrollment1);

        //assert
        Assertions.assertEquals(expected, enrollment1);
    }

    @Test
    void getEnrollmentByIdTest(){
        //assign
        //mock rider 1
        Rider rider1 = new Rider();

        rider1.setId(1);
        rider1.setFirstname("Henk");
        rider1.setLastname("Janssen");

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


        //act
        Enrollment expected = enrollmentService.getEnrollmentById(enrollment1.getId());

        //assert
        Assertions.assertEquals(expected, enrollment1);
    }

    @Test
    void updateEnrollmentTest(){
        //assign
        //mock rider update
        Rider riderUpdate = new Rider();

        riderUpdate.setId(1);
        riderUpdate.setFirstname("Henk Update");
        riderUpdate.setLastname("Janssen");

        //mock game update
        Game gameUpdate = new Game();

        gameUpdate.setId(1);
        gameUpdate.setName("Wedstrijd 1 Update");
        gameUpdate.setDate(LocalDate.of(2024, 4, 4));
        gameUpdate.setLocation("Tilburg");
        gameUpdate.setDescription("Dit is een test wedstrijd");

        //mock enrollment update
        Enrollment enrollmentUpdate = new Enrollment();

        enrollmentUpdate.setId(1);
        enrollmentUpdate.setGame(gameUpdate);
        enrollmentUpdate.setRider(riderUpdate);

        //mock rider old
        Rider riderOld = new Rider();

        riderOld.setId(1);
        riderOld.setFirstname("Henk");
        riderOld.setLastname("Janssen");

        //mock game old
        Game gameOld = new Game();

        gameOld.setId(1);
        gameOld.setName("Wedstrijd 1");
        gameOld.setDate(LocalDate.of(2024, 4, 4));
        gameOld.setLocation("Tilburg");
        gameOld.setDescription("Dit is een test wedstrijd");

        //mock enrollment old
        Enrollment enrollmentOld = new Enrollment();

        enrollmentOld.setId(1);
        enrollmentOld.setGame(gameOld);
        enrollmentOld.setRider(riderOld);

        //act
        enrollmentUpdate = enrollmentService.updateEnrollment(enrollmentUpdate);

        //assert
        Assertions.assertNotEquals(enrollmentOld, enrollmentUpdate);
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
