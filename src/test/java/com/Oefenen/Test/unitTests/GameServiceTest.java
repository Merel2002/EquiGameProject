package com.Oefenen.Test.unitTests;

import com.Oefenen.Test.mock.MockGameRepo;
import com.Oefenen.Test.models.DTO.GameDTO;
import com.Oefenen.Test.models.DTO.RiderDTO;
import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.services.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GameServiceTest {
    private GameService gameService;
    private MockGameRepo mockGameRepo;
    List<Game> gameList;

    @BeforeEach
    void setup() {
        this.mockGameRepo = new MockGameRepo();
        this.gameService = new GameService(mockGameRepo);

        gameList = new ArrayList<>();

        //mock game 1
        Game game1 = new Game();

        game1.setId(1);
        game1.setName("Wedstrijd 1");
        game1.setDate(LocalDate.of(2024, 4, 4));
        game1.setLocation("Tilburg");
        game1.setDescription("Dit is een test wedstrijd");

        gameList.add(game1);

        //mock game 2
        Game game2 = new Game();

        game2.setId(2);
        game2.setName("Wedstrijd 2");
        game2.setDate(LocalDate.of(2024, 5, 4));
        game2.setLocation("Tilburg");
        game2.setDescription("Dit is de 2e test wedstrijd");

        gameList.add(game2);

        mockGameRepo.FillDatabase(gameList);
    }

    @Test
    void getAllGamesTest(){
        //assign
        List<GameDTO> gamelist1;

        //act
        gamelist1 = gameService.getAllGames();

        //assert
        Assertions.assertEquals(1, gamelist1.get(0).getId());
        Assertions.assertEquals("Wedstrijd 1", gamelist1.get(0).getName());
        Assertions.assertEquals(LocalDate.of(2024, 4, 4), gamelist1.get(0).getDate());
        Assertions.assertEquals("Tilburg", gamelist1.get(0).getLocation());
        Assertions.assertEquals("Dit is een test wedstrijd", gamelist1.get(0).getDescription());

        Assertions.assertEquals(2, gamelist1.get(1).getId());
        Assertions.assertEquals("Wedstrijd 2", gamelist1.get(1).getName());
        Assertions.assertEquals(LocalDate.of(2024, 5, 4), gamelist1.get(1).getDate());
        Assertions.assertEquals("Tilburg", gamelist1.get(0).getLocation());
        Assertions.assertEquals("Dit is de 2e test wedstrijd", gamelist1.get(1).getDescription());
    }

    @Test
    void createGameTest(){
        //assign
        GameDTO game1 = new GameDTO();

        game1.setName("Wedstrijd 1");
        game1.setDate(LocalDate.of(2024, 4, 4));
        game1.setLocation("Tilburg");
        game1.setDescription("Dit is een test wedstrijd");

        boolean expected = true;

        //act
        boolean outcome = gameService.createGame(game1);

        //assert
        Assertions.assertEquals(outcome, expected);
    }

    @Test
    void getGameByIdTest(){
        //assign
        GameDTO game1 = new GameDTO();

        game1.setId(1);
        game1.setName("Wedstrijd 1");
        game1.setDate(LocalDate.of(2024, 4, 4));
        game1.setLocation("Tilburg");
        game1.setDescription("Dit is een test wedstrijd");

        //act
        GameDTO expected = gameService.getGameById(game1.getId());

        //assert
        Assertions.assertEquals(expected, game1);
    }

    @Test
    void getGameByNameTest(){
        //assign
        GameDTO game1 = new GameDTO();

        game1.setId(1);
        game1.setName("Wedstrijd 1");
        game1.setDate(LocalDate.of(2024, 4, 4));
        game1.setLocation("Tilburg");
        game1.setDescription("Dit is een test wedstrijd");

        //act
        GameDTO expected = gameService.getGameByName(game1.getName());

        //assert
        Assertions.assertEquals(expected, game1);
    }

    @Test
    void updateGameTest(){

        //assign
        GameDTO gameUpdate = new GameDTO();

        gameUpdate.setId(1);
        gameUpdate.setName("Wedstrijd 1 UPDATE");
        gameUpdate.setDate(LocalDate.of(2024, 4, 4));
        gameUpdate.setLocation("Tilburg");
        gameUpdate.setDescription("Dit is een test wedstrijd");

        boolean expected = true;

        //act
        boolean outcome = gameService.updateGame(gameUpdate);

        //assert
        Assertions.assertEquals(outcome, expected);
    }

    @Test
    void deleteGameTest(){
        //assign
        String outcome;

        //act
        outcome = gameService.deleteGameById(1);

        //assert
        Assertions.assertEquals(outcome, "Game got deleted.");
    }
}
