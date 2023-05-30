package com.Oefenen.Test;

import com.Oefenen.Test.models.DTO.CreateRiderDTO;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Tag("IntegrationTest")
public class RiderControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllRidersTest()
    {
        try {
            MvcResult result = mvc.perform(MockMvcRequestBuilders
                            .get("/adminAPI/riders")
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();

            String jsonResult = result.getResponse().getContentAsString();
            List<RiderDTO> riderDTOS = new ObjectMapper().readValue(jsonResult, new TypeReference<List<RiderDTO>>(){});
            for(RiderDTO value: riderDTOS){
                Assertions.assertNotNull(value.getFirstname());
                Assertions.assertNotNull(value.getLastname());
                Assertions.assertNotNull(value.getId());
            }

        }catch (Exception ex){
        }
    }

    @Test
    public void getRiderByIdTest(){
        try{
            mvc.perform( MockMvcRequestBuilders
                            .get("/adminAPI/rider/id/{id}", 1)
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
        }catch(Exception ex){

        }
    }

    @Test
    public void getRiderByNameTest(){
        try{
            mvc.perform( MockMvcRequestBuilders
                            .get("/adminAPI/riders/name/{name}", "Henk")
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Henk"));
        }catch(Exception ex){

        }
    }

    @Test
    public void addRiderTest(){
        try {
            mvc.perform(MockMvcRequestBuilders
                            .post("/adminAPI/riders")
                            .content(asJsonString(new CreateRiderDTO("Henk", "Janssen")))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception ex){

        }
    }

    @Test
    public void updateRiderTest(){
        try {
            mvc.perform(MockMvcRequestBuilders
                            .put("/adminAPI/riders")
                            .content(asJsonString(new RiderDTO(1,"Trudy", "Janssen")))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception ex){

        }
    }

    @Test
    public void deleteRiderTest(){
        try {
            MvcResult result = mvc.perform(MockMvcRequestBuilders.delete("/adminAPI/riders/{id}", 1))
                    .andExpect(status().isAccepted())
                    .andReturn();

            String Jsonresult = result.getResponse().getContentAsString();
            String outcome = new ObjectMapper().readValue(Jsonresult, new TypeReference<String>(){});
            Assertions.assertEquals("true", outcome);

        } catch (Exception ex){

        }
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}