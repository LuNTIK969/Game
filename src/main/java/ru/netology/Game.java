package ru.netology;

import ru.netology.classes.NotRegisteredException;
import ru.netology.data.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public void registration(Player player) {
        players.add(player);
    }

    public int round(String plNameOne, String plNameTwo) {
        Player player1 = null;
        Player player2 = null;

        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(plNameOne)) {
                player1 = player;
            }
        }
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(plNameTwo)) {
                player2 = player;
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException(plNameOne);
        }
        if (player2 == null) {
            throw new NotRegisteredException(plNameTwo);
        }

        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        return 0;
    }

}
