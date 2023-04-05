package com.Oefenen.Test;

import com.Oefenen.Test.mock.MockRiderRepo;
import com.Oefenen.Test.models.Rider;
import com.Oefenen.Test.services.RiderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RiderServiceTest {
    private RiderService riderService;
    private MockRiderRepo mockRiderRepo;
    List<Rider> riderList;

    @BeforeEach
    void setup() {
        this.mockRiderRepo = new MockRiderRepo();
        this.riderService = new RiderService(mockRiderRepo);

        riderList = new ArrayList<>();

        //mock rider 1
        Rider rider1 = new Rider();

        rider1.setId(1);
        rider1.setFirstname("Henk");
        rider1.setLastname("Janssen");

        riderList.add(rider1);

        //mock rider 2
        Rider rider2 = new Rider();

        rider2.setId(2);
        rider2.setFirstname("Truus");
        rider2.setLastname("Janssen");

        riderList.add(rider2);
        mockRiderRepo.FillDatabase(riderList);
    }

    @Test
    void getAllRidersTest() {
        //assign
        List<Rider> riderList1;

        //act
        riderList1 = riderService.getAllRiders();

        //assert
        Assertions.assertEquals(1, riderList1.get(0).getId());
        Assertions.assertEquals("Henk", riderList1.get(0).getFirstname());
        Assertions.assertEquals("Janssen", riderList1.get(0).getLastname());

        Assertions.assertEquals(2, riderList1.get(1).getId());
        Assertions.assertEquals("Truus", riderList1.get(1).getFirstname());
        Assertions.assertEquals("Janssen", riderList1.get(1).getLastname());
    }

    @Test
    void createGameTest() {
        //assign
        Rider rider = new Rider();

        rider.setId(1);
        rider.setFirstname("Henk");
        rider.setLastname("Janssen");

        //act
        Rider expected = riderService.createRider(rider);

        //assert
        Assertions.assertEquals(expected, rider);
    }

    @Test
    void getGameByIdTest() {
        //assign
        Rider rider = new Rider();

        rider.setId(1);
        rider.setFirstname("Henk");
        rider.setLastname("Janssen");

        //act
        Rider expected = riderService.getRiderById(rider.getId());

        //assert
        Assertions.assertEquals(expected, rider);
    }

    @Test
    void updateGameTest() {
        //assign
        Rider riderUpdate = new Rider();

        riderUpdate.setId(1);
        riderUpdate.setFirstname("Henk Update");
        riderUpdate.setLastname("Janssen");


        Rider riderOld = new Rider();

        riderOld.setId(1);
        riderOld.setFirstname("Henk");
        riderOld.setLastname("Janssen");

        //act
        riderUpdate = riderService.updateRider(riderUpdate);

        //assert
        Assertions.assertNotEquals(riderUpdate, riderOld);
    }

    @Test
    void deleteGameTest() {
        //assign
        String outcome;

        //act
        outcome = riderService.deleteRiderById(1);

        //assert
        Assertions.assertEquals(outcome, "Rider got deleted.");
    }
}
