package ru.netology.data;

import lombok.*;

@Getter

public class Player {
    final int id;
    final String name;
    final int strength;

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

}
