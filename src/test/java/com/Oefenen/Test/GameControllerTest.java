package com.Oefenen.Test;

import com.Oefenen.Test.models.DTO.GameDTO;
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

import javax.print.attribute.standard.Media;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Tag("IntegrationTest")
public class GameControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllGamesTest()
    {
        try {
            MvcResult result = mvc.perform(MockMvcRequestBuilders
                            .get("/adminAPI/games")
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                     .andReturn();

            String jsonResult = result.getResponse().getContentAsString();
            List<GameDTO> gameDTOS = new ObjectMapper().readValue(jsonResult, new TypeReference<List<GameDTO>>(){});
            for(GameDTO value: gameDTOS){
                Assertions.assertNotNull(value.getName());
                Assertions.assertNotNull(value.getId());
                Assertions.assertNotNull(value.getDate());
                Assertions.assertNotNull(value.getLocation());
                Assertions.assertNotNull(value.getDescription());
            }

        }catch (Exception ex){
        }
    }

    @Test
    public void getGameByIdTest(){
        try{
            mvc.perform( MockMvcRequestBuilders
                            .get("/adminAPI/games/id/{id}", 1)
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
        }catch(Exception ex){

        }
    }

    @Test
    public void getGameByNameTest(){
        try{
            mvc.perform( MockMvcRequestBuilders
                            .get("/adminAPI/games/name/{name}", "Game1")
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Game1"));
        }catch(Exception ex){

        }
    }

    @Test
    public void addGameTest(){
//        try {
//            MvcResult result = mvc.perform(MockMvcRequestBuilders
//                            .post("/adminAPI/games")
//                            .content(asJsonString(new GameDTO("Springwedstrijd", "Testwedstrijd", "Bavel", LocalDate.of(2090, 9, -9))))
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andReturn();
//
//            Boolean Json = result.equals(true);
//
//            Assertions.assertEquals(true, Json);
//
//        } catch (Exception ex){
//
//        }
        try{
            mvc.perform(MockMvcRequestBuilders
                    .post("/adminAPI/games")
                    .content(asJsonString(new GameDTO("Springwedstrijd", "Testwedstrijd", "Bavel", LocalDate.of(2090, 9, 9))))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception ex){

        }
    }

    @Test
    public void updateGameTest(){
        try {
            MvcResult result = mvc.perform(MockMvcRequestBuilders
                            .put("/adminAPI/games")
                            .content(asJsonString(new GameDTO(1,"Springwedstrijd", "Testwedstrijd", LocalDate.of(2090, 9, -9), "Bavel")))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn();

            Boolean Json = result.equals(true);

            Assertions.assertEquals(true, Json);

        } catch (Exception ex){

        }
    }

    @Test
    public void deleteGameTest(){
        try {
            MvcResult result = mvc.perform(MockMvcRequestBuilders.delete("/adminAPI/games/{id}", 1))
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