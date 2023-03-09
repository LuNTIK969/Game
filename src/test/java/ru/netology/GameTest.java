package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.classes.NotRegisteredException;
import ru.netology.data.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Иванович", 70);
    Player player2 = new Player(2, "Петрович", 95);
    Player player3 = new Player(3, "Василий", 93);
    Player player4 = new Player(4, "Эдуардо", 95);

    @BeforeEach
    public void shouldRegistered() {
        game.registration(player1);
        game.registration(player2);
        game.registration(player3);
        game.registration(player4);
    }

    @Test
    public void shouldFirstPlayerWin() {

        int actual = game.round(player2.getName(), player1.getName());

        assertEquals(1, actual);
    }

    @Test
    public void shouldSecondPlayerWin() {

        int actual = game.round(player3.getName(), player2.getName());

        assertEquals(2, actual);
    }

    @Test
    public void shouldNoOneWin() {

        int actual = game.round(player2.getName(), player4.getName());

        assertEquals(0, actual);
    }

    @Test
    public void shouldNotPlayRoundIfFirstPlayerAnotherRegistered() {

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Ильич", "Петрович");
        });
    }

    @Test
    public void shouldNotPlayRoundIfSecondPlayerAnotherRegistered() {

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Иванович", "Ильич");
        });
    }

    @Test
    public void shouldNotPlayRoundIfFirstPlayerNotRegistered() {
        Game game = new Game();

        game.registration(player2);

        assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player2.getName());
        });
    }

    @Test
    public void shouldNotPlayRoundIfSecondPlayerNotRegistered() {
        Game game = new Game();

        game.registration(player1);

        assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player2.getName());
        });
    }

//    @Test
//    public void shouldSetNewId() {
//
//        player1.setId(4);
//
//        assertEquals(4, player1.getId());
//    }
//
//    @Test
//    public void shouldSetNewName() {
//
//        player1.setName("Ильич");
//
//        assertEquals("Ильич", player1.getName());
//    }

}