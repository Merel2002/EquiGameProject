package com.Oefenen.Test.IntegrationTest;

import com.Oefenen.Test.models.DTO.EnrollmentDTO;
import com.Oefenen.Test.models.DTO.GameDTO;
import com.Oefenen.Test.models.DTO.RiderDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Tag("IntegrationTest")
public class EnrollmentControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllEnrollmentsTest()
    {
        try {
            MvcResult result = mvc.perform(MockMvcRequestBuilders
                            .get("/api/enrollments")
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();

            String jsonResult = result.getResponse().getContentAsString();
            List<EnrollmentDTO> enrollmentDTOS = new ObjectMapper().readValue(jsonResult, new TypeReference<List<EnrollmentDTO>>(){});
            for(EnrollmentDTO value: enrollmentDTOS){
                Assertions.assertNotNull(value.getId());
                Assertions.assertNotNull(value.getGame());
                Assertions.assertNotNull(value.getRider());
            }

        }catch (Exception ex){
        }
    }


    @Test
    public void addEnrollmentTest(){
        try {
            MvcResult result = mvc.perform(MockMvcRequestBuilders
                            .post("/api/addEnrollment")
                            .content(asJsonString(new EnrollmentDTO(new GameDTO("Springwedstrijd", "Testwedstrijd", "Bavel", LocalDate.of(2090, 9, -9)), new RiderDTO("Henk", "Janssen"))))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn();

            String Jsonresult = result.getResponse().getContentAsString();
            String outcome = new ObjectMapper().readValue(Jsonresult, new TypeReference<String>(){});
            Assertions.assertEquals("true", outcome);

        } catch (Exception ex){

        }
    }
    @Test
    public void getEnrollmentById(){
        try{
            mvc.perform( MockMvcRequestBuilders
                            .get("/api/enrollment/{id}", 1)
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
        }catch(Exception ex){

        }
    }
//    @Test
//    public void getAllEnrollmentsByRiderId(){
//        try{
//            MvcResult result = mvc.perform( MockMvcRequestBuilders
//                            .get("/api/enrollment/user/{id}", 1)
//                            .accept(MediaType.APPLICATION_JSON))
//                    .andDo(print())
//                    .andExpect(status().isOk())
//                    .andReturn();
//
//            String Jsonresult = result.getResponse().getContentAsString();
//            List<EnrollmentDTO> enrollmentDTOS = new ObjectMapper().readValue(Jsonresult, new TypeReference<List<EnrollmentDTO>>(){});
//            for(EnrollmentDTO value: enrollmentDTOS){
//                Assertions.assertNotNull(value.getId());
//                Assertions.assertNotNull(value.getGame());
//                Assertions.assertEquals(value.getRider().getId(), 1);
//            }
//
//
//        }catch(Exception ex){
//
//        }
//    }
//    @Test
//    public void getAllEnrollmentsByGameId(){
//        try{
//            MvcResult result = mvc.perform( MockMvcRequestBuilders
//                            .get("/api/enrollment/game/{id}", 1)
//                            .accept(MediaType.APPLICATION_JSON))
//                    .andDo(print())
//                    .andExpect(status().isOk())
//                    .andReturn();
//
//            String Jsonresult = result.getResponse().getContentAsString();
//            List<EnrollmentDTO> enrollmentDTOS = new ObjectMapper().readValue(Jsonresult, new TypeReference<List<EnrollmentDTO>>(){});
//            for(EnrollmentDTO value: enrollmentDTOS){
//                Assertions.assertNotNull(value.getId());
//                Assertions.assertNotNull(value.getRider());
//                Assertions.assertEquals(value.getGame().getId(), 1);
//            }
//        }catch(Exception ex){
//
//        }
//    }

    @Test
    public void updateEnrollmentTest(){
        try {
            MvcResult result = mvc.perform(MockMvcRequestBuilders
                            .post("/api/updateEnrollment")
                            .content(asJsonString(new EnrollmentDTO(1, new GameDTO(1, "Springwedstrijd", "Testwedstrijd",  LocalDate.of(2090, 9, -9), "Bavel"), new RiderDTO(1,"Henk", "Janssen"))))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn();

            String Jsonresult = result.getResponse().getContentAsString();
            String outcome = new ObjectMapper().readValue(Jsonresult, new TypeReference<String>(){});
            Assertions.assertEquals("true", outcome);
        } catch (Exception ex){

        }
    }

//    @Test
//    public void deleteEnrollmentTest(){
//        try {
//            MvcResult result = mvc.perform(MockMvcRequestBuilders.delete("/api/deleteEnrollment/{id}", 1))
//                    .andExpect(status().isAccepted())
//                    .andReturn();
//
//            String Jsonresult = result.getResponse().getContentAsString();
//            String outcome = new ObjectMapper().readValue(Jsonresult, new TypeReference<String>(){});
//            Assertions.assertEquals("true", outcome);
//        } catch (Exception ex){
//
//        }
//    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}