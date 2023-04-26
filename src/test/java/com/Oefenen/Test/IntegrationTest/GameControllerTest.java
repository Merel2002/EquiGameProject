package com.Oefenen.Test.IntegrationTest;

import com.Oefenen.Test.models.DTO.GameDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

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
            mvc.perform(MockMvcRequestBuilders
                            .get("/api/games")
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.games").exists())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.games[*].id").isNotEmpty());
        }catch (Exception ex){
        }
    }

    @Test
    public void getGameByIdTest(){
        try{
            mvc.perform( MockMvcRequestBuilders
                            .get("/api/gameid/{id}", 1)
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
                            .get("/api/game/{name}", "Game1")
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Game1"));
        }catch(Exception ex){

        }
    }

    @Test
    public void addGameTest(){
        try {
            mvc.perform(MockMvcRequestBuilders
                            .post("/api/addGame")
                            .content(asJsonString(new GameDTO("Springwedstrijd", "Testwedstrijd", "Bavel", LocalDate.of(2090, 9, -9))))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception ex){

        }
    }

    @Test
    public void updateGameTest(){
        try {
            mvc.perform(MockMvcRequestBuilders
                            .put("/api/updateGame")
                            .content(asJsonString(new GameDTO(1,"Springwedstrijd", "Testwedstrijd", LocalDate.of(2090, 9, -9), "Bavel")))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception ex){

        }
    }

    @Test
    public void deleteGameTest(){
        try {
            mvc.perform(MockMvcRequestBuilders.delete("/api/deleteGame/{id}", 1))
                    .andExpect(status().isAccepted());
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