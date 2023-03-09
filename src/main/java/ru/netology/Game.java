package ru.netology;

import ru.netology.classes.NotRegisteredException;
import ru.netology.data.Player;

import java.util.HashMap;

public class Game {
    HashMap<Integer, Player> players = new HashMap();

    public void registration(Player player) {
        players.put(player.getId(), player);
    }

    public Player findByName(String name) {
        for (Player player : players.values()) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String plNameOne, String plNameTwo) {
        Player player1 = findByName(plNameOne);
        Player player2 = findByName(plNameTwo);

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
