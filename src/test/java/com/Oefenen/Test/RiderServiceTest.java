package com.Oefenen.Test;

import com.Oefenen.Test.mock.MockRiderRepo;
import com.Oefenen.Test.models.DTO.CreateRiderDTO;
import com.Oefenen.Test.models.DTO.RiderDTO;
import com.Oefenen.Test.models.Rider;
import com.Oefenen.Test.services.RiderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

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
        List<RiderDTO> riderList1;

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
    void createRiderTest() {
        //assign
        CreateRiderDTO riderDTO = new CreateRiderDTO();

        riderDTO.setFirstname("Henk");
        riderDTO.setLastname("Janssen");

        boolean expected = true;

        //act
        boolean riderCreated = riderService.createRider(riderDTO);

        //assert
        Assertions.assertEquals(expected, riderCreated);
    }

    @Test
    void getGameByIdTest() {
        //assign
        RiderDTO riderDTO = new RiderDTO();

        riderDTO.setId(1);
        riderDTO.setFirstname("Henk");
        riderDTO.setLastname("Janssen");

        //act
        RiderDTO expected = riderService.getRiderById(riderDTO.getId());

        //assert
        Assertions.assertEquals(expected, riderDTO);
    }

    @Test
    void updateGameTest() {
        //assign
        RiderDTO riderUpdate = new RiderDTO();

        riderUpdate.setId(1);
        riderUpdate.setFirstname("Henk Update");
        riderUpdate.setLastname("Janssen");

        boolean expected = true;

        //act
        boolean outcome = riderService.updateRider(riderUpdate);

        //assert
        Assertions.assertEquals(outcome, expected);
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
