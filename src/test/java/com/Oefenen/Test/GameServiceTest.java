package com.Oefenen.Test;

import com.Oefenen.Test.mock.MockGameRepo;
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
        List<Game> gamelist1;

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
        Game game1 = new Game();

        game1.setId(1);
        game1.setName("Wedstrijd 1");
        game1.setDate(LocalDate.of(2024, 4, 4));
        game1.setLocation("Tilburg");
        game1.setDescription("Dit is een test wedstrijd");

        //act
        Game expected = gameService.createGame(game1);

        //assert
        Assertions.assertEquals(expected, game1);
    }

    @Test
    void getGameByIdTest(){
        //assign
        Game game1 = new Game();

        game1.setId(1);
        game1.setName("Wedstrijd 1");
        game1.setDate(LocalDate.of(2024, 4, 4));
        game1.setLocation("Tilburg");
        game1.setDescription("Dit is een test wedstrijd");

        //act
        Game expected = gameService.getGameById(game1.getId());

        //assert
        Assertions.assertEquals(expected, game1);
    }

    @Test
    void updateGameTest(){
        //assign
        Game gameUpdate = new Game();

        gameUpdate.setId(1);
        gameUpdate.setName("Wedstrijd 1 UPDATE");
        gameUpdate.setDate(LocalDate.of(2024, 4, 4));
        gameUpdate.setLocation("Tilburg");
        gameUpdate.setDescription("Dit is een test wedstrijd");

        Game gameOld = new Game();

        gameOld.setId(1);
        gameOld.setName("Wedstrijd 1");
        gameOld.setDate(LocalDate.of(2024, 4, 4));
        gameOld.setLocation("Tilburg");
        gameOld.setDescription("Dit is een test wedstrijd");

        //act
        gameUpdate = gameService.updateGame(gameUpdate);

        //assert
        Assertions.assertNotEquals(gameUpdate, gameOld);
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
