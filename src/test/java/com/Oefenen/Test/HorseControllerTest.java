package com.Oefenen.Test;

import com.Oefenen.Test.models.DTO.CreateRiderDTO;
import com.Oefenen.Test.models.DTO.GameDTO;
import com.Oefenen.Test.models.DTO.HorseDTO;
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
public class HorseControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllHorsesTest()
    {
        try {
            MvcResult result = mvc.perform(MockMvcRequestBuilders
                            .get("/adminAPI/horses")
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();

            String jsonResult = result.getResponse().getContentAsString();
            List<HorseDTO> horseDTOS = new ObjectMapper().readValue(jsonResult, new TypeReference<List<HorseDTO>>(){});
            for(HorseDTO value: horseDTOS){
                Assertions.assertNotNull(value.getName());
                Assertions.assertNotNull(value.getAge());
                Assertions.assertNotNull(value.getId());
            }

        }catch (Exception ex){
        }
    }

    @Test
    public void getHorseByIdTest(){
        try{
            mvc.perform( MockMvcRequestBuilders
                            .get("/adminAPI/horses/id/{id}", 1)
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
        }catch(Exception ex){

        }
    }

    @Test
    public void getHorseByNameTest(){
        try{
            mvc.perform( MockMvcRequestBuilders
                            .get("/adminAPI/horses/name/{name}", "In time")
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("In time"));
        }catch(Exception ex){

        }
    }

    @Test
    public void addHorseTest(){
        try {
            mvc.perform(MockMvcRequestBuilders
                            .post("/adminAPI/horses")
                            .content(asJsonString(new HorseDTO("In time", LocalDate.of(2010, 9, 9))))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception ex){

        }
    }

    @Test
    public void updateHorseTest(){
        try {
            mvc.perform(MockMvcRequestBuilders
                            .put("/adminAPI/horses")
                            .content(asJsonString(new HorseDTO(1,"Koos", LocalDate.of(2010, 9, 9))))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception ex){

        }
    }

    @Test
    public void deleteHorseTest(){
        try {
            MvcResult result = mvc.perform(MockMvcRequestBuilders.delete("/adminAPI/horses/{id}", 1))
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
